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

public interface GenericVisitor<R, C> {

    public R visit(Attribute n, C ctx) throws Exception;

    public R visit(AttributeType n, C ctx) throws Exception;

    public R visit(Comment n, C ctx) throws Exception;

    public R visit(CopyElement n, C ctx) throws Exception;

    public R visit(DefineElement n, C ctx) throws Exception;

    public R visit(Fxml n, C ctx) throws Exception;

    public R visit(ImportProcessing n, C ctx) throws Exception;

    public R visit(ImportType n, C ctx) throws Exception;

    public R visit(IncludeElement n, C ctx) throws Exception;

    public R visit(InstanceDeclarationElement n, C ctx) throws Exception;

    public R visit(LanguageProcessing n, C ctx) throws Exception;

    public R visit(Project n, C ctx) throws Exception;

    public R visit(PropertyElement n, C ctx) throws Exception;

    public R visit(PropertyType n, C ctx) throws Exception;

    public R visit(ReferenceElement n, C ctx) throws Exception;

    public R visit(RootElement n, C ctx) throws Exception;

    public R visit(ScriptElement n, C ctx) throws Exception;

    public R visit(UknownStaticPropertyElement n, C ctx) throws Exception;

    public R visit(UknownTypeElement n, C ctx) throws Exception;

}
