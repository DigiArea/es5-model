package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class AllocationExpression.
 */
public class AllocationExpression extends Expression {

    /** 
     * The body.
     */
    private Expression body;

    public Expression getBody() {
        return body;
    }

    public void setBody(Expression body) {
        this.body = body;
    }

    AllocationExpression() {
        super();
    }

    AllocationExpression(Expression body, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
