package com.digiarea.es5.visitor;

import com.digiarea.es5.visitor.GenericVisitor;
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

public class GenericVisitorAdapter<R, C> implements GenericVisitor<R, C> {

    @Override
    public R visit(AllocationExpression n, C ctx) throws Exception {
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ArrayAccessExpression n, C ctx) throws Exception {
        if (n.getName() != null) {
            n.getName().accept(this, ctx);
        }
        if (n.getIndex() != null) {
            n.getIndex().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ArrayLiteral n, C ctx) throws Exception {
        if (n.getExpressions() != null) {
            n.getExpressions().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(AssignmentExpression n, C ctx) throws Exception {
        if (n.getTarget() != null) {
            n.getTarget().accept(this, ctx);
        }
        if (n.getValue() != null) {
            n.getValue().accept(this, ctx);
        }
        if (n.getAssignOperator() != null) {
            n.getAssignOperator().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(AssignOperator n, C ctx) throws Exception {
        return null;
    }

    @Override
    public R visit(BinaryExpression n, C ctx) throws Exception {
        if (n.getLeft() != null) {
            n.getLeft().accept(this, ctx);
        }
        if (n.getRight() != null) {
            n.getRight().accept(this, ctx);
        }
        if (n.getBinaryOperator() != null) {
            n.getBinaryOperator().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(BinaryOperator n, C ctx) throws Exception {
        return null;
    }

    @Override
    public R visit(Block n, C ctx) throws Exception {
        if (n.getStatements() != null) {
            n.getStatements().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(BlockComment n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(BooleanLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(BreakStatement n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(CallExpression n, C ctx) throws Exception {
        if (n.getScope() != null) {
            n.getScope().accept(this, ctx);
        }
        if (n.getArgs() != null) {
            n.getArgs().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(CaseBlock n, C ctx) throws Exception {
        if (n.getDefaultClause() != null) {
            n.getDefaultClause().accept(this, ctx);
        }
        if (n.getCaseClauses() != null) {
            n.getCaseClauses().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(CaseClause n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getStatements() != null) {
            n.getStatements().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(CatchClause n, C ctx) throws Exception {
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(CompilationUnit n, C ctx) throws Exception {
        if (n.getElements() != null) {
            n.getElements().accept(this, ctx);
        }
        if (n.getComments() != null) {
            n.getComments().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ConditionalExpression n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getThenExpr() != null) {
            n.getThenExpr().accept(this, ctx);
        }
        if (n.getElseExpr() != null) {
            n.getElseExpr().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ConstantStatement n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ContinueStatement n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(DebuggerStatement n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(DecimalLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(DefaultClause n, C ctx) throws Exception {
        if (n.getStatements() != null) {
            n.getStatements().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(DoWhileStatement n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(EmptyLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(EmptyStatement n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(EnclosedExpression n, C ctx) throws Exception {
        if (n.getInner() != null) {
            n.getInner().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ExpressionStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(FieldAccessExpression n, C ctx) throws Exception {
        if (n.getScope() != null) {
            n.getScope().accept(this, ctx);
        }
        if (n.getField() != null) {
            n.getField().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(FloatLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ForeachStatement n, C ctx) throws Exception {
        if (n.getVariable() != null) {
            n.getVariable().accept(this, ctx);
        }
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ForStatement n, C ctx) throws Exception {
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
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(FunctionDeclaration n, C ctx) throws Exception {
        if (n.getParameters() != null) {
            n.getParameters().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(FunctionExpression n, C ctx) throws Exception {
        if (n.getParameters() != null) {
            n.getParameters().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(GetAssignment n, C ctx) throws Exception {
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getPropertyName() != null) {
            n.getPropertyName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(HexIntegerLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(IdentifierName n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(IfStatement n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getThenStatement() != null) {
            n.getThenStatement().accept(this, ctx);
        }
        if (n.getElseStatement() != null) {
            n.getElseStatement().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ImportStatement n, C ctx) throws Exception {
        if (n.getName() != null) {
            n.getName().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(JSDocComment n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(LabelledStatement n, C ctx) throws Exception {
        if (n.getStatement() != null) {
            n.getStatement().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(LetDefinition n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(LetExpression n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(LetStatement n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getStatement() != null) {
            n.getStatement().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(LineComment n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(NewExpression n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getInitializer() != null) {
            n.getInitializer().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public <E extends Node> R visit(NodeList<E> n, C ctx) throws Exception {
        if (n.getNodes() != null) {
            for (E item : n.getNodes()) {
                if (item != null) {
                    item.accept(this, ctx);
                }
            }
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(NullLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ObjectLiteral n, C ctx) throws Exception {
        if (n.getPropertyAssignments() != null) {
            n.getPropertyAssignments().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(OctalLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(Parameter n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(Project n, C ctx) throws Exception {
        if (n.getCompilationUnits() != null) {
            n.getCompilationUnits().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(PutAssignment n, C ctx) throws Exception {
        if (n.getPropertyValue() != null) {
            n.getPropertyValue().accept(this, ctx);
        }
        if (n.getPropertyName() != null) {
            n.getPropertyName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(RegexpLiteral n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ReturnStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(SequenceExpression n, C ctx) throws Exception {
        if (n.getExpressions() != null) {
            n.getExpressions().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(SetAssignment n, C ctx) throws Exception {
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getPropertyName() != null) {
            n.getPropertyName().accept(this, ctx);
        }
        if (n.getComment() != null) {
            n.getComment().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(StringLiteralDouble n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(StringLiteralSingle n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(SuperExpression n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(SwitchStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getBlock() != null) {
            n.getBlock().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ThisExpression n, C ctx) throws Exception {
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(ThrowStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(TryStatement n, C ctx) throws Exception {
        if (n.getTryBlock() != null) {
            n.getTryBlock().accept(this, ctx);
        }
        if (n.getCatchClause() != null) {
            n.getCatchClause().accept(this, ctx);
        }
        if (n.getFinallyBlock() != null) {
            n.getFinallyBlock().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(UnaryExpression n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getUnaryOperator() != null) {
            n.getUnaryOperator().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(UnaryOperator n, C ctx) throws Exception {
        return null;
    }

    @Override
    public R visit(VariableDeclaration n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(VariableExpression n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(VariableStatement n, C ctx) throws Exception {
        if (n.getVariableDeclarations() != null) {
            n.getVariableDeclarations().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(WhileStatement n, C ctx) throws Exception {
        if (n.getCondition() != null) {
            n.getCondition().accept(this, ctx);
        }
        if (n.getBody() != null) {
            n.getBody().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    @Override
    public R visit(WithStatement n, C ctx) throws Exception {
        if (n.getExpression() != null) {
            n.getExpression().accept(this, ctx);
        }
        if (n.getStatement() != null) {
            n.getStatement().accept(this, ctx);
        }
        if (n.getJsDocComment() != null) {
            n.getJsDocComment().accept(this, ctx);
        }
        return null;
    }

    public GenericVisitorAdapter() {
        super();
    }

}
