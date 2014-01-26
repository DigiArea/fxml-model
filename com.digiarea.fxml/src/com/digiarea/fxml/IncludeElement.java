package com.digiarea.fxml;

import java.nio.charset.Charset;
import java.util.List;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class IncludeElement extends ValueElement {

    private String source = null;

    private String resources = null;

    private Charset charset = null;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    IncludeElement() {
        super();
    }

    IncludeElement(String source, String resources, Charset charset, String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        super(fxId, controller, prefix, name, id, identifier, attributes, elements);
        setSource(source);
        setResources(resources);
        setCharset(charset);
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
