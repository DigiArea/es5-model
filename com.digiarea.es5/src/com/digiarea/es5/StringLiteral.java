package com.digiarea.es5;

import com.digiarea.es5.PropertyName;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class StringLiteral.
 */
public abstract class StringLiteral extends PropertyName {

    StringLiteral() {
        super();
    }

    StringLiteral(String value, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(value, jsDocComment, posBegin, posEnd);
    }

}
