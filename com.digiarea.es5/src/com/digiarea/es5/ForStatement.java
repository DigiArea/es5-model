package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class ForStatement.
 */
public class ForStatement extends Statement {

    /** 
     * The variable.
     */
    private Expression variable;

    /** 
     * The condition.
     */
    private Expression condition;

    /** 
     * The expr.
     */
    private Expression expr;

    /** 
     * The body.
     */
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

    ForStatement(Expression variable, Expression condition, Expression expr, Statement body, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
