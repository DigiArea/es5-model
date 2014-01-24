/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Expression;
import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class CaseClause extends Node {

    private Expression expression;

    private NodeList<Statement> statements;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public NodeList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(NodeList<Statement> statements) {
        this.statements = statements;
    }

    CaseClause() {
        super();
    }

    CaseClause(Expression expression, NodeList<Statement> statements, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expression = expression;
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
