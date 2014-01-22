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
import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class ObjectLiteral extends Literal {

    private NodeList<PropertyAssignment> propertyAssignments;

    public NodeList<PropertyAssignment> getPropertyAssignments() {
        return propertyAssignments;
    }

    public void setPropertyAssignments(NodeList<PropertyAssignment> propertyAssignments) {
        this.propertyAssignments = propertyAssignments;
    }

    public ObjectLiteral() {
        super();
    }

    public ObjectLiteral(NodeList<PropertyAssignment> propertyAssignments, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.propertyAssignments = propertyAssignments;
    }

    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
