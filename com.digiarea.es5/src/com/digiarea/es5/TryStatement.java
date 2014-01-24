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
import com.digiarea.es5.Block;
import com.digiarea.es5.CatchClause;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class TryStatement.
 */
public class TryStatement extends Statement {

    /** 
     * The try block.
     */
    private Block tryBlock;

    /** 
     * The catch clause.
     */
    private CatchClause catchClause;

    /** 
     * The finally block.
     */
    private Block finallyBlock;

    /**
     * Gets the try block.
     *
     * @return the try block
     */
    public Block getTryBlock() {
        return tryBlock;
    }

    /**
     * Sets the try block.
     *
     * @param tryBlock the new try block
     */
    public void setTryBlock(Block tryBlock) {
        this.tryBlock = tryBlock;
    }

    /**
     * Gets the catch clause.
     *
     * @return the catch clause
     */
    public CatchClause getCatchClause() {
        return catchClause;
    }

    /**
     * Sets the catch clause.
     *
     * @param catchClause the new catch clause
     */
    public void setCatchClause(CatchClause catchClause) {
        this.catchClause = catchClause;
    }

    /**
     * Gets the finally block.
     *
     * @return the finally block
     */
    public Block getFinallyBlock() {
        return finallyBlock;
    }

    /**
     * Sets the finally block.
     *
     * @param finallyBlock the new finally block
     */
    public void setFinallyBlock(Block finallyBlock) {
        this.finallyBlock = finallyBlock;
    }

    /**
     * Instantiates a new try statement.
     */
    TryStatement() {
        super();
    }

    /**
     * Instantiates a new try statement.
     *
     * @param tryBlock the try block
     * @param catchClause the catch clause
     * @param finallyBlock the finally block
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    TryStatement(Block tryBlock, CatchClause catchClause, Block finallyBlock, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.tryBlock = tryBlock;
        this.catchClause = catchClause;
        this.finallyBlock = finallyBlock;
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
