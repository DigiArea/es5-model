package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.JSDocComment;

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

    Comment() {
        super();
    }

    Comment(String content, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.content = content;
    }

}
