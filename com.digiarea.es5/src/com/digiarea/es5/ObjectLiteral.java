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
import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class ObjectLiteral.
 */
public class ObjectLiteral extends Literal {

    /** 
     * The property assignments.
     */
    private NodeList<PropertyAssignment> propertyAssignments;

    /**
     * Gets the property assignments.
     *
     * @return the property assignments
     */
    public NodeList<PropertyAssignment> getPropertyAssignments() {
        return propertyAssignments;
    }

    /**
     * Sets the property assignments.
     *
     * @param propertyAssignments the new property assignments
     */
    public void setPropertyAssignments(NodeList<PropertyAssignment> propertyAssignments) {
        this.propertyAssignments = propertyAssignments;
    }

    /**
     * Instantiates a new object literal.
     */
    ObjectLiteral() {
        super();
    }

    /**
     * Instantiates a new object literal.
     *
     * @param propertyAssignments the property assignments
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    ObjectLiteral(NodeList<PropertyAssignment> propertyAssignments, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.propertyAssignments = propertyAssignments;
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
