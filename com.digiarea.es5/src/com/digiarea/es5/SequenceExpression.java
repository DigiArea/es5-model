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
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class SequenceExpression.
 */
public class SequenceExpression extends Expression {

    /** 
     * The expressions.
     */
    private NodeList<Expression> expressions;

    /**
     * Gets the expressions.
     *
     * @return the expressions
     */
    public NodeList<Expression> getExpressions() {
        return expressions;
    }

    /**
     * Sets the expressions.
     *
     * @param expressions the new expressions
     */
    public void setExpressions(NodeList<Expression> expressions) {
        this.expressions = expressions;
    }

    /**
     * Instantiates a new sequence expression.
     */
    SequenceExpression() {
        super();
    }

    /**
     * Instantiates a new sequence expression.
     *
     * @param expressions the expressions
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    SequenceExpression(NodeList<Expression> expressions, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expressions = expressions;
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
