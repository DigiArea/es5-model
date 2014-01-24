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

import com.digiarea.es5.Expression;

/** 
 * The Class Literal.
 */
public abstract class Literal extends Expression {

    /**
     * Instantiates a new literal.
     */
    Literal() {
        super();
    }

    /**
     * Instantiates a new literal.
     *
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    Literal(int posBegin, int posEnd) {
        super(posBegin, posEnd);
    }

}
