package com.digiarea.es5;

import com.digiarea.es5.Expression;

public abstract class Literal extends Expression {

    public Literal() {
        super();
    }

    public Literal(int posBegin, int posEnd) {
        super(posBegin, posEnd);
    }

}
