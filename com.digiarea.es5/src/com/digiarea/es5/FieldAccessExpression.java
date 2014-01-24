/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.IdentifierName;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class FieldAccessExpression extends Expression {

    private Expression scope;

    private IdentifierName field;

    public Expression getScope() {
        return scope;
    }

    public void setScope(Expression scope) {
        this.scope = scope;
    }

    public IdentifierName getField() {
        return field;
    }

    public void setField(IdentifierName field) {
        this.field = field;
    }

    FieldAccessExpression() {
        super();
    }

    FieldAccessExpression(Expression scope, IdentifierName field, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.scope = scope;
        this.field = field;
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
