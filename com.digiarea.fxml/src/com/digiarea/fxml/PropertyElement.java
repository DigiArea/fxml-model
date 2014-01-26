package com.digiarea.fxml;

import java.util.List;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class PropertyElement extends Element {

    public enum PropertyType {

        INSTANCE_PROPERTY, 
        STATIC_PROPERTY;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    private String value = null;

    private PropertyElement.PropertyType propertyType = null;

    public PropertyElement(PropertyElement.PropertyType propertyType) {
        super();
        this.propertyType = propertyType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PropertyElement.PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyElement.PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    PropertyElement() {
        super();
    }

    PropertyElement(String value, PropertyElement.PropertyType propertyType, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        super(prefix, name, id, identifier, attributes, elements);
        setValue(value);
        setPropertyType(propertyType);
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
