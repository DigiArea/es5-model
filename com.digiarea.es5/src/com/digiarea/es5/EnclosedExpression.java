package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class EnclosedExpression.
 */
public class EnclosedExpression extends Expression {

    /** 
     * The inner.
     */
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

    EnclosedExpression(Expression inner, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
