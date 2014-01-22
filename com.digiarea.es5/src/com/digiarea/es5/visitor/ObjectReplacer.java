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
import java.util.Map;
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
public class ObjectReplacer implements GenericVisitor<Node, Map<Object, Object>> {

    @Override
    public Node visit(AllocationExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        AllocationExpression img = new AllocationExpression();
        if (n.getBody() != null) {
            img.setBody((Expression) n.getBody().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ArrayAccessExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ArrayAccessExpression img = new ArrayAccessExpression();
        if (n.getName() != null) {
            img.setName((Expression) n.getName().accept(this, ctx));
        }
        if (n.getIndex() != null) {
            img.setIndex((Expression) n.getIndex().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ArrayLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ArrayLiteral img = new ArrayLiteral();
        if (n.getExpressions() != null) {
            img.setExpressions((NodeList<Expression>) n.getExpressions().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(AssignmentExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        AssignmentExpression img = new AssignmentExpression();
        if (n.getTarget() != null) {
            img.setTarget((Expression) n.getTarget().accept(this, ctx));
        }
        if (n.getValue() != null) {
            img.setValue((Expression) n.getValue().accept(this, ctx));
        }
        if (ctx.containsKey(n.getAssignOperator())) {
            img.setAssignOperator((AssignmentExpression.AssignOperator) ctx.get(n.getAssignOperator()));
        } else {
            img.setAssignOperator(n.getAssignOperator());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(AssignOperator n, Map<Object, Object> ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(BinaryExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        BinaryExpression img = new BinaryExpression();
        if (n.getLeft() != null) {
            img.setLeft((Expression) n.getLeft().accept(this, ctx));
        }
        if (n.getRight() != null) {
            img.setRight((Expression) n.getRight().accept(this, ctx));
        }
        if (ctx.containsKey(n.getBinaryOperator())) {
            img.setBinaryOperator((BinaryExpression.BinaryOperator) ctx.get(n.getBinaryOperator()));
        } else {
            img.setBinaryOperator(n.getBinaryOperator());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(BinaryOperator n, Map<Object, Object> ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(Block n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Block img = new Block();
        if (n.getStatements() != null) {
            img.setStatements((NodeList<Statement>) n.getStatements().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(BlockComment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        BlockComment img = new BlockComment();
        if (ctx.containsKey(n.getContent())) {
            img.setContent((String) ctx.get(n.getContent()));
        } else {
            img.setContent(n.getContent());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(BooleanLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        BooleanLiteral img = new BooleanLiteral();
        if (ctx.containsKey(n.isValue())) {
            img.setValue((boolean) ctx.get(n.isValue()));
        } else {
            img.setValue(n.isValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(BreakStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        BreakStatement img = new BreakStatement();
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(CallExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        CallExpression img = new CallExpression();
        if (n.getScope() != null) {
            img.setScope((Expression) n.getScope().accept(this, ctx));
        }
        if (n.getArgs() != null) {
            img.setArgs((NodeList<Expression>) n.getArgs().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(CaseBlock n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(CaseClause n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        CaseClause img = new CaseClause();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getStatements() != null) {
            img.setStatements((NodeList<Statement>) n.getStatements().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(CatchClause n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        CatchClause img = new CatchClause();
        if (ctx.containsKey(n.getString())) {
            img.setString((String) ctx.get(n.getString()));
        } else {
            img.setString(n.getString());
        }
        if (n.getBlock() != null) {
            img.setBlock((Block) n.getBlock().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(CompilationUnit n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        CompilationUnit img = new CompilationUnit();
        if (n.getElements() != null) {
            img.setElements((NodeList<Statement>) n.getElements().accept(this, ctx));
        }
        if (n.getComments() != null) {
            img.setComments((NodeList<Comment>) n.getComments().accept(this, ctx));
        }
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ConditionalExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ConstantStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ConstantStatement img = new ConstantStatement();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ContinueStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ContinueStatement img = new ContinueStatement();
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(DebuggerStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        DebuggerStatement img = new DebuggerStatement();
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(DecimalLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        DecimalLiteral img = new DecimalLiteral();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(DefaultClause n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        DefaultClause img = new DefaultClause();
        if (n.getStatements() != null) {
            img.setStatements((NodeList<Statement>) n.getStatements().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(DoWhileStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(EmptyLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        EmptyLiteral img = new EmptyLiteral();
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(EmptyStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        EmptyStatement img = new EmptyStatement();
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(EnclosedExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        EnclosedExpression img = new EnclosedExpression();
        if (n.getInner() != null) {
            img.setInner((Expression) n.getInner().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ExpressionStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ExpressionStatement img = new ExpressionStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(FieldAccessExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        FieldAccessExpression img = new FieldAccessExpression();
        if (n.getScope() != null) {
            img.setScope((Expression) n.getScope().accept(this, ctx));
        }
        if (n.getField() != null) {
            img.setField((IdentifierName) n.getField().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(FloatLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        FloatLiteral img = new FloatLiteral();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ForeachStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ForStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(FunctionDeclaration n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        FunctionDeclaration img = new FunctionDeclaration();
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (n.getParameters() != null) {
            img.setParameters((NodeList<Parameter>) n.getParameters().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Block) n.getBody().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(FunctionExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        FunctionExpression img = new FunctionExpression();
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (n.getParameters() != null) {
            img.setParameters((NodeList<Parameter>) n.getParameters().accept(this, ctx));
        }
        if (n.getBody() != null) {
            img.setBody((Block) n.getBody().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(GetAssignment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(HexIntegerLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        HexIntegerLiteral img = new HexIntegerLiteral();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(IdentifierName n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        IdentifierName img = new IdentifierName();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(IfStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ImportStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ImportStatement img = new ImportStatement();
        if (n.getName() != null) {
            img.setName((IdentifierName) n.getName().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(JSDocComment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        JSDocComment img = new JSDocComment();
        if (ctx.containsKey(n.getContent())) {
            img.setContent((String) ctx.get(n.getContent()));
        } else {
            img.setContent(n.getContent());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(LabelledStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        LabelledStatement img = new LabelledStatement();
        if (ctx.containsKey(n.getLabel())) {
            img.setLabel((String) ctx.get(n.getLabel()));
        } else {
            img.setLabel(n.getLabel());
        }
        if (n.getStatement() != null) {
            img.setStatement((Statement) n.getStatement().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(LetDefinition n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        LetDefinition img = new LetDefinition();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(LetExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        LetExpression img = new LetExpression();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(LetStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(LineComment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        LineComment img = new LineComment();
        if (ctx.containsKey(n.getContent())) {
            img.setContent((String) ctx.get(n.getContent()));
        } else {
            img.setContent(n.getContent());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(NewExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        NewExpression img = new NewExpression();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getInitializer() != null) {
            img.setInitializer((ObjectLiteral) n.getInitializer().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public <E extends Node> Node visit(NodeList<E> n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        NodeList<E> img = new NodeList<E>();
        if (n.getNodes() != null) {
            List<E> nodes = new ArrayList<E>();
            for (E item : n.getNodes()) {
                if (item != null) {
                    E node = (E) item.accept(this, ctx);
                    if (node != null) {
                        nodes.add(node);
                    }
                }
            }
            img.setNodes(nodes);
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(NullLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        NullLiteral img = new NullLiteral();
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ObjectLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ObjectLiteral img = new ObjectLiteral();
        if (n.getPropertyAssignments() != null) {
            img.setPropertyAssignments((NodeList<PropertyAssignment>) n.getPropertyAssignments().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(OctalLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        OctalLiteral img = new OctalLiteral();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(Parameter n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Parameter img = new Parameter();
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(Project n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        Project img = new Project();
        if (n.getCompilationUnits() != null) {
            img.setCompilationUnits((NodeList<CompilationUnit>) n.getCompilationUnits().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(PutAssignment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(RegexpLiteral n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        RegexpLiteral img = new RegexpLiteral();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ReturnStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ReturnStatement img = new ReturnStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(SequenceExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        SequenceExpression img = new SequenceExpression();
        if (n.getExpressions() != null) {
            img.setExpressions((NodeList<Expression>) n.getExpressions().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(SetAssignment n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        SetAssignment img = new SetAssignment();
        if (ctx.containsKey(n.getIdentifier())) {
            img.setIdentifier((String) ctx.get(n.getIdentifier()));
        } else {
            img.setIdentifier(n.getIdentifier());
        }
        if (n.getBlock() != null) {
            img.setBlock((Block) n.getBlock().accept(this, ctx));
        }
        if (n.getPropertyName() != null) {
            img.setPropertyName((PropertyName) n.getPropertyName().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(StringLiteralDouble n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        StringLiteralDouble img = new StringLiteralDouble();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(StringLiteralSingle n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        StringLiteralSingle img = new StringLiteralSingle();
        if (ctx.containsKey(n.getValue())) {
            img.setValue((String) ctx.get(n.getValue()));
        } else {
            img.setValue(n.getValue());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(SuperExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        SuperExpression img = new SuperExpression();
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(SwitchStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ThisExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ThisExpression img = new ThisExpression();
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(ThrowStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        ThrowStatement img = new ThrowStatement();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(TryStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(UnaryExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        UnaryExpression img = new UnaryExpression();
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (ctx.containsKey(n.getUnaryOperator())) {
            img.setUnaryOperator((UnaryExpression.UnaryOperator) ctx.get(n.getUnaryOperator()));
        } else {
            img.setUnaryOperator(n.getUnaryOperator());
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(UnaryOperator n, Map<Object, Object> ctx) throws Exception {
        return null;
    }

    @Override
    public Node visit(VariableDeclaration n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        VariableDeclaration img = new VariableDeclaration();
        if (ctx.containsKey(n.getName())) {
            img.setName((String) ctx.get(n.getName()));
        } else {
            img.setName(n.getName());
        }
        if (n.getExpression() != null) {
            img.setExpression((Expression) n.getExpression().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(VariableExpression n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        VariableExpression img = new VariableExpression();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(VariableStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
        VariableStatement img = new VariableStatement();
        if (n.getVariableDeclarations() != null) {
            img.setVariableDeclarations((NodeList<VariableDeclaration>) n.getVariableDeclarations().accept(this, ctx));
        }
        if (n.getComment() != null) {
            img.setComment((Comment) n.getComment().accept(this, ctx));
        }
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(WhileStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    @Override
    public Node visit(WithStatement n, Map<Object, Object> ctx) throws Exception {
        if (ctx.containsKey(n)) {
            return (Node) ctx.get(n);
        }
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
        if (ctx.containsKey(n.getPosBegin())) {
            img.setPosBegin((int) ctx.get(n.getPosBegin()));
        } else {
            img.setPosBegin(n.getPosBegin());
        }
        if (ctx.containsKey(n.getPosEnd())) {
            img.setPosEnd((int) ctx.get(n.getPosEnd()));
        } else {
            img.setPosEnd(n.getPosEnd());
        }
        return img;
    }

    public ObjectReplacer() {
        super();
    }

}