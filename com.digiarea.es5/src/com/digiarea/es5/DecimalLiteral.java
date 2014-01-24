/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.NumericLiteral;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class DecimalLiteral extends NumericLiteral {

    DecimalLiteral() {
        super();
    }

    DecimalLiteral(String value, int posBegin, int posEnd) {
        super(value, posBegin, posEnd);
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
