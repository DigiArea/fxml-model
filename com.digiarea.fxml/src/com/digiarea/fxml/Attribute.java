package com.digiarea.fxml;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class Attribute extends Node {

    public enum AttributeType {

        EVENT_HANDLER, 
        INSTANCE_PROPERTY, 
        STATIC_PROPERTY;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    private Attribute.AttributeType attributeType;

    private String prefix = null;

    private String name;

    private String value;

    public Attribute.AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(Attribute.AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Attribute() {
        super();
    }

    Attribute(Attribute.AttributeType attributeType, String prefix, String name, String value) {
        super();
        setAttributeType(attributeType);
        setPrefix(prefix);
        setName(name);
        setValue(value);
    }

    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
