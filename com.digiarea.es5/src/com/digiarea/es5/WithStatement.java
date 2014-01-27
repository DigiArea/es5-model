package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class WithStatement.
 */
public class WithStatement extends Statement {

    /** 
     * The expression.
     */
    private Expression expression;

    /** 
     * The statement.
     */
    private Statement statement;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    WithStatement() {
        super();
    }

    WithStatement(Expression expression, Statement statement, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.expression = expression;
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
