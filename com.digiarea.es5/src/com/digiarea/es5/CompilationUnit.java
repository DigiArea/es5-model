/*******************************************************************************
 * Copyright (c) 2011 - 2014 DigiArea, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DigiArea, Inc. - initial API and implementation
 *******************************************************************************/
package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
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

    /**
     * Gets the elements.
     *
     * @return the elements
     */
    public NodeList<Statement> getElements() {
        return elements;
    }

    /**
     * Sets the elements.
     *
     * @param elements the new elements
     */
    public void setElements(NodeList<Statement> elements) {
        this.elements = elements;
    }

    /**
     * Gets the comments.
     *
     * @return the comments
     */
    public NodeList<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the comments.
     *
     * @param comments the new comments
     */
    public void setComments(NodeList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new compilation unit.
     */
    CompilationUnit() {
        super();
    }

    /**
     * Instantiates a new compilation unit.
     *
     * @param elements the elements
     * @param comments the comments
     * @param name the name
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    CompilationUnit(NodeList<Statement> elements, NodeList<Comment> comments, String name, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.elements = elements;
        this.comments = comments;
        this.name = name;
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.Node#accept(com.digiarea.es5.visitor.VoidVisitor, java.lang.Object)
     */
    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.Node#accept(com.digiarea.es5.visitor.GenericVisitor, java.lang.Object)
     */
    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
