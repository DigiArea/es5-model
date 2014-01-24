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

import java.util.Arrays;
import java.util.List;

import com.digiarea.es5.AssignmentExpression.AssignOperator;
import com.digiarea.es5.BinaryExpression.BinaryOperator;
import com.digiarea.es5.UnaryExpression.UnaryOperator;

/**
 * The Class NodeFacade.
 */
public class NodeFacade extends NodeFactory {

	/**
	 * JS doc comment.
	 *
	 * @param content the content
	 * @return the JS doc comment
	 */
	public static JSDocComment JSDocComment(String content) {
		return JSDocComment(content);
	}

	/**
	 * Line comment.
	 *
	 * @param content the content
	 * @return the line comment
	 */
	public static LineComment LineComment(String content) {
		return LineComment(content);
	}

	/**
	 * Block comment.
	 *
	 * @param content the content
	 * @return the block comment
	 */
	public static BlockComment BlockComment(String content) {
		return BlockComment(content);
	}

	/**
	 * Decimal literal.
	 *
	 * @param value the value
	 * @return the decimal literal
	 */
	public static DecimalLiteral DecimalLiteral(String value) {
		return DecimalLiteral(value);
	}

	/**
	 * Octal literal.
	 *
	 * @param value the value
	 * @return the octal literal
	 */
	public static OctalLiteral OctalLiteral(String value) {
		return OctalLiteral(value);
	}

	/**
	 * Hex integer literal.
	 *
	 * @param value the value
	 * @return the hex integer literal
	 */
	public static HexIntegerLiteral HexIntegerLiteral(String value) {
		return HexIntegerLiteral(value);
	}

	/**
	 * Float literal.
	 *
	 * @param value the value
	 * @return the float literal
	 */
	public static FloatLiteral FloatLiteral(String value) {
		return FloatLiteral(value);
	}

	/**
	 * Boolean literal.
	 *
	 * @param value the value
	 * @return the boolean literal
	 */
	public static BooleanLiteral BooleanLiteral(boolean value) {
		return BooleanLiteral(value);
	}

	/**
	 * Regexp literal.
	 *
	 * @param value the value
	 * @return the regexp literal
	 */
	public static RegexpLiteral RegexpLiteral(String value) {
		return RegexpLiteral(value);
	}

	/**
	 * String literal single.
	 *
	 * @param value the value
	 * @return the string literal single
	 */
	public static StringLiteralSingle StringLiteralSingle(String value) {
		return StringLiteralSingle(value);
	}

	/**
	 * String literal double.
	 *
	 * @param value the value
	 * @return the string literal double
	 */
	public static StringLiteralDouble StringLiteralDouble(String value) {
		return StringLiteralDouble(value);
	}

	/**
	 * Identifier name.
	 *
	 * @param value the value
	 * @return the identifier name
	 */
	public static IdentifierName IdentifierName(String value) {
		return IdentifierName(value);
	}

	/**
	 * Enclosed expression.
	 *
	 * @param inner the inner
	 * @return the enclosed expression
	 */
	public static EnclosedExpression EnclosedExpression(Expression inner) {
		return EnclosedExpression(inner);
	}

	/**
	 * Function expression.
	 *
	 * @param name the name
	 * @param parameters the parameters
	 * @param body the body
	 * @return the function expression
	 */
	public static FunctionExpression FunctionExpression(String name,
			List<Parameter> parameters, Block body) {
		return FunctionExpression(name, NodeList(parameters), body);
	}

	/**
	 * Call expression.
	 *
	 * @param scope the scope
	 * @param args the args
	 * @return the call expression
	 */
	public static CallExpression CallExpression(Expression scope,
			List<Expression> args) {
		return CallExpression(scope, NodeList(args));
	}

	/**
	 * Array access expression.
	 *
	 * @param name the name
	 * @param index the index
	 * @return the array access expression
	 */
	public static ArrayAccessExpression ArrayAccessExpression(Expression name,
			Expression index) {
		return ArrayAccessExpression(name, index);
	}

	/**
	 * Field access expression.
	 *
	 * @param scope the scope
	 * @param field the field
	 * @return the field access expression
	 */
	public static FieldAccessExpression FieldAccessExpression(Expression scope,
			IdentifierName field) {
		return FieldAccessExpression(scope, field);
	}

	/**
	 * New expression.
	 *
	 * @param expression the expression
	 * @return the new expression
	 */
	public static NewExpression NewExpression(Expression expression) {
		return NewExpression(expression);
	}

	/**
	 * Array literal.
	 *
	 * @param expressions the expressions
	 * @return the array literal
	 */
	public static ArrayLiteral ArrayLiteral(List<Expression> expressions) {
		return ArrayLiteral(NodeList(expressions));
	}

	/**
	 * Object literal.
	 *
	 * @param propertyAssignments the property assignments
	 * @return the object literal
	 */
	public static ObjectLiteral ObjectLiteral(
			List<PropertyAssignment> propertyAssignments) {
		return ObjectLiteral(NodeList(propertyAssignments));
	}

	/**
	 * Gets the assignment.
	 *
	 * @param propertyName the property name
	 * @param block the block
	 * @return the gets the assignment
	 */
	public static GetAssignment GetAssignment(PropertyName propertyName,
			Block block) {
		return GetAssignment(block, propertyName, null, 0, 0);
	}

	/**
	 * Sets the assignment.
	 *
	 * @param propertyName the property name
	 * @param identifier the identifier
	 * @param block the block
	 * @return the sets the assignment
	 */
	public static SetAssignment SetAssignment(PropertyName propertyName,
			String identifier, Block block) {
		return SetAssignment(identifier, block, propertyName, null, 0, 0);
	}

	/**
	 * Put assignment.
	 *
	 * @param propertyName the property name
	 * @param propertyValue the property value
	 * @return the put assignment
	 */
	public static PutAssignment PutAssignment(PropertyName propertyName,
			Expression propertyValue) {
		return PutAssignment(propertyValue, propertyName, null, 0, 0);
	}

	/**
	 * Unary expression.
	 *
	 * @param expression the expression
	 * @param operator the operator
	 * @return the unary expression
	 */
	public static UnaryExpression UnaryExpression(Expression expression,
			UnaryOperator operator) {
		return UnaryExpression(expression, operator);
	}

	/**
	 * Binary expression.
	 *
	 * @param left the left
	 * @param right the right
	 * @param operator the operator
	 * @return the binary expression
	 */
	public static BinaryExpression BinaryExpression(Expression left,
			Expression right, BinaryOperator operator) {
		return BinaryExpression(left, right, operator);
	}

	/**
	 * Conditional expression.
	 *
	 * @param condition the condition
	 * @param thenExpr the then expr
	 * @param elseExpr the else expr
	 * @return the conditional expression
	 */
	public static ConditionalExpression ConditionalExpression(
			Expression condition, Expression thenExpr, Expression elseExpr) {
		return ConditionalExpression(condition, thenExpr, elseExpr);
	}

	/**
	 * Assignment expression.
	 *
	 * @param target the target
	 * @param value the value
	 * @param operator the operator
	 * @return the assignment expression
	 */
	public static AssignmentExpression AssignmentExpression(Expression target,
			Expression value, AssignOperator operator) {
		return AssignmentExpression(target, value, operator);
	}

	/**
	 * Sequence expression.
	 *
	 * @param expressions the expressions
	 * @return the sequence expression
	 */
	public static SequenceExpression SequenceExpression(
			List<Expression> expressions) {
		return SequenceExpression(NodeList(expressions));
	}

	/**
	 * Block.
	 *
	 * @param statements the statements
	 * @return the block
	 */
	public static Block Block(List<Statement> statements) {
		return Block(NodeList(statements), null, 0, 0);
	}

	/**
	 * Let definition.
	 *
	 * @param comment the comment
	 * @param declarations the declarations
	 * @return the let definition
	 */
	public static LetDefinition LetDefinition(JSDocComment comment,
			List<VariableDeclaration> declarations) {
		return LetDefinition(NodeList(declarations), comment, 0, 0);
	}

	/**
	 * Let statement.
	 *
	 * @param comment the comment
	 * @param declarations the declarations
	 * @param statement the statement
	 * @return the let statement
	 */
	public static LetStatement LetStatement(JSDocComment comment,
			List<VariableDeclaration> declarations, Statement statement) {
		return LetStatement(NodeList(declarations), statement, null, 0, 0);
	}

	/**
	 * Debugger statement.
	 *
	 * @param comment the comment
	 * @return the debugger statement
	 */
	public static DebuggerStatement DebuggerStatement(JSDocComment comment) {
		return DebuggerStatement(comment);
	}

	/**
	 * Constant statement.
	 *
	 * @param comment the comment
	 * @param declarations the declarations
	 * @return the constant statement
	 */
	public static ConstantStatement ConstantStatement(JSDocComment comment,
			List<VariableDeclaration> declarations) {
		return ConstantStatement(NodeList(declarations), comment, 0, 0);
	}

	/**
	 * Variable statement.
	 *
	 * @param comment the comment
	 * @param declarations the declarations
	 * @return the variable statement
	 */
	public static VariableStatement VariableStatement(JSDocComment comment,
			List<VariableDeclaration> declarations) {
		return VariableStatement(NodeList(declarations), comment, 0, 0);
	}

	/**
	 * Variable declaration.
	 *
	 * @param name the name
	 * @param expression the expression
	 * @return the variable declaration
	 */
	public static VariableDeclaration VariableDeclaration(String name,
			Expression expression) {
		return VariableDeclaration(name, expression);
	}

	/**
	 * Empty statement.
	 *
	 * @param comment the comment
	 * @return the empty statement
	 */
	public static EmptyStatement EmptyStatement(JSDocComment comment) {
		return EmptyStatement(comment);
	}

	/**
	 * If statement.
	 *
	 * @param comment the comment
	 * @param condition the condition
	 * @param thenStatement the then statement
	 * @param elseStatement the else statement
	 * @return the if statement
	 */
	public static IfStatement IfStatement(JSDocComment comment,
			Expression condition, Statement thenStatement,
			Statement elseStatement) {
		return IfStatement(condition, thenStatement, elseStatement, comment, 0,
				0);
	}

	/**
	 * Labelled statement.
	 *
	 * @param comment the comment
	 * @param label the label
	 * @param statement the statement
	 * @return the labelled statement
	 */
	public static LabelledStatement LabelledStatement(JSDocComment comment,
			String label, Statement statement) {
		return LabelledStatement(label, statement, comment, 0, 0);
	}

	/**
	 * Expression statement.
	 *
	 * @param comment the comment
	 * @param expression the expression
	 * @return the expression statement
	 */
	public static ExpressionStatement ExpressionStatement(JSDocComment comment,
			Expression expression) {
		return ExpressionStatement(expression, comment, 0, 0);
	}

	/**
	 * While statement.
	 *
	 * @param comment the comment
	 * @param condition the condition
	 * @param statement the statement
	 * @return the while statement
	 */
	public static WhileStatement WhileStatement(JSDocComment comment,
			Expression condition, Statement statement) {
		return WhileStatement(condition, statement, comment, 0, 0);
	}

	/**
	 * Do while statement.
	 *
	 * @param comment the comment
	 * @param condition the condition
	 * @param statement the statement
	 * @return the do while statement
	 */
	public static DoWhileStatement DoWhileStatement(JSDocComment comment,
			Expression condition, Statement statement) {
		return DoWhileStatement(condition, statement, comment, 0, 0);
	}

	/**
	 * For statement.
	 *
	 * @param comment the comment
	 * @param variable the variable
	 * @param condition the condition
	 * @param expr the expr
	 * @param body the body
	 * @return the for statement
	 */
	public static ForStatement ForStatement(JSDocComment comment,
			Expression variable, Expression condition, Expression expr,
			Statement body) {
		return ForStatement(variable, condition, expr, body, comment, 0, 0);
	}

	/**
	 * Variable expression.
	 *
	 * @param declarations the declarations
	 * @return the variable expression
	 */
	public static VariableExpression VariableExpression(
			List<VariableDeclaration> declarations) {
		return VariableExpression(NodeList(declarations));
	}

	/**
	 * Let expression.
	 *
	 * @param declarations the declarations
	 * @param expression the expression
	 * @return the let expression
	 */
	public static LetExpression LetExpression(
			List<VariableDeclaration> declarations, Expression expression) {
		return LetExpression(NodeList(declarations), expression);
	}

	/**
	 * Foreach statement.
	 *
	 * @param comment the comment
	 * @param variable the variable
	 * @param expression the expression
	 * @param body the body
	 * @return the foreach statement
	 */
	public static ForeachStatement ForeachStatement(JSDocComment comment,
			Expression variable, Expression expression, Statement body) {
		return ForeachStatement(variable, expression, body, comment, 0, 0);
	}

	/**
	 * Break statement.
	 *
	 * @param comment the comment
	 * @param identifier the identifier
	 * @return the break statement
	 */
	public static BreakStatement BreakStatement(JSDocComment comment,
			String identifier) {
		return BreakStatement(identifier, comment, 0, 0);
	}

	/**
	 * Continue statement.
	 *
	 * @param comment the comment
	 * @param identifier the identifier
	 * @return the continue statement
	 */
	public static ContinueStatement ContinueStatement(JSDocComment comment,
			String identifier) {
		return ContinueStatement(identifier, comment, 0, 0);
	}

	/**
	 * With statement.
	 *
	 * @param comment the comment
	 * @param expression the expression
	 * @param statement the statement
	 * @return the with statement
	 */
	public static WithStatement WithStatement(JSDocComment comment,
			Expression expression, Statement statement) {
		return WithStatement(expression, statement, comment, 0, 0);
	}

	/**
	 * Try statement.
	 *
	 * @param comment the comment
	 * @param tryBlock the try block
	 * @param catchClause the catch clause
	 * @param finallyBlock the finally block
	 * @return the try statement
	 */
	public static TryStatement TryStatement(JSDocComment comment,
			Block tryBlock, CatchClause catchClause, Block finallyBlock) {
		return TryStatement(tryBlock, catchClause, finallyBlock, comment, 0, 0);
	}

	/**
	 * Throw statement.
	 *
	 * @param comment the comment
	 * @param expression the expression
	 * @return the throw statement
	 */
	public static ThrowStatement ThrowStatement(JSDocComment comment,
			Expression expression) {
		return ThrowStatement(expression, comment, 0, 0);
	}

	/**
	 * Case block.
	 *
	 * @param comment the comment
	 * @param defaultClause the default clause
	 * @param caseClauses the case clauses
	 * @return the case block
	 */
	public static CaseBlock CaseBlock(JSDocComment comment,
			DefaultClause defaultClause, List<CaseClause> caseClauses) {
		return CaseBlock(defaultClause, NodeList(caseClauses), comment, 0, 0);
	}

	/**
	 * Switch statement.
	 *
	 * @param comment the comment
	 * @param expression the expression
	 * @param block the block
	 * @return the switch statement
	 */
	public static SwitchStatement SwitchStatement(JSDocComment comment,
			Expression expression, CaseBlock block) {
		return SwitchStatement(expression, block, comment, 0, 0);
	}

	/**
	 * Catch clause.
	 *
	 * @param identifier the identifier
	 * @param block the block
	 * @return the catch clause
	 */
	public static CatchClause CatchClause(String identifier, Block block) {
		return CatchClause(identifier, block);
	}

	/**
	 * Return statement.
	 *
	 * @param comment the comment
	 * @param expression the expression
	 * @return the return statement
	 */
	public static ReturnStatement ReturnStatement(JSDocComment comment,
			Expression expression) {
		return ReturnStatement(expression, comment, 0, 0);
	}

	/**
	 * Case clause.
	 *
	 * @param expression the expression
	 * @param statements the statements
	 * @return the case clause
	 */
	public static CaseClause CaseClause(Expression expression,
			List<Statement> statements) {
		return CaseClause(expression, NodeList(statements));
	}

	/**
	 * Function declaration.
	 *
	 * @param comment the comment
	 * @param name the name
	 * @param parameters the parameters
	 * @param body the body
	 * @return the function declaration
	 */
	public static FunctionDeclaration FunctionDeclaration(JSDocComment comment,
			String name, List<Parameter> parameters, Block body) {
		return FunctionDeclaration(name, NodeList(parameters), body, comment,
				0, 0);
	}

	/**
	 * Parameter.
	 *
	 * @param name the name
	 * @return the parameter
	 */
	public static Parameter Parameter(String name) {
		return Parameter(name);
	}

	/**
	 * Default clause.
	 *
	 * @param statements the statements
	 * @return the default clause
	 */
	public static DefaultClause DefaultClause(List<Statement> statements) {
		return DefaultClause(NodeList(statements));
	}

	/**
	 * Compilation unit.
	 *
	 * @param comments the comments
	 * @param elements the elements
	 * @param name the name
	 * @return the compilation unit
	 */
	public static CompilationUnit CompilationUnit(List<Comment> comments,
			List<Statement> elements, String name) {
		return CompilationUnit(NodeList(elements), NodeList(comments), name, 0,
				0);
	}

	/**
	 * This method return null when nodes equals null.
	 *
	 * @param <E> the element type
	 * @param nodes the nodes
	 * @return the node list
	 */
	public static <E extends Node> NodeList<E> NodeList(List<E> nodes) {
		if (nodes != null) {
			return NodeList(nodes);
		}
		return null;
	}

	/**
	 * This method return null when node equals null.
	 *
	 * @param <E> the element type
	 * @param node the node
	 * @return the node list
	 */
	public static <E extends Node> NodeList<E> NodeList(E node) {
		if (node != null) {
			return NodeList(Arrays.asList(node));
		}
		return null;
	}

	/**
	 * This method return null when node equals null.
	 *
	 * @param <E> the element type
	 * @param node the node
	 * @return the node list
	 */
	public static <E extends Node> NodeList<E> NodeList(E[] node) {
		if (node != null) {
			return NodeList(Arrays.asList(node));
		}
		return null;
	}

	/**
	 * New expression.
	 *
	 * @param expression the expression
	 * @param initializer the initializer
	 * @return the new expression
	 */
	public static NewExpression NewExpression(Expression expression,
			ObjectLiteral initializer) {
		return NewExpression(expression, initializer);
	}

	/**
	 * Expression statement.
	 *
	 * @param expression the expression
	 * @return the expression statement
	 */
	public static ExpressionStatement ExpressionStatement(Expression expression) {
		return ExpressionStatement(null, expression);
	}

	/**
	 * Allocation expression.
	 *
	 * @param expression the expression
	 * @return the allocation expression
	 */
	public static AllocationExpression AllocationExpression(
			Expression expression) {
		return AllocationExpression(expression, 0, 0);
	}

}
