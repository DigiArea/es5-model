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
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class LetExpression.
 */
public class LetExpression extends Expression {

    /** 
     * The variable declarations.
     */
    private NodeList<VariableDeclaration> variableDeclarations = null;

    /** 
     * The expression.
     */
    private Expression expression = null;

    /**
     * Gets the variable declarations.
     *
     * @return the variable declarations
     */
    public NodeList<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    /**
     * Sets the variable declarations.
     *
     * @param variableDeclarations the new variable declarations
     */
    public void setVariableDeclarations(NodeList<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }

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
     * Instantiates a new let expression.
     */
    LetExpression() {
        super();
    }

    /**
     * Instantiates a new let expression.
     *
     * @param variableDeclarations the variable declarations
     * @param expression the expression
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    LetExpression(NodeList<VariableDeclaration> variableDeclarations, Expression expression, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.variableDeclarations = variableDeclarations;
        this.expression = expression;
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
