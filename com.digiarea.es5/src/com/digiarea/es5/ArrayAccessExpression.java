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
 * The Class ArrayAccessExpression.
 */
public class ArrayAccessExpression extends Expression {

    /** 
     * The name.
     */
    private Expression name;

    /** 
     * The index.
     */
    private Expression index;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public Expression getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(Expression name) {
        this.name = name;
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    public Expression getIndex() {
        return index;
    }

    /**
     * Sets the index.
     *
     * @param index the new index
     */
    public void setIndex(Expression index) {
        this.index = index;
    }

    /**
     * Instantiates a new array access expression.
     */
    ArrayAccessExpression() {
        super();
    }

    /**
     * Instantiates a new array access expression.
     *
     * @param name the name
     * @param index the index
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    ArrayAccessExpression(Expression name, Expression index, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.name = name;
        this.index = index;
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
