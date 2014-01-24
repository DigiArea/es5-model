/*
 * 
 */
package com.digiarea.es5.visitor;

import java.util.List;
import com.digiarea.es5.visitor.GenericVisitor;
import com.digiarea.es5.AllocationExpression;
import java.util.ArrayList;
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

public class ChildrenProvider<C> implements GenericVisitor<List<Object>, Void> {

    @Override
    public List<Object> visit(AllocationExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ArrayAccessExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getName() != null) {
            img.add(n.getName());
        }
        if (n.getIndex() != null) {
            img.add(n.getIndex());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ArrayLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpressions() != null) {
            img.add(n.getExpressions());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(AssignmentExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getTarget() != null) {
            img.add(n.getTarget());
        }
        if (n.getValue() != null) {
            img.add(n.getValue());
        }
        img.add(n.getAssignOperator());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(AssignOperator n, Void ctx) throws Exception {
        return null;
    }

    @Override
    public List<Object> visit(BinaryExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getLeft() != null) {
            img.add(n.getLeft());
        }
        if (n.getRight() != null) {
            img.add(n.getRight());
        }
        img.add(n.getBinaryOperator());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(BinaryOperator n, Void ctx) throws Exception {
        return null;
    }

    @Override
    public List<Object> visit(Block n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getStatements() != null) {
            img.add(n.getStatements());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(BlockComment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getContent());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(BooleanLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.isValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(BreakStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getIdentifier());
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(CallExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getScope() != null) {
            img.add(n.getScope());
        }
        if (n.getArgs() != null) {
            img.add(n.getArgs());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(CaseBlock n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getDefaultClause() != null) {
            img.add(n.getDefaultClause());
        }
        if (n.getCaseClauses() != null) {
            img.add(n.getCaseClauses());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(CaseClause n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getStatements() != null) {
            img.add(n.getStatements());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(CatchClause n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getString());
        if (n.getBlock() != null) {
            img.add(n.getBlock());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(CompilationUnit n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getElements() != null) {
            img.add(n.getElements());
        }
        if (n.getComments() != null) {
            img.add(n.getComments());
        }
        img.add(n.getName());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ConditionalExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getCondition() != null) {
            img.add(n.getCondition());
        }
        if (n.getThenExpr() != null) {
            img.add(n.getThenExpr());
        }
        if (n.getElseExpr() != null) {
            img.add(n.getElseExpr());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ConstantStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariableDeclarations() != null) {
            img.add(n.getVariableDeclarations());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ContinueStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getIdentifier());
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(DebuggerStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(DecimalLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(DefaultClause n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getStatements() != null) {
            img.add(n.getStatements());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(DoWhileStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getCondition() != null) {
            img.add(n.getCondition());
        }
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(EmptyLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(EmptyStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(EnclosedExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getInner() != null) {
            img.add(n.getInner());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ExpressionStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(FieldAccessExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getScope() != null) {
            img.add(n.getScope());
        }
        if (n.getField() != null) {
            img.add(n.getField());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(FloatLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ForeachStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariable() != null) {
            img.add(n.getVariable());
        }
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ForStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariable() != null) {
            img.add(n.getVariable());
        }
        if (n.getCondition() != null) {
            img.add(n.getCondition());
        }
        if (n.getExpr() != null) {
            img.add(n.getExpr());
        }
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(FunctionDeclaration n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getName());
        if (n.getParameters() != null) {
            img.add(n.getParameters());
        }
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(FunctionExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getName());
        if (n.getParameters() != null) {
            img.add(n.getParameters());
        }
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(GetAssignment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getBlock() != null) {
            img.add(n.getBlock());
        }
        if (n.getPropertyName() != null) {
            img.add(n.getPropertyName());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(HexIntegerLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(IdentifierName n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(IfStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getCondition() != null) {
            img.add(n.getCondition());
        }
        if (n.getThenStatement() != null) {
            img.add(n.getThenStatement());
        }
        if (n.getElseStatement() != null) {
            img.add(n.getElseStatement());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ImportStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getName() != null) {
            img.add(n.getName());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(JSDocComment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getContent());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(LabelledStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getLabel());
        if (n.getStatement() != null) {
            img.add(n.getStatement());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(LetDefinition n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariableDeclarations() != null) {
            img.add(n.getVariableDeclarations());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(LetExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariableDeclarations() != null) {
            img.add(n.getVariableDeclarations());
        }
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(LetStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariableDeclarations() != null) {
            img.add(n.getVariableDeclarations());
        }
        if (n.getStatement() != null) {
            img.add(n.getStatement());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(LineComment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getContent());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(NewExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getInitializer() != null) {
            img.add(n.getInitializer());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public <E extends Node> List<Object> visit(NodeList<E> n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getNodes() != null) {
            img.add(n.getNodes());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(NullLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ObjectLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getPropertyAssignments() != null) {
            img.add(n.getPropertyAssignments());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(OctalLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(Parameter n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getName());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(Project n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getCompilationUnits() != null) {
            img.add(n.getCompilationUnits());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(PutAssignment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getPropertyValue() != null) {
            img.add(n.getPropertyValue());
        }
        if (n.getPropertyName() != null) {
            img.add(n.getPropertyName());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(RegexpLiteral n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ReturnStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(SequenceExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpressions() != null) {
            img.add(n.getExpressions());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(SetAssignment n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getIdentifier());
        if (n.getBlock() != null) {
            img.add(n.getBlock());
        }
        if (n.getPropertyName() != null) {
            img.add(n.getPropertyName());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(StringLiteralDouble n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(StringLiteralSingle n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getValue());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(SuperExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(SwitchStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getBlock() != null) {
            img.add(n.getBlock());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ThisExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(ThrowStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(TryStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getTryBlock() != null) {
            img.add(n.getTryBlock());
        }
        if (n.getCatchClause() != null) {
            img.add(n.getCatchClause());
        }
        if (n.getFinallyBlock() != null) {
            img.add(n.getFinallyBlock());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(UnaryExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        img.add(n.getUnaryOperator());
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(UnaryOperator n, Void ctx) throws Exception {
        return null;
    }

    @Override
    public List<Object> visit(VariableDeclaration n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        img.add(n.getName());
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(VariableExpression n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariableDeclarations() != null) {
            img.add(n.getVariableDeclarations());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(VariableStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getVariableDeclarations() != null) {
            img.add(n.getVariableDeclarations());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(WhileStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getCondition() != null) {
            img.add(n.getCondition());
        }
        if (n.getBody() != null) {
            img.add(n.getBody());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    @Override
    public List<Object> visit(WithStatement n, Void ctx) throws Exception {
        List<Object> img = new ArrayList<Object>();
        if (n.getExpression() != null) {
            img.add(n.getExpression());
        }
        if (n.getStatement() != null) {
            img.add(n.getStatement());
        }
        if (n.getComment() != null) {
            img.add(n.getComment());
        }
        img.add(n.getPosBegin());
        img.add(n.getPosEnd());
        return img;
    }

    public ChildrenProvider() {
        super();
    }

}
