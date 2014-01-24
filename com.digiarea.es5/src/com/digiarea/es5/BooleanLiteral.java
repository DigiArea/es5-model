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

import com.digiarea.es5.Literal;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class BooleanLiteral.
 */
public class BooleanLiteral extends Literal {

    /** 
     * The value.
     */
    private boolean value;

    /**
     * Checks if is value.
     *
     * @return true, if is value
     */
    public boolean isValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * Instantiates a new boolean literal.
     */
    BooleanLiteral() {
        super();
    }

    /**
     * Instantiates a new boolean literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    BooleanLiteral(boolean value, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.value = value;
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
