/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class VariableDeclaration extends Node {

    private String name;

    private Expression expression;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    VariableDeclaration() {
        super();
    }

    VariableDeclaration(String name, Expression expression, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.name = name;
        this.expression = expression;
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
