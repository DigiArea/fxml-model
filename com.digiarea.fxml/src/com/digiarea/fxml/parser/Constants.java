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

public class Constants {

	public enum Pos {
		BASELINE_CENTER, BASELINE_LEFT, BASELINE_RIGHT, BOTTOM_CENTER, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER, CENTER_LEFT, CENTER_RIGHT, TOP_CENTER, TOP_LEFT, TOP_RIGHT
	}

	public enum Priority {
		ALWAYS, NEVER, SOMETIMES
	}

	public enum ContentDisplay {
		BOTTOM, CENTER, GRAPHIC_ONLY, LEFT, RIGHT, TEXT_ONLY, TOP
	}

	public enum TabClosingPolicy {
		ALL_TABS, SELECTED_TAB, UNAVAILABLE
	}

	public enum VPos {
		BASELINE, BOTTOM, CENTER, TOP
	}

	public enum HPos {
		CENTER, LEFT, RIGHT
	}

	public enum TextAlignment {
		CENTER, JUSTIFY, LEFT, RIGHT
	}

	public enum OverrunStyle {
		CENTER_ELLIPSIS, CENTER_WORD_ELLIPSIS, CLIP, ELLIPSIS, LEADING_ELLIPSIS, LEADING_WORD_ELLIPSIS, WORD_ELLIPSIS
	}

	public enum Side {
		BOTTOM, LEFT, RIGHT, TOP
	}

	public static final String DEFAULT_CHARSET_NAME = "UTF-8";

	public static final String LANGUAGE_PROCESSING_INSTRUCTION = "language";
	public static final String IMPORT_PROCESSING_INSTRUCTION = "import";

	public static final String FX_NAMESPACE_PREFIX = "fx";
	public static final String FX_CONTROLLER_ATTRIBUTE = "controller";
	public static final String FX_ID_ATTRIBUTE = "id";
	public static final String FX_VALUE_ATTRIBUTE = "value";
	public static final String FX_CONSTANT_ATTRIBUTE = "constant";
	public static final String FX_FACTORY_ATTRIBUTE = "factory";

	public static final String INCLUDE_TAG = "include";
	public static final String INCLUDE_SOURCE_ATTRIBUTE = "source";
	public static final String INCLUDE_RESOURCES_ATTRIBUTE = "resources";
	public static final String INCLUDE_CHARSET_ATTRIBUTE = "charset";

	public static final String SCRIPT_TAG = "script";
	public static final String SCRIPT_SOURCE_ATTRIBUTE = "source";
	public static final String SCRIPT_CHARSET_ATTRIBUTE = "charset";

	public static final String DEFINE_TAG = "define";

	public static final String REFERENCE_TAG = "reference";
	public static final String REFERENCE_SOURCE_ATTRIBUTE = "source";

	public static final String ROOT_TAG = "root";
	public static final String ROOT_TYPE_ATTRIBUTE = "type";

	public static final String COPY_TAG = "copy";
	public static final String COPY_SOURCE_ATTRIBUTE = "source";

	public static final String EVENT_HANDLER_PREFIX = "on";
	public static final String EVENT_KEY = "event";
	public static final String CHANGE_EVENT_HANDLER_SUFFIX = "Change";

	public static final String NULL_KEYWORD = "null";

	public static final String ESCAPE_PREFIX = "\\";
	public static final String RELATIVE_PATH_PREFIX = "@";
	public static final String RESOURCE_KEY_PREFIX = "%";
	public static final String EXPRESSION_PREFIX = "$";
	public static final String BINDING_EXPRESSION_PREFIX = "${";
	public static final String BINDING_EXPRESSION_SUFFIX = "}";

	public static final String BI_DIRECTIONAL_BINDING_PREFIX = "#{";
	public static final String BI_DIRECTIONAL_BINDING_SUFFIX = "}";

	public static final String ARRAY_COMPONENT_DELIMITER = ",";

	public static final String LOCATION_KEY = "location";
	public static final String RESOURCES_KEY = "resources";

	public static final String CONTROLLER_METHOD_PREFIX = "#";
	public static final String CONTROLLER_KEYWORD = "controller";
	public static final String CONTROLLER_SUFFIX = "Controller";

	public static final String INITIALIZE_METHOD_NAME = "initialize";

	public static final String FX_NAMESPACE_VERSION = "1";

	public static final String ID_ATTRIBUTE = "id";

}
