package com.digiarea.fxml.visitor;

import java.util.ArrayList;
import java.util.List;

import com.digiarea.fxml.Attribute;
import com.digiarea.fxml.Attribute.AttributeType;
import com.digiarea.fxml.Comment;
import com.digiarea.fxml.CopyElement;
import com.digiarea.fxml.DefineElement;
import com.digiarea.fxml.Fxml;
import com.digiarea.fxml.ImportProcessing;
import com.digiarea.fxml.ImportProcessing.ImportType;
import com.digiarea.fxml.IncludeElement;
import com.digiarea.fxml.InstanceDeclarationElement;
import com.digiarea.fxml.LanguageProcessing;
import com.digiarea.fxml.Project;
import com.digiarea.fxml.PropertyElement;
import com.digiarea.fxml.PropertyElement.PropertyType;
import com.digiarea.fxml.ReferenceElement;
import com.digiarea.fxml.RootElement;
import com.digiarea.fxml.ScriptElement;
import com.digiarea.fxml.UknownStaticPropertyElement;
import com.digiarea.fxml.UknownTypeElement;

public class ChildrenProvider<C> implements GenericVisitor<List<Object>, Void> {

    @Override
    public List<Object> visit(Attribute n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getAttributeType());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getValue());
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(AttributeType n, Void ctx) throws Exception {
        return null;
    }

    @Override
    public List<Object> visit(Comment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(CopyElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getSource());
        img.add(n.getFxId());
        img.add(n.getController());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(DefineElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(Fxml n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getProcessingInstructions() != null) {
            img.add(n.getProcessingInstructions());
        }
        if (n.getRoot() != null) {
            img.add(n.getRoot());
        }
        if (n.getComments() != null) {
            img.add(n.getComments());
        }
        img.add(n.getName());
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(ImportProcessing n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getImportType());
        img.add(n.getValue());
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(ImportType n, Void ctx) throws Exception {
        return null;
    }

    @Override
    public List<Object> visit(IncludeElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getSource());
        img.add(n.getResources());
        img.add(n.getCharset());
        img.add(n.getFxId());
        img.add(n.getController());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(InstanceDeclarationElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getConstant());
        img.add(n.getFactory());
        img.add(n.getFxId());
        img.add(n.getController());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(LanguageProcessing n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getLanguage());
        img.add(n.getValue());
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(Project n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getName());
        if (n.getFxmls() != null) {
            img.add(n.getFxmls());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(PropertyElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPropertyType());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(PropertyType n, Void ctx) throws Exception {
        return null;
    }

    @Override
    public List<Object> visit(ReferenceElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getSource());
        img.add(n.getFxId());
        img.add(n.getController());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(RootElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getType());
        img.add(n.getFxId());
        img.add(n.getController());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(ScriptElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getSource());
        img.add(n.getCharset());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(UknownStaticPropertyElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    @Override
    public List<Object> visit(UknownTypeElement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getFxId());
        img.add(n.getController());
        img.add(n.getPrefix());
        img.add(n.getName());
        img.add(n.getId());
        img.add(n.getIdentifier());
        if (n.getAttributes() != null) {
            img.add(n.getAttributes());
        }
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getParent() != null) {
            img.add(n.getParent());
        }
        return img;
    }

    public ChildrenProvider() {
        super();
    }

}
