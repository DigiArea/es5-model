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

/** 
 * The Class NewExpression.
 */
public class NewExpression extends Expression {

    /** 
     * The expression.
     */
    private Expression expression = null;

    /** 
     * The initializer.
     */
    private ObjectLiteral initializer = null;

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
     * Gets the initializer.
     *
     * @return the initializer
     */
    public ObjectLiteral getInitializer() {
        return initializer;
    }

    /**
     * Sets the initializer.
     *
     * @param initializer the new initializer
     */
    public void setInitializer(ObjectLiteral initializer) {
        this.initializer = initializer;
    }

    /**
     * Instantiates a new new expression.
     */
    NewExpression() {
        super();
    }

    /**
     * Instantiates a new new expression.
     *
     * @param expression the expression
     * @param initializer the initializer
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    NewExpression(Expression expression, ObjectLiteral initializer, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expression = expression;
        this.initializer = initializer;
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
