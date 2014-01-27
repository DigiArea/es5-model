package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class Expression.
 */
public abstract class Expression extends Node {

    Expression() {
        super();
    }

    Expression(JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
    }

}
