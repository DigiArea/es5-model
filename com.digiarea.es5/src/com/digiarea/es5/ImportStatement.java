/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.IdentifierName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class ImportStatement extends Statement {

    private IdentifierName name;

    public IdentifierName getName() {
        return name;
    }

    public void setName(IdentifierName name) {
        this.name = name;
    }

    ImportStatement() {
        super();
    }

    ImportStatement(IdentifierName name, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.name = name;
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
