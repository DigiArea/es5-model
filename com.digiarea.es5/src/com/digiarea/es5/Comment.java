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

/** 
 * The Class Comment.
 */
public abstract class Comment extends Node {

    /** The content.
     */
    private String content;

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Instantiates a new comment.
     */
    Comment() {
        super();
    }

    /**
     * Instantiates a new comment.
     *
     * @param content the content
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    Comment(String content, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.content = content;
    }

}
