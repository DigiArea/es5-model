package com.digiarea.es5;

import com.digiarea.es5.Literal;
import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class ObjectLiteral.
 */
public class ObjectLiteral extends Literal {

    /** 
     * The property assignments.
     */
    private NodeList<PropertyAssignment> propertyAssignments;

    public NodeList<PropertyAssignment> getPropertyAssignments() {
        return propertyAssignments;
    }

    public void setPropertyAssignments(NodeList<PropertyAssignment> propertyAssignments) {
        this.propertyAssignments = propertyAssignments;
    }

    ObjectLiteral() {
        super();
    }

    ObjectLiteral(NodeList<PropertyAssignment> propertyAssignments, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.propertyAssignments = propertyAssignments;
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
