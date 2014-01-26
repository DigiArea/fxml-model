package com.digiarea.fxml;

import java.util.List;

public abstract class ValueElement extends Element {

    private String fxId = null;

    private String controller = null;

    public String getFxId() {
        return fxId;
    }

    public void setFxId(String fxId) {
        this.fxId = fxId;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    ValueElement() {
        super();
    }

    ValueElement(String fxId, String controller, String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        super(prefix, name, id, identifier, attributes, elements);
        setFxId(fxId);
        setController(controller);
    }

}
