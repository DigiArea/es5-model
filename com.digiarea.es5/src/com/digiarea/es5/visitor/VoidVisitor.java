package com.digiarea.es5.visitor;

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

public interface VoidVisitor<C> {

    public void visit(AllocationExpression n, C ctx) throws Exception;

    public void visit(ArrayAccessExpression n, C ctx) throws Exception;

    public void visit(ArrayLiteral n, C ctx) throws Exception;

    public void visit(AssignmentExpression n, C ctx) throws Exception;

    public void visit(AssignOperator n, C ctx) throws Exception;

    public void visit(BinaryExpression n, C ctx) throws Exception;

    public void visit(BinaryOperator n, C ctx) throws Exception;

    public void visit(Block n, C ctx) throws Exception;

    public void visit(BlockComment n, C ctx) throws Exception;

    public void visit(BooleanLiteral n, C ctx) throws Exception;

    public void visit(BreakStatement n, C ctx) throws Exception;

    public void visit(CallExpression n, C ctx) throws Exception;

    public void visit(CaseBlock n, C ctx) throws Exception;

    public void visit(CaseClause n, C ctx) throws Exception;

    public void visit(CatchClause n, C ctx) throws Exception;

    public void visit(CompilationUnit n, C ctx) throws Exception;

    public void visit(ConditionalExpression n, C ctx) throws Exception;

    public void visit(ConstantStatement n, C ctx) throws Exception;

    public void visit(ContinueStatement n, C ctx) throws Exception;

    public void visit(DebuggerStatement n, C ctx) throws Exception;

    public void visit(DecimalLiteral n, C ctx) throws Exception;

    public void visit(DefaultClause n, C ctx) throws Exception;

    public void visit(DoWhileStatement n, C ctx) throws Exception;

    public void visit(EmptyLiteral n, C ctx) throws Exception;

    public void visit(EmptyStatement n, C ctx) throws Exception;

    public void visit(EnclosedExpression n, C ctx) throws Exception;

    public void visit(ExpressionStatement n, C ctx) throws Exception;

    public void visit(FieldAccessExpression n, C ctx) throws Exception;

    public void visit(FloatLiteral n, C ctx) throws Exception;

    public void visit(ForeachStatement n, C ctx) throws Exception;

    public void visit(ForStatement n, C ctx) throws Exception;

    public void visit(FunctionDeclaration n, C ctx) throws Exception;

    public void visit(FunctionExpression n, C ctx) throws Exception;

    public void visit(GetAssignment n, C ctx) throws Exception;

    public void visit(HexIntegerLiteral n, C ctx) throws Exception;

    public void visit(IdentifierName n, C ctx) throws Exception;

    public void visit(IfStatement n, C ctx) throws Exception;

    public void visit(ImportStatement n, C ctx) throws Exception;

    public void visit(JSDocComment n, C ctx) throws Exception;

    public void visit(LabelledStatement n, C ctx) throws Exception;

    public void visit(LetDefinition n, C ctx) throws Exception;

    public void visit(LetExpression n, C ctx) throws Exception;

    public void visit(LetStatement n, C ctx) throws Exception;

    public void visit(LineComment n, C ctx) throws Exception;

    public void visit(NewExpression n, C ctx) throws Exception;

    public <E extends Node> void visit(NodeList<E> n, C ctx) throws Exception;

    public void visit(NullLiteral n, C ctx) throws Exception;

    public void visit(ObjectLiteral n, C ctx) throws Exception;

    public void visit(OctalLiteral n, C ctx) throws Exception;

    public void visit(Parameter n, C ctx) throws Exception;

    public void visit(Project n, C ctx) throws Exception;

    public void visit(PutAssignment n, C ctx) throws Exception;

    public void visit(RegexpLiteral n, C ctx) throws Exception;

    public void visit(ReturnStatement n, C ctx) throws Exception;

    public void visit(SequenceExpression n, C ctx) throws Exception;

    public void visit(SetAssignment n, C ctx) throws Exception;

    public void visit(StringLiteralDouble n, C ctx) throws Exception;

    public void visit(StringLiteralSingle n, C ctx) throws Exception;

    public void visit(SuperExpression n, C ctx) throws Exception;

    public void visit(SwitchStatement n, C ctx) throws Exception;

    public void visit(ThisExpression n, C ctx) throws Exception;

    public void visit(ThrowStatement n, C ctx) throws Exception;

    public void visit(TryStatement n, C ctx) throws Exception;

    public void visit(UnaryExpression n, C ctx) throws Exception;

    public void visit(UnaryOperator n, C ctx) throws Exception;

    public void visit(VariableDeclaration n, C ctx) throws Exception;

    public void visit(VariableExpression n, C ctx) throws Exception;

    public void visit(VariableStatement n, C ctx) throws Exception;

    public void visit(WhileStatement n, C ctx) throws Exception;

    public void visit(WithStatement n, C ctx) throws Exception;

}
