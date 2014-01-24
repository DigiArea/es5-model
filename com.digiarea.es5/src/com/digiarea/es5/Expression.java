/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Node;

public abstract class Expression extends Node {

    Expression() {
        super();
    }

    Expression(int posBegin, int posEnd) {
        super(posBegin, posEnd);
    }

}
