package com.digiarea.fxml;

import java.util.List;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class Project extends Node {

    private String name;

    private List<Fxml> fxmls = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addFxmls(Fxml fxmls) {
        boolean res = getFxmls().add(fxmls);
        if (res) {
            if (fxmls != null) {
                fxmls.setParent(this);
            }
        }
        return res;
    }

    public boolean removeFxmls(Fxml fxmls) {
        boolean res = getFxmls().remove(fxmls);
        if (res) {
            if (fxmls != null) {
                fxmls.setParent(null);
            }
        }
        return res;
    }

    public List<Fxml> getFxmls() {
        return fxmls;
    }

    public void setFxmls(List<Fxml> fxmls) {
        if (fxmls != null) {
            for (Fxml item : fxmls) {
                item.setParent(this);
            }
        }
        this.fxmls = fxmls;
    }

    Project() {
        super();
    }

    Project(String name, List<Fxml> fxmls) {
        super();
        setName(name);
        setFxmls(fxmls);
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
