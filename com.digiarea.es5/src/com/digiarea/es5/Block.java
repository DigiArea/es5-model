/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public final class Block extends Statement {

    private NodeList<Statement> statements;

    public NodeList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(NodeList<Statement> statements) {
        this.statements = statements;
    }

    Block() {
        super();
    }

    Block(NodeList<Statement> statements, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.statements = statements;
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
