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

import com.digiarea.es5.WhileStatement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.Statement;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class DoWhileStatement.
 */
public class DoWhileStatement extends WhileStatement {

    /**
     * Instantiates a new do while statement.
     */
    DoWhileStatement() {
        super();
    }

    /**
     * Instantiates a new do while statement.
     *
     * @param condition the condition
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    DoWhileStatement(Expression condition, Statement body, Comment comment, int posBegin, int posEnd) {
        super(condition, body, comment, posBegin, posEnd);
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.WhileStatement#accept(com.digiarea.es5.visitor.VoidVisitor, java.lang.Object)
     */
    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.WhileStatement#accept(com.digiarea.es5.visitor.GenericVisitor, java.lang.Object)
     */
    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
