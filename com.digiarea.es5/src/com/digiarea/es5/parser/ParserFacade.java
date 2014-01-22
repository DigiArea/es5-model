package com.digiarea.es5.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.digiarea.es5.Node;

public class ParserFacade {

	public static final Node parse(String jsCode) throws Exception {
		InputStream is = new ByteArrayInputStream(jsCode.getBytes());
		ASTParser parser = new ASTParser(is);
		{
			try {
				Node node = parser.VariableDeclaration();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.FunctionDeclaration();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.FunctionExpression();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.Expression();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.Statement();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.Block();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.CompilationUnit(null);
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.ArrayLiteral();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
			try {
				Node node = parser.EmptyStatement();
				if (parser.getNextToken().kind == ASTParserConstants.EOF) {
					return node;
				}
			} catch (Exception e) {
				// nothing to do
			} finally {
				parser.reset(is);
			}
		}
		return null;
	}

	public ParserFacade() {
		super();
	}

}
