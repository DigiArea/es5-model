/*******************************************************************************
 * Copyright (c) 2011 - 2014 DigiArea, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DigiArea, Inc. - initial API and implementation
 *******************************************************************************/
package com.digiarea.es5;

import com.digiarea.es5.Literal;

/** 
 * The Class StringBasedLiteral.
 */
public abstract class StringBasedLiteral extends Literal {

    /** 
     * The value.
     */
    protected String value;

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Instantiates a new string based literal.
     */
    StringBasedLiteral() {
        super();
    }

    /**
     * Instantiates a new string based literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    StringBasedLiteral(String value, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.value = value;
    }

}
