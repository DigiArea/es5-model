package com.digiarea.es5;

import com.digiarea.es5.Literal;
import com.digiarea.es5.Expression;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class ArrayLiteral.
 */
public class ArrayLiteral extends Literal {

    /** 
     * The expressions.
     */
    private NodeList<Expression> expressions = null;

    public NodeList<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(NodeList<Expression> expressions) {
        this.expressions = expressions;
    }

    ArrayLiteral() {
        super();
    }

    ArrayLiteral(NodeList<Expression> expressions, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
