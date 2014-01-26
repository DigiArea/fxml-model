package com.digiarea.fxml;

import java.nio.charset.Charset;
import java.util.List;

class NodeFactory {

    public static Attribute Attribute() {
        return new Attribute();
    }

    public static Attribute Attribute(Attribute.AttributeType attributeType, String prefix, String name, String value) {
        return new Attribute(attributeType, prefix, name, value);
    }

    public static Comment Comment() {
        return new Comment();
    }

    public static Comment Comment(String value) {
        return new Comment(value);
    }

    public static CopyElement CopyElement() {
        return new CopyElement();
    }

    public static CopyElement CopyElement(String source, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new CopyElement(source, fxId, controller, prefix, name, id, identifier, attributes, elements);
    }

    public static DefineElement DefineElement() {
        return new DefineElement();
    }

    public static DefineElement DefineElement(String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new DefineElement(prefix, name, id, identifier, attributes, elements);
    }

    public static Fxml Fxml() {
        return new Fxml();
    }

    public static Fxml Fxml(List<ProcessingInstruction> processingInstructions, Element root, List<Comment> comments, String name) {
        return new Fxml(processingInstructions, root, comments, name);
    }

    public static ImportProcessing ImportProcessing() {
        return new ImportProcessing();
    }

    public static ImportProcessing ImportProcessing(ImportProcessing.ImportType importType, String value) {
        return new ImportProcessing(importType, value);
    }

    public static IncludeElement IncludeElement() {
        return new IncludeElement();
    }

    public static IncludeElement IncludeElement(String source, String resources, Charset charset, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new IncludeElement(source, resources, charset, fxId, controller, prefix, name, id, identifier, attributes, elements);
    }

    public static InstanceDeclarationElement InstanceDeclarationElement() {
        return new InstanceDeclarationElement();
    }

    public static InstanceDeclarationElement InstanceDeclarationElement(String value, String constant, String factory, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new InstanceDeclarationElement(value, constant, factory, fxId, controller, prefix, name, id, identifier, attributes, elements);
    }

    public static LanguageProcessing LanguageProcessing() {
        return new LanguageProcessing();
    }

    public static LanguageProcessing LanguageProcessing(String language, String value) {
        return new LanguageProcessing(language, value);
    }

    public static Project Project() {
        return new Project();
    }

    public static Project Project(String name, List<Fxml> fxmls) {
        return new Project(name, fxmls);
    }

    public static PropertyElement PropertyElement() {
        return new PropertyElement();
    }

    public static PropertyElement PropertyElement(String value, PropertyElement.PropertyType propertyType, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new PropertyElement(value, propertyType, prefix, name, id, identifier, attributes, elements);
    }

    public static ReferenceElement ReferenceElement() {
        return new ReferenceElement();
    }

    public static ReferenceElement ReferenceElement(String source, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new ReferenceElement(source, fxId, controller, prefix, name, id, identifier, attributes, elements);
    }

    public static RootElement RootElement() {
        return new RootElement();
    }

    public static RootElement RootElement(String type, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new RootElement(type, fxId, controller, prefix, name, id, identifier, attributes, elements);
    }

    public static ScriptElement ScriptElement() {
        return new ScriptElement();
    }

    public static ScriptElement ScriptElement(String source, Charset charset, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new ScriptElement(source, charset, prefix, name, id, identifier, attributes, elements);
    }

    public static UknownStaticPropertyElement UknownStaticPropertyElement() {
        return new UknownStaticPropertyElement();
    }

    public static UknownStaticPropertyElement UknownStaticPropertyElement(String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new UknownStaticPropertyElement(prefix, name, id, identifier, attributes, elements);
    }

    public static UknownTypeElement UknownTypeElement() {
        return new UknownTypeElement();
    }

    public static UknownTypeElement UknownTypeElement(String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        return new UknownTypeElement(fxId, controller, prefix, name, id, identifier, attributes, elements);
    }

}
