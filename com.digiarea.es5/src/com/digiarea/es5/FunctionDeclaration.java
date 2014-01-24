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

import com.digiarea.es5.Statement;
import com.digiarea.es5.Parameter;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Block;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class FunctionDeclaration.
 */
public class FunctionDeclaration extends Statement {

    /** 
     * The name.
     */
    private String name;

    /** 
     * The parameters.
     */
    private NodeList<Parameter> parameters;

    /** 
     * The body.
     */
    private Block body;

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
     * Gets the parameters.
     *
     * @return the parameters
     */
    public NodeList<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters.
     *
     * @param parameters the new parameters
     */
    public void setParameters(NodeList<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public Block getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(Block body) {
        this.body = body;
    }

    /**
     * Instantiates a new function declaration.
     */
    FunctionDeclaration() {
        super();
    }

    /**
     * Instantiates a new function declaration.
     *
     * @param name the name
     * @param parameters the parameters
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    FunctionDeclaration(String name, NodeList<Parameter> parameters, Block body, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.name = name;
        this.parameters = parameters;
        this.body = body;
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
