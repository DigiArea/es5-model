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

/**
 * The Class GenericPipeline.
 *
 * @param <C> the generic type
 */
public class GenericPipeline<C> implements Runnable {

    /**
     * The node.
     */
    private Node node = null;

    /**
     * The visitors.
     */
    private List<GenericVisitor<Node, C>> visitors = null;

    /**
     * The context.
     */
    private C context = null;

    /**
     * Instantiates a new generic pipeline.
     */
    public GenericPipeline() {
        super();
    }

    /**
     * Instantiates a new generic pipeline.
     *
     * @param node the node
     * @param visitors the visitors
     * @param context the context
     */
    public GenericPipeline(Node node, List<GenericVisitor<Node, C>> visitors, C context) {
        super();
        this.node = node;
        this.visitors = visitors;
        this.context = context;
    }

    /**
     * Gets the node.
     *
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
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
