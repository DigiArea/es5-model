package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class ConstantStatement extends Statement {

    private NodeList<VariableDeclaration> variableDeclarations;

    public NodeList<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public void setVariableDeclarations(NodeList<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }

    public ConstantStatement() {
        super();
    }

    public ConstantStatement(NodeList<VariableDeclaration> variableDeclarations, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.variableDeclarations = variableDeclarations;
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
