/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class ForStatement extends Statement {

    private Expression variable;

    private Expression condition;

    private Expression expr;

    private Statement body;

    public Expression getVariable() {
        return variable;
    }

    public void setVariable(Expression variable) {
        this.variable = variable;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }

    ForStatement() {
        super();
    }

    ForStatement(Expression variable, Expression condition, Expression expr, Statement body, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.variable = variable;
        this.condition = condition;
        this.expr = expr;
        this.body = body;
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
