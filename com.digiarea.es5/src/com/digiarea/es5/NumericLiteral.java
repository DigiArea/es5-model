package com.digiarea.es5;

import com.digiarea.es5.PropertyName;

public abstract class NumericLiteral extends PropertyName {

    public NumericLiteral() {
        super();
    }

    public NumericLiteral(String value, int posBegin, int posEnd) {
        super(value, posBegin, posEnd);
    }

}
