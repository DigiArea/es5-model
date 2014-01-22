package com.digiarea.es5;

import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.Block;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class GetAssignment extends PropertyAssignment {

    private Block block;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public GetAssignment() {
        super();
    }

    public GetAssignment(Block block, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(propertyName, comment, posBegin, posEnd);
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
