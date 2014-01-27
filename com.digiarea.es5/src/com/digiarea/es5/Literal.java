package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class Literal.
 */
public abstract class Literal extends Expression {

    Literal() {
        super();
    }

    Literal(JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
    }

}
