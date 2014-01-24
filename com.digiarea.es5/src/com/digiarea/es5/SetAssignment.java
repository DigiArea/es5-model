/*
 * 
 */
package com.digiarea.es5;

import com.digiarea.es5.GetAssignment;
import com.digiarea.es5.Block;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class SetAssignment extends GetAssignment {

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    SetAssignment() {
        super();
    }

    SetAssignment(String identifier, Block block, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(block, propertyName, comment, posBegin, posEnd);
        this.identifier = identifier;
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
