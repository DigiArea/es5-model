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

import com.digiarea.es5.Node;
import com.digiarea.es5.Comment;

/** 
 * The Class Statement.
 */
public abstract class Statement extends Node {

    /** 
     * The comment.
     */
    private Comment comment = null;

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
     * Instantiates a new statement.
     */
    Statement() {
        super();
    }

    /**
     * Instantiates a new statement.
     *
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    Statement(Comment comment, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.comment = comment;
    }

}
