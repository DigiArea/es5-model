package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class CompilationUnit extends Node {

    private NodeList<Statement> elements;

    private NodeList<Comment> comments;

    private String name;

    public NodeList<Statement> getElements() {
        return elements;
    }

    public void setElements(NodeList<Statement> elements) {
        this.elements = elements;
    }

    public NodeList<Comment> getComments() {
        return comments;
    }

    public void setComments(NodeList<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompilationUnit() {
        super();
    }

    public CompilationUnit(NodeList<Statement> elements, NodeList<Comment> comments, String name, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.elements = elements;
        this.comments = comments;
        this.name = name;
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
