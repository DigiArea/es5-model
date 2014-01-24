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
 * The Class WhileStatement.
 */
public class WhileStatement extends Statement {

    /** 
     * The condition.
     */
    private Expression condition;

    /** 
     * The body.
     */
    private Statement body;

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
     * Gets the body.
     *
     * @return the body
     */
    public Statement getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(Statement body) {
        this.body = body;
    }

    /**
     * Instantiates a new while statement.
     */
    WhileStatement() {
        super();
    }

    /**
     * Instantiates a new while statement.
     *
     * @param condition the condition
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    WhileStatement(Expression condition, Statement body, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.condition = condition;
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
