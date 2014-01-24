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
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;

/** 
 * The Class PropertyAssignment.
 */
public abstract class PropertyAssignment extends Expression {

    /** 
     * The property name.
     */
    private PropertyName propertyName;

    /** 
     * The comment.
     */
    private Comment comment = null;

    /**
     * Gets the property name.
     *
     * @return the property name
     */
    public PropertyName getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the property name.
     *
     * @param propertyName the new property name
     */
    public void setPropertyName(PropertyName propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment the new comment
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    /**
     * Instantiates a new property assignment.
     */
    PropertyAssignment() {
        super();
    }

    /**
     * Instantiates a new property assignment.
     *
     * @param propertyName the property name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    PropertyAssignment(PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.propertyName = propertyName;
        this.comment = comment;
    }

}
