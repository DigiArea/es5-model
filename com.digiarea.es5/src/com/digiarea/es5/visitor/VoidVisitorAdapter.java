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

import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.AllocationExpression;
import com.digiarea.es5.ArrayAccessExpression;
import com.digiarea.es5.ArrayLiteral;
import com.digiarea.es5.AssignmentExpression;
import com.digiarea.es5.AssignmentExpression.AssignOperator;
import com.digiarea.es5.BinaryExpression;
import com.digiarea.es5.BinaryExpression.BinaryOperator;
import com.digiarea.es5.Block;
import com.digiarea.es5.BlockComment;
import com.digiarea.es5.BooleanLiteral;
import com.digiarea.es5.BreakStatement;
import com.digiarea.es5.CallExpression;
import com.digiarea.es5.CaseBlock;
import com.digiarea.es5.CaseClause;
import com.digiarea.es5.CatchClause;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.ConditionalExpression;
import com.digiarea.es5.ConstantStatement;
import com.digiarea.es5.ContinueStatement;
import com.digiarea.es5.DebuggerStatement;
import com.digiarea.es5.DecimalLiteral;
import com.digiarea.es5.DefaultClause;
import com.digiarea.es5.DoWhileStatement;
import com.digiarea.es5.EmptyLiteral;
import com.digiarea.es5.EmptyStatement;
import com.digiarea.es5.EnclosedExpression;
import com.digiarea.es5.ExpressionStatement;
import com.digiarea.es5.FieldAccessExpression;
import com.digiarea.es5.FloatLiteral;
import com.digiarea.es5.ForeachStatement;
import com.digiarea.es5.ForStatement;
import com.digiarea.es5.FunctionDeclaration;
import com.digiarea.es5.FunctionExpression;
import com.digiarea.es5.GetAssignment;
import com.digiarea.es5.HexIntegerLiteral;
import com.digiarea.es5.IdentifierName;
import com.digiarea.es5.IfStatement;
import com.digiarea.es5.ImportStatement;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.LabelledStatement;
import com.digiarea.es5.LetDefinition;
import com.digiarea.es5.LetExpression;
import com.digiarea.es5.LetStatement;
import com.digiarea.es5.LineComment;
import com.digiarea.es5.NewExpression;
import com.digiarea.es5.Node;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.NullLiteral;
import com.digiarea.es5.ObjectLiteral;
import com.digiarea.es5.OctalLiteral;
import com.digiarea.es5.Parameter;
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
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.VariableExpression;
import com.digiarea.es5.VariableStatement;
import com.digiarea.es5.WhileStatement;
import com.digiarea.es5.WithStatement;

/**
 * The Class VoidVisitorAdapter.
 *
 * @param <C> the generic type
 */
public class VoidVisitorAdapter<C> implements VoidVisitor<C> {

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.AllocationExpression, java.lang.Object)
     */
    @Override
    public void visit(AllocationExpression n, C ctx) throws Exception {
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ArrayAccessExpression, java.lang.Object)
     */
    @Override
    public void visit(ArrayAccessExpression n, C ctx) throws Exception {
        if (n.getName() != null) {
            n.getName().accept(this, ctx);
        }
        if (n.getIndex() != null) {
            n.getIndex().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ArrayLiteral, java.lang.Object)
     */
    @Override
    public void visit(ArrayLiteral n, C ctx) throws Exception {
        if (n.getExpressions() != null) {
            n.getExpressions().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.AssignmentExpression, java.lang.Object)
     */
    @Override
    public void visit(AssignmentExpression n, C ctx) throws Exception {
        if (n.getTarget() != null) {
            n.getTarget().accept(this, ctx);
        }
        if (n.getValue() != null) {
            n.getValue().accept(this, ctx);
        }
        if (n.getAssignOperator() != null) {
            n.getAssignOperator().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.AssignmentExpression.AssignOperator, java.lang.Object)
     */
    @Override
    public void visit(AssignOperator n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.BinaryExpression, java.lang.Object)
     */
    @Override
    public void visit(BinaryExpression n, C ctx) throws Exception {
        if (n.getLeft() != null) {
            n.getLeft().accept(this, ctx);
        }
        if (n.getRight() != null) {
            n.getRight().accept(this, ctx);
        }
        if (n.getBinaryOperator() != null) {
            n.getBinaryOperator().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.BinaryExpression.BinaryOperator, java.lang.Object)
     */
    @Override
    public void visit(BinaryOperator n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.Block, java.lang.Object)
     */
    @Override
    public void visit(Block n, C ctx) throws Exception {
        if (n.getStatements() != null) {
            n.getStatements().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.BlockComment, java.lang.Object)
     */
    @Override
    public void visit(BlockComment n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.BooleanLiteral, java.lang.Object)
     */
    @Override
    public void visit(BooleanLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.BreakStatement, java.lang.Object)
     */
    @Override
    public void visit(BreakStatement n, C ctx) throws Exception {
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.CallExpression, java.lang.Object)
     */
    @Override
    public void visit(CallExpression n, C ctx) throws Exception {
        if (n.getScope() != null) {
            n.getScope().accept(this, ctx);
        }
        if (n.getArgs() != null) {
            n.getArgs().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.CaseBlock, java.lang.Object)
     */
    @Override
    public void visit(CaseBlock n, C ctx) throws Exception {
        if (n.getDefaultClause() != null) {
            n.getDefaultClause().accept(this, ctx);
        }
        if (n.getCaseClauses() != null) {
            n.getCaseClauses().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.CaseClause, java.lang.Object)
     */
    @Override
    public void visit(CaseClause n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getStatements() != null) {
            n.getStatements().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.CatchClause, java.lang.Object)
     */
    @Override
    public void visit(CatchClause n, C ctx) throws Exception {
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.CompilationUnit, java.lang.Object)
     */
    @Override
    public void visit(CompilationUnit n, C ctx) throws Exception {
        if (n.getElements() != null) {
            n.getElements().accept(this, ctx);
        }
        if (n.getComments() != null) {
            n.getComments().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ConditionalExpression, java.lang.Object)
     */
    @Override
    public void visit(ConditionalExpression n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getThenExpr() != null) {
            n.getThenExpr().accept(this, ctx);
        }
        if (n.getElseExpr() != null) {
            n.getElseExpr().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ConstantStatement, java.lang.Object)
     */
    @Override
    public void visit(ConstantStatement n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ContinueStatement, java.lang.Object)
     */
    @Override
    public void visit(ContinueStatement n, C ctx) throws Exception {
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.DebuggerStatement, java.lang.Object)
     */
    @Override
    public void visit(DebuggerStatement n, C ctx) throws Exception {
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.DecimalLiteral, java.lang.Object)
     */
    @Override
    public void visit(DecimalLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.DefaultClause, java.lang.Object)
     */
    @Override
    public void visit(DefaultClause n, C ctx) throws Exception {
        if (n.getStatements() != null) {
            n.getStatements().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.DoWhileStatement, java.lang.Object)
     */
    @Override
    public void visit(DoWhileStatement n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.EmptyLiteral, java.lang.Object)
     */
    @Override
    public void visit(EmptyLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.EmptyStatement, java.lang.Object)
     */
    @Override
    public void visit(EmptyStatement n, C ctx) throws Exception {
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.EnclosedExpression, java.lang.Object)
     */
    @Override
    public void visit(EnclosedExpression n, C ctx) throws Exception {
        if (n.getInner() != null) {
            n.getInner().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ExpressionStatement, java.lang.Object)
     */
    @Override
    public void visit(ExpressionStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.FieldAccessExpression, java.lang.Object)
     */
    @Override
    public void visit(FieldAccessExpression n, C ctx) throws Exception {
        if (n.getScope() != null) {
            n.getScope().accept(this, ctx);
        }
        if (n.getField() != null) {
            n.getField().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.FloatLiteral, java.lang.Object)
     */
    @Override
    public void visit(FloatLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ForeachStatement, java.lang.Object)
     */
    @Override
    public void visit(ForeachStatement n, C ctx) throws Exception {
        if (n.getVariable() != null) {
            n.getVariable().accept(this, ctx);
        }
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ForStatement, java.lang.Object)
     */
    @Override
    public void visit(ForStatement n, C ctx) throws Exception {
        if (n.getVariable() != null) {
            n.getVariable().accept(this, ctx);
        }
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getExpr() != null) {
            n.getExpr().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.FunctionDeclaration, java.lang.Object)
     */
    @Override
    public void visit(FunctionDeclaration n, C ctx) throws Exception {
        if (n.getParameters() != null) {
            n.getParameters().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.FunctionExpression, java.lang.Object)
     */
    @Override
    public void visit(FunctionExpression n, C ctx) throws Exception {
        if (n.getParameters() != null) {
            n.getParameters().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.GetAssignment, java.lang.Object)
     */
    @Override
    public void visit(GetAssignment n, C ctx) throws Exception {
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getPropertyName() != null) {
            n.getPropertyName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.HexIntegerLiteral, java.lang.Object)
     */
    @Override
    public void visit(HexIntegerLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.IdentifierName, java.lang.Object)
     */
    @Override
    public void visit(IdentifierName n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.IfStatement, java.lang.Object)
     */
    @Override
    public void visit(IfStatement n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getThenStatement() != null) {
            n.getThenStatement().accept(this, ctx);
        }
        if (n.getElseStatement() != null) {
            n.getElseStatement().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ImportStatement, java.lang.Object)
     */
    @Override
    public void visit(ImportStatement n, C ctx) throws Exception {
        if (n.getName() != null) {
            n.getName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.JSDocComment, java.lang.Object)
     */
    @Override
    public void visit(JSDocComment n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.LabelledStatement, java.lang.Object)
     */
    @Override
    public void visit(LabelledStatement n, C ctx) throws Exception {
        if (n.getStatement() != null) {
            n.getStatement().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.LetDefinition, java.lang.Object)
     */
    @Override
    public void visit(LetDefinition n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.LetExpression, java.lang.Object)
     */
    @Override
    public void visit(LetExpression n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.LetStatement, java.lang.Object)
     */
    @Override
    public void visit(LetStatement n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getStatement() != null) {
            n.getStatement().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.LineComment, java.lang.Object)
     */
    @Override
    public void visit(LineComment n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.NewExpression, java.lang.Object)
     */
    @Override
    public void visit(NewExpression n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getInitializer() != null) {
            n.getInitializer().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.NodeList, java.lang.Object)
     */
    @Override
    public <E extends Node> void visit(NodeList<E> n, C ctx) throws Exception {
        if (n.getNodes() != null) {
            for (E item : n.getNodes()) {
                if (item != null) {
                    item.accept(this, ctx);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.NullLiteral, java.lang.Object)
     */
    @Override
    public void visit(NullLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ObjectLiteral, java.lang.Object)
     */
    @Override
    public void visit(ObjectLiteral n, C ctx) throws Exception {
        if (n.getPropertyAssignments() != null) {
            n.getPropertyAssignments().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.OctalLiteral, java.lang.Object)
     */
    @Override
    public void visit(OctalLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.Parameter, java.lang.Object)
     */
    @Override
    public void visit(Parameter n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.Project, java.lang.Object)
     */
    @Override
    public void visit(Project n, C ctx) throws Exception {
        if (n.getCompilationUnits() != null) {
            n.getCompilationUnits().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.PutAssignment, java.lang.Object)
     */
    @Override
    public void visit(PutAssignment n, C ctx) throws Exception {
        if (n.getPropertyValue() != null) {
            n.getPropertyValue().accept(this, ctx);
        }
        if (n.getPropertyName() != null) {
            n.getPropertyName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.RegexpLiteral, java.lang.Object)
     */
    @Override
    public void visit(RegexpLiteral n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ReturnStatement, java.lang.Object)
     */
    @Override
    public void visit(ReturnStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.SequenceExpression, java.lang.Object)
     */
    @Override
    public void visit(SequenceExpression n, C ctx) throws Exception {
        if (n.getExpressions() != null) {
            n.getExpressions().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.SetAssignment, java.lang.Object)
     */
    @Override
    public void visit(SetAssignment n, C ctx) throws Exception {
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getPropertyName() != null) {
            n.getPropertyName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.StringLiteralDouble, java.lang.Object)
     */
    @Override
    public void visit(StringLiteralDouble n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.StringLiteralSingle, java.lang.Object)
     */
    @Override
    public void visit(StringLiteralSingle n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.SuperExpression, java.lang.Object)
     */
    @Override
    public void visit(SuperExpression n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.SwitchStatement, java.lang.Object)
     */
    @Override
    public void visit(SwitchStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ThisExpression, java.lang.Object)
     */
    @Override
    public void visit(ThisExpression n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.ThrowStatement, java.lang.Object)
     */
    @Override
    public void visit(ThrowStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.TryStatement, java.lang.Object)
     */
    @Override
    public void visit(TryStatement n, C ctx) throws Exception {
        if (n.getTryBlock() != null) {
            n.getTryBlock().accept(this, ctx);
        }
        if (n.getCatchClause() != null) {
            n.getCatchClause().accept(this, ctx);
        }
        if (n.getFinallyBlock() != null) {
            n.getFinallyBlock().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.UnaryExpression, java.lang.Object)
     */
    @Override
    public void visit(UnaryExpression n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getUnaryOperator() != null) {
            n.getUnaryOperator().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.UnaryExpression.UnaryOperator, java.lang.Object)
     */
    @Override
    public void visit(UnaryOperator n, C ctx) throws Exception {
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.VariableDeclaration, java.lang.Object)
     */
    @Override
    public void visit(VariableDeclaration n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.VariableExpression, java.lang.Object)
     */
    @Override
    public void visit(VariableExpression n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.VariableStatement, java.lang.Object)
     */
    @Override
    public void visit(VariableStatement n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.WhileStatement, java.lang.Object)
     */
    @Override
    public void visit(WhileStatement n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.visitor.VoidVisitor#visit(com.digiarea.es5.WithStatement, java.lang.Object)
     */
    @Override
    public void visit(WithStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getStatement() != null) {
            n.getStatement().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
    }

    /**
     * Instantiates a new void visitor adapter.
     */
    public VoidVisitorAdapter() {
        super();
    }

}
