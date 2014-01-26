package com.digiarea.fxml.visitor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.digiarea.fxml.Attribute;
import com.digiarea.fxml.Attribute.AttributeType;
import com.digiarea.fxml.Comment;
import com.digiarea.fxml.CopyElement;
import com.digiarea.fxml.DefineElement;
import com.digiarea.fxml.Element;
import com.digiarea.fxml.Fxml;
import com.digiarea.fxml.ImportProcessing;
import com.digiarea.fxml.ImportProcessing.ImportType;
import com.digiarea.fxml.IncludeElement;
import com.digiarea.fxml.InstanceDeclarationElement;
import com.digiarea.fxml.LanguageProcessing;
import com.digiarea.fxml.Node;
import com.digiarea.fxml.NodeFacade;
import com.digiarea.fxml.ProcessingInstruction;
import com.digiarea.fxml.Project;
import com.digiarea.fxml.PropertyElement;
import com.digiarea.fxml.PropertyElement.PropertyType;
import com.digiarea.fxml.ReferenceElement;
import com.digiarea.fxml.RootElement;
import com.digiarea.fxml.ScriptElement;
import com.digiarea.fxml.UknownStaticPropertyElement;
import com.digiarea.fxml.UknownTypeElement;

public class ObjectReplacer implements GenericVisitor<Node, Map<Object, Object>> {

    @Override
    public Node visit(Attribute n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Attribute img = NodeFacade.Attribute();
        if (ctx.containsKey(n.getAttributeType())) {
            img.setAttributeType((Attribute.AttributeType) ctx.get(n.getAttributeType()));
        } else {
            img.setAttributeType(n.getAttributeType());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(AttributeType n, Map<Object, Object> ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(Comment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Comment img = NodeFacade.Comment();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(CopyElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        CopyElement img = NodeFacade.CopyElement();
        if (ctx.containsKey(n.getSource())) {
            img.setSource((String) ctx.get(n.getSource()));
        } else {
            img.setSource(n.getSource());
        }
        if (ctx.containsKey(n.getFxId())) {
            img.setFxId((String) ctx.get(n.getFxId()));
        } else {
            img.setFxId(n.getFxId());
        }
        if (ctx.containsKey(n.getController())) {
            img.setController((String) ctx.get(n.getController()));
        } else {
            img.setController(n.getController());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(DefineElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        DefineElement img = NodeFacade.DefineElement();
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(Fxml n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Fxml img = NodeFacade.Fxml();
        if (n.getProcessingInstructions() != null) {
            List<ProcessingInstruction> processingInstructions = new ArrayList<ProcessingInstruction>();
            for (ProcessingInstruction item : n.getProcessingInstructions()) {
                if (item != null) {
                    ProcessingInstruction node = (ProcessingInstruction) item.accept(this, ctx);
                    if (node != null) {
                        processingInstructions.add(node);
                    }
                }
            }
            img.setProcessingInstructions(processingInstructions);
        }
        if (n.getRoot() != null) {
            img.setRoot((Element) n.getRoot().accept(this, ctx));
        }
        if (n.getComments() != null) {
            List<Comment> comments = new ArrayList<Comment>();
            for (Comment item : n.getComments()) {
                if (item != null) {
                    Comment node = (Comment) item.accept(this, ctx);
                    if (node != null) {
                        comments.add(node);
                    }
                }
            }
            img.setComments(comments);
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(ImportProcessing n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ImportProcessing img = NodeFacade.ImportProcessing();
        if (ctx.containsKey(n.getImportType())) {
            img.setImportType((ImportProcessing.ImportType) ctx.get(n.getImportType()));
        } else {
            img.setImportType(n.getImportType());
        }
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(ImportType n, Map<Object, Object> ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(IncludeElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        IncludeElement img = NodeFacade.IncludeElement();
        if (ctx.containsKey(n.getSource())) {
            img.setSource((String) ctx.get(n.getSource()));
        } else {
            img.setSource(n.getSource());
        }
        if (ctx.containsKey(n.getResources())) {
            img.setResources((String) ctx.get(n.getResources()));
        } else {
            img.setResources(n.getResources());
        }
        if (ctx.containsKey(n.getCharset())) {
            img.setCharset((Charset) ctx.get(n.getCharset()));
        } else {
            img.setCharset(n.getCharset());
        }
        if (ctx.containsKey(n.getFxId())) {
            img.setFxId((String) ctx.get(n.getFxId()));
        } else {
            img.setFxId(n.getFxId());
        }
        if (ctx.containsKey(n.getController())) {
            img.setController((String) ctx.get(n.getController()));
        } else {
            img.setController(n.getController());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(InstanceDeclarationElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        InstanceDeclarationElement img = NodeFacade.InstanceDeclarationElement();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getConstant())) {
            img.setConstant((String) ctx.get(n.getConstant()));
        } else {
            img.setConstant(n.getConstant());
        }
        if (ctx.containsKey(n.getFactory())) {
            img.setFactory((String) ctx.get(n.getFactory()));
        } else {
            img.setFactory(n.getFactory());
        }
        if (ctx.containsKey(n.getFxId())) {
            img.setFxId((String) ctx.get(n.getFxId()));
        } else {
            img.setFxId(n.getFxId());
        }
        if (ctx.containsKey(n.getController())) {
            img.setController((String) ctx.get(n.getController()));
        } else {
            img.setController(n.getController());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(LanguageProcessing n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        LanguageProcessing img = NodeFacade.LanguageProcessing();
        if (ctx.containsKey(n.getLanguage())) {
            img.setLanguage((String) ctx.get(n.getLanguage()));
        } else {
            img.setLanguage(n.getLanguage());
        }
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(Project n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Project img = NodeFacade.Project();
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (n.getFxmls() != null) {
            List<Fxml> fxmls = new ArrayList<Fxml>();
            for (Fxml item : n.getFxmls()) {
                if (item != null) {
                    Fxml node = (Fxml) item.accept(this, ctx);
                    if (node != null) {
                        fxmls.add(node);
                    }
                }
            }
            img.setFxmls(fxmls);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(PropertyElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        PropertyElement img = NodeFacade.PropertyElement();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPropertyType())) {
            img.setPropertyType((PropertyElement.PropertyType) ctx.get(n.getPropertyType()));
        } else {
            img.setPropertyType(n.getPropertyType());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(PropertyType n, Map<Object, Object> ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(ReferenceElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ReferenceElement img = NodeFacade.ReferenceElement();
        if (ctx.containsKey(n.getSource())) {
            img.setSource((String) ctx.get(n.getSource()));
        } else {
            img.setSource(n.getSource());
        }
        if (ctx.containsKey(n.getFxId())) {
            img.setFxId((String) ctx.get(n.getFxId()));
        } else {
            img.setFxId(n.getFxId());
        }
        if (ctx.containsKey(n.getController())) {
            img.setController((String) ctx.get(n.getController()));
        } else {
            img.setController(n.getController());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(RootElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        RootElement img = NodeFacade.RootElement();
        if (ctx.containsKey(n.getType())) {
            img.setType((String) ctx.get(n.getType()));
        } else {
            img.setType(n.getType());
        }
        if (ctx.containsKey(n.getFxId())) {
            img.setFxId((String) ctx.get(n.getFxId()));
        } else {
            img.setFxId(n.getFxId());
        }
        if (ctx.containsKey(n.getController())) {
            img.setController((String) ctx.get(n.getController()));
        } else {
            img.setController(n.getController());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(ScriptElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ScriptElement img = NodeFacade.ScriptElement();
        if (ctx.containsKey(n.getSource())) {
            img.setSource((String) ctx.get(n.getSource()));
        } else {
            img.setSource(n.getSource());
        }
        if (ctx.containsKey(n.getCharset())) {
            img.setCharset((Charset) ctx.get(n.getCharset()));
        } else {
            img.setCharset(n.getCharset());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(UknownStaticPropertyElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        UknownStaticPropertyElement img = NodeFacade.UknownStaticPropertyElement();
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(UknownTypeElement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        UknownTypeElement img = NodeFacade.UknownTypeElement();
        if (ctx.containsKey(n.getFxId())) {
            img.setFxId((String) ctx.get(n.getFxId()));
        } else {
            img.setFxId(n.getFxId());
        }
        if (ctx.containsKey(n.getController())) {
            img.setController((String) ctx.get(n.getController()));
        } else {
            img.setController(n.getController());
        }
        if (ctx.containsKey(n.getPrefix())) {
            img.setPrefix((String) ctx.get(n.getPrefix()));
        } else {
            img.setPrefix(n.getPrefix());
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getId())) {
            img.setId((String) ctx.get(n.getId()));
        } else {
            img.setId(n.getId());
        }
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    Attribute node = (Attribute) item.accept(this, ctx);
                    if (node != null) {
                        attributes.add(node);
                    }
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    Element node = (Element) item.accept(this, ctx);
                    if (node != null) {
                        elements.add(node);
                    }
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    public ObjectReplacer() {
        super();
    }

}
