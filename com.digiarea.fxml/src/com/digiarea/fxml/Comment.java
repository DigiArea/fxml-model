package com.digiarea.fxml;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class Comment extends Node {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Comment() {
        super();
    }

    Comment(String value) {
        super();
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
