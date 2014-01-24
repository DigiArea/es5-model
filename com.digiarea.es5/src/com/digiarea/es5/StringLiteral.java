/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.PropertyName;

public abstract class StringLiteral extends PropertyName {

    StringLiteral() {
        super();
    }

    StringLiteral(String value, int posBegin, int posEnd) {
        super(value, posBegin, posEnd);
    }

}
