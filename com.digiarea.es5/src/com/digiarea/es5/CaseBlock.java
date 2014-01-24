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
import com.digiarea.es5.DefaultClause;
import com.digiarea.es5.CaseClause;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class CaseBlock.
 */
public class CaseBlock extends Statement {

    /** 
     * The default clause.
     */
    private DefaultClause defaultClause;

    /** 
     * The case clauses.
     */
    private NodeList<CaseClause> caseClauses;

    /**
     * Gets the default clause.
     *
     * @return the default clause
     */
    public DefaultClause getDefaultClause() {
        return defaultClause;
    }

    /**
     * Sets the default clause.
     *
     * @param defaultClause the new default clause
     */
    public void setDefaultClause(DefaultClause defaultClause) {
        this.defaultClause = defaultClause;
    }

    /**
     * Gets the case clauses.
     *
     * @return the case clauses
     */
    public NodeList<CaseClause> getCaseClauses() {
        return caseClauses;
    }

    /**
     * Sets the case clauses.
     *
     * @param caseClauses the new case clauses
     */
    public void setCaseClauses(NodeList<CaseClause> caseClauses) {
        this.caseClauses = caseClauses;
    }

    /**
     * Instantiates a new case block.
     */
    CaseBlock() {
        super();
    }

    /**
     * Instantiates a new case block.
     *
     * @param defaultClause the default clause
     * @param caseClauses the case clauses
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    CaseBlock(DefaultClause defaultClause, NodeList<CaseClause> caseClauses, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.defaultClause = defaultClause;
        this.caseClauses = caseClauses;
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
