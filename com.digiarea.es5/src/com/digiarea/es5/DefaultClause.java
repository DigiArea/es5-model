package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class DefaultClause.
 */
public class DefaultClause extends Node {

    /** 
     * The statements.
     */
    private NodeList<Statement> statements;

    public NodeList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(NodeList<Statement> statements) {
        this.statements = statements;
    }

    DefaultClause() {
        super();
    }

    DefaultClause(NodeList<Statement> statements, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
