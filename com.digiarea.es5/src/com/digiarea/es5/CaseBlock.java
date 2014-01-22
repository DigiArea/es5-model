package com.digiarea.es5;

import com.digiarea.es5.Statement;
import com.digiarea.es5.DefaultClause;
import com.digiarea.es5.CaseClause;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Comment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

public class CaseBlock extends Statement {

    private DefaultClause defaultClause;

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

    public CaseBlock() {
        super();
    }

    public CaseBlock(DefaultClause defaultClause, NodeList<CaseClause> caseClauses, Comment comment, int posBegin, int posEnd) {
        super(comment, posBegin, posEnd);
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
