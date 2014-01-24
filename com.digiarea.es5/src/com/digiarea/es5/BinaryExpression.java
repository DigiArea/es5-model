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
 * The Class BinaryExpression.
 */
public class BinaryExpression extends Expression {

    /** 
     * The Enum BinaryOperator.
     */
    public static enum BinaryOperator {

        /** 
         * The or.
         */
        or, 
        /** 
         * The and.
         */
        and, 
        /** 
         * The bin or.
         */
        binOr, 
        /** 
         * The bin and.
         */
        binAnd, 
        /** 
         * The xor.
         */
        xor, 
        /** 
         * The equals.
         */
        equals, 
        /** 
         * The not equals.
         */
        notEquals, 
        /** 
         * The identity.
         */
        identity, 
        /** 
         * The not identity.
         */
        notIdentity, 
        /** 
         * The less.
         */
        less, 
        /** 
         * The greater.
         */
        greater, 
        /** 
         * The less equals.
         */
        lessEquals, 
        /** 
         * The greater equals.
         */
        greaterEquals, 
        /** 
         * The l shift.
         */
        lShift, 
        /** 
         * The r signed shift.
         */
        rSignedShift, 
        /** 
         * The r unsigned shift.
         */
        rUnsignedShift, 
        /** 
         * The plus.
         */
        plus, 
        /** 
         * The minus.
         */
        minus, 
        /** 
         * The times.
         */
        times, 
        /** 
         * The divide.
         */
        divide, 
        /** 
         * The remainder.
         */
        remainder, 
        /** 
         * The op instanceof.
         */
        opInstanceof, 
        /** 
         * The in.
         */
        in;

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
     * The left.
     */
    private Expression left;

    /** 
     * The right.
     */
    private Expression right;

    /** 
     * The binary operator.
     */
    private BinaryExpression.BinaryOperator binaryOperator;

    /**
     * Gets the left.
     *
     * @return the left
     */
    public Expression getLeft() {
        return left;
    }

    /**
     * Sets the left.
     *
     * @param left the new left
     */
    public void setLeft(Expression left) {
        this.left = left;
    }

    /**
     * Gets the right.
     *
     * @return the right
     */
    public Expression getRight() {
        return right;
    }

    /**
     * Sets the right.
     *
     * @param right the new right
     */
    public void setRight(Expression right) {
        this.right = right;
    }

    /**
     * Gets the binary operator.
     *
     * @return the binary operator
     */
    public BinaryExpression.BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    /**
     * Sets the binary operator.
     *
     * @param binaryOperator the new binary operator
     */
    public void setBinaryOperator(BinaryExpression.BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    /**
     * Instantiates a new binary expression.
     */
    BinaryExpression() {
        super();
    }

    /**
     * Instantiates a new binary expression.
     *
     * @param left the left
     * @param right the right
     * @param binaryOperator the binary operator
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    BinaryExpression(Expression left, Expression right, BinaryExpression.BinaryOperator binaryOperator, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.left = left;
        this.right = right;
        this.binaryOperator = binaryOperator;
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
