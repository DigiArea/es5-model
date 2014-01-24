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

import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.Expression;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class PutAssignment.
 */
public class PutAssignment extends PropertyAssignment {

    /** 
     * The property value.
     */
    private Expression propertyValue;

    /**
     * Gets the property value.
     *
     * @return the property value
     */
    public Expression getPropertyValue() {
        return propertyValue;
    }

    /**
     * Sets the property value.
     *
     * @param propertyValue the new property value
     */
    public void setPropertyValue(Expression propertyValue) {
        this.propertyValue = propertyValue;
    }

    /**
     * Instantiates a new put assignment.
     */
    PutAssignment() {
        super();
    }

    /**
     * Instantiates a new put assignment.
     *
     * @param propertyValue the property value
     * @param propertyName the property name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    PutAssignment(Expression propertyValue, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(propertyName, comment, posBegin, posEnd);
        this.propertyValue = propertyValue;
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
