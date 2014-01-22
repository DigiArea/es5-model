package com.digiarea.es5;

import com.digiarea.es5.Node;

/** 
 * The Class Comment.
 */
public abstract class Comment extends Node {

    /** The content.
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment() {
        super();
    }

    public Comment(String content, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.content = content;
    }

}
