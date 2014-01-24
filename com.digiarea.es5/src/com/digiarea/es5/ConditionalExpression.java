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

import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class ConditionalExpression.
 */
public class ConditionalExpression extends Expression {

    /** 
     * The condition.
     */
    private Expression condition;

    /** 
     * The then expr.
     */
    private Expression thenExpr;

    /** 
     * The else expr.
     */
    private Expression elseExpr;

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
     * Gets the then expr.
     *
     * @return the then expr
     */
    public Expression getThenExpr() {
        return thenExpr;
    }

    /**
     * Sets the then expr.
     *
     * @param thenExpr the new then expr
     */
    public void setThenExpr(Expression thenExpr) {
        this.thenExpr = thenExpr;
    }

    /**
     * Gets the else expr.
     *
     * @return the else expr
     */
    public Expression getElseExpr() {
        return elseExpr;
    }

    /**
     * Sets the else expr.
     *
     * @param elseExpr the new else expr
     */
    public void setElseExpr(Expression elseExpr) {
        this.elseExpr = elseExpr;
    }

    /**
     * Instantiates a new conditional expression.
     */
    ConditionalExpression() {
        super();
    }

    /**
     * Instantiates a new conditional expression.
     *
     * @param condition the condition
     * @param thenExpr the then expr
     * @param elseExpr the else expr
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    ConditionalExpression(Expression condition, Expression thenExpr, Expression elseExpr, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
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
