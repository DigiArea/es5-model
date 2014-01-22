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

public class NodeFacade extends NodeFactory {

	public static JSDocComment JSDocComment(String content) {
		return JSDocComment(content);
	}

	public static LineComment LineComment(String content) {
		return LineComment(content);
	}

	public static BlockComment BlockComment(String content) {
		return BlockComment(content);
	}

	public static DecimalLiteral DecimalLiteral(String value) {
		return DecimalLiteral(value);
	}

	public static OctalLiteral OctalLiteral(String value) {
		return OctalLiteral(value);
	}

	public static HexIntegerLiteral HexIntegerLiteral(String value) {
		return HexIntegerLiteral(value);
	}

	public static FloatLiteral FloatLiteral(String value) {
		return FloatLiteral(value);
	}

	public static BooleanLiteral BooleanLiteral(boolean value) {
		return BooleanLiteral(value);
	}

	public static RegexpLiteral RegexpLiteral(String value) {
		return RegexpLiteral(value);
	}

	public static StringLiteralSingle StringLiteralSingle(String value) {
		return StringLiteralSingle(value);
	}

	public static StringLiteralDouble StringLiteralDouble(String value) {
		return StringLiteralDouble(value);
	}

	public static IdentifierName IdentifierName(String value) {
		return IdentifierName(value);
	}

	public static EnclosedExpression EnclosedExpression(Expression inner) {
		return EnclosedExpression(inner);
	}

	public static FunctionExpression FunctionExpression(String name,
			List<Parameter> parameters, Block body) {
		return FunctionExpression(name, NodeList(parameters), body);
	}

	public static CallExpression CallExpression(Expression scope,
			List<Expression> args) {
		return CallExpression(scope, NodeList(args));
	}

	public static ArrayAccessExpression ArrayAccessExpression(Expression name,
			Expression index) {
		return ArrayAccessExpression(name, index);
	}

	public static FieldAccessExpression FieldAccessExpression(Expression scope,
			IdentifierName field) {
		return FieldAccessExpression(scope, field);
	}

	public static NewExpression NewExpression(Expression expression) {
		return NewExpression(expression);
	}

	public static ArrayLiteral ArrayLiteral(List<Expression> expressions) {
		return ArrayLiteral(NodeList(expressions));
	}

	public static ObjectLiteral ObjectLiteral(
			List<PropertyAssignment> propertyAssignments) {
		return ObjectLiteral(NodeList(propertyAssignments));
	}

	public static GetAssignment GetAssignment(PropertyName propertyName,
			Block block) {
		return GetAssignment(block, propertyName, null, 0, 0);
	}

	public static SetAssignment SetAssignment(PropertyName propertyName,
			String identifier, Block block) {
		return SetAssignment(identifier, block, propertyName, null, 0, 0);
	}

	public static PutAssignment PutAssignment(PropertyName propertyName,
			Expression propertyValue) {
		return PutAssignment(propertyValue, propertyName, null, 0, 0);
	}

	public static UnaryExpression UnaryExpression(Expression expression,
			UnaryOperator operator) {
		return UnaryExpression(expression, operator);
	}

	public static BinaryExpression BinaryExpression(Expression left,
			Expression right, BinaryOperator operator) {
		return BinaryExpression(left, right, operator);
	}

	public static ConditionalExpression ConditionalExpression(
			Expression condition, Expression thenExpr, Expression elseExpr) {
		return ConditionalExpression(condition, thenExpr, elseExpr);
	}

	public static AssignmentExpression AssignmentExpression(Expression target,
			Expression value, AssignOperator operator) {
		return AssignmentExpression(target, value, operator);
	}

	public static SequenceExpression SequenceExpression(
			List<Expression> expressions) {
		return SequenceExpression(NodeList(expressions));
	}

	public static Block Block(List<Statement> statements) {
		return Block(NodeList(statements), null, 0, 0);
	}

	public static LetDefinition LetDefinition(JSDocComment comment,
			List<VariableDeclaration> declarations) {
		return LetDefinition(NodeList(declarations), comment, 0, 0);
	}

	public static LetStatement LetStatement(JSDocComment comment,
			List<VariableDeclaration> declarations, Statement statement) {
		return LetStatement(NodeList(declarations), statement, null, 0, 0);
	}

	public static DebuggerStatement DebuggerStatement(JSDocComment comment) {
		return DebuggerStatement(comment);
	}

	public static ConstantStatement ConstantStatement(JSDocComment comment,
			List<VariableDeclaration> declarations) {
		return ConstantStatement(NodeList(declarations), comment, 0, 0);
	}

	public static VariableStatement VariableStatement(JSDocComment comment,
			List<VariableDeclaration> declarations) {
		return VariableStatement(NodeList(declarations), comment, 0, 0);
	}

	public static VariableDeclaration VariableDeclaration(String name,
			Expression expression) {
		return VariableDeclaration(name, expression);
	}

	public static EmptyStatement EmptyStatement(JSDocComment comment) {
		return EmptyStatement(comment);
	}

	public static IfStatement IfStatement(JSDocComment comment,
			Expression condition, Statement thenStatement,
			Statement elseStatement) {
		return IfStatement(condition, thenStatement, elseStatement, comment, 0,
				0);
	}

	public static LabelledStatement LabelledStatement(JSDocComment comment,
			String label, Statement statement) {
		return LabelledStatement(label, statement, comment, 0, 0);
	}

	public static ExpressionStatement ExpressionStatement(JSDocComment comment,
			Expression expression) {
		return ExpressionStatement(expression, comment, 0, 0);
	}

	public static WhileStatement WhileStatement(JSDocComment comment,
			Expression condition, Statement statement) {
		return WhileStatement(condition, statement, comment, 0, 0);
	}

	public static DoWhileStatement DoWhileStatement(JSDocComment comment,
			Expression condition, Statement statement) {
		return DoWhileStatement(condition, statement, comment, 0, 0);
	}

	public static ForStatement ForStatement(JSDocComment comment,
			Expression variable, Expression condition, Expression expr,
			Statement body) {
		return ForStatement(variable, condition, expr, body, comment, 0, 0);
	}

	public static VariableExpression VariableExpression(
			List<VariableDeclaration> declarations) {
		return VariableExpression(NodeList(declarations));
	}

	public static LetExpression LetExpression(
			List<VariableDeclaration> declarations, Expression expression) {
		return LetExpression(NodeList(declarations), expression);
	}

	public static ForeachStatement ForeachStatement(JSDocComment comment,
			Expression variable, Expression expression, Statement body) {
		return ForeachStatement(variable, expression, body, comment, 0, 0);
	}

	public static BreakStatement BreakStatement(JSDocComment comment,
			String identifier) {
		return BreakStatement(identifier, comment, 0, 0);
	}

	public static ContinueStatement ContinueStatement(JSDocComment comment,
			String identifier) {
		return ContinueStatement(identifier, comment, 0, 0);
	}

	public static WithStatement WithStatement(JSDocComment comment,
			Expression expression, Statement statement) {
		return WithStatement(expression, statement, comment, 0, 0);
	}

	public static TryStatement TryStatement(JSDocComment comment,
			Block tryBlock, CatchClause catchClause, Block finallyBlock) {
		return TryStatement(tryBlock, catchClause, finallyBlock, comment, 0, 0);
	}

	public static ThrowStatement ThrowStatement(JSDocComment comment,
			Expression expression) {
		return ThrowStatement(expression, comment, 0, 0);
	}

	public static CaseBlock CaseBlock(JSDocComment comment,
			DefaultClause defaultClause, List<CaseClause> caseClauses) {
		return CaseBlock(defaultClause, NodeList(caseClauses), comment, 0, 0);
	}

	public static SwitchStatement SwitchStatement(JSDocComment comment,
			Expression expression, CaseBlock block) {
		return SwitchStatement(expression, block, comment, 0, 0);
	}

	public static CatchClause CatchClause(String identifier, Block block) {
		return CatchClause(identifier, block);
	}

	public static ReturnStatement ReturnStatement(JSDocComment comment,
			Expression expression) {
		return ReturnStatement(expression, comment, 0, 0);
	}

	public static CaseClause CaseClause(Expression expression,
			List<Statement> statements) {
		return CaseClause(expression, NodeList(statements));
	}

	public static FunctionDeclaration FunctionDeclaration(JSDocComment comment,
			String name, List<Parameter> parameters, Block body) {
		return FunctionDeclaration(name, NodeList(parameters), body, comment,
				0, 0);
	}

	public static Parameter Parameter(String name) {
		return Parameter(name);
	}

	public static DefaultClause DefaultClause(List<Statement> statements) {
		return DefaultClause(NodeList(statements));
	}

	public static CompilationUnit CompilationUnit(List<Comment> comments,
			List<Statement> elements, String name) {
		return CompilationUnit(NodeList(elements), NodeList(comments), name, 0,
				0);
	}

	/**
	 * This method return null when nodes equals null
	 * 
	 * @param nodes
	 * @return
	 */
	public static <E extends Node> NodeList<E> NodeList(List<E> nodes) {
		if (nodes != null) {
			return NodeList(nodes);
		}
		return null;
	}

	/**
	 * This method return null when node equals null
	 * 
	 * @param node
	 * @return
	 */
	public static <E extends Node> NodeList<E> NodeList(E node) {
		if (node != null) {
			return NodeList(Arrays.asList(node));
		}
		return null;
	}

	/**
	 * This method return null when node equals null
	 * 
	 * @param node
	 * @return
	 */
	public static <E extends Node> NodeList<E> NodeList(E[] node) {
		if (node != null) {
			return NodeList(Arrays.asList(node));
		}
		return null;
	}

	public static NewExpression NewExpression(Expression expression,
			ObjectLiteral initializer) {
		return NewExpression(expression, initializer);
	}

}
