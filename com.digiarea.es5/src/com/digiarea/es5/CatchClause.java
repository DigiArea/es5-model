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

import com.digiarea.es5.Node;
import com.digiarea.es5.Block;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class CatchClause.
 */
public class CatchClause extends Node {

    /** 
     * The string.
     */
    private String string;

    /** 
     * The block.
     */
    private Block block;

    /**
     * Gets the string.
     *
     * @return the string
     */
    public String getString() {
        return string;
    }

    /**
     * Sets the string.
     *
     * @param string the new string
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * Gets the block.
     *
     * @return the block
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Sets the block.
     *
     * @param block the new block
     */
    public void setBlock(Block block) {
        this.block = block;
    }

    /**
     * Instantiates a new catch clause.
     */
    CatchClause() {
        super();
    }

    /**
     * Instantiates a new catch clause.
     *
     * @param string the string
     * @param block the block
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    CatchClause(String string, Block block, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.string = string;
        this.block = block;
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
