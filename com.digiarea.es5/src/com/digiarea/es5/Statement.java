/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Comment;

public abstract class Statement extends Node {

    private Comment comment = null;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    Statement() {
        super();
    }

    Statement(Comment comment, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.comment = comment;
    }

}
