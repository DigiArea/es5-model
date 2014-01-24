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
import com.digiarea.es5.IdentifierName;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class FieldAccessExpression.
 */
public class FieldAccessExpression extends Expression {

    /** 
     * The scope.
     */
    private Expression scope;

    /** 
     * The field.
     */
    private IdentifierName field;

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
     * Gets the field.
     *
     * @return the field
     */
    public IdentifierName getField() {
        return field;
    }

    /**
     * Sets the field.
     *
     * @param field the new field
     */
    public void setField(IdentifierName field) {
        this.field = field;
    }

    /**
     * Instantiates a new field access expression.
     */
    FieldAccessExpression() {
        super();
    }

    /**
     * Instantiates a new field access expression.
     *
     * @param scope the scope
     * @param field the field
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    FieldAccessExpression(Expression scope, IdentifierName field, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.scope = scope;
        this.field = field;
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
