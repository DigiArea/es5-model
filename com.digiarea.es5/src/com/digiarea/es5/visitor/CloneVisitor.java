/*******************************************************************************
 * Copyright (c) 2011 - 2014 DigiArea, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DigiArea, Inc. - initial API and implementation
 *******************************************************************************/
package com.digiarea.es5.visitor;

import com.digiarea.es5.Node;
import com.digiarea.es5.visitor.GenericVisitor;
import com.digiarea.es5.AllocationExpression;
import com.digiarea.es5.Expression;
import com.digiarea.es5.ArrayAccessExpression;
import com.digiarea.es5.ArrayLiteral;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.AssignmentExpression;
import com.digiarea.es5.AssignmentExpression.AssignOperator;
import com.digiarea.es5.BinaryExpression;
import com.digiarea.es5.BinaryExpression.BinaryOperator;
import com.digiarea.es5.Block;
import com.digiarea.es5.Statement;
import com.digiarea.es5.Comment;
import com.digiarea.es5.BlockComment;
import com.digiarea.es5.BooleanLiteral;
import com.digiarea.es5.BreakStatement;
import com.digiarea.es5.CallExpression;
import com.digiarea.es5.CaseBlock;
import com.digiarea.es5.DefaultClause;
import com.digiarea.es5.CaseClause;
import com.digiarea.es5.CatchClause;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.ConditionalExpression;
import com.digiarea.es5.ConstantStatement;
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.ContinueStatement;
import com.digiarea.es5.DebuggerStatement;
import com.digiarea.es5.DecimalLiteral;
import com.digiarea.es5.DoWhileStatement;
import com.digiarea.es5.EmptyLiteral;
import com.digiarea.es5.EmptyStatement;
import com.digiarea.es5.EnclosedExpression;
import com.digiarea.es5.ExpressionStatement;
import com.digiarea.es5.FieldAccessExpression;
import com.digiarea.es5.IdentifierName;
import com.digiarea.es5.FloatLiteral;
import com.digiarea.es5.ForeachStatement;
import com.digiarea.es5.ForStatement;
import com.digiarea.es5.FunctionDeclaration;
import com.digiarea.es5.Parameter;
import com.digiarea.es5.FunctionExpression;
import com.digiarea.es5.GetAssignment;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.HexIntegerLiteral;
import com.digiarea.es5.IfStatement;
import com.digiarea.es5.ImportStatement;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.LabelledStatement;
import com.digiarea.es5.LetDefinition;
import com.digiarea.es5.LetExpression;
import com.digiarea.es5.LetStatement;
import com.digiarea.es5.LineComment;
import com.digiarea.es5.NewExpression;
import com.digiarea.es5.ObjectLiteral;
import java.util.List;
import java.util.ArrayList;
import com.digiarea.es5.NullLiteral;
import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.OctalLiteral;
import com.digiarea.es5.Project;
import com.digiarea.es5.PutAssignment;
import com.digiarea.es5.RegexpLiteral;
import com.digiarea.es5.ReturnStatement;
import com.digiarea.es5.SequenceExpression;
import com.digiarea.es5.SetAssignment;
import com.digiarea.es5.StringLiteralDouble;
import com.digiarea.es5.StringLiteralSingle;
import com.digiarea.es5.SuperExpression;
import com.digiarea.es5.SwitchStatement;
import com.digiarea.es5.ThisExpression;
import com.digiarea.es5.ThrowStatement;
import com.digiarea.es5.TryStatement;
import com.digiarea.es5.UnaryExpression;
import com.digiarea.es5.UnaryExpression.UnaryOperator;
import com.digiarea.es5.VariableExpression;
import com.digiarea.es5.VariableStatement;
import com.digiarea.es5.WhileStatement;
import com.digiarea.es5.WithStatement;

@SuppressWarnings("unchecked")
public class CloneVisitor<C> implements GenericVisitor<Node, C> {

    @Override
    public Node visit(AllocationExpression n, C ctx) throws Exception {
        AllocationExpression img = new AllocationExpression();
        if (n.getBody() != null) {
            img.setBody((Expression) n.getBody().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ArrayAccessExpression n, C ctx) throws Exception {
        ArrayAccessExpression img = new ArrayAccessExpression();
        if (n.getName() != null) {
            img.setName((Expression) n.getName().accept(this, ctx));
        }
        if (n.getIndex() != null) {
            img.setIndex((Expression) n.getIndex().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ArrayLiteral n, C ctx) throws Exception {
        ArrayLiteral img = new ArrayLiteral();
        if (n.getExpressions() != null) {
            img.setExpressions((NodeList<Expression>) n.getExpressions().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(AssignmentExpression n, C ctx) throws Exception {
        AssignmentExpression img = new AssignmentExpression();
        if (n.getTarget() != null) {
            img.setTarget((Expression) n.getTarget().accept(this, ctx));
        }
        if (n.getValue() != null) {
            img.setValue((Expression) n.getValue().accept(this, ctx));
        }
        img.setAssignOperator(n.getAssignOperator());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(AssignOperator n, C ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(BinaryExpression n, C ctx) throws Exception {
        BinaryExpression img = new BinaryExpression();
        if (n.getLeft() != null) {
            img.setLeft((Expression) n.getLeft().accept(this, ctx));
        }
        if (n.getRight() != null) {
            img.setRight((Expression) n.getRight().accept(this, ctx));
        }
        img.setBinaryOperator(n.getBinaryOperator());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(BinaryOperator n, C ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(Block n, C ctx) throws Exception {
        Block img = new Block();
        if (n.getStatements() != null) {
            img.setStatements((NodeList<Statement>) n.getStatements().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(BlockComment n, C ctx) throws Exception {
        BlockComment img = new BlockComment();
        img.setContent(n.getContent());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(BooleanLiteral n, C ctx) throws Exception {
        BooleanLiteral img = new BooleanLiteral();
        img.setValue(n.isValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(BreakStatement n, C ctx) throws Exception {
        BreakStatement img = new BreakStatement();
        img.setIdentifier(n.getIdentifier());
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(CallExpression n, C ctx) throws Exception {
        CallExpression img = new CallExpression();
        if (n.getScope() != null) {
            img.setScope((Expression) n.getScope().accept(this, ctx));
        }
        if (n.getArgs() != null) {
            img.setArgs((NodeList<Expression>) n.getArgs().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(CaseBlock n, C ctx) throws Exception {
        CaseBlock img = new CaseBlock();
        if (n.getDefaultClause() != null) {
            img.setDefaultClause((DefaultClause) n.getDefaultClause().accept(this, ctx));
        }
        if (n.getCaseClauses() != null) {
            img.setCaseClauses((NodeList<CaseClause>) n.getCaseClauses().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(CaseClause n, C ctx) throws Exception {
        CaseClause img = new CaseClause();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getStatements() != null) {
            img.setStatements((NodeList<Statement>) n.getStatements().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(CatchClause n, C ctx) throws Exception {
        CatchClause img = new CatchClause();
        img.setString(n.getString());
        if (n.getBlock() != null) {
            img.setBlock((Block) n.getBlock().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(CompilationUnit n, C ctx) throws Exception {
        CompilationUnit img = new CompilationUnit();
        if (n.getElements() != null) {
            img.setElements((NodeList<Statement>) n.getElements().accept(this, ctx));
        }
        if (n.getComments() != null) {
            img.setComments((NodeList<Comment>) n.getComments().accept(this, ctx));
        }
        img.setName(n.getName());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ConditionalExpression n, C ctx) throws Exception {
        ConditionalExpression img = new ConditionalExpression();
        if (n.getCondition() != null) {
            img.setCondition((Expression) n.getCondition().accept(this, ctx));
        }
        if (n.getThenExpr() != null) {
            img.setThenExpr((Expression) n.getThenExpr().accept(this, ctx));
        }
        if (n.getElseExpr() != null) {
            img.setElseExpr((Expression) n.getElseExpr().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ConstantStatement n, C ctx) throws Exception {
        ConstantStatement img = new ConstantStatement();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ContinueStatement n, C ctx) throws Exception {
        ContinueStatement img = new ContinueStatement();
        img.setIdentifier(n.getIdentifier());
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(DebuggerStatement n, C ctx) throws Exception {
        DebuggerStatement img = new DebuggerStatement();
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(DecimalLiteral n, C ctx) throws Exception {
        DecimalLiteral img = new DecimalLiteral();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(DefaultClause n, C ctx) throws Exception {
        DefaultClause img = new DefaultClause();
        if (n.getStatements() != null) {
            img.setStatements((NodeList<Statement>) n.getStatements().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(DoWhileStatement n, C ctx) throws Exception {
        DoWhileStatement img = new DoWhileStatement();
        if (n.getCondition() != null) {
            img.setCondition((Expression) n.getCondition().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Statement) n.getBody().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(EmptyLiteral n, C ctx) throws Exception {
        EmptyLiteral img = new EmptyLiteral();
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(EmptyStatement n, C ctx) throws Exception {
        EmptyStatement img = new EmptyStatement();
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(EnclosedExpression n, C ctx) throws Exception {
        EnclosedExpression img = new EnclosedExpression();
        if (n.getInner() != null) {
            img.setInner((Expression) n.getInner().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ExpressionStatement n, C ctx) throws Exception {
        ExpressionStatement img = new ExpressionStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(FieldAccessExpression n, C ctx) throws Exception {
        FieldAccessExpression img = new FieldAccessExpression();
        if (n.getScope() != null) {
            img.setScope((Expression) n.getScope().accept(this, ctx));
        }
        if (n.getField() != null) {
            img.setField((IdentifierName) n.getField().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(FloatLiteral n, C ctx) throws Exception {
        FloatLiteral img = new FloatLiteral();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ForeachStatement n, C ctx) throws Exception {
        ForeachStatement img = new ForeachStatement();
        if (n.getVariable() != null) {
            img.setVariable((Expression) n.getVariable().accept(this, ctx));
        }
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Statement) n.getBody().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ForStatement n, C ctx) throws Exception {
        ForStatement img = new ForStatement();
        if (n.getVariable() != null) {
            img.setVariable((Expression) n.getVariable().accept(this, ctx));
        }
        if (n.getCondition() != null) {
            img.setCondition((Expression) n.getCondition().accept(this, ctx));
        }
        if (n.getExpr() != null) {
            img.setExpr((Expression) n.getExpr().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Statement) n.getBody().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(FunctionDeclaration n, C ctx) throws Exception {
        FunctionDeclaration img = new FunctionDeclaration();
        img.setName(n.getName());
        if (n.getParameters() != null) {
            img.setParameters((NodeList<Parameter>) n.getParameters().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Block) n.getBody().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(FunctionExpression n, C ctx) throws Exception {
        FunctionExpression img = new FunctionExpression();
        img.setName(n.getName());
        if (n.getParameters() != null) {
            img.setParameters((NodeList<Parameter>) n.getParameters().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Block) n.getBody().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(GetAssignment n, C ctx) throws Exception {
        GetAssignment img = new GetAssignment();
        if (n.getBlock() != null) {
            img.setBlock((Block) n.getBlock().accept(this, ctx));
        }
        if (n.getPropertyName() != null) {
            img.setPropertyName((PropertyName) n.getPropertyName().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(HexIntegerLiteral n, C ctx) throws Exception {
        HexIntegerLiteral img = new HexIntegerLiteral();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(IdentifierName n, C ctx) throws Exception {
        IdentifierName img = new IdentifierName();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(IfStatement n, C ctx) throws Exception {
        IfStatement img = new IfStatement();
        if (n.getCondition() != null) {
            img.setCondition((Expression) n.getCondition().accept(this, ctx));
        }
        if (n.getThenStatement() != null) {
            img.setThenStatement((Statement) n.getThenStatement().accept(this, ctx));
        }
        if (n.getElseStatement() != null) {
            img.setElseStatement((Statement) n.getElseStatement().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ImportStatement n, C ctx) throws Exception {
        ImportStatement img = new ImportStatement();
        if (n.getName() != null) {
            img.setName((IdentifierName) n.getName().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(JSDocComment n, C ctx) throws Exception {
        JSDocComment img = new JSDocComment();
        img.setContent(n.getContent());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(LabelledStatement n, C ctx) throws Exception {
        LabelledStatement img = new LabelledStatement();
        img.setLabel(n.getLabel());
        if (n.getStatement() != null) {
            img.setStatement((Statement) n.getStatement().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(LetDefinition n, C ctx) throws Exception {
        LetDefinition img = new LetDefinition();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(LetExpression n, C ctx) throws Exception {
        LetExpression img = new LetExpression();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(LetStatement n, C ctx) throws Exception {
        LetStatement img = new LetStatement();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getStatement() != null) {
            img.setStatement((Statement) n.getStatement().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(LineComment n, C ctx) throws Exception {
        LineComment img = new LineComment();
        img.setContent(n.getContent());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(NewExpression n, C ctx) throws Exception {
        NewExpression img = new NewExpression();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getInitializer() != null) {
            img.setInitializer((ObjectLiteral) n.getInitializer().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public <E extends Node> Node visit(NodeList<E> n, C ctx) throws Exception {
        NodeList<E> img = new NodeList<E>();
        if (n.getNodes() != null) {
            List<E> nodes = new ArrayList<E>();
            for (E item : n.getNodes()) {
                if (item != null) {
                    nodes.add((E) item.accept(this, ctx));
                }
            }
            img.setNodes(nodes);
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(NullLiteral n, C ctx) throws Exception {
        NullLiteral img = new NullLiteral();
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ObjectLiteral n, C ctx) throws Exception {
        ObjectLiteral img = new ObjectLiteral();
        if (n.getPropertyAssignments() != null) {
            img.setPropertyAssignments((NodeList<PropertyAssignment>) n.getPropertyAssignments().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(OctalLiteral n, C ctx) throws Exception {
        OctalLiteral img = new OctalLiteral();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(Parameter n, C ctx) throws Exception {
        Parameter img = new Parameter();
        img.setName(n.getName());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(Project n, C ctx) throws Exception {
        Project img = new Project();
        if (n.getCompilationUnits() != null) {
            img.setCompilationUnits((NodeList<CompilationUnit>) n.getCompilationUnits().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(PutAssignment n, C ctx) throws Exception {
        PutAssignment img = new PutAssignment();
        if (n.getPropertyValue() != null) {
            img.setPropertyValue((Expression) n.getPropertyValue().accept(this, ctx));
        }
        if (n.getPropertyName() != null) {
            img.setPropertyName((PropertyName) n.getPropertyName().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(RegexpLiteral n, C ctx) throws Exception {
        RegexpLiteral img = new RegexpLiteral();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ReturnStatement n, C ctx) throws Exception {
        ReturnStatement img = new ReturnStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(SequenceExpression n, C ctx) throws Exception {
        SequenceExpression img = new SequenceExpression();
        if (n.getExpressions() != null) {
            img.setExpressions((NodeList<Expression>) n.getExpressions().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(SetAssignment n, C ctx) throws Exception {
        SetAssignment img = new SetAssignment();
        img.setIdentifier(n.getIdentifier());
        if (n.getBlock() != null) {
            img.setBlock((Block) n.getBlock().accept(this, ctx));
        }
        if (n.getPropertyName() != null) {
            img.setPropertyName((PropertyName) n.getPropertyName().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(StringLiteralDouble n, C ctx) throws Exception {
        StringLiteralDouble img = new StringLiteralDouble();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(StringLiteralSingle n, C ctx) throws Exception {
        StringLiteralSingle img = new StringLiteralSingle();
        img.setValue(n.getValue());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(SuperExpression n, C ctx) throws Exception {
        SuperExpression img = new SuperExpression();
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(SwitchStatement n, C ctx) throws Exception {
        SwitchStatement img = new SwitchStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getBlock() != null) {
            img.setBlock((CaseBlock) n.getBlock().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ThisExpression n, C ctx) throws Exception {
        ThisExpression img = new ThisExpression();
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(ThrowStatement n, C ctx) throws Exception {
        ThrowStatement img = new ThrowStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(TryStatement n, C ctx) throws Exception {
        TryStatement img = new TryStatement();
        if (n.getTryBlock() != null) {
            img.setTryBlock((Block) n.getTryBlock().accept(this, ctx));
        }
        if (n.getCatchClause() != null) {
            img.setCatchClause((CatchClause) n.getCatchClause().accept(this, ctx));
        }
        if (n.getFinallyBlock() != null) {
            img.setFinallyBlock((Block) n.getFinallyBlock().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(UnaryExpression n, C ctx) throws Exception {
        UnaryExpression img = new UnaryExpression();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        img.setUnaryOperator(n.getUnaryOperator());
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(UnaryOperator n, C ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(VariableDeclaration n, C ctx) throws Exception {
        VariableDeclaration img = new VariableDeclaration();
        img.setName(n.getName());
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(VariableExpression n, C ctx) throws Exception {
        VariableExpression img = new VariableExpression();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(VariableStatement n, C ctx) throws Exception {
        VariableStatement img = new VariableStatement();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(WhileStatement n, C ctx) throws Exception {
        WhileStatement img = new WhileStatement();
        if (n.getCondition() != null) {
            img.setCondition((Expression) n.getCondition().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Statement) n.getBody().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    @Override
    public Node visit(WithStatement n, C ctx) throws Exception {
        WithStatement img = new WithStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getStatement() != null) {
            img.setStatement((Statement) n.getStatement().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        img.setPosBegin(n.getPosBegin());
        img.setPosEnd(n.getPosEnd());
        return img;
    }

    public CloneVisitor() {
        super();
    }

}
