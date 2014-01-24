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
import com.digiarea.es5.Expression;
import com.digiarea.es5.CaseBlock;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class SwitchStatement.
 */
public class SwitchStatement extends Statement {

    /** 
     * The expression.
     */
    private Expression expression;

    /** 
     * The block.
     */
    private CaseBlock block;

    /**
     * Gets the expression.
     *
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Sets the expression.
     *
     * @param expression the new expression
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Gets the block.
     *
     * @return the block
     */
    public CaseBlock getBlock() {
        return block;
    }

    /**
     * Sets the block.
     *
     * @param block the new block
     */
    public void setBlock(CaseBlock block) {
        this.block = block;
    }

    /**
     * Instantiates a new switch statement.
     */
    SwitchStatement() {
        super();
    }

    /**
     * Instantiates a new switch statement.
     *
     * @param expression the expression
     * @param block the block
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    SwitchStatement(Expression expression, CaseBlock block, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.expression = expression;
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
