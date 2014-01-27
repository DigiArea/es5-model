package com.digiarea.es5;

import com.digiarea.es5.StringBasedLiteral;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class PropertyName.
 */
public abstract class PropertyName extends StringBasedLiteral {

    PropertyName() {
        super();
    }

    PropertyName(String value, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(value, jsDocComment, posBegin, posEnd);
    }

}
