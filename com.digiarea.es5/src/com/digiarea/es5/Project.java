package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.JSDocComment;
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

    public NodeList<CompilationUnit> getCompilationUnits() {
        return compilationUnits;
    }

    public void setCompilationUnits(NodeList<CompilationUnit> compilationUnits) {
        this.compilationUnits = compilationUnits;
    }

    Project() {
        super();
    }

    Project(NodeList<CompilationUnit> compilationUnits, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.compilationUnits = compilationUnits;
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
