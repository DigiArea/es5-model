package com.digiarea.es5;

import com.digiarea.es5.Literal;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class NullLiteral extends Literal {

    public NullLiteral() {
        super();
    }

    public NullLiteral(int posBegin, int posEnd) {
        super(posBegin, posEnd);
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
