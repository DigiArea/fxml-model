package com.digiarea.fxml;

import java.util.List;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class InstanceDeclarationElement extends ValueElement {

    private String value = null;

    private String constant = null;

    private String factory = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    InstanceDeclarationElement() {
        super();
    }

    InstanceDeclarationElement(String value, String constant, String factory, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        super(fxId, controller, prefix, name, id, identifier, attributes, elements);
        setValue(value);
        setConstant(constant);
        setFactory(factory);
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
