/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Literal;

public abstract class StringBasedLiteral extends Literal {

    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    StringBasedLiteral() {
        super();
    }

    StringBasedLiteral(String value, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.value = value;
    }

}
