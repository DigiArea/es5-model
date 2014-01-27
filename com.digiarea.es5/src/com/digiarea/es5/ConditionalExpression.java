package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class ConditionalExpression.
 */
public class ConditionalExpression extends Expression {

    /** 
     * The condition.
     */
    private Expression condition;

    /** 
     * The then expr.
     */
    private Expression thenExpr;

    /** 
     * The else expr.
     */
    private Expression elseExpr;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Expression getThenExpr() {
        return thenExpr;
    }

    public void setThenExpr(Expression thenExpr) {
        this.thenExpr = thenExpr;
    }

    public Expression getElseExpr() {
        return elseExpr;
    }

    public void setElseExpr(Expression elseExpr) {
        this.elseExpr = elseExpr;
    }

    ConditionalExpression() {
        super();
    }

    ConditionalExpression(Expression condition, Expression thenExpr, Expression elseExpr, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
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
