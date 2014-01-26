package com.digiarea.fxml;

import java.util.List;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class Fxml extends Node {

    private List<ProcessingInstruction> processingInstructions = null;

    private Element root = null;

    private List<Comment> comments = null;

    private String name;

    public boolean addProcessingInstructions(ProcessingInstruction processingInstructions) {
        boolean res = getProcessingInstructions().add(processingInstructions);
        if (res) {
            if (processingInstructions != null) {
                processingInstructions.setParent(this);
            }
        }
        return res;
    }

    public boolean removeProcessingInstructions(ProcessingInstruction processingInstructions) {
        boolean res = getProcessingInstructions().remove(processingInstructions);
        if (res) {
            if (processingInstructions != null) {
                processingInstructions.setParent(null);
            }
        }
        return res;
    }

    public List<ProcessingInstruction> getProcessingInstructions() {
        return processingInstructions;
    }

    public void setProcessingInstructions(List<ProcessingInstruction> processingInstructions) {
        if (processingInstructions != null) {
            for (ProcessingInstruction item : processingInstructions) {
                item.setParent(this);
            }
        }
        this.processingInstructions = processingInstructions;
    }

    public Element getRoot() {
        return root;
    }

    public void setRoot(Element root) {
        if (root != null) {
            root.setParent(this);
        }
        this.root = root;
    }

    public boolean addComments(Comment comments) {
        boolean res = getComments().add(comments);
        if (res) {
            if (comments != null) {
                comments.setParent(this);
            }
        }
        return res;
    }

    public boolean removeComments(Comment comments) {
        boolean res = getComments().remove(comments);
        if (res) {
            if (comments != null) {
                comments.setParent(null);
            }
        }
        return res;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        if (comments != null) {
            for (Comment item : comments) {
                item.setParent(this);
            }
        }
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Fxml() {
        super();
    }

    Fxml(List<ProcessingInstruction> processingInstructions, Element root, List<Comment> comments, String name) {
        super();
        setProcessingInstructions(processingInstructions);
        setRoot(root);
        setComments(comments);
        setName(name);
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
