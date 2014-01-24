/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class SequenceExpression extends Expression {

    private NodeList<Expression> expressions;

    public NodeList<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(NodeList<Expression> expressions) {
        this.expressions = expressions;
    }

    SequenceExpression() {
        super();
    }

    SequenceExpression(NodeList<Expression> expressions, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.expressions = expressions;
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
