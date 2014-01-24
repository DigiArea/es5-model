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
 * The Class CallExpression.
 */
public class CallExpression extends Expression {

    /** 
     * The scope.
     */
    private Expression scope;

    /** 
     * The args.
     */
    private NodeList<Expression> args;

    /**
     * Gets the scope.
     *
     * @return the scope
     */
    public Expression getScope() {
        return scope;
    }

    /**
     * Sets the scope.
     *
     * @param scope the new scope
     */
    public void setScope(Expression scope) {
        this.scope = scope;
    }

    /**
     * Gets the args.
     *
     * @return the args
     */
    public NodeList<Expression> getArgs() {
        return args;
    }

    /**
     * Sets the args.
     *
     * @param args the new args
     */
    public void setArgs(NodeList<Expression> args) {
        this.args = args;
    }

    /**
     * Instantiates a new call expression.
     */
    CallExpression() {
        super();
    }

    /**
     * Instantiates a new call expression.
     *
     * @param scope the scope
     * @param args the args
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    CallExpression(Expression scope, NodeList<Expression> args, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.scope = scope;
        this.args = args;
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
