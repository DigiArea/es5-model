package com.digiarea.es5.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.digiarea.es5.AllocationExpression;
import com.digiarea.es5.ArrayAccessExpression;
import com.digiarea.es5.ArrayLiteral;
import com.digiarea.es5.AssignmentExpression;
import com.digiarea.es5.BinaryExpression;
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
import com.digiarea.es5.LabelledStatement;
import com.digiarea.es5.LetDefinition;
import com.digiarea.es5.LetExpression;
import com.digiarea.es5.LetStatement;
import com.digiarea.es5.NewExpression;
import com.digiarea.es5.Node;
import com.digiarea.es5.NodeFacade;
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
import com.digiarea.es5.Statement;
import com.digiarea.es5.StringLiteralDouble;
import com.digiarea.es5.StringLiteralSingle;
import com.digiarea.es5.SuperExpression;
import com.digiarea.es5.SwitchStatement;
import com.digiarea.es5.ThisExpression;
import com.digiarea.es5.ThrowStatement;
import com.digiarea.es5.TryStatement;
import com.digiarea.es5.UnaryExpression;
import com.digiarea.es5.VariableDeclaration;
import com.digiarea.es5.VariableExpression;
import com.digiarea.es5.VariableStatement;
import com.digiarea.es5.WhileStatement;
import com.digiarea.es5.WithStatement;
import com.digiarea.es5.tools.IErrorManager.ErrorType;
import com.digiarea.es5.visitor.VoidVisitorAdapter;

public class NamespaceOrganizer extends VoidVisitorAdapter<Node> {

	public class SymbolComparator implements Comparator<String> {

		public SymbolComparator() {
		}

		@Override
		public int compare(String key1, String key2) {
			if (key1.length() <= key2.length()) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public class AlphabetComparator implements Comparator<String> {

		public AlphabetComparator() {
		}

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}

	private IErrorManager errorManager;

	/**
	 * Found nodes. Key is a namespace. Value is a node.
	 */
	private TreeMap<String, Node> nodes;
	/**
	 * A path of the output directory
	 */
	private String output;
	/**
	 * A path of the current processing compilation unit
	 */
	private String path;

	private Map<String, String> browsers;
	/**
	 * Map of libraries. Key is the name of a library. Value is a list of
	 * namespaces. All prototypes of a namespace are automatically added to the
	 * library.
	 */
	private Map<String, List<String>> libraries;

	private static final String JS_EXT = "js";
	private static final String JS_EXT_DOTTED = "." + JS_EXT;

	private String copyright;

	public NamespaceOrganizer(IErrorManager errorManager) {
		nodes = new TreeMap<>();
		this.errorManager = errorManager;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void setBrowsers(Map<String, String> browsers) {
		this.browsers = browsers;
	}

	public void setLibraries(Map<String, List<String>> libraries) {
		this.libraries = libraries;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void byClass() throws Exception {
		// TODO
	}

	public void byOneUnit() throws Exception {
		// TODO
	}

	public void byLibrary() throws IOException {
		if (libraries != null && !libraries.isEmpty()) {
			// sort();
			TreeMap<String, Node> myNodes = new TreeMap<>(nodes);
			for (String library : libraries.keySet()) {
				List<String> namespaces = libraries.get(library);
				List<Node> libraryNodes = new ArrayList<Node>();
				for (String string : namespaces) {
					libraryNodes.addAll(pollNodes(myNodes, string));
				}
				createFile(libraryNodes, library);
			}
			if (!myNodes.isEmpty()) {
				createFile(new ArrayList<Node>(myNodes.values()), "globals");
			}
		}
	}

	public List<Node> pollNodes(Map<String, Node> nodes, String prefix) {
		Set<String> set = nodes.keySet();
		List<Node> poll = new ArrayList<>();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String o = itr.next();
			if (o.startsWith(prefix + ".") || o.equals(prefix)) {
				poll.add(nodes.get(o));
				itr.remove();
			}
		}
		return poll;
	}

	private void createFile(Collection<Node> nodes, String name)
			throws IOException {
		Path path = Paths.get(output, name + JS_EXT_DOTTED);
		CompilationUnit result = NodeFacade.CompilationUnit(null,
				(List<Statement>) (List<?>) nodes, name);
		File output = path.toFile();
		if (!output.exists()) {
			output.createNewFile();
		} else {
			errorManager.report(ErrorType.ERROR,
					"FILE EXISTS: " + output.getAbsolutePath());
		}
		FileOutputStream stream = new FileOutputStream(output);
		String content = result.toString();
		if (copyright != null) {
			content = copyright + "\n\n" + result.toString();
		}
		stream.write(content.getBytes());
		stream.close();
	}

	// public void getAstRoot() throws Exception {
	// TreeMap<String, Node> sortedSymbols = new TreeMap<String, Node>(
	// new SymbolComparator());
	// sortedSymbols.putAll(nodes);
	// // Map<String, Node> finalSymbols = new TreeMap<String, Node>(
	// // new AlphabetComparator());
	// // finalSymbols.putAll(sortedSymbols);
	//
	// List<Node> stmt = new ArrayList<>();
	// for (Node node : sortedSymbols.values()) {
	// stmt.add(node);
	// }
	//
	// Set<String> set = nodes.keySet();
	// List<Node> globals = new ArrayList<>();
	// while (!nodes.isEmpty()) {
	// String name = null;
	// boolean namespace = false;
	// Iterator<String> itr = set.iterator();
	// List<Node> finalNode = new ArrayList<>();
	// List<String> names = new ArrayList<>();
	// while (itr.hasNext()) {
	// String o = itr.next();
	// if (name == null) {
	// if (o.contains(".")) {
	// int index = o.indexOf(".");
	// name = o.substring(0, index);
	// namespace = true;
	// } else {
	// name = o;
	// }
	// // if (name.contains("Element")) {
	// // System.out.println("NAME MAIN: " + name);
	// // }
	// }
	// if ((namespace && (o.startsWith(name + ".") || o.equals(name)))
	// || (!namespace && o.startsWith(name))) {
	// finalNode.add(nodes.get(o));
	// itr.remove();
	// names.add(o);
	// }
	// }
	// if (finalNode.size() == 1) {
	// globals.addAll(finalNode);
	// } else {
	// CompilationUnit result = NodeFacade.CompilationUnit(null,
	// (List<Statement>) (List<?>) finalNode, "sasha.s");
	// File output = new File("/home/daginno/temp/externs/" + name
	// + ".js");
	// if (!output.exists()) {
	// output.createNewFile();
	// } else {
	// System.out.println("FILE EXISTS: "
	// + output.getAbsolutePath());
	// }
	// FileOutputStream stream = new FileOutputStream(output);
	// stream.write(result.toString().getBytes());
	// stream.close();
	// }
	// }
	// if (!stmt.isEmpty()) {
	// CompilationUnit result = NodeFacade.CompilationUnit(null,
	// (List<Statement>) (List<?>) stmt, "sasha.s");
	// File output = new File("/home/daginno/temp/" + "AllNodes" + ".js");
	// if (!output.exists()) {
	// output.createNewFile();
	// } else {
	// System.out.println("FILE EXISTS: " + output.getAbsolutePath());
	// }
	// FileOutputStream stream = new FileOutputStream(output);
	// stream.write(result.toString().getBytes());
	// stream.close();
	// }
	//
	// }

	public Map<String, Node> getNodes() {
		return nodes;
	}

	@Override
	public void visit(ExpressionStatement n, Node ctx) throws Exception {
		Expression expression = n.getExpression();
		if (expression instanceof AssignmentExpression
				|| expression instanceof IdentifierName
				|| expression instanceof FieldAccessExpression
				|| expression instanceof ArrayAccessExpression) {
			n.getExpression().accept(this, n);
		} else {
			warnUnknown(expression);
		}
	}

	@Override
	public void visit(AllocationExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ArrayAccessExpression n, Node ctx) throws Exception {
		Expression index = n.getIndex();
		Expression name = n.getName();
		if ((name instanceof FieldAccessExpression || name instanceof IdentifierName)
				&& index instanceof com.digiarea.es5.StringLiteral) {
			String realName = name.toString() + "."
					+ ((com.digiarea.es5.StringLiteral) index).getValue();
			put(realName, ctx);
		} else {
			warnUnknown(n);
		}
	}

	@Override
	public void visit(ArrayLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(AssignmentExpression n, Node ctx) throws Exception {
		Expression expression = n.getTarget();
		if (expression instanceof IdentifierName
				|| expression instanceof FieldAccessExpression
				|| expression instanceof ArrayAccessExpression) {
			expression.accept(this, ctx);
		} else {
			warnUnknown(expression);
		}
	}

	@Override
	public void visit(BinaryExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(Block n, Node ctx) throws Exception {
		super.visit(n, ctx);
	}

	@Override
	public void visit(BlockComment n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(BooleanLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(BreakStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(CallExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(CaseBlock n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(CaseClause n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(CatchClause n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ConditionalExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ConstantStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ContinueStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(DebuggerStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(DecimalLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(DefaultClause n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(DoWhileStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(EmptyLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(EmptyStatement n, Node ctx) throws Exception {
		// warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(EnclosedExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(FieldAccessExpression n, Node ctx) throws Exception {
		String name = n.toString();
		put(name, ctx);
	}

	@Override
	public void visit(FloatLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ForeachStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ForStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(FunctionDeclaration n, Node ctx) throws Exception {
		put(n.getName(), n);
	}

	@Override
	public void visit(FunctionExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(GetAssignment n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(HexIntegerLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(IdentifierName n, Node ctx) throws Exception {
		String name = n.toString();
		put(name, ctx);
	}

	@Override
	public void visit(IfStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ImportStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(LabelledStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(LetDefinition n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(LetExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(LetStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(NewExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(NullLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ObjectLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(OctalLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(Parameter n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(Project n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(PutAssignment n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(RegexpLiteral n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ReturnStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(SequenceExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(SetAssignment n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(StringLiteralDouble n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(StringLiteralSingle n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(SuperExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(SwitchStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ThisExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(ThrowStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(TryStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(UnaryExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(VariableDeclaration n, Node ctx) throws Exception {
		String realName = n.getName();
		put(realName, ctx);
	}

	@Override
	public void visit(VariableExpression n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(VariableStatement n, Node ctx) throws Exception {
		super.visit(n, n);
	}

	@Override
	public void visit(WhileStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	@Override
	public void visit(WithStatement n, Node ctx) throws Exception {
		warnUnknown(n);
		super.visit(n, ctx);
	}

	private void warnUnknown(Node node) {
		errorManager.report(ErrorType.ERROR, "UNKNOWN NODE: " + " "
				+ node.getClass().getName() + " " + node.toString());
	}

	private void warnDuplicate(Node node, String name) {
		errorManager.report(ErrorType.ERROR, "NODE EXISTS: "
				+ node.getClass().getName() + " " + nodes.get(name).toString()
				+ " " + node.getPosBegin() + " " + node.getPosEnd());
	}

	private void put(String name, Node node) {
		if (nodes.containsKey(name)) {
			warnDuplicate(node, name);

			Node existingNode = nodes.get(name);

			String finalComment = "";

			if (existingNode.getJsDocComment() != null
					&& existingNode.getJsDocComment().getContent() != null) {
				finalComment = finalComment
						+ existingNode.getJsDocComment().getContent();
			}

			if (browsers != null) {
				String browser = browsers.get(path);
				if (browser != null) {
					finalComment = finalComment + "\n * " + "@browser "
							+ browser + "\n";
				}
			}

			if (node.getJsDocComment() != null
					&& node.getJsDocComment().getContent() != null) {
				finalComment = finalComment
						+ node.getJsDocComment().getContent();
			}

			if (!finalComment.isEmpty()) {
				existingNode.setJsDocComment(NodeFacade
						.JSDocComment(finalComment));
			}

		} else {
			nodes.put(name, node);
			String finalComment = "";

			if (node.getJsDocComment() != null
					&& node.getJsDocComment().getContent() != null) {
				finalComment = finalComment
						+ node.getJsDocComment().getContent();
			}

			if (browsers != null) {
				String browser = browsers.get(path);
				if (browser != null) {
					finalComment = finalComment + "\n * " + "@browser "
							+ browser + "\n";
				}
			}

			if (!finalComment.isEmpty()) {
				node.setJsDocComment(NodeFacade.JSDocComment(finalComment));
			}
		}
	}
}
