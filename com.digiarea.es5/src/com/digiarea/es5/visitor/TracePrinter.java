package com.digiarea.es5.visitor;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.digiarea.common.SourcePrinter;
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
import com.digiarea.es5.Expression;
import com.digiarea.es5.ExpressionStatement;
import com.digiarea.es5.FieldAccessExpression;
import com.digiarea.es5.FloatLiteral;
import com.digiarea.es5.ForStatement;
import com.digiarea.es5.ForeachStatement;
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
import com.digiarea.es5.PropertyAssignment;
import com.digiarea.es5.PutAssignment;
import com.digiarea.es5.RegexpLiteral;
import com.digiarea.es5.ReturnStatement;
import com.digiarea.es5.SequenceExpression;
import com.digiarea.es5.SetAssignment;
import com.digiarea.es5.Statement;
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

public class TracePrinter implements VoidVisitor<SourcePrinter> {

	private void printExpressions(List<Expression> expressions,
			SourcePrinter printer) throws Exception, IOException {
		for (Iterator<Expression> i = expressions.iterator(); i.hasNext();) {
			Expression expression = i.next();
			if (expression != null) {
				expression.accept(this, printer);
			}
			if (i.hasNext()) {
				printer.print(", ");
			}
		}
	}

	private void printStatements(List<Statement> statements,
			SourcePrinter printer) throws Exception, IOException {
		for (Iterator<Statement> i = statements.iterator(); i.hasNext();) {
			Statement statement = i.next();
			statement.accept(this, printer);
			if (i.hasNext()) {

			}
		}
	}

	private void printVariableDeclarations(List<VariableDeclaration> decls,
			SourcePrinter printer) throws Exception, IOException {
		for (Iterator<VariableDeclaration> i = decls.iterator(); i.hasNext();) {
			VariableDeclaration expression = i.next();
			expression.accept(this, printer);
			if (i.hasNext()) {
				printer.print(", ");
			}
		}
	}

	@Override
	public void visit(AllocationExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("new ");
		if (n.getBody() != null) {
			n.getBody().accept(this, printer);
		}
	}

	@Override
	public void visit(ArrayAccessExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getName() != null) {
			n.getName().accept(this, printer);
		}
		printer.print("[");
		if (n.getIndex() != null) {
			n.getIndex().accept(this, printer);
		}
		printer.print("]");
	}

	@Override
	public void visit(ArrayLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("[");
		List<Expression> expressions = n.getExpressions();
		if (expressions != null) {
			printExpressions(expressions, printer);
		}
		printer.print("]");
	}

	@Override
	public void visit(AssignmentExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getTarget() != null) {
			n.getTarget().accept(this, printer);
		}
		if (n.getAssignOperator() != null) {
			n.getAssignOperator().accept(this, printer);
		}
		if (n.getValue() != null) {
			n.getValue().accept(this, printer);
		}
	}

	@Override
	public void visit(AssignOperator n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		switch (n) {
		case and:
			printer.print("&=");
			break;
		case lShift:
			printer.print("<<=");
			break;
		case assign:
			printer.print("=");
			break;
		case minus:
			printer.print("-=");
			break;
		case or:
			printer.print("|=");
			break;
		case plus:
			printer.print("+=");
			break;
		case rem:
			printer.print("%=");
			break;
		case rSignedShift:
			printer.print(">>=");
			break;
		case rUnsignedShift:
			printer.print(">>>=");
			break;
		case slash:
			printer.print("/=");
			break;
		case star:
			printer.print("*=");
			break;
		case xor:
			printer.print("^=");
			break;
		}
	}

	@Override
	public void visit(BinaryExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getLeft() != null) {
			n.getLeft().accept(this, printer);
		}
		if (n.getBinaryOperator() != null) {
			n.getBinaryOperator().accept(this, printer);
		}
		if (n.getRight() != null) {
			n.getRight().accept(this, printer);
		}
	}

	@Override
	public void visit(BinaryOperator n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		switch (n) {
		case and:
			printer.print("&&");
			break;
		case binAnd:
			printer.print("&");
			break;
		case binOr:
			printer.print("|");
			break;
		case divide:
			printer.print("/");
			break;
		case equals:
			printer.print("==");
			break;
		case greater:
			printer.print(">");
			break;
		case greaterEquals:
			printer.print(">=");
			break;
		case identity:
			printer.print("===");
			break;
		case in:
			printer.print("in");
			break;
		case lShift:
			printer.print("<<");
			break;
		case less:
			printer.print("<");
			break;
		case lessEquals:
			printer.print("<=");
			break;
		case minus:
			printer.print("-");
			break;
		case notEquals:
			printer.print("!=");
			break;
		case notIdentity:
			printer.print("!==");
			break;
		case opInstanceof:
			printer.print("instanceof");
			break;
		case or:
			printer.print("||");
			break;
		case plus:
			printer.print("+");
			break;
		case rSignedShift:
			printer.print(">>");
			break;
		case rUnsignedShift:
			printer.print(">>>");
			break;
		case remainder:
			printer.print("%");
			break;
		case times:
			printer.print("*");
			break;
		case xor:
			printer.print("^");
			break;
		}
	}

	@Override
	public void visit(Block n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("{");
		if (n.getComment() != null) {

			n.getComment().accept(this, printer);

		}
		if (n.getStatements() != null) {

			for (Statement item : n.getStatements()) {
				if (item != null) {
					item.accept(this, printer);

				}
			}

		}
		printer.print("}");
	}

	@Override
	public void visit(BooleanLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.isValue() ? "true" : "false");
	}

	@Override
	public void visit(BreakStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("break");
		if (n.getIdentifier() != null) {
			printer.print(" ");
			printer.print(n.getIdentifier());
		}
		printer.print(";");
	}

	@Override
	public void visit(CallExpression n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getScope() != null) {
			n.getScope().accept(this, printer);
		}
		printer.print("(");
		if (n.getArgs() != null) {
			printExpressions(n.getArgs(), printer);
		}
		printer.print(")");
	}

	@Override
	public void visit(CaseBlock n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(" {");
		if (n.getComment() != null) {

			n.getComment().accept(this, printer);

		}
		if (n.getCaseClauses() != null) {

			for (CaseClause item : n.getCaseClauses()) {
				if (item != null) {
					item.accept(this, printer);
				}
			}

		}
		if (n.getDefaultClause() != null) {
			n.getDefaultClause().accept(this, printer);
		}

		printer.print("}");
	}

	@Override
	public void visit(CaseClause n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");

		if (n.getExpression() != null) {
			printer.print("case ");
			n.getExpression().accept(this, printer);
			printer.print(":");
		}
		List<Statement> statements = n.getStatements();
		if (statements != null) {

			printStatements(statements, printer);

		}
	}

	@Override
	public void visit(CatchClause n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(" catch ( ");
		printer.print(n.getString());
		printer.print(" ) ");
		if (n.getBlock() != null) {
			n.getBlock().accept(this, printer);
		}
	}

	@Override
	public void visit(CompilationUnit n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getElements() != null) {
			for (Statement item : n.getElements()) {
				if (item != null) {
					item.accept(this, printer);

				}
			}
		}
	}

	@Override
	public void visit(ConditionalExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getCondition() != null) {
			n.getCondition().accept(this, printer);
		}
		printer.print(" ? ");
		if (n.getThenExpr() != null) {
			n.getThenExpr().accept(this, printer);
		}
		printer.print(" : ");
		if (n.getElseExpr() != null) {
			n.getElseExpr().accept(this, printer);
		}
	}

	@Override
	public void visit(ConstantStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("const ");
		List<VariableDeclaration> decls = n.getVariableDeclarations();
		if (decls != null) {
			printVariableDeclarations(decls, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(ContinueStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("continue");
		if (n.getIdentifier() != null) {
			printer.print(" ");
			printer.print(n.getIdentifier());
		}
		printer.print(";");
	}

	@Override
	public void visit(DebuggerStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.printLn("debugger;");
	}

	@Override
	public void visit(DecimalLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getValue());
	}

	@Override
	public void visit(DefaultClause n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");

		printer.print("default:");
		List<Statement> statements = n.getStatements();
		if (statements != null) {

			printStatements(statements, printer);

		}
	}

	@Override
	public void visit(DoWhileStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		if (n.getBody() != null) {
			printer.print("do ");
			n.getBody().accept(this, printer);
		}
		if (n.getCondition() != null) {
			printer.print(" while (");
			n.getCondition().accept(this, printer);
			printer.print(")");
		}
	}

	@Override
	public void visit(EmptyLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
	}

	@Override
	public void visit(EmptyStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(EnclosedExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("(");
		if (n.getInner() != null) {
			n.getInner().accept(this, printer);
		}
		printer.print(")");
	}

	@Override
	public void visit(ExpressionStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		if (n.getExpression() != null) {
			n.getExpression().accept(this, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(FieldAccessExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getScope() != null) {
			n.getScope().accept(this, printer);
		}
		if (n.getField() != null) {
			printer.print(".");
			n.getField().accept(this, printer);
		}
	}

	@Override
	public void visit(FloatLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getValue());
	}

	@Override
	public void visit(ForeachStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("for (");
		if (n.getVariable() != null) {
			n.getVariable().accept(this, printer);
		}
		printer.print(" in ");
		if (n.getExpression() != null) {
			n.getExpression().accept(this, printer);
		}
		printer.print(") ");
		if (n.getBody() != null) {
			n.getBody().accept(this, printer);
		}
	}

	@Override
	public void visit(ForStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("for (");
		if (n.getVariable() != null) {
			n.getVariable().accept(this, printer);
		}
		printer.print("; ");
		if (n.getCondition() != null) {
			n.getCondition().accept(this, printer);
		}
		printer.print("; ");
		if (n.getExpr() != null) {
			n.getExpr().accept(this, printer);
		}
		printer.print(") ");
		if (n.getBody() != null) {
			n.getBody().accept(this, printer);
		}
	}

	@Override
	public void visit(FunctionDeclaration n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("function ");
		printer.print(n.getName());
		printer.print("(");
		List<Parameter> args = n.getParameters();
		if (args != null) {
			for (Iterator<Parameter> i = args.iterator(); i.hasNext();) {
				Parameter e = i.next();
				e.accept(this, printer);
				if (i.hasNext()) {
					printer.print(", ");
				}
			}
		}
		printer.print(") ");
		if (n.getBody() != null) {
			n.getBody().accept(this, printer);
		}
	}

	@Override
	public void visit(FunctionExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("function");
		if (n.getName() != null) {
			printer.print(" ");
			printer.print(n.getName());
		}
		printer.print("(");
		if (n.getParameters() != null) {
			for (Iterator<Parameter> i = n.getParameters().iterator(); i
					.hasNext();) {
				i.next().accept(this, printer);
				if (i.hasNext()) {
					printer.print(", ");
				}
			}
		}
		printer.print(") ");
		if (n.getBody() != null) {
			n.getBody().accept(this, printer);
		}
	}

	@Override
	public void visit(GetAssignment n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("get ");
		if (n.getPropertyName() != null) {
			n.getPropertyName().accept(this, printer);
		}
		printer.print("() ");
		if (n.getBlock() != null) {
			n.getBlock().accept(this, printer);
		}
	}

	@Override
	public void visit(HexIntegerLiteral n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getValue());
	}

	@Override
	public void visit(IdentifierName n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getValue());
	}

	@Override
	public void visit(IfStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("if (");
		if (n.getCondition() != null) {
			n.getCondition().accept(this, printer);
		}
		printer.print(") ");
		if (n.getThenStatement() != null) {
			n.getThenStatement().accept(this, printer);
		}
		if (n.getElseStatement() != null) {
			printer.print(" else ");
			n.getElseStatement().accept(this, printer);
		}
	}

	@Override
	public void visit(ImportStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("import ");
		if (n.getName() != null) {
			n.getName().accept(this, printer);
		}
		printer.printLn(";");
	}

	@Override
	public void visit(LabelledStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print(n.getLabel());
		printer.print(":");
		if (n.getStatement() != null) {
			n.getStatement().accept(this, printer);
		}
	}

	@Override
	public void visit(LetDefinition n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("let ");
		List<VariableDeclaration> decls = n.getVariableDeclarations();
		if (decls != null) {
			printVariableDeclarations(decls, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(LetExpression n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("let ");
		if (n.getExpression() != null) {
			printer.print("(");
		}
		List<VariableDeclaration> decls = n.getVariableDeclarations();
		if (decls != null) {
			printVariableDeclarations(decls, printer);
		}
		if (n.getExpression() != null) {
			printer.print(") ");
			n.getExpression().accept(this, printer);
		}
	}

	@Override
	public void visit(LetStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("let (");
		List<VariableDeclaration> decls = n.getVariableDeclarations();
		if (decls != null) {
			printVariableDeclarations(decls, printer);
		}
		printer.print(") ");
		if (n.getStatement() != null) {
			n.getStatement().accept(this, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(NewExpression n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("new ");
		if (n.getExpression() != null) {
			n.getExpression().accept(this, printer);
		}
		if (n.getInitializer() != null) {
			n.getInitializer().accept(this, printer);
		}
	}

	@Override
	public void visit(NullLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("null");
	}

	@Override
	public void visit(ObjectLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("{");
		List<PropertyAssignment> propertyAssignments = n
				.getPropertyAssignments();
		if (propertyAssignments != null) {

			for (Iterator<PropertyAssignment> i = propertyAssignments
					.iterator(); i.hasNext();) {
				PropertyAssignment propertyAssignment = i.next();
				propertyAssignment.accept(this, printer);
				if (i.hasNext()) {
					printer.print(",");
				}

			}

		}
		printer.print("}");
	}

	@Override
	public void visit(OctalLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getValue());
	}

	@Override
	public void visit(Parameter n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getName());
	}

	@Override
	public void visit(Project n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getCompilationUnits() != null) {
			for (CompilationUnit item : n.getCompilationUnits()) {
				if (item != null) {
					item.accept(this, printer);
				}
			}
		}
	}

	@Override
	public void visit(PutAssignment n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		if (n.getPropertyName() != null) {
			n.getPropertyName().accept(this, printer);
		}
		printer.print(" : ");
		if (n.getPropertyValue() != null) {
			n.getPropertyValue().accept(this, printer);
		}
	}

	@Override
	public void visit(RegexpLiteral n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getValue());
	}

	@Override
	public void visit(ReturnStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("return");
		if (n.getExpression() != null) {
			printer.print(" ");
			n.getExpression().accept(this, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(SequenceExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getExpressions() != null) {
			for (Iterator<Expression> i = n.getExpressions().iterator(); i
					.hasNext();) {
				Expression arg = i.next();
				if (arg != null) {
					arg.accept(this, printer);
					if (i.hasNext()) {
						printer.print(", ");
					}
				}

			}
		}
	}

	@Override
	public void visit(SetAssignment n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("set ");
		if (n.getPropertyName() != null) {
			n.getPropertyName().accept(this, printer);
		}
		printer.print("(");
		printer.print(n.getIdentifier());
		printer.print(") ");
		if (n.getBlock() != null) {
			n.getBlock().accept(this, printer);
		}
	}

	@Override
	public void visit(StringLiteralSingle n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("'");
		printer.print(n.getValue());
		printer.print("'");
	}

	@Override
	public void visit(StringLiteralDouble n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("\"");
		printer.print(n.getValue());
		printer.print("\"");
	}

	@Override
	public void visit(SuperExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("super");
	}

	@Override
	public void visit(SwitchStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		if (n.getExpression() != null) {
			printer.print("switch (");
			n.getExpression().accept(this, printer);
			printer.print(")");
		}
		if (n.getBlock() != null) {
			n.getBlock().accept(this, printer);
		} else {
			printer.print("{}");
		}
	}

	@Override
	public void visit(ThisExpression n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("this");
	}

	@Override
	public void visit(ThrowStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("throw ");
		if (n.getExpression() != null) {
			n.getExpression().accept(this, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(TryStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		if (n.getTryBlock() != null) {
			printer.print("try ");
			n.getTryBlock().accept(this, printer);
		}
		if (n.getCatchClause() != null) {
			n.getCatchClause().accept(this, printer);
		}
		if (n.getFinallyBlock() != null) {
			printer.print(" finally ");
			n.getFinallyBlock().accept(this, printer);
		}
	}

	@Override
	public void visit(UnaryExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		switch (n.getUnaryOperator()) {
		case delete:
			printer.print(" delete ");
			break;
		case inverse:
			printer.print(" ~");
			break;
		case negative:
			printer.print(" -");
			break;
		case not:
			printer.print(" !");
			break;
		case opVoid:
			printer.print(" void ");
			break;
		case positive:
			printer.print(" +");
			break;
		case preDecrement:
			printer.print(" --");
			break;
		case preIncrement:
			printer.print(" ++");
			break;
		case typeof:
			printer.print(" typeof ");
			break;
		case rem:
			printer.print(" %");
			break;
		default:
			break;
		}
		if (n.getExpression() != null) {
			n.getExpression().accept(this, printer);
		}
		switch (n.getUnaryOperator()) {
		case posDecrement:
			printer.print("-- ");
			break;
		case posIncrement:
			printer.print("++ ");
			break;
		default:
			break;
		}
	}

	@Override
	public void visit(UnaryOperator n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		switch (n) {
		case delete:
			printer.print("delete ");
			break;
		case inverse:
			printer.print("~");
			break;
		case negative:
			printer.print("-");
			break;
		case not:
			printer.print("!");
			break;
		case opVoid:
			printer.print("void ");
			break;
		case positive:
			printer.print("+");
			break;
		case preDecrement:
			printer.print("--");
			break;
		case preIncrement:
			printer.print("++");
			break;
		case typeof:
			printer.print("typeof ");
			break;
		case posDecrement:
			printer.print("--");
			break;
		case posIncrement:
			printer.print("++");
			break;
		case rem:
			printer.print("%");
			break;
		default:
			break;
		}
	}

	@Override
	public void visit(VariableDeclaration n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print(n.getName());
		if (n.getExpression() != null) {
			printer.print("=");
			n.getExpression().accept(this, printer);
		}
	}

	@Override
	public void visit(VariableExpression n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("var ");
		List<VariableDeclaration> decls = n.getVariableDeclarations();
		if (decls != null) {
			printVariableDeclarations(decls, printer);
		}
	}

	@Override
	public void visit(VariableStatement n, SourcePrinter printer)
			throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("var ");
		List<VariableDeclaration> decls = n.getVariableDeclarations();
		if (decls != null) {
			printVariableDeclarations(decls, printer);
		}
		printer.print(";");
	}

	@Override
	public void visit(WhileStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		printer.print("while (");
		if (n.getCondition() != null) {
			n.getCondition().accept(this, printer);
		}
		printer.print(") ");
		if (n.getBody() != null) {
			n.getBody().accept(this, printer);
		}
	}

	@Override
	public void visit(WithStatement n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		if (n.getComment() != null) {
			n.getComment().accept(this, printer);
		}
		if (n.getExpression() != null) {
			printer.print("with (");
			n.getExpression().accept(this, printer);
			printer.print(")");
		}
		if (n.getStatement() != null) {
			n.getStatement().accept(this, printer);
		}
	}

	@Override
	public void visit(BlockComment n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("/*");
		printer.print(n.getContent().replaceAll("\t", SourcePrinter.INDENT));
		printer.printLn("*/");
	}

	@Override
	public void visit(JSDocComment n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("/**");
		printer.print(n.getContent().replaceAll("\t", SourcePrinter.INDENT));
		printer.printLn("*/");
	}

	@Override
	public void visit(LineComment n, SourcePrinter printer) throws Exception {
		printer.print(n.getClass().getName());
		printer.print(":->");
		printer.print("//");
		printer.printLn(n.getContent());
	}

	@Override
	public <E extends Node> void visit(NodeList<E> n, SourcePrinter printer)
			throws Exception {
		// not used
	}

}
