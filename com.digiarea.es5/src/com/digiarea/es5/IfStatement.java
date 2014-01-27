package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.Expression;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class IfStatement.
 */
public class IfStatement extends Statement {

    /** 
     * The condition.
     */
    private Expression condition;

    /** 
     * The then statement.
     */
    private Statement thenStatement;

    /** 
     * The else statement.
     */
    private Statement elseStatement;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Statement getThenStatement() {
        return thenStatement;
    }

    public void setThenStatement(Statement thenStatement) {
        this.thenStatement = thenStatement;
    }

    public Statement getElseStatement() {
        return elseStatement;
    }

    public void setElseStatement(Statement elseStatement) {
        this.elseStatement = elseStatement;
    }

    IfStatement() {
        super();
    }

    IfStatement(Expression condition, Statement thenStatement, Statement elseStatement, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
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
