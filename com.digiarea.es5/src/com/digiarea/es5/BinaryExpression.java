package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class BinaryExpression.
 */
public class BinaryExpression extends Expression {

    /** 
     * The Enum BinaryOperator.
     */
    public static enum BinaryOperator {

        /** 
         * The or.
         */
        or, 
        /** 
         * The and.
         */
        and, 
        /** 
         * The bin or.
         */
        binOr, 
        /** 
         * The bin and.
         */
        binAnd, 
        /** 
         * The xor.
         */
        xor, 
        /** 
         * The equals.
         */
        equals, 
        /** 
         * The not equals.
         */
        notEquals, 
        /** 
         * The identity.
         */
        identity, 
        /** 
         * The not identity.
         */
        notIdentity, 
        /** 
         * The less.
         */
        less, 
        /** 
         * The greater.
         */
        greater, 
        /** 
         * The less equals.
         */
        lessEquals, 
        /** 
         * The greater equals.
         */
        greaterEquals, 
        /** 
         * The l shift.
         */
        lShift, 
        /** 
         * The r signed shift.
         */
        rSignedShift, 
        /** 
         * The r unsigned shift.
         */
        rUnsignedShift, 
        /** 
         * The plus.
         */
        plus, 
        /** 
         * The minus.
         */
        minus, 
        /** 
         * The times.
         */
        times, 
        /** 
         * The divide.
         */
        divide, 
        /** 
         * The remainder.
         */
        remainder, 
        /** 
         * The op instanceof.
         */
        opInstanceof, 
        /** 
         * The in.
         */
        in;

        public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
            v.visit(this, ctx);
        }

        public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
            return v.visit(this, ctx);
        }

    }

    /** 
     * The left.
     */
    private Expression left;

    /** 
     * The right.
     */
    private Expression right;

    /** 
     * The binary operator.
     */
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

    BinaryExpression(Expression left, Expression right, BinaryExpression.BinaryOperator binaryOperator, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
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
