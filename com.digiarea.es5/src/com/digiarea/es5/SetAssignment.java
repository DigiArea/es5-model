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

import com.digiarea.es5.GetAssignment;
import com.digiarea.es5.Block;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class SetAssignment.
 */
public class SetAssignment extends GetAssignment {

    /** 
     * The identifier.
     */
    private String identifier;

    /**
     * Gets the identifier.
     *
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier.
     *
     * @param identifier the new identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Instantiates a new sets the assignment.
     */
    SetAssignment() {
        super();
    }

    /**
     * Instantiates a new sets the assignment.
     *
     * @param identifier the identifier
     * @param block the block
     * @param propertyName the property name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    SetAssignment(String identifier, Block block, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(block, propertyName, comment, posBegin, posEnd);
        this.identifier = identifier;
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.GetAssignment#accept(com.digiarea.es5.visitor.VoidVisitor, java.lang.Object)
     */
    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.GetAssignment#accept(com.digiarea.es5.visitor.GenericVisitor, java.lang.Object)
     */
    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
