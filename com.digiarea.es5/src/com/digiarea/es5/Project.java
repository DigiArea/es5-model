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
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class Project.
 */
public class Project extends Node {

    /** 
     * The compilation units.
     */
    private NodeList<CompilationUnit> compilationUnits = null;

    /**
     * Gets the compilation units.
     *
     * @return the compilation units
     */
    public NodeList<CompilationUnit> getCompilationUnits() {
        return compilationUnits;
    }

    /**
     * Sets the compilation units.
     *
     * @param compilationUnits the new compilation units
     */
    public void setCompilationUnits(NodeList<CompilationUnit> compilationUnits) {
        this.compilationUnits = compilationUnits;
    }

    /**
     * Instantiates a new project.
     */
    Project() {
        super();
    }

    /**
     * Instantiates a new project.
     *
     * @param compilationUnits the compilation units
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    Project(NodeList<CompilationUnit> compilationUnits, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.compilationUnits = compilationUnits;
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
