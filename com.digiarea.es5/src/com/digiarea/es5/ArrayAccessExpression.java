/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class ArrayAccessExpression extends Expression {

    private Expression name;

    private Expression index;

    public Expression getName() {
        return name;
    }

    public void setName(Expression name) {
        this.name = name;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    ArrayAccessExpression() {
        super();
    }

    ArrayAccessExpression(Expression name, Expression index, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.name = name;
        this.index = index;
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
