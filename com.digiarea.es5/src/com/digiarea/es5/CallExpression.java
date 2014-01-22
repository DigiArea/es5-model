package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class CallExpression extends Expression {

    private Expression scope;

    private NodeList<Expression> args;

    public Expression getScope() {
        return scope;
    }

    public void setScope(Expression scope) {
        this.scope = scope;
    }

    public NodeList<Expression> getArgs() {
        return args;
    }

    public void setArgs(NodeList<Expression> args) {
        this.args = args;
    }

    public CallExpression() {
        super();
    }

    public CallExpression(Expression scope, NodeList<Expression> args, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.scope = scope;
        this.args = args;
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
