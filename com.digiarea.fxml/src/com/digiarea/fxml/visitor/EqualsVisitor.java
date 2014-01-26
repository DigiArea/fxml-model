package com.digiarea.fxml.visitor;

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
import com.digiarea.fxml.Node;
import com.digiarea.fxml.Project;
import com.digiarea.fxml.PropertyElement;
import com.digiarea.fxml.PropertyElement.PropertyType;
import com.digiarea.fxml.ReferenceElement;
import com.digiarea.fxml.RootElement;
import com.digiarea.fxml.ScriptElement;
import com.digiarea.fxml.UknownStaticPropertyElement;
import com.digiarea.fxml.UknownTypeElement;

public class EqualsVisitor implements GenericVisitor<Boolean, Node> {

    private static final EqualsVisitor SINGLETON = new EqualsVisitor();

    public static boolean equals(Node n1, Node n2) throws Exception {
        return SINGLETON.nodeEquals(n1, n2);
    }

    protected <T extends Node> boolean nodeEquals(T n1, T n2) throws Exception {
        if (n1 == n2) {
            return true;
        }
        if (n1 == null) {
            if (n2 == null) {
                return true;
            }
            return false;
        } else if (n2 == null) {
            return false;
        }
        if (n1.getClass() != n2.getClass()) {
            return false;
        }
        return n1.accept(this, n2).booleanValue();
    }

    protected <T extends Node> boolean nodesEquals(List<T> nodes1, List<T> nodes2) throws Exception {
        if (nodes1 == null) {
            if (nodes2 == null) {
                return true;
            }
            return false;
        } else if (nodes2 == null) {
            return false;
        }
        if (nodes1.size() != nodes2.size()) {
            return false;
        }
        for (int i = 0; i < nodes1.size(); i++) {
            if (!nodeEquals(nodes1.get(i), nodes2.get(i))) {
                return false;
            }
        }
        return true;
    }

    protected boolean objEquals(Object n1, Object n2) {
        if (n1 == n2) {
            return true;
        }
        if (n1 == null) {
            if (n2 == null) {
                return true;
            }
            return false;
        } else if (n2 == null) {
            return false;
        }
        return n1.equals(n2);
    }

    @Override
    public Boolean visit(Attribute n, Node ctx) throws Exception {
        Attribute x = (Attribute) ctx;
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (n.getAttributeType() != x.getAttributeType()) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(AttributeType n, Node ctx) throws Exception {
        return java.lang.Boolean.FALSE;
    }

    @Override
    public Boolean visit(Comment n, Node ctx) throws Exception {
        Comment x = (Comment) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(CopyElement n, Node ctx) throws Exception {
        CopyElement x = (CopyElement) ctx;
        if (!objEquals(n.getSource(), x.getSource())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getFxId(), x.getFxId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getController(), x.getController())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(DefineElement n, Node ctx) throws Exception {
        DefineElement x = (DefineElement) ctx;
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(Fxml n, Node ctx) throws Exception {
        Fxml x = (Fxml) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getProcessingInstructions(), x.getProcessingInstructions())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getRoot(), x.getRoot())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getComments(), x.getComments())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ImportProcessing n, Node ctx) throws Exception {
        ImportProcessing x = (ImportProcessing) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (n.getImportType() != x.getImportType()) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ImportType n, Node ctx) throws Exception {
        return java.lang.Boolean.FALSE;
    }

    @Override
    public Boolean visit(IncludeElement n, Node ctx) throws Exception {
        IncludeElement x = (IncludeElement) ctx;
        if (!objEquals(n.getSource(), x.getSource())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getResources(), x.getResources())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getFxId(), x.getFxId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getController(), x.getController())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getCharset(), x.getCharset())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(InstanceDeclarationElement n, Node ctx) throws Exception {
        InstanceDeclarationElement x = (InstanceDeclarationElement) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getConstant(), x.getConstant())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getFactory(), x.getFactory())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getFxId(), x.getFxId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getController(), x.getController())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(LanguageProcessing n, Node ctx) throws Exception {
        LanguageProcessing x = (LanguageProcessing) ctx;
        if (!objEquals(n.getLanguage(), x.getLanguage())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(Project n, Node ctx) throws Exception {
        Project x = (Project) ctx;
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getFxmls(), x.getFxmls())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(PropertyElement n, Node ctx) throws Exception {
        PropertyElement x = (PropertyElement) ctx;
        if (!objEquals(n.getValue(), x.getValue())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (n.getPropertyType() != x.getPropertyType()) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(PropertyType n, Node ctx) throws Exception {
        return java.lang.Boolean.FALSE;
    }

    @Override
    public Boolean visit(ReferenceElement n, Node ctx) throws Exception {
        ReferenceElement x = (ReferenceElement) ctx;
        if (!objEquals(n.getSource(), x.getSource())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getFxId(), x.getFxId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getController(), x.getController())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(RootElement n, Node ctx) throws Exception {
        RootElement x = (RootElement) ctx;
        if (!objEquals(n.getType(), x.getType())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getFxId(), x.getFxId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getController(), x.getController())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(ScriptElement n, Node ctx) throws Exception {
        ScriptElement x = (ScriptElement) ctx;
        if (!objEquals(n.getSource(), x.getSource())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getCharset(), x.getCharset())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(UknownStaticPropertyElement n, Node ctx) throws Exception {
        UknownStaticPropertyElement x = (UknownStaticPropertyElement) ctx;
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    @Override
    public Boolean visit(UknownTypeElement n, Node ctx) throws Exception {
        UknownTypeElement x = (UknownTypeElement) ctx;
        if (!objEquals(n.getFxId(), x.getFxId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getController(), x.getController())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getPrefix(), x.getPrefix())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getName(), x.getName())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getId(), x.getId())) {
            return java.lang.Boolean.FALSE;
        }
        if (!objEquals(n.getIdentifier(), x.getIdentifier())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getAttributes(), x.getAttributes())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodesEquals(n.getElements(), x.getElements())) {
            return java.lang.Boolean.FALSE;
        }
        if (!nodeEquals(n.getParent(), x.getParent())) {
            return java.lang.Boolean.FALSE;
        }
        return java.lang.Boolean.TRUE;
    }

    public EqualsVisitor() {
        super();
    }

}
