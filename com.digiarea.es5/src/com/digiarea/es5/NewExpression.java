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
import com.digiarea.es5.ObjectLiteral;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class NewExpression extends Expression {

    private Expression expression = null;

    private ObjectLiteral initializer = null;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ObjectLiteral getInitializer() {
        return initializer;
    }

    public void setInitializer(ObjectLiteral initializer) {
        this.initializer = initializer;
    }

    NewExpression() {
        super();
    }

    NewExpression(Expression expression, ObjectLiteral initializer, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expression = expression;
        this.initializer = initializer;
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
