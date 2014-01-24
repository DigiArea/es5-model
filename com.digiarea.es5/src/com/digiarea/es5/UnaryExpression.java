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
 * The Class UnaryExpression.
 */
public final class UnaryExpression extends Expression {

    /** 
     * The Enum UnaryOperator.
     */
    public static enum UnaryOperator {

        /** 
         * The positive.
         */
        positive, 
        /** 
         * The negative.
         */
        negative, 
        /** 
         * The pre increment.
         */
        preIncrement, 
        /** 
         * The pre decrement.
         */
        preDecrement, 
        /** 
         * The not.
         */
        not, 
        /** 
         * The rem.
         */
        rem, 
        /** 
         * The inverse.
         */
        inverse, 
        /** 
         * The pos increment.
         */
        posIncrement, 
        /** 
         * The pos decrement.
         */
        posDecrement, 
        /** 
         * The delete.
         */
        delete, 
        /** 
         * The op void.
         */
        opVoid, 
        /** 
         * The typeof.
         */
        typeof;

        /**
         * Accept.
         *
         * @param <C> the generic type
         * @param v the v
         * @param ctx the ctx
         * @throws Exception the exception
         */
        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        /**
         * Accept.
         *
         * @param <R> the generic type
         * @param <C> the generic type
         * @param v the v
         * @param ctx the ctx
         * @return the r
         * @throws Exception the exception
         */
        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    /** 
     * The expression.
     */
    private Expression expression;

    /** 
     * The unary operator.
     */
    private UnaryExpression.UnaryOperator unaryOperator;

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
     * Gets the unary operator.
     *
     * @return the unary operator
     */
    public UnaryExpression.UnaryOperator getUnaryOperator() {
        return unaryOperator;
    }

    /**
     * Sets the unary operator.
     *
     * @param unaryOperator the new unary operator
     */
    public void setUnaryOperator(UnaryExpression.UnaryOperator unaryOperator) {
        this.unaryOperator = unaryOperator;
    }

    /**
     * Instantiates a new unary expression.
     */
    UnaryExpression() {
        super();
    }

    /**
     * Instantiates a new unary expression.
     *
     * @param expression the expression
     * @param unaryOperator the unary operator
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    UnaryExpression(Expression expression, UnaryExpression.UnaryOperator unaryOperator, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expression = expression;
        this.unaryOperator = unaryOperator;
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
