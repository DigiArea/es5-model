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
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class LetDefinition.
 */
public class LetDefinition extends Statement {

    /** 
     * The variable declarations.
     */
    private NodeList<VariableDeclaration> variableDeclarations = null;

    /**
     * Gets the variable declarations.
     *
     * @return the variable declarations
     */
    public NodeList<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    /**
     * Sets the variable declarations.
     *
     * @param variableDeclarations the new variable declarations
     */
    public void setVariableDeclarations(NodeList<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }

    /**
     * Instantiates a new let definition.
     */
    LetDefinition() {
        super();
    }

    /**
     * Instantiates a new let definition.
     *
     * @param variableDeclarations the variable declarations
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    LetDefinition(NodeList<VariableDeclaration> variableDeclarations, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.variableDeclarations = variableDeclarations;
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
