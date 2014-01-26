package com.digiarea.fxml;

import com.digiarea.fxml.visitor.GenericVisitor;
import com.digiarea.fxml.visitor.VoidVisitor;

public class ImportProcessing extends ProcessingInstruction {

    public enum ImportType {

        IMPORT_PACKAGE, 
        IMPORT_CLASS;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    private ImportProcessing.ImportType importType = null;

    private String value;

    public ImportProcessing.ImportType getImportType() {
        return importType;
    }

    public void setImportType(ImportProcessing.ImportType importType) {
        this.importType = importType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ImportProcessing() {
        super();
    }

    ImportProcessing(ImportProcessing.ImportType importType, String value) {
        super();
        setImportType(importType);
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
