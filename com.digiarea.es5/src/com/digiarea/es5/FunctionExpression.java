package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.Parameter;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Block;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class FunctionExpression.
 */
public class FunctionExpression extends Expression {

    /** 
     * The name.
     */
    private String name;

    /** 
     * The parameters.
     */
    private NodeList<Parameter> parameters;

    /** 
     * The body.
     */
    private Block body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(NodeList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Block getBody() {
        return body;
    }

    public void setBody(Block body) {
        this.body = body;
    }

    FunctionExpression() {
        super();
    }

    FunctionExpression(String name, NodeList<Parameter> parameters, Block body, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.name = name;
        this.parameters = parameters;
        this.body = body;
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
