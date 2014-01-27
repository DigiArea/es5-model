package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.CaseBlock;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class SwitchStatement.
 */
public class SwitchStatement extends Statement {

    /** 
     * The expression.
     */
    private Expression expression;

    /** 
     * The block.
     */
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

    SwitchStatement() {
        super();
    }

    SwitchStatement(Expression expression, CaseBlock block, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
