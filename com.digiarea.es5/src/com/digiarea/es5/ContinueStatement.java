package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class ContinueStatement extends Statement {

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ContinueStatement() {
        super();
    }

    public ContinueStatement(String identifier, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.identifier = identifier;
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
