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
package com.digiarea.es5;

import com.digiarea.es5.AllocationExpression;
import com.digiarea.es5.Expression;
import com.digiarea.es5.ArrayAccessExpression;
import com.digiarea.es5.ArrayLiteral;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.AssignmentExpression;
import com.digiarea.es5.BinaryExpression;
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
import com.digiarea.es5.Node;
import java.util.List;
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
import com.digiarea.es5.VariableExpression;
import com.digiarea.es5.VariableStatement;
import com.digiarea.es5.WhileStatement;
import com.digiarea.es5.WithStatement;

/**
 * A factory for creating Node objects.
 */
class NodeFactory {

    /**
     * Allocation expression.
     *
     * @return the allocation expression
     */
    public static AllocationExpression AllocationExpression() {
        return new AllocationExpression();
    }

    /**
     * Allocation expression.
     *
     * @param body the body
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the allocation expression
     */
    public static AllocationExpression AllocationExpression(Expression body, int posBegin, int posEnd) {
        return new AllocationExpression(body, posBegin, posEnd);
    }

    /**
     * Array access expression.
     *
     * @return the array access expression
     */
    public static ArrayAccessExpression ArrayAccessExpression() {
        return new ArrayAccessExpression();
    }

    /**
     * Array access expression.
     *
     * @param name the name
     * @param index the index
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the array access expression
     */
    public static ArrayAccessExpression ArrayAccessExpression(Expression name, Expression index, int posBegin, int posEnd) {
        return new ArrayAccessExpression(name, index, posBegin, posEnd);
    }

    /**
     * Array literal.
     *
     * @return the array literal
     */
    public static ArrayLiteral ArrayLiteral() {
        return new ArrayLiteral();
    }

    /**
     * Array literal.
     *
     * @param expressions the expressions
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the array literal
     */
    public static ArrayLiteral ArrayLiteral(NodeList<Expression> expressions, int posBegin, int posEnd) {
        return new ArrayLiteral(expressions, posBegin, posEnd);
    }

    /**
     * Assignment expression.
     *
     * @return the assignment expression
     */
    public static AssignmentExpression AssignmentExpression() {
        return new AssignmentExpression();
    }

    /**
     * Assignment expression.
     *
     * @param target the target
     * @param value the value
     * @param assignOperator the assign operator
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the assignment expression
     */
    public static AssignmentExpression AssignmentExpression(Expression target, Expression value, AssignmentExpression.AssignOperator assignOperator, int posBegin, int posEnd) {
        return new AssignmentExpression(target, value, assignOperator, posBegin, posEnd);
    }

    /**
     * Binary expression.
     *
     * @return the binary expression
     */
    public static BinaryExpression BinaryExpression() {
        return new BinaryExpression();
    }

    /**
     * Binary expression.
     *
     * @param left the left
     * @param right the right
     * @param binaryOperator the binary operator
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the binary expression
     */
    public static BinaryExpression BinaryExpression(Expression left, Expression right, BinaryExpression.BinaryOperator binaryOperator, int posBegin, int posEnd) {
        return new BinaryExpression(left, right, binaryOperator, posBegin, posEnd);
    }

    /**
     * Block.
     *
     * @return the block
     */
    public static Block Block() {
        return new Block();
    }

    /**
     * Block.
     *
     * @param statements the statements
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the block
     */
    public static Block Block(NodeList<Statement> statements, Comment comment, int posBegin, int posEnd) {
        return new Block(statements, comment, posBegin, posEnd);
    }

    /**
     * Block comment.
     *
     * @return the block comment
     */
    public static BlockComment BlockComment() {
        return new BlockComment();
    }

    /**
     * Block comment.
     *
     * @param content the content
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the block comment
     */
    public static BlockComment BlockComment(String content, int posBegin, int posEnd) {
        return new BlockComment(content, posBegin, posEnd);
    }

    /**
     * Boolean literal.
     *
     * @return the boolean literal
     */
    public static BooleanLiteral BooleanLiteral() {
        return new BooleanLiteral();
    }

    /**
     * Boolean literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the boolean literal
     */
    public static BooleanLiteral BooleanLiteral(boolean value, int posBegin, int posEnd) {
        return new BooleanLiteral(value, posBegin, posEnd);
    }

    /**
     * Break statement.
     *
     * @return the break statement
     */
    public static BreakStatement BreakStatement() {
        return new BreakStatement();
    }

    /**
     * Break statement.
     *
     * @param identifier the identifier
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the break statement
     */
    public static BreakStatement BreakStatement(String identifier, Comment comment, int posBegin, int posEnd) {
        return new BreakStatement(identifier, comment, posBegin, posEnd);
    }

    /**
     * Call expression.
     *
     * @return the call expression
     */
    public static CallExpression CallExpression() {
        return new CallExpression();
    }

    /**
     * Call expression.
     *
     * @param scope the scope
     * @param args the args
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the call expression
     */
    public static CallExpression CallExpression(Expression scope, NodeList<Expression> args, int posBegin, int posEnd) {
        return new CallExpression(scope, args, posBegin, posEnd);
    }

    /**
     * Case block.
     *
     * @return the case block
     */
    public static CaseBlock CaseBlock() {
        return new CaseBlock();
    }

    /**
     * Case block.
     *
     * @param defaultClause the default clause
     * @param caseClauses the case clauses
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the case block
     */
    public static CaseBlock CaseBlock(DefaultClause defaultClause, NodeList<CaseClause> caseClauses, Comment comment, int posBegin, int posEnd) {
        return new CaseBlock(defaultClause, caseClauses, comment, posBegin, posEnd);
    }

    /**
     * Case clause.
     *
     * @return the case clause
     */
    public static CaseClause CaseClause() {
        return new CaseClause();
    }

    /**
     * Case clause.
     *
     * @param expression the expression
     * @param statements the statements
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the case clause
     */
    public static CaseClause CaseClause(Expression expression, NodeList<Statement> statements, int posBegin, int posEnd) {
        return new CaseClause(expression, statements, posBegin, posEnd);
    }

    /**
     * Catch clause.
     *
     * @return the catch clause
     */
    public static CatchClause CatchClause() {
        return new CatchClause();
    }

    /**
     * Catch clause.
     *
     * @param string the string
     * @param block the block
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the catch clause
     */
    public static CatchClause CatchClause(String string, Block block, int posBegin, int posEnd) {
        return new CatchClause(string, block, posBegin, posEnd);
    }

    /**
     * Compilation unit.
     *
     * @return the compilation unit
     */
    public static CompilationUnit CompilationUnit() {
        return new CompilationUnit();
    }

    /**
     * Compilation unit.
     *
     * @param elements the elements
     * @param comments the comments
     * @param name the name
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the compilation unit
     */
    public static CompilationUnit CompilationUnit(NodeList<Statement> elements, NodeList<Comment> comments, String name, int posBegin, int posEnd) {
        return new CompilationUnit(elements, comments, name, posBegin, posEnd);
    }

    /**
     * Conditional expression.
     *
     * @return the conditional expression
     */
    public static ConditionalExpression ConditionalExpression() {
        return new ConditionalExpression();
    }

    /**
     * Conditional expression.
     *
     * @param condition the condition
     * @param thenExpr the then expr
     * @param elseExpr the else expr
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the conditional expression
     */
    public static ConditionalExpression ConditionalExpression(Expression condition, Expression thenExpr, Expression elseExpr, int posBegin, int posEnd) {
        return new ConditionalExpression(condition, thenExpr, elseExpr, posBegin, posEnd);
    }

    /**
     * Constant statement.
     *
     * @return the constant statement
     */
    public static ConstantStatement ConstantStatement() {
        return new ConstantStatement();
    }

    /**
     * Constant statement.
     *
     * @param variableDeclarations the variable declarations
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the constant statement
     */
    public static ConstantStatement ConstantStatement(NodeList<VariableDeclaration> variableDeclarations, Comment comment, int posBegin, int posEnd) {
        return new ConstantStatement(variableDeclarations, comment, posBegin, posEnd);
    }

    /**
     * Continue statement.
     *
     * @return the continue statement
     */
    public static ContinueStatement ContinueStatement() {
        return new ContinueStatement();
    }

    /**
     * Continue statement.
     *
     * @param identifier the identifier
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the continue statement
     */
    public static ContinueStatement ContinueStatement(String identifier, Comment comment, int posBegin, int posEnd) {
        return new ContinueStatement(identifier, comment, posBegin, posEnd);
    }

    /**
     * Debugger statement.
     *
     * @return the debugger statement
     */
    public static DebuggerStatement DebuggerStatement() {
        return new DebuggerStatement();
    }

    /**
     * Debugger statement.
     *
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the debugger statement
     */
    public static DebuggerStatement DebuggerStatement(Comment comment, int posBegin, int posEnd) {
        return new DebuggerStatement(comment, posBegin, posEnd);
    }

    /**
     * Decimal literal.
     *
     * @return the decimal literal
     */
    public static DecimalLiteral DecimalLiteral() {
        return new DecimalLiteral();
    }

    /**
     * Decimal literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the decimal literal
     */
    public static DecimalLiteral DecimalLiteral(String value, int posBegin, int posEnd) {
        return new DecimalLiteral(value, posBegin, posEnd);
    }

    /**
     * Default clause.
     *
     * @return the default clause
     */
    public static DefaultClause DefaultClause() {
        return new DefaultClause();
    }

    /**
     * Default clause.
     *
     * @param statements the statements
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the default clause
     */
    public static DefaultClause DefaultClause(NodeList<Statement> statements, int posBegin, int posEnd) {
        return new DefaultClause(statements, posBegin, posEnd);
    }

    /**
     * Do while statement.
     *
     * @return the do while statement
     */
    public static DoWhileStatement DoWhileStatement() {
        return new DoWhileStatement();
    }

    /**
     * Do while statement.
     *
     * @param condition the condition
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the do while statement
     */
    public static DoWhileStatement DoWhileStatement(Expression condition, Statement body, Comment comment, int posBegin, int posEnd) {
        return new DoWhileStatement(condition, body, comment, posBegin, posEnd);
    }

    /**
     * Empty literal.
     *
     * @return the empty literal
     */
    public static EmptyLiteral EmptyLiteral() {
        return new EmptyLiteral();
    }

    /**
     * Empty literal.
     *
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the empty literal
     */
    public static EmptyLiteral EmptyLiteral(int posBegin, int posEnd) {
        return new EmptyLiteral(posBegin, posEnd);
    }

    /**
     * Empty statement.
     *
     * @return the empty statement
     */
    public static EmptyStatement EmptyStatement() {
        return new EmptyStatement();
    }

    /**
     * Empty statement.
     *
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the empty statement
     */
    public static EmptyStatement EmptyStatement(Comment comment, int posBegin, int posEnd) {
        return new EmptyStatement(comment, posBegin, posEnd);
    }

    /**
     * Enclosed expression.
     *
     * @return the enclosed expression
     */
    public static EnclosedExpression EnclosedExpression() {
        return new EnclosedExpression();
    }

    /**
     * Enclosed expression.
     *
     * @param inner the inner
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the enclosed expression
     */
    public static EnclosedExpression EnclosedExpression(Expression inner, int posBegin, int posEnd) {
        return new EnclosedExpression(inner, posBegin, posEnd);
    }

    /**
     * Expression statement.
     *
     * @return the expression statement
     */
    public static ExpressionStatement ExpressionStatement() {
        return new ExpressionStatement();
    }

    /**
     * Expression statement.
     *
     * @param expression the expression
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the expression statement
     */
    public static ExpressionStatement ExpressionStatement(Expression expression, Comment comment, int posBegin, int posEnd) {
        return new ExpressionStatement(expression, comment, posBegin, posEnd);
    }

    /**
     * Field access expression.
     *
     * @return the field access expression
     */
    public static FieldAccessExpression FieldAccessExpression() {
        return new FieldAccessExpression();
    }

    /**
     * Field access expression.
     *
     * @param scope the scope
     * @param field the field
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the field access expression
     */
    public static FieldAccessExpression FieldAccessExpression(Expression scope, IdentifierName field, int posBegin, int posEnd) {
        return new FieldAccessExpression(scope, field, posBegin, posEnd);
    }

    /**
     * Float literal.
     *
     * @return the float literal
     */
    public static FloatLiteral FloatLiteral() {
        return new FloatLiteral();
    }

    /**
     * Float literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the float literal
     */
    public static FloatLiteral FloatLiteral(String value, int posBegin, int posEnd) {
        return new FloatLiteral(value, posBegin, posEnd);
    }

    /**
     * Foreach statement.
     *
     * @return the foreach statement
     */
    public static ForeachStatement ForeachStatement() {
        return new ForeachStatement();
    }

    /**
     * Foreach statement.
     *
     * @param variable the variable
     * @param expression the expression
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the foreach statement
     */
    public static ForeachStatement ForeachStatement(Expression variable, Expression expression, Statement body, Comment comment, int posBegin, int posEnd) {
        return new ForeachStatement(variable, expression, body, comment, posBegin, posEnd);
    }

    /**
     * For statement.
     *
     * @return the for statement
     */
    public static ForStatement ForStatement() {
        return new ForStatement();
    }

    /**
     * For statement.
     *
     * @param variable the variable
     * @param condition the condition
     * @param expr the expr
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the for statement
     */
    public static ForStatement ForStatement(Expression variable, Expression condition, Expression expr, Statement body, Comment comment, int posBegin, int posEnd) {
        return new ForStatement(variable, condition, expr, body, comment, posBegin, posEnd);
    }

    /**
     * Function declaration.
     *
     * @return the function declaration
     */
    public static FunctionDeclaration FunctionDeclaration() {
        return new FunctionDeclaration();
    }

    /**
     * Function declaration.
     *
     * @param name the name
     * @param parameters the parameters
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the function declaration
     */
    public static FunctionDeclaration FunctionDeclaration(String name, NodeList<Parameter> parameters, Block body, Comment comment, int posBegin, int posEnd) {
        return new FunctionDeclaration(name, parameters, body, comment, posBegin, posEnd);
    }

    /**
     * Function expression.
     *
     * @return the function expression
     */
    public static FunctionExpression FunctionExpression() {
        return new FunctionExpression();
    }

    /**
     * Function expression.
     *
     * @param name the name
     * @param parameters the parameters
     * @param body the body
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the function expression
     */
    public static FunctionExpression FunctionExpression(String name, NodeList<Parameter> parameters, Block body, int posBegin, int posEnd) {
        return new FunctionExpression(name, parameters, body, posBegin, posEnd);
    }

    /**
     * Gets the assignment.
     *
     * @return the gets the assignment
     */
    public static GetAssignment GetAssignment() {
        return new GetAssignment();
    }

    /**
     * Gets the assignment.
     *
     * @param block the block
     * @param propertyName the property name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the gets the assignment
     */
    public static GetAssignment GetAssignment(Block block, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        return new GetAssignment(block, propertyName, comment, posBegin, posEnd);
    }

    /**
     * Hex integer literal.
     *
     * @return the hex integer literal
     */
    public static HexIntegerLiteral HexIntegerLiteral() {
        return new HexIntegerLiteral();
    }

    /**
     * Hex integer literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the hex integer literal
     */
    public static HexIntegerLiteral HexIntegerLiteral(String value, int posBegin, int posEnd) {
        return new HexIntegerLiteral(value, posBegin, posEnd);
    }

    /**
     * Identifier name.
     *
     * @return the identifier name
     */
    public static IdentifierName IdentifierName() {
        return new IdentifierName();
    }

    /**
     * Identifier name.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the identifier name
     */
    public static IdentifierName IdentifierName(String value, int posBegin, int posEnd) {
        return new IdentifierName(value, posBegin, posEnd);
    }

    /**
     * If statement.
     *
     * @return the if statement
     */
    public static IfStatement IfStatement() {
        return new IfStatement();
    }

    /**
     * If statement.
     *
     * @param condition the condition
     * @param thenStatement the then statement
     * @param elseStatement the else statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the if statement
     */
    public static IfStatement IfStatement(Expression condition, Statement thenStatement, Statement elseStatement, Comment comment, int posBegin, int posEnd) {
        return new IfStatement(condition, thenStatement, elseStatement, comment, posBegin, posEnd);
    }

    /**
     * Import statement.
     *
     * @return the import statement
     */
    public static ImportStatement ImportStatement() {
        return new ImportStatement();
    }

    /**
     * Import statement.
     *
     * @param name the name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the import statement
     */
    public static ImportStatement ImportStatement(IdentifierName name, Comment comment, int posBegin, int posEnd) {
        return new ImportStatement(name, comment, posBegin, posEnd);
    }

    /**
     * JS doc comment.
     *
     * @return the JS doc comment
     */
    public static JSDocComment JSDocComment() {
        return new JSDocComment();
    }

    /**
     * JS doc comment.
     *
     * @param content the content
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the JS doc comment
     */
    public static JSDocComment JSDocComment(String content, int posBegin, int posEnd) {
        return new JSDocComment(content, posBegin, posEnd);
    }

    /**
     * Labelled statement.
     *
     * @return the labelled statement
     */
    public static LabelledStatement LabelledStatement() {
        return new LabelledStatement();
    }

    /**
     * Labelled statement.
     *
     * @param label the label
     * @param statement the statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the labelled statement
     */
    public static LabelledStatement LabelledStatement(String label, Statement statement, Comment comment, int posBegin, int posEnd) {
        return new LabelledStatement(label, statement, comment, posBegin, posEnd);
    }

    /**
     * Let definition.
     *
     * @return the let definition
     */
    public static LetDefinition LetDefinition() {
        return new LetDefinition();
    }

    /**
     * Let definition.
     *
     * @param variableDeclarations the variable declarations
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the let definition
     */
    public static LetDefinition LetDefinition(NodeList<VariableDeclaration> variableDeclarations, Comment comment, int posBegin, int posEnd) {
        return new LetDefinition(variableDeclarations, comment, posBegin, posEnd);
    }

    /**
     * Let expression.
     *
     * @return the let expression
     */
    public static LetExpression LetExpression() {
        return new LetExpression();
    }

    /**
     * Let expression.
     *
     * @param variableDeclarations the variable declarations
     * @param expression the expression
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the let expression
     */
    public static LetExpression LetExpression(NodeList<VariableDeclaration> variableDeclarations, Expression expression, int posBegin, int posEnd) {
        return new LetExpression(variableDeclarations, expression, posBegin, posEnd);
    }

    /**
     * Let statement.
     *
     * @return the let statement
     */
    public static LetStatement LetStatement() {
        return new LetStatement();
    }

    /**
     * Let statement.
     *
     * @param variableDeclarations the variable declarations
     * @param statement the statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the let statement
     */
    public static LetStatement LetStatement(NodeList<VariableDeclaration> variableDeclarations, Statement statement, Comment comment, int posBegin, int posEnd) {
        return new LetStatement(variableDeclarations, statement, comment, posBegin, posEnd);
    }

    /**
     * Line comment.
     *
     * @return the line comment
     */
    public static LineComment LineComment() {
        return new LineComment();
    }

    /**
     * Line comment.
     *
     * @param content the content
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the line comment
     */
    public static LineComment LineComment(String content, int posBegin, int posEnd) {
        return new LineComment(content, posBegin, posEnd);
    }

    /**
     * New expression.
     *
     * @return the new expression
     */
    public static NewExpression NewExpression() {
        return new NewExpression();
    }

    /**
     * New expression.
     *
     * @param expression the expression
     * @param initializer the initializer
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the new expression
     */
    public static NewExpression NewExpression(Expression expression, ObjectLiteral initializer, int posBegin, int posEnd) {
        return new NewExpression(expression, initializer, posBegin, posEnd);
    }

    /**
     * Node list.
     *
     * @param <E> the element type
     * @return the node list
     */
    public static <E extends Node> NodeList<E> NodeList() {
        return new NodeList<E>();
    }

    /**
     * Node list.
     *
     * @param <E> the element type
     * @param nodes the nodes
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the node list
     */
    public static <E extends Node> NodeList<E> NodeList(List<E> nodes, int posBegin, int posEnd) {
        return new NodeList<E>(nodes, posBegin, posEnd);
    }

    /**
     * Null literal.
     *
     * @return the null literal
     */
    public static NullLiteral NullLiteral() {
        return new NullLiteral();
    }

    /**
     * Null literal.
     *
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the null literal
     */
    public static NullLiteral NullLiteral(int posBegin, int posEnd) {
        return new NullLiteral(posBegin, posEnd);
    }

    /**
     * Object literal.
     *
     * @return the object literal
     */
    public static ObjectLiteral ObjectLiteral() {
        return new ObjectLiteral();
    }

    /**
     * Object literal.
     *
     * @param propertyAssignments the property assignments
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the object literal
     */
    public static ObjectLiteral ObjectLiteral(NodeList<PropertyAssignment> propertyAssignments, int posBegin, int posEnd) {
        return new ObjectLiteral(propertyAssignments, posBegin, posEnd);
    }

    /**
     * Octal literal.
     *
     * @return the octal literal
     */
    public static OctalLiteral OctalLiteral() {
        return new OctalLiteral();
    }

    /**
     * Octal literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the octal literal
     */
    public static OctalLiteral OctalLiteral(String value, int posBegin, int posEnd) {
        return new OctalLiteral(value, posBegin, posEnd);
    }

    /**
     * Parameter.
     *
     * @return the parameter
     */
    public static Parameter Parameter() {
        return new Parameter();
    }

    /**
     * Parameter.
     *
     * @param name the name
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the parameter
     */
    public static Parameter Parameter(String name, int posBegin, int posEnd) {
        return new Parameter(name, posBegin, posEnd);
    }

    /**
     * Project.
     *
     * @return the project
     */
    public static Project Project() {
        return new Project();
    }

    /**
     * Project.
     *
     * @param compilationUnits the compilation units
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the project
     */
    public static Project Project(NodeList<CompilationUnit> compilationUnits, int posBegin, int posEnd) {
        return new Project(compilationUnits, posBegin, posEnd);
    }

    /**
     * Put assignment.
     *
     * @return the put assignment
     */
    public static PutAssignment PutAssignment() {
        return new PutAssignment();
    }

    /**
     * Put assignment.
     *
     * @param propertyValue the property value
     * @param propertyName the property name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the put assignment
     */
    public static PutAssignment PutAssignment(Expression propertyValue, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        return new PutAssignment(propertyValue, propertyName, comment, posBegin, posEnd);
    }

    /**
     * Regexp literal.
     *
     * @return the regexp literal
     */
    public static RegexpLiteral RegexpLiteral() {
        return new RegexpLiteral();
    }

    /**
     * Regexp literal.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the regexp literal
     */
    public static RegexpLiteral RegexpLiteral(String value, int posBegin, int posEnd) {
        return new RegexpLiteral(value, posBegin, posEnd);
    }

    /**
     * Return statement.
     *
     * @return the return statement
     */
    public static ReturnStatement ReturnStatement() {
        return new ReturnStatement();
    }

    /**
     * Return statement.
     *
     * @param expression the expression
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the return statement
     */
    public static ReturnStatement ReturnStatement(Expression expression, Comment comment, int posBegin, int posEnd) {
        return new ReturnStatement(expression, comment, posBegin, posEnd);
    }

    /**
     * Sequence expression.
     *
     * @return the sequence expression
     */
    public static SequenceExpression SequenceExpression() {
        return new SequenceExpression();
    }

    /**
     * Sequence expression.
     *
     * @param expressions the expressions
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the sequence expression
     */
    public static SequenceExpression SequenceExpression(NodeList<Expression> expressions, int posBegin, int posEnd) {
        return new SequenceExpression(expressions, posBegin, posEnd);
    }

    /**
     * Sets the assignment.
     *
     * @return the sets the assignment
     */
    public static SetAssignment SetAssignment() {
        return new SetAssignment();
    }

    /**
     * Sets the assignment.
     *
     * @param identifier the identifier
     * @param block the block
     * @param propertyName the property name
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the sets the assignment
     */
    public static SetAssignment SetAssignment(String identifier, Block block, PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        return new SetAssignment(identifier, block, propertyName, comment, posBegin, posEnd);
    }

    /**
     * String literal double.
     *
     * @return the string literal double
     */
    public static StringLiteralDouble StringLiteralDouble() {
        return new StringLiteralDouble();
    }

    /**
     * String literal double.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the string literal double
     */
    public static StringLiteralDouble StringLiteralDouble(String value, int posBegin, int posEnd) {
        return new StringLiteralDouble(value, posBegin, posEnd);
    }

    /**
     * String literal single.
     *
     * @return the string literal single
     */
    public static StringLiteralSingle StringLiteralSingle() {
        return new StringLiteralSingle();
    }

    /**
     * String literal single.
     *
     * @param value the value
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the string literal single
     */
    public static StringLiteralSingle StringLiteralSingle(String value, int posBegin, int posEnd) {
        return new StringLiteralSingle(value, posBegin, posEnd);
    }

    /**
     * Super expression.
     *
     * @return the super expression
     */
    public static SuperExpression SuperExpression() {
        return new SuperExpression();
    }

    /**
     * Super expression.
     *
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the super expression
     */
    public static SuperExpression SuperExpression(int posBegin, int posEnd) {
        return new SuperExpression(posBegin, posEnd);
    }

    /**
     * Switch statement.
     *
     * @return the switch statement
     */
    public static SwitchStatement SwitchStatement() {
        return new SwitchStatement();
    }

    /**
     * Switch statement.
     *
     * @param expression the expression
     * @param block the block
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the switch statement
     */
    public static SwitchStatement SwitchStatement(Expression expression, CaseBlock block, Comment comment, int posBegin, int posEnd) {
        return new SwitchStatement(expression, block, comment, posBegin, posEnd);
    }

    /**
     * This expression.
     *
     * @return the this expression
     */
    public static ThisExpression ThisExpression() {
        return new ThisExpression();
    }

    /**
     * This expression.
     *
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the this expression
     */
    public static ThisExpression ThisExpression(int posBegin, int posEnd) {
        return new ThisExpression(posBegin, posEnd);
    }

    /**
     * Throw statement.
     *
     * @return the throw statement
     */
    public static ThrowStatement ThrowStatement() {
        return new ThrowStatement();
    }

    /**
     * Throw statement.
     *
     * @param expression the expression
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the throw statement
     */
    public static ThrowStatement ThrowStatement(Expression expression, Comment comment, int posBegin, int posEnd) {
        return new ThrowStatement(expression, comment, posBegin, posEnd);
    }

    /**
     * Try statement.
     *
     * @return the try statement
     */
    public static TryStatement TryStatement() {
        return new TryStatement();
    }

    /**
     * Try statement.
     *
     * @param tryBlock the try block
     * @param catchClause the catch clause
     * @param finallyBlock the finally block
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the try statement
     */
    public static TryStatement TryStatement(Block tryBlock, CatchClause catchClause, Block finallyBlock, Comment comment, int posBegin, int posEnd) {
        return new TryStatement(tryBlock, catchClause, finallyBlock, comment, posBegin, posEnd);
    }

    /**
     * Unary expression.
     *
     * @return the unary expression
     */
    public static UnaryExpression UnaryExpression() {
        return new UnaryExpression();
    }

    /**
     * Unary expression.
     *
     * @param expression the expression
     * @param unaryOperator the unary operator
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the unary expression
     */
    public static UnaryExpression UnaryExpression(Expression expression, UnaryExpression.UnaryOperator unaryOperator, int posBegin, int posEnd) {
        return new UnaryExpression(expression, unaryOperator, posBegin, posEnd);
    }

    /**
     * Variable declaration.
     *
     * @return the variable declaration
     */
    public static VariableDeclaration VariableDeclaration() {
        return new VariableDeclaration();
    }

    /**
     * Variable declaration.
     *
     * @param name the name
     * @param expression the expression
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the variable declaration
     */
    public static VariableDeclaration VariableDeclaration(String name, Expression expression, int posBegin, int posEnd) {
        return new VariableDeclaration(name, expression, posBegin, posEnd);
    }

    /**
     * Variable expression.
     *
     * @return the variable expression
     */
    public static VariableExpression VariableExpression() {
        return new VariableExpression();
    }

    /**
     * Variable expression.
     *
     * @param variableDeclarations the variable declarations
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the variable expression
     */
    public static VariableExpression VariableExpression(NodeList<VariableDeclaration> variableDeclarations, int posBegin, int posEnd) {
        return new VariableExpression(variableDeclarations, posBegin, posEnd);
    }

    /**
     * Variable statement.
     *
     * @return the variable statement
     */
    public static VariableStatement VariableStatement() {
        return new VariableStatement();
    }

    /**
     * Variable statement.
     *
     * @param variableDeclarations the variable declarations
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the variable statement
     */
    public static VariableStatement VariableStatement(NodeList<VariableDeclaration> variableDeclarations, Comment comment, int posBegin, int posEnd) {
        return new VariableStatement(variableDeclarations, comment, posBegin, posEnd);
    }

    /**
     * While statement.
     *
     * @return the while statement
     */
    public static WhileStatement WhileStatement() {
        return new WhileStatement();
    }

    /**
     * While statement.
     *
     * @param condition the condition
     * @param body the body
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the while statement
     */
    public static WhileStatement WhileStatement(Expression condition, Statement body, Comment comment, int posBegin, int posEnd) {
        return new WhileStatement(condition, body, comment, posBegin, posEnd);
    }

    /**
     * With statement.
     *
     * @return the with statement
     */
    public static WithStatement WithStatement() {
        return new WithStatement();
    }

    /**
     * With statement.
     *
     * @param expression the expression
     * @param statement the statement
     * @param comment the comment
     * @param posBegin the pos begin
     * @param posEnd the pos end
     * @return the with statement
     */
    public static WithStatement WithStatement(Expression expression, Statement statement, Comment comment, int posBegin, int posEnd) {
        return new WithStatement(expression, statement, comment, posBegin, posEnd);
    }

}
