/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class EnclosedExpression extends Expression {

    private Expression inner;

    public Expression getInner() {
        return inner;
    }

    public void setInner(Expression inner) {
        this.inner = inner;
    }

    EnclosedExpression() {
        super();
    }

    EnclosedExpression(Expression inner, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.inner = inner;
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
