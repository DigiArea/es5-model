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
package com.digiarea.es5.visitor;

import com.digiarea.es5.Node;
import com.digiarea.es5.visitor.VoidVisitor;
import java.util.List;

public class VoidPipeline<C> implements Runnable {

    private Node node = null;

    private List<VoidVisitor<C>> visitors = null;

    private C context = null;

    public VoidPipeline() {
        super();
    }

    public VoidPipeline(Node node, List<VoidVisitor<C>> visitors, C context) {
        super();
        this.node = node;
        this.visitors = visitors;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (VoidVisitor<C> visitor : visitors) {
                node.accept(visitor, context);
            }
        } catch (final Exception e) {
            throw new Error(e.getMessage());
        }
    }

}
