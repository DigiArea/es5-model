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
 * The Class WithStatement.
 */
public class WithStatement extends Statement {

    /** 
     * The expression.
     */
    private Expression expression;

    /** 
     * The statement.
     */
    private Statement statement;

    /**
     * Gets the expression.
     *
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Sets the expression.
     *
     * @param expression the new expression
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
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
     * Instantiates a new with statement.
     */
    WithStatement() {
        super();
    }

    /**
     * Instantiates a new with statement.
     *
     * @param expression the expression
     * @param statement the statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    WithStatement(Expression expression, Statement statement, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.expression = expression;
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
