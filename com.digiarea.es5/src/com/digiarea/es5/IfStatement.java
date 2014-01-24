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
import com.digiarea.es5.Expression;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class IfStatement.
 */
public class IfStatement extends Statement {

    /** 
     * The condition.
     */
    private Expression condition;

    /** 
     * The then statement.
     */
    private Statement thenStatement;

    /** 
     * The else statement.
     */
    private Statement elseStatement;

    /**
     * Gets the condition.
     *
     * @return the condition
     */
    public Expression getCondition() {
        return condition;
    }

    /**
     * Sets the condition.
     *
     * @param condition the new condition
     */
    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    /**
     * Gets the then statement.
     *
     * @return the then statement
     */
    public Statement getThenStatement() {
        return thenStatement;
    }

    /**
     * Sets the then statement.
     *
     * @param thenStatement the new then statement
     */
    public void setThenStatement(Statement thenStatement) {
        this.thenStatement = thenStatement;
    }

    /**
     * Gets the else statement.
     *
     * @return the else statement
     */
    public Statement getElseStatement() {
        return elseStatement;
    }

    /**
     * Sets the else statement.
     *
     * @param elseStatement the new else statement
     */
    public void setElseStatement(Statement elseStatement) {
        this.elseStatement = elseStatement;
    }

    /**
     * Instantiates a new if statement.
     */
    IfStatement() {
        super();
    }

    /**
     * Instantiates a new if statement.
     *
     * @param condition the condition
     * @param thenStatement the then statement
     * @param elseStatement the else statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    IfStatement(Expression condition, Statement thenStatement, Statement elseStatement, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
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
