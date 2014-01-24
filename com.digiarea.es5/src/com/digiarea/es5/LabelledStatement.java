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
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class LabelledStatement.
 */
public class LabelledStatement extends Statement {

    /** 
     * The label.
     */
    private String label;

    /** 
     * The statement.
     */
    private Statement statement;

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the statement.
     *
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Sets the statement.
     *
     * @param statement the new statement
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * Instantiates a new labelled statement.
     */
    LabelledStatement() {
        super();
    }

    /**
     * Instantiates a new labelled statement.
     *
     * @param label the label
     * @param statement the statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    LabelledStatement(String label, Statement statement, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.label = label;
        this.statement = statement;
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
