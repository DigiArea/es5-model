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
 * The Class LetStatement.
 */
public class LetStatement extends Statement {

    /** 
     * The variable declarations.
     */
    private NodeList<VariableDeclaration> variableDeclarations = null;

    /** 
     * The statement.
     */
    private Statement statement = null;

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
     * Gets the statement.
     *
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Sets the statement.
     *
     * @param statement the new statement
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * Instantiates a new let statement.
     */
    LetStatement() {
        super();
    }

    /**
     * Instantiates a new let statement.
     *
     * @param variableDeclarations the variable declarations
     * @param statement the statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    LetStatement(NodeList<VariableDeclaration> variableDeclarations, Statement statement, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.variableDeclarations = variableDeclarations;
        this.statement = statement;
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
