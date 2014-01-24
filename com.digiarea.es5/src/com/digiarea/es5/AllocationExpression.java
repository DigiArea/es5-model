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
 * The Class AllocationExpression.
 */
public class AllocationExpression extends Expression {

    /** 
     * The body.
     */
    private Expression body;

    /**
     * Gets the body.
     *
     * @return the body
     */
    public Expression getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(Expression body) {
        this.body = body;
    }

    /**
     * Instantiates a new allocation expression.
     */
    AllocationExpression() {
        super();
    }

    /**
     * Instantiates a new allocation expression.
     *
     * @param body the body
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    AllocationExpression(Expression body, int posBegin, int posEnd) {
        super(posBegin, posEnd);
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
