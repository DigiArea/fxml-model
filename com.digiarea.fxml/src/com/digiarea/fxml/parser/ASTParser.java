/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.digiarea.fxml.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import com.digiarea.fxml.Attribute.AttributeType;
import com.digiarea.fxml.CopyElement;
import com.digiarea.fxml.DefineElement;
import com.digiarea.fxml.Element;
import com.digiarea.fxml.Fxml;
import com.digiarea.fxml.ImportProcessing.ImportType;
import com.digiarea.fxml.IncludeElement;
import com.digiarea.fxml.InstanceDeclarationElement;
import com.digiarea.fxml.Node;
import com.digiarea.fxml.NodeFacade;
import com.digiarea.fxml.PropertyElement;
import com.digiarea.fxml.PropertyElement.PropertyType;
import com.digiarea.fxml.ReferenceElement;
import com.digiarea.fxml.RootElement;
import com.digiarea.fxml.ScriptElement;
import com.digiarea.fxml.ValueElement;

public class ASTParser {

	private static final Pattern extraneousWhitespacePattern = Pattern
			.compile("\\s+");

	private InputStream inputStream;
	private Charset charset;
	private XMLStreamReader xmlStreamReader = null;
	private Fxml fxml = null;
	private Node parent = null;
	private Element current = null;

	public ASTParser(InputStream inputStream, String encoding) {
		super();
		this.inputStream = inputStream;
		if (encoding != null) {
			charset = Charset.forName(encoding);
		} else {
			charset = Charset.forName("UTF-8");
		}
	}

	public Fxml parse(String fileName) throws Exception {
		if (inputStream == null) {
			throw new NullPointerException("inputStream is null.");
		}
		fxml = NodeFacade.Fxml();
		fxml.setName(fileName);
		// Create the parser
		try {
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			xmlInputFactory.setProperty("javax.xml.stream.isCoalescing", true);
			// Some stream readers incorrectly report an empty string as the
			// prefix for the default namespace; correct this as needed
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, charset);
			xmlStreamReader = new StreamReaderDelegate(
					xmlInputFactory.createXMLStreamReader(inputStreamReader)) {

				@Override
				public String getPrefix() {
					String prefix = super.getPrefix();
					if (prefix != null && prefix.length() == 0) {
						prefix = null;
					}
					return prefix;
				}

				@Override
				public String getAttributePrefix(int index) {
					String attributePrefix = super.getAttributePrefix(index);
					if (attributePrefix != null
							&& attributePrefix.length() == 0) {
						attributePrefix = null;
					}
					return attributePrefix;
				}
			};
		} catch (XMLStreamException exception) {
			throw new LoadException(exception);
		}
		// Parse the XML stream
		try {
			while (xmlStreamReader.hasNext()) {
				int event = xmlStreamReader.next();
				switch (event) {
				case XMLStreamConstants.PROCESSING_INSTRUCTION:
					processProcessingInstruction();
					break;
				case XMLStreamConstants.COMMENT:
					processComment();
					break;
				case XMLStreamConstants.START_ELEMENT:
					processStartElement();
					break;
				case XMLStreamConstants.END_ELEMENT:
					processEndElement();
					break;
				case XMLStreamConstants.CHARACTERS:
					processCharacters();
					break;
				}
			}
		} catch (XMLStreamException exception) {
			throw new LoadException(exception);
		}
		// Clear the parser
		xmlStreamReader = null;
		return fxml;
	}

	private void processCharacters() throws IOException {
		// Process the characters
		if (!xmlStreamReader.isWhiteSpace()) {
			if (current instanceof PropertyElement) {
				String text = xmlStreamReader.getText();
				text = extraneousWhitespacePattern.matcher(text)
						.replaceAll(" ");
				((PropertyElement) current).setValue(text.trim());
			}
		}
	}

	private void processEndElement() throws IOException {
		current = (Element) parent;
		parent = current.getParent();
	}

	private void processStartElement() throws IOException {
		// Create the element
		createElement();
		// Process the start tag
		for (int i = 0, n = xmlStreamReader.getAttributeCount(); i < n; i++) {
			String prefix = xmlStreamReader.getAttributePrefix(i);
			String localName = xmlStreamReader.getAttributeLocalName(i);
			String value = xmlStreamReader.getAttributeValue(i);
			processAttribute(prefix, localName, value);
		}
		// insert into parent
		if (parent == null) {
			fxml.setRoot(current);
		} else if (parent instanceof Element) {
			((Element) parent).addElements(current);
		}
		parent = current;
	}

	private void processComment() throws IOException {
		fxml.addComments(NodeFacade.Comment(xmlStreamReader.getText()));
	}

	private void processProcessingInstruction() throws IOException {
		String piTarget = xmlStreamReader.getPITarget().trim();
		if (piTarget.equals(Constants.LANGUAGE_PROCESSING_INSTRUCTION)) {
			processLanguage();
		} else if (piTarget.equals(Constants.IMPORT_PROCESSING_INSTRUCTION)) {
			processImport();
		}
	}

	private void processLanguage() throws LoadException {
		String language = xmlStreamReader.getPIData();
		String value = xmlStreamReader.getText();
		fxml.addProcessingInstructions(NodeFacade.LanguageProcessing(language,
				value));
	}

	private void processImport() throws LoadException {
		String target = xmlStreamReader.getPIData().trim();
		if (target.endsWith(".*")) {
			fxml.addProcessingInstructions(NodeFacade.ImportProcessing(
					ImportType.IMPORT_PACKAGE,
					target.substring(0, target.length() - 2)));
		} else {
			fxml.addProcessingInstructions(NodeFacade.ImportProcessing(
					ImportType.IMPORT_CLASS, target));
		}
	}

	private void createElement() throws IOException {
		String prefix = xmlStreamReader.getPrefix();
		String localName = xmlStreamReader.getLocalName();
		if (prefix == null) {
			int i = localName.lastIndexOf('.');
			if (Character.isLowerCase(localName.charAt(i + 1))) {
				if (i == -1) {
					// This is an instance property
					current = new PropertyElement(
							PropertyType.INSTANCE_PROPERTY);
				} else {
					// This is a static property
					current = new PropertyElement(PropertyType.STATIC_PROPERTY);
				}
			} else {
				current = NodeFacade.InstanceDeclarationElement();
			}
		} else if (prefix.equals(Constants.FX_NAMESPACE_PREFIX)) {
			if (localName.equals(Constants.INCLUDE_TAG)) {
				current = NodeFacade.IncludeElement();
			} else if (localName.equals(Constants.REFERENCE_TAG)) {
				current = NodeFacade.ReferenceElement();
			} else if (localName.equals(Constants.COPY_TAG)) {
				current = NodeFacade.CopyElement();
			} else if (localName.equals(Constants.ROOT_TAG)) {
				current = NodeFacade.RootElement();
			} else if (localName.equals(Constants.SCRIPT_TAG)) {
				current = NodeFacade.ScriptElement();
			} else if (localName.equals(Constants.DEFINE_TAG)) {
				current = NodeFacade.DefineElement();
			} else {
				throw new LoadException(prefix + ":" + localName
						+ " is not a valid element.");
			}
		} else {
			throw new LoadException("Unexpected namespace prefix: " + prefix
					+ ".");
		}
		current.setPrefix(prefix);
		current.setName(localName);
	}

	private void processAttribute(String prefix, String localName, String value)
			throws IOException {
		// process Elements
		if (current instanceof CopyElement) {
			if (prefix == null) {
				if (localName.equals(Constants.COPY_SOURCE_ATTRIBUTE)) {
					((CopyElement) current).setSource(value);
				} else {
					processValueAttribute(prefix, localName, value);
				}
			} else {
				processValueAttribute(prefix, localName, value);
			}
		} else if (current instanceof DefineElement) {
			throw new LoadException("Element does not support attributes.");
		} else if (current instanceof IncludeElement) {
			if (prefix == null) {
				if (localName.equals(Constants.INCLUDE_SOURCE_ATTRIBUTE)) {
					((IncludeElement) current).setSource(value);
				} else if (localName
						.equals(Constants.INCLUDE_RESOURCES_ATTRIBUTE)) {
					((IncludeElement) current).setResources(value);
				} else if (localName
						.equals(Constants.INCLUDE_CHARSET_ATTRIBUTE)) {
					((IncludeElement) current).setCharset(Charset
							.forName(value));
				} else {
					processValueAttribute(prefix, localName, value);
				}
			} else {
				processValueAttribute(prefix, localName, value);
			}
		} else if (current instanceof InstanceDeclarationElement) {
			if (prefix != null && prefix.equals(Constants.FX_NAMESPACE_PREFIX)) {
				if (localName.equals(Constants.FX_VALUE_ATTRIBUTE)) {
					((InstanceDeclarationElement) current).setValue(value);
				} else if (localName.equals(Constants.FX_CONSTANT_ATTRIBUTE)) {
					((InstanceDeclarationElement) current).setConstant(value);
				} else if (localName.equals(Constants.FX_FACTORY_ATTRIBUTE)) {
					((InstanceDeclarationElement) current).setFactory(value);
				} else {
					processValueAttribute(prefix, localName, value);
				}
			} else {
				processValueAttribute(prefix, localName, value);
			}
		} else if (current instanceof ReferenceElement) {
			if (prefix == null) {
				if (localName.equals(Constants.REFERENCE_SOURCE_ATTRIBUTE)) {
					((ReferenceElement) current).setSource(value);
				} else {
					processValueAttribute(prefix, localName, value);
				}
			} else {
				processValueAttribute(prefix, localName, value);
			}
		} else if (current instanceof RootElement) {
			if (prefix == null) {
				if (localName.equals(Constants.ROOT_TYPE_ATTRIBUTE)) {
					((RootElement) current).setType(value);
				} else {
					processValueAttribute(prefix, localName, value);
				}
			} else {
				processValueAttribute(prefix, localName, value);
			}
		} else if (current instanceof ScriptElement) {
			if (prefix == null
					&& localName.equals(Constants.SCRIPT_SOURCE_ATTRIBUTE)) {
				((ScriptElement) current).setSource(value);
			} else if (localName.equals(Constants.SCRIPT_CHARSET_ATTRIBUTE)) {
				((ScriptElement) current).setCharset(Charset.forName(value));
			} else {
				throw new LoadException(prefix == null ? localName : prefix
						+ ":" + localName + " is not a valid attribute.");
			}
		} else {
			processNormalAttribute(prefix, localName, value);
		}
	}

	private void processValueAttribute(String prefix, String localName,
			String value) throws IOException {
		// process ValueElement
		if (current instanceof ValueElement) {
			if (prefix != null && prefix.equals(Constants.FX_NAMESPACE_PREFIX)) {
				if (localName.equals(Constants.FX_ID_ATTRIBUTE)) {
					// Verify that ID is a valid identifier
					if (value.equals(Constants.NULL_KEYWORD)) {
						throw new LoadException("Invalid identifier.");
					}
					for (int i = 0, n = value.length(); i < n; i++) {
						if (!Character.isJavaIdentifierPart(value.charAt(i))) {
							throw new LoadException("Invalid identifier.");
						}
					}
					((ValueElement) current).setFxId(value);
				} else if (localName.equals(Constants.FX_CONTROLLER_ATTRIBUTE)) {
					((ValueElement) current).setController(value);
				}
			} else {
				processNormalAttribute(prefix, localName, value);
			}
		}
	}

	private void processNormalAttribute(String prefix, String localName,
			String value) throws IOException {
		if (prefix == null) {
			// It is useful to have id as a field and as an attribute
			if (current instanceof Element) {
				if (localName.equals(Constants.ID_ATTRIBUTE)) {
					((Element) current).setId(value);
				}
			}
			// Add the attribute to the appropriate list
			if (localName.startsWith(Constants.EVENT_HANDLER_PREFIX)) {
				current.addAttributes(NodeFacade.Attribute(
						AttributeType.EVENT_HANDLER, prefix, localName, value));
			} else {
				int i = localName.lastIndexOf('.');
				if (i == -1) {
					// The attribute represents an instance property
					current.addAttributes(NodeFacade.Attribute(
							AttributeType.INSTANCE_PROPERTY, prefix, localName,
							value));
				} else {
					// The attribute represents a static property
					current.addAttributes(NodeFacade.Attribute(
							AttributeType.STATIC_PROPERTY, prefix, localName,
							value));
				}
			}
		} else {
			throw new LoadException(prefix + ":" + localName
					+ " is not a valid attribute.");
		}
	}

}
