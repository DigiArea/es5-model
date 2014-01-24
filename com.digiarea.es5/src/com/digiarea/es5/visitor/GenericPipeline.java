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
import com.digiarea.es5.visitor.GenericVisitor;
import java.util.List;

public class GenericPipeline<C> implements Runnable {

    private Node node = null;

    private List<GenericVisitor<Node, C>> visitors = null;

    private C context = null;

    public GenericPipeline() {
        super();
    }

    public GenericPipeline(Node node, List<GenericVisitor<Node, C>> visitors, C context) {
        super();
        this.node = node;
        this.visitors = visitors;
        this.context = context;
    }

    public Node getNode() {
        return node;
    }

    @Override
    public void run() {
        try {
            for (GenericVisitor<Node, C> visitor : visitors) {
                node = node.accept(visitor, context);
            }
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

}
