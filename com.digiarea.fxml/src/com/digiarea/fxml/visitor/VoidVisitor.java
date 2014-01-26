package com.digiarea.fxml.visitor;

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

public interface VoidVisitor<C> {

    public void visit(Attribute n, C ctx) throws Exception;

    public void visit(AttributeType n, C ctx) throws Exception;

    public void visit(Comment n, C ctx) throws Exception;

    public void visit(CopyElement n, C ctx) throws Exception;

    public void visit(DefineElement n, C ctx) throws Exception;

    public void visit(Fxml n, C ctx) throws Exception;

    public void visit(ImportProcessing n, C ctx) throws Exception;

    public void visit(ImportType n, C ctx) throws Exception;

    public void visit(IncludeElement n, C ctx) throws Exception;

    public void visit(InstanceDeclarationElement n, C ctx) throws Exception;

    public void visit(LanguageProcessing n, C ctx) throws Exception;

    public void visit(Project n, C ctx) throws Exception;

    public void visit(PropertyElement n, C ctx) throws Exception;

    public void visit(PropertyType n, C ctx) throws Exception;

    public void visit(ReferenceElement n, C ctx) throws Exception;

    public void visit(RootElement n, C ctx) throws Exception;

    public void visit(ScriptElement n, C ctx) throws Exception;

    public void visit(UknownStaticPropertyElement n, C ctx) throws Exception;

    public void visit(UknownTypeElement n, C ctx) throws Exception;

}
