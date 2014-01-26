package com.digiarea.fxml;

import java.util.List;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class DefineElement extends Element {

    DefineElement() {
        super();
    }

    DefineElement(String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        super(prefix, name, id, identifier, attributes, elements);
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
