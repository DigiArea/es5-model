package com.digiarea.es5;

import com.digiarea.es5.StringBasedLiteral;

public abstract class PropertyName extends StringBasedLiteral {

    public PropertyName() {
        super();
    }

    public PropertyName(String value, int posBegin, int posEnd) {
        super(value, posBegin, posEnd);
    }

}
