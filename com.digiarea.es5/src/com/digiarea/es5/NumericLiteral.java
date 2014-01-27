package com.digiarea.es5;

import com.digiarea.es5.PropertyName;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class NumericLiteral.
 */
public abstract class NumericLiteral extends PropertyName {

    NumericLiteral() {
        super();
    }

    NumericLiteral(String value, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(value, jsDocComment, posBegin, posEnd);
    }

}
