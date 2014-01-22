package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class LabelledStatement extends Statement {

    private String label;

    private Statement statement;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public LabelledStatement() {
        super();
    }

    public LabelledStatement(String label, Statement statement, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.label = label;
        this.statement = statement;
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
