package com.digiarea.es5;

import com.digiarea.es5.Node;
import com.digiarea.es5.Block;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class CatchClause.
 */
public class CatchClause extends Node {

    /** 
     * The string.
     */
    private String string;

    /** 
     * The block.
     */
    private Block block;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    CatchClause() {
        super();
    }

    CatchClause(String string, Block block, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.string = string;
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
