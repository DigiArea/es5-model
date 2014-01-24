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

import com.digiarea.es5.Statement;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class Block.
 */
public final class Block extends Statement {

    /** 
     * The statements.
     */
    private NodeList<Statement> statements;

    /**
     * Gets the statements.
     *
     * @return the statements
     */
    public NodeList<Statement> getStatements() {
        return statements;
    }

    /**
     * Sets the statements.
     *
     * @param statements the new statements
     */
    public void setStatements(NodeList<Statement> statements) {
        this.statements = statements;
    }

    /**
     * Instantiates a new block.
     */
    Block() {
        super();
    }

    /**
     * Instantiates a new block.
     *
     * @param statements the statements
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    Block(NodeList<Statement> statements, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.statements = statements;
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.Node#accept(com.digiarea.es5.visitor.VoidVisitor, java.lang.Object)
     */
    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.Node#accept(com.digiarea.es5.visitor.GenericVisitor, java.lang.Object)
     */
    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
