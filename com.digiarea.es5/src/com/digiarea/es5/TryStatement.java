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

public class TryStatement extends Statement {

    private Block tryBlock;

    private CatchClause catchClause;

    private Block finallyBlock;

    public Block getTryBlock() {
        return tryBlock;
    }

    public void setTryBlock(Block tryBlock) {
        this.tryBlock = tryBlock;
    }

    public CatchClause getCatchClause() {
        return catchClause;
    }

    public void setCatchClause(CatchClause catchClause) {
        this.catchClause = catchClause;
    }

    public Block getFinallyBlock() {
        return finallyBlock;
    }

    public void setFinallyBlock(Block finallyBlock) {
        this.finallyBlock = finallyBlock;
    }

    public TryStatement() {
        super();
    }

    public TryStatement(Block tryBlock, CatchClause catchClause, Block finallyBlock, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.tryBlock = tryBlock;
        this.catchClause = catchClause;
        this.finallyBlock = finallyBlock;
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
