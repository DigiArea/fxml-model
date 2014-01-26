package com.digiarea.fxml;

import java.util.List;

public abstract class Element extends Node {

    private String prefix = null;

    private String name = null;

    private String id = null;

    private String identifier = null;

    private List<Attribute> attributes = null;

    private List<Element> elements = null;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean addAttributes(Attribute attributes) {
        boolean res = getAttributes().add(attributes);
        if (res) {
            if (attributes != null) {
                attributes.setParent(this);
            }
        }
        return res;
    }

    public boolean removeAttributes(Attribute attributes) {
        boolean res = getAttributes().remove(attributes);
        if (res) {
            if (attributes != null) {
                attributes.setParent(null);
            }
        }
        return res;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        if (attributes != null) {
            for (Attribute item : attributes) {
                item.setParent(this);
            }
        }
        this.attributes = attributes;
    }

    public boolean addElements(Element elements) {
        boolean res = getElements().add(elements);
        if (res) {
            if (elements != null) {
                elements.setParent(this);
            }
        }
        return res;
    }

    public boolean removeElements(Element elements) {
        boolean res = getElements().remove(elements);
        if (res) {
            if (elements != null) {
                elements.setParent(null);
            }
        }
        return res;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        if (elements != null) {
            for (Element item : elements) {
                item.setParent(this);
            }
        }
        this.elements = elements;
    }

    Element() {
        super();
    }

    Element(String prefix, String name, String id, String identifier, List<Attribute> attributes, List<Element> elements) {
        super();
        setPrefix(prefix);
        setName(name);
        setId(id);
        setIdentifier(identifier);
        setAttributes(attributes);
        setElements(elements);
    }

}
