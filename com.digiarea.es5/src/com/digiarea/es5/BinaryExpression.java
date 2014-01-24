/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class BinaryExpression extends Expression {

    public static enum BinaryOperator {

        or, 
        and, 
        binOr, 
        binAnd, 
        xor, 
        equals, 
        notEquals, 
        identity, 
        notIdentity, 
        less, 
        greater, 
        lessEquals, 
        greaterEquals, 
        lShift, 
        rSignedShift, 
        rUnsignedShift, 
        plus, 
        minus, 
        times, 
        divide, 
        remainder, 
        opInstanceof, 
        in;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    private Expression left;

    private Expression right;

    private BinaryExpression.BinaryOperator binaryOperator;

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public BinaryExpression.BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public void setBinaryOperator(BinaryExpression.BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    BinaryExpression() {
        super();
    }

    BinaryExpression(Expression left, Expression right, BinaryExpression.BinaryOperator binaryOperator, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.left = left;
        this.right = right;
        this.binaryOperator = binaryOperator;
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
