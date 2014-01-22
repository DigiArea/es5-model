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

public class AssignmentExpression extends Expression {

    public static enum AssignOperator {

        assign, 
        plus, 
        minus, 
        star, 
        slash, 
        and, 
        or, 
        xor, 
        rem, 
        lShift, 
        rSignedShift, 
        rUnsignedShift;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    private Expression target;

    private Expression value;

    private AssignmentExpression.AssignOperator assignOperator;

    public Expression getTarget() {
        return target;
    }

    public void setTarget(Expression target) {
        this.target = target;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    public AssignmentExpression.AssignOperator getAssignOperator() {
        return assignOperator;
    }

    public void setAssignOperator(AssignmentExpression.AssignOperator assignOperator) {
        this.assignOperator = assignOperator;
    }

    public AssignmentExpression() {
        super();
    }

    public AssignmentExpression(Expression target, Expression value, AssignmentExpression.AssignOperator assignOperator, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.target = target;
        this.value = value;
        this.assignOperator = assignOperator;
    }

    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}