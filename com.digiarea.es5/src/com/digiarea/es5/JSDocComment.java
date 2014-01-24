/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class JavadocComment.
 */
public final class JSDocComment extends Comment {

    JSDocComment() {
        super();
    }

    JSDocComment(String content, int posBegin, int posEnd) {
        super(content, posBegin, posEnd);
    }

    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
