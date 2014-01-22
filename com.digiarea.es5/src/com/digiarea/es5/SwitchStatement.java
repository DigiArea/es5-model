package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.CaseBlock;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class SwitchStatement extends Statement {

    private Expression expression;

    private CaseBlock block;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public CaseBlock getBlock() {
        return block;
    }

    public void setBlock(CaseBlock block) {
        this.block = block;
    }

    public SwitchStatement() {
        super();
    }

    public SwitchStatement(Expression expression, CaseBlock block, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
        this.expression = expression;
        this.block = block;
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
