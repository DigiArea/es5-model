package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class VariableExpression extends Expression {

    private NodeList<VariableDeclaration> variableDeclarations;

    public NodeList<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public void setVariableDeclarations(NodeList<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }

    public VariableExpression() {
        super();
    }

    public VariableExpression(NodeList<VariableDeclaration> variableDeclarations, int posBegin, int posEnd) {
        super(posBegin, posEnd);
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
