package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class Statement.
 */
public abstract class Statement extends Node {

    Statement() {
        super();
    }

    Statement(JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
    }

}
