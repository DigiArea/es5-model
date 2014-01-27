package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class CompilationUnit.
 */
public class CompilationUnit extends Node {

    /** 
     * The elements.
     */
    private NodeList<Statement> elements;

    /** 
     * The comments.
     */
    private NodeList<Comment> comments;

    /** 
     * The name.
     */
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

    CompilationUnit() {
        super();
    }

    CompilationUnit(NodeList<Statement> elements, NodeList<Comment> comments, String name, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
