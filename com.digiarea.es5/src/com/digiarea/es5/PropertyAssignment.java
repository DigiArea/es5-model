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

public abstract class PropertyAssignment extends Expression {

    private PropertyName propertyName;

    private Comment comment = null;

    public PropertyName getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(PropertyName propertyName) {
        this.propertyName = propertyName;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    PropertyAssignment() {
        super();
    }

    PropertyAssignment(PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.propertyName = propertyName;
        this.comment = comment;
    }

}
