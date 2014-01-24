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
 * The Class AssignmentExpression.
 */
public class AssignmentExpression extends Expression {

    /** 
     * The Enum AssignOperator.
     */
    public static enum AssignOperator {

        /** 
         * The assign.
         */
        assign, 
        /** 
         * The plus.
         */
        plus, 
        /** 
         * The minus.
         */
        minus, 
        /** 
         * The star.
         */
        star, 
        /** 
         * The slash.
         */
        slash, 
        /** 
         * The and.
         */
        and, 
        /** 
         * The or.
         */
        or, 
        /** 
         * The xor.
         */
        xor, 
        /** 
         * The rem.
         */
        rem, 
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
        rUnsignedShift;

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
     * The target.
     */
    private Expression target;

    /** 
     * The value.
     */
    private Expression value;

    /** 
     * The assign operator.
     */
    private AssignmentExpression.AssignOperator assignOperator;

    /**
     * Gets the target.
     *
     * @return the target
     */
    public Expression getTarget() {
        return target;
    }

    /**
     * Sets the target.
     *
     * @param target the new target
     */
    public void setTarget(Expression target) {
        this.target = target;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public Expression getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(Expression value) {
        this.value = value;
    }

    /**
     * Gets the assign operator.
     *
     * @return the assign operator
     */
    public AssignmentExpression.AssignOperator getAssignOperator() {
        return assignOperator;
    }

    /**
     * Sets the assign operator.
     *
     * @param assignOperator the new assign operator
     */
    public void setAssignOperator(AssignmentExpression.AssignOperator assignOperator) {
        this.assignOperator = assignOperator;
    }

    /**
     * Instantiates a new assignment expression.
     */
    AssignmentExpression() {
        super();
    }

    /**
     * Instantiates a new assignment expression.
     *
     * @param target the target
     * @param value the value
     * @param assignOperator the assign operator
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    AssignmentExpression(Expression target, Expression value, AssignmentExpression.AssignOperator assignOperator, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.target = target;
        this.value = value;
        this.assignOperator = assignOperator;
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
