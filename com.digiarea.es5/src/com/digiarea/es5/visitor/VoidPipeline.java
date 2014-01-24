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

/**
 * The Class VoidPipeline.
 *
 * @param <C> the generic type
 */
public class VoidPipeline<C> implements Runnable {

    /**
     * The node.
     */
    private Node node = null;

    /**
     * The visitors.
     */
    private List<VoidVisitor<C>> visitors = null;

    /**
     * The context.
     */
    private C context = null;

    /**
     * Instantiates a new void pipeline.
     */
    public VoidPipeline() {
        super();
    }

    /**
     * Instantiates a new void pipeline.
     *
     * @param node the node
     * @param visitors the visitors
     * @param context the context
     */
    public VoidPipeline(Node node, List<VoidVisitor<C>> visitors, C context) {
        super();
        this.node = node;
        this.visitors = visitors;
        this.context = context;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
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
