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

import com.digiarea.es5.PropertyName;

public abstract class StringLiteral extends PropertyName {

    StringLiteral() {
        super();
    }

    StringLiteral(String value, int posBegin, int posEnd) {
        super(value, posBegin, posEnd);
    }

}
