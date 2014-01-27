package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.DefaultClause;
import com.digiarea.es5.CaseClause;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class CaseBlock.
 */
public class CaseBlock extends Statement {

    /** 
     * The default clause.
     */
    private DefaultClause defaultClause;

    /** 
     * The case clauses.
     */
    private NodeList<CaseClause> caseClauses;

    public DefaultClause getDefaultClause() {
        return defaultClause;
    }

    public void setDefaultClause(DefaultClause defaultClause) {
        this.defaultClause = defaultClause;
    }

    public NodeList<CaseClause> getCaseClauses() {
        return caseClauses;
    }

    public void setCaseClauses(NodeList<CaseClause> caseClauses) {
        this.caseClauses = caseClauses;
    }

    CaseBlock() {
        super();
    }

    CaseBlock(DefaultClause defaultClause, NodeList<CaseClause> caseClauses, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.defaultClause = defaultClause;
        this.caseClauses = caseClauses;
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
