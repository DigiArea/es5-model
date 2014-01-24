/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;

public abstract class Literal extends Expression {

    Literal() {
        super();
    }

    Literal(int posBegin, int posEnd) {
        super(posBegin, posEnd);
    }

}
