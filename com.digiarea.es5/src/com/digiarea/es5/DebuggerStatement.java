package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class DebuggerStatement extends Statement {

    public DebuggerStatement() {
        super();
    }

    public DebuggerStatement(Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
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
