package com.digiarea.es5;

import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.Block;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class GetAssignment.
 */
public class GetAssignment extends PropertyAssignment {

    /** 
     * The block.
     */
    private Block block;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    GetAssignment() {
        super();
    }

    GetAssignment(Block block, PropertyName propertyName, Comment comment, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(propertyName, comment, jsDocComment, posBegin, posEnd);
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
