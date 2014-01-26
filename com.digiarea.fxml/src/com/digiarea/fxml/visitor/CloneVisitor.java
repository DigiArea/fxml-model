package com.digiarea.fxml.visitor;

import java.util.ArrayList;
import java.util.List;

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

public class CloneVisitor<C> implements GenericVisitor<Node, C> {

    @Override
    public Node visit(Attribute n, C ctx) throws Exception {
        Attribute img = NodeFacade.Attribute();
        img.setAttributeType(n.getAttributeType());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setValue(n.getValue());
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(AttributeType n, C ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(Comment n, C ctx) throws Exception {
        Comment img = NodeFacade.Comment();
        img.setValue(n.getValue());
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(CopyElement n, C ctx) throws Exception {
        CopyElement img = NodeFacade.CopyElement();
        img.setSource(n.getSource());
        img.setFxId(n.getFxId());
        img.setController(n.getController());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(DefineElement n, C ctx) throws Exception {
        DefineElement img = NodeFacade.DefineElement();
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(Fxml n, C ctx) throws Exception {
        Fxml img = NodeFacade.Fxml();
        if (n.getProcessingInstructions() != null) {
            List<ProcessingInstruction> processingInstructions = new ArrayList<ProcessingInstruction>();
            for (ProcessingInstruction item : n.getProcessingInstructions()) {
                if (item != null) {
                    processingInstructions.add((ProcessingInstruction) item.accept(this, ctx));
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
                    comments.add((Comment) item.accept(this, ctx));
                }
            }
            img.setComments(comments);
        }
        img.setName(n.getName());
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(ImportProcessing n, C ctx) throws Exception {
        ImportProcessing img = NodeFacade.ImportProcessing();
        img.setImportType(n.getImportType());
        img.setValue(n.getValue());
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(ImportType n, C ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(IncludeElement n, C ctx) throws Exception {
        IncludeElement img = NodeFacade.IncludeElement();
        img.setSource(n.getSource());
        img.setResources(n.getResources());
        img.setCharset(n.getCharset());
        img.setFxId(n.getFxId());
        img.setController(n.getController());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(InstanceDeclarationElement n, C ctx) throws Exception {
        InstanceDeclarationElement img = NodeFacade.InstanceDeclarationElement();
        img.setValue(n.getValue());
        img.setConstant(n.getConstant());
        img.setFactory(n.getFactory());
        img.setFxId(n.getFxId());
        img.setController(n.getController());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(LanguageProcessing n, C ctx) throws Exception {
        LanguageProcessing img = NodeFacade.LanguageProcessing();
        img.setLanguage(n.getLanguage());
        img.setValue(n.getValue());
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    @Override
    public Node visit(Project n, C ctx) throws Exception {
        Project img = NodeFacade.Project();
        img.setName(n.getName());
        if (n.getFxmls() != null) {
            List<Fxml> fxmls = new ArrayList<Fxml>();
            for (Fxml item : n.getFxmls()) {
                if (item != null) {
                    fxmls.add((Fxml) item.accept(this, ctx));
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
    public Node visit(PropertyElement n, C ctx) throws Exception {
        PropertyElement img = NodeFacade.PropertyElement();
        img.setValue(n.getValue());
        img.setPropertyType(n.getPropertyType());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(PropertyType n, C ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(ReferenceElement n, C ctx) throws Exception {
        ReferenceElement img = NodeFacade.ReferenceElement();
        img.setSource(n.getSource());
        img.setFxId(n.getFxId());
        img.setController(n.getController());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(RootElement n, C ctx) throws Exception {
        RootElement img = NodeFacade.RootElement();
        img.setType(n.getType());
        img.setFxId(n.getFxId());
        img.setController(n.getController());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(ScriptElement n, C ctx) throws Exception {
        ScriptElement img = NodeFacade.ScriptElement();
        img.setSource(n.getSource());
        img.setCharset(n.getCharset());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(UknownStaticPropertyElement n, C ctx) throws Exception {
        UknownStaticPropertyElement img = NodeFacade.UknownStaticPropertyElement();
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
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
    public Node visit(UknownTypeElement n, C ctx) throws Exception {
        UknownTypeElement img = NodeFacade.UknownTypeElement();
        img.setFxId(n.getFxId());
        img.setController(n.getController());
        img.setPrefix(n.getPrefix());
        img.setName(n.getName());
        img.setId(n.getId());
        img.setIdentifier(n.getIdentifier());
        if (n.getAttributes() != null) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            for (Attribute item : n.getAttributes()) {
                if (item != null) {
                    attributes.add((Attribute) item.accept(this, ctx));
                }
            }
            img.setAttributes(attributes);
        }
        if (n.getElements() != null) {
            List<Element> elements = new ArrayList<Element>();
            for (Element item : n.getElements()) {
                if (item != null) {
                    elements.add((Element) item.accept(this, ctx));
                }
            }
            img.setElements(elements);
        }
        if (n.getParent() != null) {
            img.setParent((Node) n.getParent().accept(this, ctx));
        }
        return img;
    }

    public CloneVisitor() {
        super();
    }

}
