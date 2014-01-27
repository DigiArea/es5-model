package com.digiarea.es5;

import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.Expression;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class PutAssignment.
 */
public class PutAssignment extends PropertyAssignment {

    /** 
     * The property value.
     */
    private Expression propertyValue;

    public Expression getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Expression propertyValue) {
        this.propertyValue = propertyValue;
    }

    PutAssignment() {
        super();
    }

    PutAssignment(Expression propertyValue, PropertyName propertyName, Comment comment, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(propertyName, comment, jsDocComment, posBegin, posEnd);
        this.propertyValue = propertyValue;
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
