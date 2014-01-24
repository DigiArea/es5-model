/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public final class UnaryExpression extends Expression {

    public static enum UnaryOperator {

        positive, 
        negative, 
        preIncrement, 
        preDecrement, 
        not, 
        rem, 
        inverse, 
        posIncrement, 
        posDecrement, 
        delete, 
        opVoid, 
        typeof;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    private Expression expression;

    private UnaryExpression.UnaryOperator unaryOperator;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public UnaryExpression.UnaryOperator getUnaryOperator() {
        return unaryOperator;
    }

    public void setUnaryOperator(UnaryExpression.UnaryOperator unaryOperator) {
        this.unaryOperator = unaryOperator;
    }

    UnaryExpression() {
        super();
    }

    UnaryExpression(Expression expression, UnaryExpression.UnaryOperator unaryOperator, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expression = expression;
        this.unaryOperator = unaryOperator;
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
