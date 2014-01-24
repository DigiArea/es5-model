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
package com.digiarea.es5.parser;
import java.util.*;
import com.digiarea.es5.*;

@SuppressWarnings({"unused", "serial"})
public final class ASTParser implements ASTParserConstants {

  private String cuName = null;

  public void reset(java.io.InputStream in) throws java.io.IOException
  {
    reset(in, null);
  }

  public void reset(java.io.InputStream in, String encoding) throws java.io.IOException
  {
    in.reset();
    ReInit(in, encoding);
    token_source.clearComments();
  }

  private void pushJSDoc()
  {
    token_source.pushJSDoc();
  }

  private JSDocComment popJSDoc()
  {
    return token_source.popJSDoc();
  }

  private List < Comment > getComments()
  {
    return token_source.getComments();
  }

  final public NumericLiteral NumericLiteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DECIMAL_LITERAL:
      jj_consume_token(DECIMAL_LITERAL);
      {if (true) return NodeFacade.DecimalLiteral(token.image);}
      break;
    case OCTAL_LITERAL:
      jj_consume_token(OCTAL_LITERAL);
      {if (true) return NodeFacade.OctalLiteral(token.image);}
      break;
    case HEX_LITERAL:
      jj_consume_token(HEX_LITERAL);
      {if (true) return NodeFacade.HexIntegerLiteral(token.image);}
      break;
    case FLOATING_POINT_LITERAL:
      jj_consume_token(FLOATING_POINT_LITERAL);
      {if (true) return NodeFacade.FloatLiteral(token.image);}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public BooleanLiteral BooleanLiteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
    {if (true) return NodeFacade.BooleanLiteral(true);}
      break;
    case FALSE:
      jj_consume_token(FALSE);
    {if (true) return NodeFacade.BooleanLiteral(false);}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public NullLiteral NullLiteral() throws ParseException {
    jj_consume_token(NULL);
    {if (true) return NodeFacade.NullLiteral();}
    throw new Error("Missing return statement in function");
  }

  final public RegexpLiteral RegexpLiteral() throws ParseException {
    jj_consume_token(REGULAR_EXPRESSION_LITERAL);
    {if (true) return NodeFacade.RegexpLiteral(token.image);}
    throw new Error("Missing return statement in function");
  }

  final public Literal Literal() throws ParseException {
  Literal literal = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
      literal = NumericLiteral();
      break;
    case STRING_LITERAL:
      literal = StringLiteral();
      break;
    case TRUE:
    case FALSE:
      literal = BooleanLiteral();
      break;
    case NULL:
      literal = NullLiteral();
      break;
    case REGULAR_EXPRESSION_LITERAL:
      literal = RegexpLiteral();
      break;
    case UNTERMINATED_STRING_LITERAL:
      jj_consume_token(UNTERMINATED_STRING_LITERAL);
        if (token.image.charAt(0) == '\u005c'')
        {
          literal = NodeFacade.StringLiteralSingle(token.image.substring(1, token.image.length()));
        } else
        {
          literal = NodeFacade.StringLiteralDouble(token.image.substring(1, token.image.length()));
        }
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return literal;}
    throw new Error("Missing return statement in function");
  }

  final public String Identifier() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    case GET:
      jj_consume_token(GET);
      break;
    case SET:
      jj_consume_token(SET);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return token.image;}
    throw new Error("Missing return statement in function");
  }

  final public IdentifierName IdentifierName() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    case BREAK:
      jj_consume_token(BREAK);
      break;
    case CONTINUE:
      jj_consume_token(CONTINUE);
      break;
    case DELETE:
      jj_consume_token(DELETE);
      break;
    case ELSE:
      jj_consume_token(ELSE);
      break;
    case FOR:
      jj_consume_token(FOR);
      break;
    case FUNCTION:
      jj_consume_token(FUNCTION);
      break;
    case IF:
      jj_consume_token(IF);
      break;
    case IN:
      jj_consume_token(IN);
      break;
    case NEW:
      jj_consume_token(NEW);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      break;
    case THIS:
      jj_consume_token(THIS);
      break;
    case TYPEOF:
      jj_consume_token(TYPEOF);
      break;
    case VAR:
      jj_consume_token(VAR);
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      break;
    case WITH:
      jj_consume_token(WITH);
      break;
    case CASE:
      jj_consume_token(CASE);
      break;
    case CATCH:
      jj_consume_token(CATCH);
      break;
    case CLASS:
      jj_consume_token(CLASS);
      break;
    case CONST:
      jj_consume_token(CONST);
      break;
    case DEBUGGER:
      jj_consume_token(DEBUGGER);
      break;
    case _DEFAULT:
      jj_consume_token(_DEFAULT);
      break;
    case DO:
      jj_consume_token(DO);
      break;
    case ENUM:
      jj_consume_token(ENUM);
      break;
    case EXPORT:
      jj_consume_token(EXPORT);
      break;
    case EXTENDS:
      jj_consume_token(EXTENDS);
      break;
    case FINALLY:
      jj_consume_token(FINALLY);
      break;
    case IMPORT:
      jj_consume_token(IMPORT);
      break;
    case SUPER:
      jj_consume_token(SUPER);
      break;
    case SWITCH:
      jj_consume_token(SWITCH);
      break;
    case THROW:
      jj_consume_token(THROW);
      break;
    case TRY:
      jj_consume_token(TRY);
      break;
    case INSTANCEOF:
      jj_consume_token(INSTANCEOF);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    case NULL:
      jj_consume_token(NULL);
      break;
    case GET:
      jj_consume_token(GET);
      break;
    case SET:
      jj_consume_token(SET);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return NodeFacade.IdentifierName(token.image);}
    throw new Error("Missing return statement in function");
  }

  final public Expression PrimaryExpression() throws ParseException {
  Expression expression = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NEW:
    case THIS:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACKET:
      expression = PrimaryExpressionInES();
      break;
    case LBRACE:
      expression = ObjectLiteral();
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_1;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    case FUNCTION:
      expression = FunctionExpression();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_2;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public Expression PrimaryExpressionInES() throws ParseException {
  Expression expression = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case THIS:
    case SUPER:
      expression = ThisOrSuper();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_3;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    case GET:
    case SET:
    case IDENTIFIER:
      expression = Name();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_4;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    case TRUE:
    case FALSE:
    case NULL:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
      expression = Literal();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[10] = jj_gen;
          break label_5;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    case LPAREN:
      expression = EnclosedExpression();
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_6;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    case NEW:
      expression = AllocationExpression();
      break;
    case LBRACKET:
      expression = ArrayLiteral();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_7;
        }
        expression = PrimarySuffix(expression);
      }
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public Expression ThisOrSuper() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case THIS:
      jj_consume_token(THIS);
      {if (true) return NodeFacade.ThisExpression();}
      break;
    case SUPER:
      jj_consume_token(SUPER);
      {if (true) return NodeFacade.SuperExpression();}
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public IdentifierName Name() throws ParseException {
  String name = null;
    name = Identifier();
    {if (true) return NodeFacade.IdentifierName(name);}
    throw new Error("Missing return statement in function");
  }

  final public EnclosedExpression EnclosedExpression() throws ParseException {
  Expression expression = null;
    jj_consume_token(LPAREN);
    expression = Expression();
    jj_consume_token(RPAREN);
    {if (true) return NodeFacade.EnclosedExpression(expression);}
    throw new Error("Missing return statement in function");
  }

  final public FunctionExpression FunctionExpression() throws ParseException {
  String name = null;
  List<Parameter> parameters = null;
  Block block = null;
    jj_consume_token(FUNCTION);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GET:
    case SET:
    case IDENTIFIER:
      name = Identifier();
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GET:
    case SET:
    case IDENTIFIER:
      parameters = FormalParameterList();
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    block = Block();
    {if (true) return NodeFacade.FunctionExpression(name, parameters, block);}
    throw new Error("Missing return statement in function");
  }

  final public Expression PrimarySuffix(Expression scope) throws ParseException {
  List<Expression> args = null;
  Expression expr = null;
  IdentifierName identifierName = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      args = Arguments();
        {if (true) return NodeFacade.CallExpression(scope, args);}
      break;
    case LBRACKET:
      jj_consume_token(LBRACKET);
      expr = Expression();
      jj_consume_token(RBRACKET);
        {if (true) return NodeFacade.ArrayAccessExpression(scope, expr);}
      break;
    case DOT:
      jj_consume_token(DOT);
      identifierName = IdentifierName();
        {if (true) return NodeFacade.FieldAccessExpression(scope, identifierName);}
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public List<Expression> Arguments() throws ParseException {
  List<Expression> expressions = null;
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      expressions = ArgumentList();
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    {if (true) return expressions;}
    throw new Error("Missing return statement in function");
  }

  final public List<Expression> ArgumentList() throws ParseException {
  List<Expression> expressions = new ArrayList<Expression>();
  Expression expression = null;
    expression = AssignmentExpression();
        expressions.add(expression);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_8;
      }
      jj_consume_token(COMMA);
      expression = AssignmentExpression();
        expressions.add(expression);
    }
    {if (true) return expressions;}
    throw new Error("Missing return statement in function");
  }

  final public Expression NewSuffix(Expression scope) throws ParseException {
  String identifier = null;
  Expression expression = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DOT:
      jj_consume_token(DOT);
      identifier = Identifier();
        {if (true) return NodeFacade.FieldAccessExpression(scope, NodeFacade.IdentifierName(identifier));}
      break;
    case LBRACKET:
      jj_consume_token(LBRACKET);
      expression = Expression();
      jj_consume_token(RBRACKET);
        {if (true) return NodeFacade.ArrayAccessExpression(scope, expression);}
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression AllocationExpression() throws ParseException {
  Expression expression = null;
  List<Expression> arguments = null;
  ObjectLiteral initializer = null;
    jj_consume_token(NEW);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case THIS:
      jj_consume_token(THIS);
        expression = NodeFacade.ThisExpression();
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[21] = jj_gen;
          break label_9;
        }
        expression = NewSuffix(expression);
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        arguments = Arguments();
          expression = NodeFacade.CallExpression(expression, arguments);
        label_10:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACKET:
          case DOT:
            ;
            break;
          default:
            jj_la1[22] = jj_gen;
            break label_10;
          }
          expression = PrimarySuffix(expression);
        }
        break;
      default:
        jj_la1[23] = jj_gen;
        ;
      }
      break;
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GET:
      case SET:
      case IDENTIFIER:
        expression = Name();
        break;
      case TRUE:
      case FALSE:
      case NULL:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
        expression = Literal();
        break;
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACKET:
        case DOT:
          ;
          break;
        default:
          jj_la1[25] = jj_gen;
          break label_11;
        }
        expression = NewSuffix(expression);
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        arguments = Arguments();
          expression = NodeFacade.CallExpression(expression, arguments);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
          initializer = ObjectLiteral();
          break;
        default:
          jj_la1[26] = jj_gen;
          ;
        }
        label_12:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACKET:
          case DOT:
            ;
            break;
          default:
            jj_la1[27] = jj_gen;
            break label_12;
          }
          expression = PrimarySuffix(expression);
        }
        break;
      default:
        jj_la1[28] = jj_gen;
        ;
      }
      break;
    case LPAREN:
      expression = EnclosedExpression();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        arguments = Arguments();
          expression = NodeFacade.CallExpression(expression, arguments);
        label_13:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACKET:
          case DOT:
            ;
            break;
          default:
            jj_la1[29] = jj_gen;
            break label_13;
          }
          expression = PrimarySuffix(expression);
        }
        break;
      default:
        jj_la1[30] = jj_gen;
        ;
      }
      break;
    case NEW:
      expression = AllocationExpression();
      break;
    case FUNCTION:
      expression = FunctionExpression();
      break;
    default:
      jj_la1[31] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return NodeFacade.NewExpression(expression, initializer);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayLiteral ArrayLiteral() throws ParseException {
  List<Expression> expressions = new ArrayList<Expression>();
  Expression expression = null;
    jj_consume_token(LBRACKET);
        expression = NodeFacade.EmptyLiteral();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      expression = AssignmentExpression();
      break;
    default:
      jj_la1[32] = jj_gen;
      ;
    }
        expressions.add(expression);
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[33] = jj_gen;
        break label_14;
      }
      jj_consume_token(COMMA);
        expression = NodeFacade.EmptyLiteral();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DELETE:
      case FUNCTION:
      case NEW:
      case THIS:
      case TYPEOF:
      case VOID:
      case SUPER:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case BANG:
      case TILDE:
      case INCR:
      case NL_INCR:
      case DECR:
      case NL_DECR:
      case PLUS:
      case MINUS:
      case REM:
        expression = AssignmentExpression();
        break;
      default:
        jj_la1[34] = jj_gen;
        ;
      }
        expressions.add(expression);
    }
    jj_consume_token(RBRACKET);
    if(expressions.size() == 1 && expression instanceof EmptyLiteral)
    {
      expressions.clear();
    }
    if (expressions.isEmpty())
    {
      expressions = null;
    }
    {if (true) return NodeFacade.ArrayLiteral(expressions);}
    throw new Error("Missing return statement in function");
  }

  final public ObjectLiteral ObjectLiteral() throws ParseException {
  List<PropertyAssignment> assignments = new ArrayList<PropertyAssignment>();
    jj_consume_token(LBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case DELETE:
    case ELSE:
    case FOR:
    case FUNCTION:
    case IF:
    case IN:
    case NEW:
    case RETURN:
    case THIS:
    case TYPEOF:
    case VAR:
    case VOID:
    case WHILE:
    case WITH:
    case CASE:
    case CATCH:
    case CLASS:
    case CONST:
    case DEBUGGER:
    case _DEFAULT:
    case DO:
    case ENUM:
    case EXPORT:
    case EXTENDS:
    case FINALLY:
    case IMPORT:
    case SUPER:
    case SWITCH:
    case THROW:
    case TRY:
    case INSTANCEOF:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
      PropertyNameAndValueList(assignments);
      break;
    default:
      jj_la1[35] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
    {if (true) return NodeFacade.ObjectLiteral(assignments.size() != 0? assignments : null);}
    throw new Error("Missing return statement in function");
  }

  final public void PropertyNameAndValueList(List<PropertyAssignment> assignments) throws ParseException {
  PropertyAssignment assignment = null;
    assignment = PropertyAssignment();
      assignments.add(assignment);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BREAK:
      case CONTINUE:
      case DELETE:
      case ELSE:
      case FOR:
      case FUNCTION:
      case IF:
      case IN:
      case NEW:
      case RETURN:
      case THIS:
      case TYPEOF:
      case VAR:
      case VOID:
      case WHILE:
      case WITH:
      case CASE:
      case CATCH:
      case CLASS:
      case CONST:
      case DEBUGGER:
      case _DEFAULT:
      case DO:
      case ENUM:
      case EXPORT:
      case EXTENDS:
      case FINALLY:
      case IMPORT:
      case SUPER:
      case SWITCH:
      case THROW:
      case TRY:
      case INSTANCEOF:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
        PropertyNameAndValueList(assignments);
        break;
      default:
        jj_la1[36] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[37] = jj_gen;
      ;
    }
  }

  final public PropertyAssignment PropertyAssignment() throws ParseException {
  PropertyName propertyName = null;
  Block block = null;
  String identifier = null;
  Expression expression = null;
    if (jj_2_1(2147483647)) {
      jj_consume_token(GET);
      propertyName = PropertyName();
      jj_consume_token(LPAREN);
      jj_consume_token(RPAREN);
      block = Block();
        {if (true) return NodeFacade.GetAssignment(propertyName, block);}
    } else if (jj_2_2(2147483647)) {
      jj_consume_token(SET);
      propertyName = PropertyName();
      jj_consume_token(LPAREN);
      identifier = Identifier();
      jj_consume_token(RPAREN);
      block = Block();
        {if (true) return NodeFacade.SetAssignment(propertyName, identifier, block);}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BREAK:
      case CONTINUE:
      case DELETE:
      case ELSE:
      case FOR:
      case FUNCTION:
      case IF:
      case IN:
      case NEW:
      case RETURN:
      case THIS:
      case TYPEOF:
      case VAR:
      case VOID:
      case WHILE:
      case WITH:
      case CASE:
      case CATCH:
      case CLASS:
      case CONST:
      case DEBUGGER:
      case _DEFAULT:
      case DO:
      case ENUM:
      case EXPORT:
      case EXTENDS:
      case FINALLY:
      case IMPORT:
      case SUPER:
      case SWITCH:
      case THROW:
      case TRY:
      case INSTANCEOF:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
        propertyName = PropertyName();
        jj_consume_token(COLON);
        expression = AssignmentExpression();
        {if (true) return NodeFacade.PutAssignment(propertyName, expression);}
        break;
      default:
        jj_la1[38] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public PropertyName PropertyName() throws ParseException {
   PropertyName propertyName = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case DELETE:
    case ELSE:
    case FOR:
    case FUNCTION:
    case IF:
    case IN:
    case NEW:
    case RETURN:
    case THIS:
    case TYPEOF:
    case VAR:
    case VOID:
    case WHILE:
    case WITH:
    case CASE:
    case CATCH:
    case CLASS:
    case CONST:
    case DEBUGGER:
    case _DEFAULT:
    case DO:
    case ENUM:
    case EXPORT:
    case EXTENDS:
    case FINALLY:
    case IMPORT:
    case SUPER:
    case SWITCH:
    case THROW:
    case TRY:
    case INSTANCEOF:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case IDENTIFIER:
      propertyName = IdentifierName();
      break;
    case STRING_LITERAL:
      propertyName = StringLiteral();
      break;
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
      propertyName = NumericLiteral();
      break;
    default:
      jj_la1[39] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return propertyName;}
    throw new Error("Missing return statement in function");
  }

  final public StringLiteral StringLiteral() throws ParseException {
    jj_consume_token(STRING_LITERAL);
    if (token.image.charAt(0) == '\u005c'')
    {
      {if (true) return NodeFacade.StringLiteralSingle(token.image.substring(1, token.image.length() - 1));}
    } else
    {
      {if (true) return NodeFacade.StringLiteralDouble(token.image.substring(1, token.image.length() - 1));}
    }
    throw new Error("Missing return statement in function");
  }

  final public UnaryExpression.UnaryOperator PostfixOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INCR:
      jj_consume_token(INCR);
       {if (true) return UnaryExpression.UnaryOperator.posIncrement;}
      break;
    case DECR:
      jj_consume_token(DECR);
       {if (true) return UnaryExpression.UnaryOperator.posDecrement;}
      break;
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression PostfixExpression() throws ParseException {
  Expression expression = null;
  UnaryExpression.UnaryOperator operator = null;
    expression = PrimaryExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INCR:
    case DECR:
      operator = PostfixOp();
      break;
    default:
      jj_la1[41] = jj_gen;
      ;
    }
    if(operator == null) {
      {if (true) return expression;}
    } else {
      {if (true) return NodeFacade.UnaryExpression(expression, operator);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression PostfixExpressionInES() throws ParseException {
  Expression expression = null;
  UnaryExpression.UnaryOperator operator = null;
    expression = PrimaryExpressionInES();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INCR:
    case DECR:
      operator = PostfixOp();
      break;
    default:
      jj_la1[42] = jj_gen;
      ;
    }
    if(operator == null) {
      {if (true) return expression;}
    } else {
      {if (true) return NodeFacade.UnaryExpression(expression, operator);}
    }
    throw new Error("Missing return statement in function");
  }

  final public UnaryExpression.UnaryOperator UnaryOp() throws ParseException {
  UnaryExpression.UnaryOperator operator = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case REM:
      jj_consume_token(REM);
        operator = UnaryExpression.UnaryOperator.rem;
      break;
    case DELETE:
      jj_consume_token(DELETE);
        operator = UnaryExpression.UnaryOperator.delete;
      break;
    case VOID:
      jj_consume_token(VOID);
        operator = UnaryExpression.UnaryOperator.opVoid;
      break;
    case TYPEOF:
      jj_consume_token(TYPEOF);
        operator = UnaryExpression.UnaryOperator.typeof;
      break;
    case INCR:
      jj_consume_token(INCR);
        operator = UnaryExpression.UnaryOperator.preIncrement;
      break;
    case NL_INCR:
      jj_consume_token(NL_INCR);
        operator = UnaryExpression.UnaryOperator.preIncrement;
      break;
    case DECR:
      jj_consume_token(DECR);
        operator = UnaryExpression.UnaryOperator.preDecrement;
      break;
    case NL_DECR:
      jj_consume_token(NL_DECR);
        operator = UnaryExpression.UnaryOperator.preDecrement;
      break;
    case PLUS:
      jj_consume_token(PLUS);
        operator = UnaryExpression.UnaryOperator.positive;
      break;
    case MINUS:
      jj_consume_token(MINUS);
        operator = UnaryExpression.UnaryOperator.negative;
      break;
    case TILDE:
      jj_consume_token(TILDE);
        operator = UnaryExpression.UnaryOperator.inverse;
      break;
    case BANG:
      jj_consume_token(BANG);
        operator = UnaryExpression.UnaryOperator.not;
      break;
    default:
      jj_la1[43] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return operator;}
    throw new Error("Missing return statement in function");
  }

  final public Expression UnaryExpression() throws ParseException {
  Expression expression = null;
  UnaryExpression.UnaryOperator operator = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
    case NEW:
    case THIS:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
      expression = PostfixExpression();
    {if (true) return expression;}
      break;
    case DELETE:
    case TYPEOF:
    case VOID:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      operator = UnaryOp();
      expression = UnaryExpression();
   {if (true) return NodeFacade.UnaryExpression(expression, operator);}
      break;
    default:
      jj_la1[44] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression UnaryExpressionInES() throws ParseException {
  Expression expression = null;
  UnaryExpression.UnaryOperator operator = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NEW:
    case THIS:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACKET:
      expression = PostfixExpressionInES();
    {if (true) return expression;}
      break;
    case DELETE:
    case TYPEOF:
    case VOID:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      operator = UnaryOp();
      expression = UnaryExpression();
    {if (true) return NodeFacade.UnaryExpression(expression, operator);}
      break;
    default:
      jj_la1[45] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator MulOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STAR:
      jj_consume_token(STAR);
        {if (true) return BinaryExpression.BinaryOperator.times;}
      break;
    case SLASH:
      jj_consume_token(SLASH);
        {if (true) return BinaryExpression.BinaryOperator.divide;}
      break;
    case REM:
      jj_consume_token(REM);
        {if (true) return BinaryExpression.BinaryOperator.remainder;}
      break;
    default:
      jj_la1[46] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression MultiplicativeExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = UnaryExpression();
    label_15:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
      case REM:
        ;
        break;
      default:
        jj_la1[47] = jj_gen;
        break label_15;
      }
      operator = MulOp();
      right = UnaryExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression MultiplicativeExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = UnaryExpressionInES();
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
      case REM:
        ;
        break;
      default:
        jj_la1[48] = jj_gen;
        break label_16;
      }
      operator = MulOp();
      right = UnaryExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator AddOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
        {if (true) return BinaryExpression.BinaryOperator.plus;}
      break;
    case MINUS:
      jj_consume_token(MINUS);
      {if (true) return BinaryExpression.BinaryOperator.minus;}
      break;
    default:
      jj_la1[49] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression AdditiveExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = MultiplicativeExpression();
    label_17:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[50] = jj_gen;
        break label_17;
      }
      operator = AddOp();
      right = MultiplicativeExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression AdditiveExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = MultiplicativeExpressionInES();
    label_18:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[51] = jj_gen;
        break label_18;
      }
      operator = AddOp();
      right = MultiplicativeExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator ShiftOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LSHIFT:
      jj_consume_token(LSHIFT);
       {if (true) return BinaryExpression.BinaryOperator.lShift;}
      break;
    case RSIGNEDSHIFT:
      jj_consume_token(RSIGNEDSHIFT);
       {if (true) return BinaryExpression.BinaryOperator.rSignedShift;}
      break;
    case RUNSIGNEDSHIFT:
      jj_consume_token(RUNSIGNEDSHIFT);
       {if (true) return BinaryExpression.BinaryOperator.rUnsignedShift;}
      break;
    default:
      jj_la1[52] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression ShiftExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = AdditiveExpression();
    label_19:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LSHIFT:
      case RSIGNEDSHIFT:
      case RUNSIGNEDSHIFT:
        ;
        break;
      default:
        jj_la1[53] = jj_gen;
        break label_19;
      }
      operator = ShiftOp();
      right = AdditiveExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression ShiftExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = AdditiveExpressionInES();
    label_20:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LSHIFT:
      case RSIGNEDSHIFT:
      case RUNSIGNEDSHIFT:
        ;
        break;
      default:
        jj_la1[54] = jj_gen;
        break label_20;
      }
      operator = ShiftOp();
      right = AdditiveExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator RelOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LT:
      jj_consume_token(LT);
      {if (true) return BinaryExpression.BinaryOperator.less;}
      break;
    case GT:
      jj_consume_token(GT);
      {if (true) return BinaryExpression.BinaryOperator.greater;}
      break;
    case LE:
      jj_consume_token(LE);
      {if (true) return BinaryExpression.BinaryOperator.lessEquals;}
      break;
    case GE:
      jj_consume_token(GE);
      {if (true) return BinaryExpression.BinaryOperator.greaterEquals;}
      break;
    case IN:
      jj_consume_token(IN);
      {if (true) return BinaryExpression.BinaryOperator.in;}
      break;
    case INSTANCEOF:
      jj_consume_token(INSTANCEOF);
      {if (true) return BinaryExpression.BinaryOperator.opInstanceof;}
      break;
    default:
      jj_la1[55] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator RelOpNoIn() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LT:
      jj_consume_token(LT);
      {if (true) return BinaryExpression.BinaryOperator.less;}
      break;
    case GT:
      jj_consume_token(GT);
      {if (true) return BinaryExpression.BinaryOperator.greater;}
      break;
    case LE:
      jj_consume_token(LE);
      {if (true) return BinaryExpression.BinaryOperator.lessEquals;}
      break;
    case GE:
      jj_consume_token(GE);
      {if (true) return BinaryExpression.BinaryOperator.greaterEquals;}
      break;
    case INSTANCEOF:
      jj_consume_token(INSTANCEOF);
      {if (true) return BinaryExpression.BinaryOperator.opInstanceof;}
      break;
    default:
      jj_la1[56] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression RelationalExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = ShiftExpression();
    label_21:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IN:
      case INSTANCEOF:
      case GT:
      case LT:
      case LE:
      case GE:
        ;
        break;
      default:
        jj_la1[57] = jj_gen;
        break label_21;
      }
      operator = RelOp();
      right = ShiftExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression RelationalExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = ShiftExpression();
    label_22:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INSTANCEOF:
      case GT:
      case LT:
      case LE:
      case GE:
        ;
        break;
      default:
        jj_la1[58] = jj_gen;
        break label_22;
      }
      operator = RelOpNoIn();
      right = ShiftExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression RelationalExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = ShiftExpressionInES();
    label_23:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IN:
      case INSTANCEOF:
      case GT:
      case LT:
      case LE:
      case GE:
        ;
        break;
      default:
        jj_la1[59] = jj_gen;
        break label_23;
      }
      operator = RelOp();
      right = ShiftExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator EqualOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      jj_consume_token(EQ);
      {if (true) return BinaryExpression.BinaryOperator.equals;}
      break;
    case NE:
      jj_consume_token(NE);
      {if (true) return BinaryExpression.BinaryOperator.notEquals;}
      break;
    case STRICT_EQ:
      jj_consume_token(STRICT_EQ);
      {if (true) return BinaryExpression.BinaryOperator.identity;}
      break;
    case STRICT_NEQ:
      jj_consume_token(STRICT_NEQ);
      {if (true) return BinaryExpression.BinaryOperator.notIdentity;}
      break;
    default:
      jj_la1[60] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression EqualityExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = RelationalExpression();
    label_24:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRICT_EQ:
      case STRICT_NEQ:
      case EQ:
      case NE:
        ;
        break;
      default:
        jj_la1[61] = jj_gen;
        break label_24;
      }
      operator = EqualOp();
      right = RelationalExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression EqualityExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = RelationalExpressionNoIn();
    label_25:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRICT_EQ:
      case STRICT_NEQ:
      case EQ:
      case NE:
        ;
        break;
      default:
        jj_la1[62] = jj_gen;
        break label_25;
      }
      operator = EqualOp();
      right = RelationalExpressionNoIn();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression EqualityExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = RelationalExpressionInES();
    label_26:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRICT_EQ:
      case STRICT_NEQ:
      case EQ:
      case NE:
        ;
        break;
      default:
        jj_la1[63] = jj_gen;
        break label_26;
      }
      operator = EqualOp();
      right = RelationalExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator BitwiseANDOp() throws ParseException {
    jj_consume_token(BIT_AND);
    {if (true) return BinaryExpression.BinaryOperator.binAnd;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseANDExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = EqualityExpression();
    label_27:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_AND:
        ;
        break;
      default:
        jj_la1[64] = jj_gen;
        break label_27;
      }
      operator = BitwiseANDOp();
      right = EqualityExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseANDExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = EqualityExpressionNoIn();
    label_28:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_AND:
        ;
        break;
      default:
        jj_la1[65] = jj_gen;
        break label_28;
      }
      operator = BitwiseANDOp();
      right = EqualityExpressionNoIn();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseANDExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = EqualityExpressionInES();
    label_29:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_AND:
        ;
        break;
      default:
        jj_la1[66] = jj_gen;
        break label_29;
      }
      operator = BitwiseANDOp();
      right = EqualityExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator BitwiseXOROp() throws ParseException {
    jj_consume_token(XOR);
    {if (true) return BinaryExpression.BinaryOperator.xor;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseXORExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = BitwiseANDExpression();
    label_30:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case XOR:
        ;
        break;
      default:
        jj_la1[67] = jj_gen;
        break label_30;
      }
      operator = BitwiseXOROp();
      right = BitwiseANDExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseXORExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = BitwiseANDExpressionNoIn();
    label_31:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case XOR:
        ;
        break;
      default:
        jj_la1[68] = jj_gen;
        break label_31;
      }
      operator = BitwiseXOROp();
      right = BitwiseANDExpressionNoIn();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseXORExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = BitwiseANDExpressionInES();
    label_32:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case XOR:
        ;
        break;
      default:
        jj_la1[69] = jj_gen;
        break label_32;
      }
      operator = BitwiseXOROp();
      right = BitwiseANDExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public BinaryExpression.BinaryOperator BitwiseOROp() throws ParseException {
    jj_consume_token(BIT_OR);
    {if (true) return BinaryExpression.BinaryOperator.or;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseORExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = BitwiseXORExpression();
    label_33:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_OR:
        ;
        break;
      default:
        jj_la1[70] = jj_gen;
        break label_33;
      }
      operator = BitwiseOROp();
      right = BitwiseXORExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseORExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = BitwiseXORExpressionNoIn();
    label_34:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_OR:
        ;
        break;
      default:
        jj_la1[71] = jj_gen;
        break label_34;
      }
      operator = BitwiseOROp();
      right = BitwiseXORExpressionNoIn();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression BitwiseORExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = BitwiseXORExpressionInES();
    label_35:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT_OR:
        ;
        break;
      default:
        jj_la1[72] = jj_gen;
        break label_35;
      }
      operator = BitwiseOROp();
      right = BitwiseXORExpression();
        result = NodeFacade.BinaryExpression(result, right, operator);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression LogicalANDExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
    result = BitwiseORExpression();
    label_36:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_AND:
        ;
        break;
      default:
        jj_la1[73] = jj_gen;
        break label_36;
      }
      jj_consume_token(SC_AND);
      right = BitwiseORExpression();
        result = NodeFacade.BinaryExpression(result, right, BinaryExpression.BinaryOperator.and);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression LogicalANDExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
    result = BitwiseORExpressionNoIn();
    label_37:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_AND:
        ;
        break;
      default:
        jj_la1[74] = jj_gen;
        break label_37;
      }
      jj_consume_token(SC_AND);
      right = BitwiseORExpressionNoIn();
        result = NodeFacade.BinaryExpression(result, right, BinaryExpression.BinaryOperator.and);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression LogicalANDExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
    result = BitwiseORExpressionInES();
    label_38:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_AND:
        ;
        break;
      default:
        jj_la1[75] = jj_gen;
        break label_38;
      }
      jj_consume_token(SC_AND);
      right = BitwiseORExpression();
        result = NodeFacade.BinaryExpression(result, right, BinaryExpression.BinaryOperator.and);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression LogicalORExpression() throws ParseException {
  Expression result = null;
  Expression right = null;
  BinaryExpression.BinaryOperator operator = null;
    result = LogicalANDExpression();
    label_39:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_OR:
        ;
        break;
      default:
        jj_la1[76] = jj_gen;
        break label_39;
      }
      jj_consume_token(SC_OR);
      right = LogicalANDExpression();
        result = NodeFacade.BinaryExpression(result, right, BinaryExpression.BinaryOperator.or);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression LogicalORExpressionNoIn() throws ParseException {
  Expression result = null;
  Expression right = null;
    result = LogicalANDExpressionNoIn();
    label_40:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_OR:
        ;
        break;
      default:
        jj_la1[77] = jj_gen;
        break label_40;
      }
      jj_consume_token(SC_OR);
      right = LogicalANDExpressionNoIn();
        result = NodeFacade.BinaryExpression(result, right, BinaryExpression.BinaryOperator.or);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression LogicalORExpressionInES() throws ParseException {
  Expression result = null;
  Expression right = null;
    result = LogicalANDExpressionInES();
    label_41:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SC_OR:
        ;
        break;
      default:
        jj_la1[78] = jj_gen;
        break label_41;
      }
      jj_consume_token(SC_OR);
      right = LogicalANDExpression();
        result = NodeFacade.BinaryExpression(result, right, BinaryExpression.BinaryOperator.or);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Expression ConditionalExpression() throws ParseException {
  Expression condition = null;
  Expression thenExpr = null;
  Expression elseExpr = null;
    condition = LogicalORExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case HOOK:
      jj_consume_token(HOOK);
      thenExpr = Expression();
      jj_consume_token(COLON);
      elseExpr = ConditionalExpression();
      break;
    default:
      jj_la1[79] = jj_gen;
      ;
    }
    if (thenExpr == null) {
      {if (true) return condition;}
    } else {
      {if (true) return NodeFacade.ConditionalExpression(condition, thenExpr, elseExpr);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression ConditionalExpressionNoIn() throws ParseException {
  Expression condition = null;
  Expression thenExpr = null;
  Expression elseExpr = null;
    condition = LogicalORExpressionNoIn();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case HOOK:
      jj_consume_token(HOOK);
      thenExpr = Expression();
      jj_consume_token(COLON);
      elseExpr = ConditionalExpressionNoIn();
      break;
    default:
      jj_la1[80] = jj_gen;
      ;
    }
    if (thenExpr == null) {
      {if (true) return condition;}
    } else {
      {if (true) return NodeFacade.ConditionalExpression(condition, thenExpr, elseExpr);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression ConditionalExpressionInES() throws ParseException {
  Expression condition = null;
  Expression thenExpr = null;
  Expression elseExpr = null;
    condition = LogicalORExpressionInES();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case HOOK:
      jj_consume_token(HOOK);
      thenExpr = Expression();
      jj_consume_token(COLON);
      elseExpr = ConditionalExpression();
      break;
    default:
      jj_la1[81] = jj_gen;
      ;
    }
    if (thenExpr == null) {
      {if (true) return condition;}
    } else {
      {if (true) return NodeFacade.ConditionalExpression(condition, thenExpr, elseExpr);}
    }
    throw new Error("Missing return statement in function");
  }

  final public AssignmentExpression.AssignOperator AssignementOperator() throws ParseException {
  AssignmentExpression.AssignOperator operator = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      jj_consume_token(ASSIGN);
        operator = AssignmentExpression.AssignOperator.assign;
      break;
    case STARASSIGN:
      jj_consume_token(STARASSIGN);
        operator = AssignmentExpression.AssignOperator.star;
      break;
    case SLASHASSIGN:
      jj_consume_token(SLASHASSIGN);
        operator = AssignmentExpression.AssignOperator.slash;
      break;
    case REMASSIGN:
      jj_consume_token(REMASSIGN);
        operator = AssignmentExpression.AssignOperator.rem;
      break;
    case PLUSASSIGN:
      jj_consume_token(PLUSASSIGN);
        operator = AssignmentExpression.AssignOperator.plus;
      break;
    case MINUSASSIGN:
      jj_consume_token(MINUSASSIGN);
        operator = AssignmentExpression.AssignOperator.minus;
      break;
    case LSHIFTASSIGN:
      jj_consume_token(LSHIFTASSIGN);
        operator = AssignmentExpression.AssignOperator.lShift;
      break;
    case RSIGNEDSHIFTASSIGN:
      jj_consume_token(RSIGNEDSHIFTASSIGN);
        operator = AssignmentExpression.AssignOperator.rSignedShift;
      break;
    case RUNSIGNEDSHIFTASSIGN:
      jj_consume_token(RUNSIGNEDSHIFTASSIGN);
        operator = AssignmentExpression.AssignOperator.rUnsignedShift;
      break;
    case ANDASSIGN:
      jj_consume_token(ANDASSIGN);
        operator = AssignmentExpression.AssignOperator.and;
      break;
    case XORASSIGN:
      jj_consume_token(XORASSIGN);
        operator = AssignmentExpression.AssignOperator.xor;
      break;
    case ORASSIGN:
      jj_consume_token(ORASSIGN);
        operator = AssignmentExpression.AssignOperator.or;
      break;
    default:
      jj_la1[82] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return operator;}
    throw new Error("Missing return statement in function");
  }

  final public Expression AssignmentExpression() throws ParseException {
  AssignmentExpression.AssignOperator operator = null;
  Expression left = null;
  Expression right = null;
    left = ConditionalExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
    case PLUSASSIGN:
    case MINUSASSIGN:
    case STARASSIGN:
    case SLASHASSIGN:
    case ANDASSIGN:
    case ORASSIGN:
    case XORASSIGN:
    case REMASSIGN:
    case LSHIFTASSIGN:
    case RSIGNEDSHIFTASSIGN:
    case RUNSIGNEDSHIFTASSIGN:
      operator = AssignementOperator();
      right = AssignmentExpression();
      break;
    default:
      jj_la1[83] = jj_gen;
      ;
    }
    if(operator == null)
    {
      {if (true) return left;}
    } else
    {
      {if (true) return NodeFacade.AssignmentExpression(left, right, operator);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression AssignmentExpressionNoIn() throws ParseException {
  AssignmentExpression.AssignOperator operator = null;
  Expression left = null;
  Expression right = null;
    left = ConditionalExpressionNoIn();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
    case PLUSASSIGN:
    case MINUSASSIGN:
    case STARASSIGN:
    case SLASHASSIGN:
    case ANDASSIGN:
    case ORASSIGN:
    case XORASSIGN:
    case REMASSIGN:
    case LSHIFTASSIGN:
    case RSIGNEDSHIFTASSIGN:
    case RUNSIGNEDSHIFTASSIGN:
      operator = AssignementOperator();
      right = AssignmentExpressionNoIn();
      break;
    default:
      jj_la1[84] = jj_gen;
      ;
    }
    if(operator == null)
    {
      {if (true) return left;}
    } else
    {
      {if (true) return NodeFacade.AssignmentExpression(left, right, operator);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression AssignmentExpressionInES() throws ParseException {
  AssignmentExpression.AssignOperator operator = null;
  Expression left = null;
  Expression right = null;
    left = ConditionalExpressionInES();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
    case PLUSASSIGN:
    case MINUSASSIGN:
    case STARASSIGN:
    case SLASHASSIGN:
    case ANDASSIGN:
    case ORASSIGN:
    case XORASSIGN:
    case REMASSIGN:
    case LSHIFTASSIGN:
    case RSIGNEDSHIFTASSIGN:
    case RUNSIGNEDSHIFTASSIGN:
      operator = AssignementOperator();
      right = AssignmentExpression();
      break;
    default:
      jj_la1[85] = jj_gen;
      ;
    }
    if(operator == null)
    {
      {if (true) return left;}
    } else
    {
      {if (true) return NodeFacade.AssignmentExpression(left, right, operator);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression Expression() throws ParseException {
  Expression expression = null;
  List<Expression> expressions = new ArrayList<Expression>();
    expression = AssignmentExpression();
      expressions.add(expression);
    label_42:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[86] = jj_gen;
        break label_42;
      }
      jj_consume_token(COMMA);
      expression = AssignmentExpression();
        expressions.add(expression);
    }
    if(expressions.size() == 1)
    {
      {if (true) return expression;}
    } else
    {
      {if (true) return NodeFacade.SequenceExpression(expressions);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression ExpressionNoIn() throws ParseException {
  Expression expression = null;
  List<Expression> expressions = new ArrayList<Expression>();
    expression = AssignmentExpressionNoIn();
      expressions.add(expression);
    label_43:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[87] = jj_gen;
        break label_43;
      }
      jj_consume_token(COMMA);
      expression = AssignmentExpressionNoIn();
        expressions.add(expression);
    }
    if(expressions.size() == 1)
    {
      {if (true) return expression;}
    } else
    {
      {if (true) return NodeFacade.SequenceExpression(expressions);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression ExpressionInES() throws ParseException {
  Expression expression = null;
  List<Expression> expressions = new ArrayList<Expression>();
    expression = AssignmentExpressionInES();
      expressions.add(expression);
    label_44:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[88] = jj_gen;
        break label_44;
      }
      jj_consume_token(COMMA);
      expression = AssignmentExpression();
        expressions.add(expression);
    }
    if(expressions.size() == 1)
    {
      {if (true) return expression;}
    } else
    {
      {if (true) return NodeFacade.SequenceExpression(expressions);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Statement Statement() throws ParseException {
  Statement statement = null;
    pushJSDoc();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      statement = Block();
      break;
    case LET:
      statement = LetStatement();
      break;
    case DEBUGGER:
      statement = DebuggerStatement();
      break;
    case CONST:
      statement = ConstantStatement();
      break;
    case VAR:
      statement = VariableStatement();
      break;
    case SEMICOLON:
      statement = EmptyStatement();
      break;
    case DELETE:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      statement = ExpressionOrLabelledStatement();
      break;
    case IF:
      statement = IfStatement();
      break;
    case FOR:
    case WHILE:
    case DO:
      statement = IterationStatement();
      break;
    case CONTINUE:
      statement = ContinueStatement();
      break;
    case BREAK:
      statement = BreakStatement();
      break;
    case RETURN:
      statement = ReturnStatement();
      break;
    case WITH:
      statement = WithStatement();
      break;
    case TRY:
      statement = TryStatement();
      break;
    case THROW:
      statement = ThrowStatement();
      break;
    case SWITCH:
      statement = SwitchStatement();
      break;
    default:
      jj_la1[89] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return statement;}
    throw new Error("Missing return statement in function");
  }

  final public Block Block() throws ParseException {
  List< Statement > statements = null;
    if (jj_2_3(3)) {
      jj_consume_token(LBRACE);
      jj_consume_token(RBRACE);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
        jj_consume_token(LBRACE);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BREAK:
        case CONTINUE:
        case DELETE:
        case FOR:
        case FUNCTION:
        case IF:
        case NEW:
        case RETURN:
        case THIS:
        case TYPEOF:
        case VAR:
        case VOID:
        case WHILE:
        case WITH:
        case CONST:
        case DEBUGGER:
        case DO:
        case SUPER:
        case SWITCH:
        case THROW:
        case TRY:
        case TRUE:
        case FALSE:
        case NULL:
        case GET:
        case SET:
        case LET:
        case DECIMAL_LITERAL:
        case HEX_LITERAL:
        case OCTAL_LITERAL:
        case FLOATING_POINT_LITERAL:
        case STRING_LITERAL:
        case UNTERMINATED_STRING_LITERAL:
        case REGULAR_EXPRESSION_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case LBRACE:
        case LBRACKET:
        case SEMICOLON:
        case BANG:
        case TILDE:
        case INCR:
        case NL_INCR:
        case DECR:
        case NL_DECR:
        case PLUS:
        case MINUS:
        case REM:
          statements = StatementList();
          break;
        default:
          jj_la1[90] = jj_gen;
          ;
        }
        jj_consume_token(RBRACE);
        break;
      default:
        jj_la1[91] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return NodeFacade.Block(statements);}
    throw new Error("Missing return statement in function");
  }

  final public Statement LetStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
  Statement statement = null;
  boolean definition = false;
    jj_consume_token(LET);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GET:
    case SET:
    case IDENTIFIER:
      declarations = VariableDeclaratorList();
        definition = true;
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      declarations = VariableDeclaratorList();
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BREAK:
      case CONTINUE:
      case DELETE:
      case FOR:
      case IF:
      case NEW:
      case RETURN:
      case THIS:
      case TYPEOF:
      case VAR:
      case VOID:
      case WHILE:
      case WITH:
      case CONST:
      case DEBUGGER:
      case DO:
      case SUPER:
      case SWITCH:
      case THROW:
      case TRY:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case LET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case SEMICOLON:
      case BANG:
      case TILDE:
      case INCR:
      case NL_INCR:
      case DECR:
      case NL_DECR:
      case PLUS:
      case MINUS:
      case REM:
        statement = Statement();
        break;
      default:
        jj_la1[92] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[93] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Sc();
    if (definition) {
      {if (true) return NodeFacade.LetDefinition(popJSDoc(), declarations);}
    } else {
      {if (true) return NodeFacade.LetStatement(popJSDoc(), declarations, statement);}
    }
    throw new Error("Missing return statement in function");
  }

  final public DebuggerStatement DebuggerStatement() throws ParseException {
    jj_consume_token(DEBUGGER);
    Sc();
    {if (true) return NodeFacade.DebuggerStatement(popJSDoc());}
    throw new Error("Missing return statement in function");
  }

  final public ConstantStatement ConstantStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
    jj_consume_token(CONST);
    declarations = VariableDeclaratorList();
    Sc();
    {if (true) return NodeFacade.ConstantStatement(popJSDoc(), declarations);}
    throw new Error("Missing return statement in function");
  }

  final public VariableStatement VariableStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
    jj_consume_token(VAR);
    declarations = VariableDeclaratorList();
    Sc();
    {if (true) return NodeFacade.VariableStatement(popJSDoc(), declarations);}
    throw new Error("Missing return statement in function");
  }

  final public List<VariableDeclaration> VariableDeclaratorList() throws ParseException {
  List<VariableDeclaration> declarations = new ArrayList<VariableDeclaration>();
  VariableDeclaration declaration;
    declaration = VariableDeclaration();
      declarations.add(declaration);
    label_45:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[94] = jj_gen;
        break label_45;
      }
      jj_consume_token(COMMA);
      declaration = VariableDeclaration();
        declarations.add(declaration);
    }
    {if (true) return declarations;}
    throw new Error("Missing return statement in function");
  }

  final public List<VariableDeclaration> VariableDeclaratorListNoIn() throws ParseException {
  List<VariableDeclaration> declarations = new ArrayList<VariableDeclaration>();
  VariableDeclaration declaration;
    declaration = VariableDeclarationNoIn();
      declarations.add(declaration);
    label_46:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[95] = jj_gen;
        break label_46;
      }
      jj_consume_token(COMMA);
      declaration = VariableDeclarationNoIn();
        declarations.add(declaration);
    }
    {if (true) return declarations;}
    throw new Error("Missing return statement in function");
  }

  final public VariableDeclaration VariableDeclaration() throws ParseException {
  String name = null;
  Expression expression = null;
    name = Identifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      expression = Initializer();
      break;
    default:
      jj_la1[96] = jj_gen;
      ;
    }
    {if (true) return NodeFacade.VariableDeclaration(name, expression);}
    throw new Error("Missing return statement in function");
  }

  final public Expression Initializer() throws ParseException {
  Expression expression = null;
    jj_consume_token(ASSIGN);
    expression = AssignmentExpression();
    {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public VariableDeclaration VariableDeclarationNoIn() throws ParseException {
  String name = null;
  Expression expression = null;
    name = Identifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      expression = InitializerNoIn();
      break;
    default:
      jj_la1[97] = jj_gen;
      ;
    }
    {if (true) return NodeFacade.VariableDeclaration(name, expression);}
    throw new Error("Missing return statement in function");
  }

  final public Expression InitializerNoIn() throws ParseException {
  Expression expression = null;
    jj_consume_token(ASSIGN);
    expression = AssignmentExpressionNoIn();
    {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public EmptyStatement EmptyStatement() throws ParseException {
    jj_consume_token(SEMICOLON);
      {if (true) return NodeFacade.EmptyStatement(popJSDoc());}
    throw new Error("Missing return statement in function");
  }

  final public Statement ExpressionOrLabelledStatement() throws ParseException {
  Statement statement = null;
  Expression expression = null;
    if (jj_2_4(2147483647)) {
      statement = LabelledStatement();
      {if (true) return statement;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DELETE:
      case NEW:
      case THIS:
      case TYPEOF:
      case VOID:
      case SUPER:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACKET:
      case BANG:
      case TILDE:
      case INCR:
      case NL_INCR:
      case DECR:
      case NL_DECR:
      case PLUS:
      case MINUS:
      case REM:
        expression = ExpressionInES();
        Sc();
      {if (true) return NodeFacade.ExpressionStatement(popJSDoc(), expression);}
        break;
      default:
        jj_la1[98] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public LabelledStatement LabelledStatement() throws ParseException {
  String identifier = null;
  Statement statement = null;
    identifier = Identifier();
    jj_consume_token(COLON);
    statement = Statement();
    {if (true) return NodeFacade.LabelledStatement(popJSDoc(), identifier, statement);}
    throw new Error("Missing return statement in function");
  }

  void Sc() throws ParseException {
    Token tok = getToken(1);
    if (tok.kind == SEMICOLON) {
        tok = getNextToken();
    } else if (tok.specialToken != null) {
        if ((tok.specialToken.kind != EOL) && (tok.specialToken.kind != SINGLE_LINE_COMMENT)) {
            throw generateParseException();
        }
    } else if ((tok.kind != EOF) && (tok.kind != RBRACE)) {
        throw generateParseException();
    }
  }

  final public IfStatement IfStatement() throws ParseException {
  Expression condition = null;
  Statement thenStatement = null;
  Statement elseStatement = null;
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    condition = Expression();
    jj_consume_token(RPAREN);
    thenStatement = Statement();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      elseStatement = Statement();
      break;
    default:
      jj_la1[99] = jj_gen;
      ;
    }
    {if (true) return NodeFacade.IfStatement(popJSDoc(), condition, thenStatement, elseStatement);}
    throw new Error("Missing return statement in function");
  }

  final public Statement IterationStatement() throws ParseException {
  Statement statement = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DO:
      statement = DoWhileStatement();
      break;
    case WHILE:
      statement = WhileStatement();
      break;
    default:
      jj_la1[100] = jj_gen;
      if (jj_2_5(2147483647)) {
        statement = ForStatement();
      } else if (jj_2_6(2147483647)) {
        statement = ForStatement();
      } else if (jj_2_7(2147483647)) {
        statement = ForVarStatement();
      } else if (jj_2_8(2147483647)) {
        statement = ForLetStatement();
      } else if (jj_2_9(3)) {
        statement = ForInStatement();
      } else if (jj_2_10(3)) {
        statement = ForInVarStatement();
      } else if (jj_2_11(3)) {
        statement = ForInLetStatement();
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return statement;}
    throw new Error("Missing return statement in function");
  }

  final public DoWhileStatement DoWhileStatement() throws ParseException {
  Expression condition = null;
  Statement statement = null;
    jj_consume_token(DO);
    statement = Statement();
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    condition = Expression();
    jj_consume_token(RPAREN);
    {if (true) return NodeFacade.DoWhileStatement(popJSDoc(), condition, statement);}
    throw new Error("Missing return statement in function");
  }

  final public WhileStatement WhileStatement() throws ParseException {
  Expression condition = null;
  Statement statement = null;
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    condition = Expression();
    jj_consume_token(RPAREN);
    statement = Statement();
    {if (true) return NodeFacade.WhileStatement(popJSDoc(), condition, statement);}
    throw new Error("Missing return statement in function");
  }

  final public ForStatement ForStatement() throws ParseException {
  Expression variable = null;
  Expression condition = null;
  Expression expr = null;
  Statement body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      variable = ExpressionNoIn();
      break;
    default:
      jj_la1[101] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      condition = Expression();
      break;
    default:
      jj_la1[102] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      expr = Expression();
      break;
    default:
      jj_la1[103] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    body = Statement();
    {if (true) return NodeFacade.ForStatement(popJSDoc(), variable, condition, expr, body);}
    throw new Error("Missing return statement in function");
  }

  final public ForStatement ForVarStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
  Expression condition = null;
  Expression expr = null;
  Statement body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    jj_consume_token(VAR);
    declarations = VariableDeclaratorList();
    jj_consume_token(SEMICOLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      condition = Expression();
      break;
    default:
      jj_la1[104] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      expr = Expression();
      break;
    default:
      jj_la1[105] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    body = Statement();
    VariableExpression var = NodeFacade.VariableExpression(declarations);
    {if (true) return NodeFacade.ForStatement(popJSDoc(), var, condition, expr, body);}
    throw new Error("Missing return statement in function");
  }

  final public ForStatement ForLetStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
  Expression condition = null;
  Expression expr = null;
  Statement body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    jj_consume_token(LET);
    declarations = VariableDeclaratorList();
    jj_consume_token(SEMICOLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      condition = Expression();
      break;
    default:
      jj_la1[106] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      expr = Expression();
      break;
    default:
      jj_la1[107] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    body = Statement();
    LetExpression let = NodeFacade.LetExpression(declarations, null);
    {if (true) return NodeFacade.ForStatement(popJSDoc(), let, condition, expr, body);}
    throw new Error("Missing return statement in function");
  }

  final public ForeachStatement ForInStatement() throws ParseException {
  Expression variable = null;
  Expression expression = null;
  Statement body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    variable = PrimaryExpression();
    jj_consume_token(IN);
    expression = Expression();
    jj_consume_token(RPAREN);
    body = Statement();
    {if (true) return NodeFacade.ForeachStatement(popJSDoc(), variable, expression, body);}
    throw new Error("Missing return statement in function");
  }

  final public ForeachStatement ForInVarStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
  Expression expression = null;
  Statement body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    jj_consume_token(VAR);
    declarations = VariableDeclaratorListNoIn();
    jj_consume_token(IN);
    expression = Expression();
    jj_consume_token(RPAREN);
    body = Statement();
    {if (true) return NodeFacade.ForeachStatement(popJSDoc(), NodeFacade.VariableExpression(declarations), expression, body);}
    throw new Error("Missing return statement in function");
  }

  final public ForeachStatement ForInLetStatement() throws ParseException {
  List<VariableDeclaration> declarations = null;
  Expression expression = null;
  Statement body = null;
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    jj_consume_token(LET);
    declarations = VariableDeclaratorListNoIn();
    jj_consume_token(IN);
    expression = Expression();
    jj_consume_token(RPAREN);
    body = Statement();
    LetExpression let = NodeFacade.LetExpression(declarations, null);
    {if (true) return NodeFacade.ForeachStatement(popJSDoc(), let, expression, body);}
    throw new Error("Missing return statement in function");
  }

  final public ContinueStatement ContinueStatement() throws ParseException {
  String identifier = null;
    jj_consume_token(CONTINUE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NO_SKIP_EOL:
      jj_consume_token(NO_SKIP_EOL);
      break;
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
      break;
    case GET:
    case SET:
    case IDENTIFIER:
      identifier = Identifier();
      Sc();
      break;
    default:
      jj_la1[108] = jj_gen;
      Sc();
    }
      {if (true) return NodeFacade.ContinueStatement(popJSDoc(), identifier);}
    throw new Error("Missing return statement in function");
  }

  final public BreakStatement BreakStatement() throws ParseException {
  String identifier = null;
    jj_consume_token(BREAK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NO_SKIP_EOL:
      jj_consume_token(NO_SKIP_EOL);
      break;
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
      break;
    case GET:
    case SET:
    case IDENTIFIER:
      identifier = Identifier();
      Sc();
      break;
    default:
      jj_la1[109] = jj_gen;
      Sc();
    }
      {if (true) return NodeFacade.BreakStatement(popJSDoc(), identifier);}
    throw new Error("Missing return statement in function");
  }

  final public ReturnStatement ReturnStatement() throws ParseException {
  Expression expression = null;
    jj_consume_token(RETURN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NO_SKIP_EOL:
      jj_consume_token(NO_SKIP_EOL);
      break;
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
      break;
    case DELETE:
    case FUNCTION:
    case NEW:
    case THIS:
    case TYPEOF:
    case VOID:
    case SUPER:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      expression = Expression();
      Sc();
      break;
    default:
      jj_la1[110] = jj_gen;
      Sc();
    }
      {if (true) return NodeFacade.ReturnStatement(popJSDoc(), expression);}
    throw new Error("Missing return statement in function");
  }

  final public WithStatement WithStatement() throws ParseException {
  Statement statement = null;
  Expression expression = null;
    jj_consume_token(WITH);
    jj_consume_token(LPAREN);
    expression = Expression();
    jj_consume_token(RPAREN);
    statement = Statement();
    {if (true) return NodeFacade.WithStatement(popJSDoc(), expression, statement);}
    throw new Error("Missing return statement in function");
  }

  final public TryStatement TryStatement() throws ParseException {
  Block tryBlock = null;
  CatchClause catchClause = null;
  Block finallyBlock = null;
    jj_consume_token(TRY);
    tryBlock = Block();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CATCH:
      catchClause = Catch();
      break;
    default:
      jj_la1[111] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FINALLY:
      finallyBlock = Finally();
      break;
    default:
      jj_la1[112] = jj_gen;
      ;
    }
    {if (true) return NodeFacade.TryStatement(popJSDoc(), tryBlock, catchClause, finallyBlock);}
    throw new Error("Missing return statement in function");
  }

  final public ThrowStatement ThrowStatement() throws ParseException {
  Expression expression = null;
    jj_consume_token(THROW);
    expression = Expression();
    Sc();
    {if (true) return NodeFacade.ThrowStatement(popJSDoc(), expression);}
    throw new Error("Missing return statement in function");
  }

  final public CatchClause Catch() throws ParseException {
  String identifier = null;
  Block block = null;
    jj_consume_token(CATCH);
    jj_consume_token(LPAREN);
    identifier = Identifier();
    jj_consume_token(RPAREN);
    block = Block();
    {if (true) return NodeFacade.CatchClause(identifier, block);}
    throw new Error("Missing return statement in function");
  }

  final public Block Finally() throws ParseException {
  Block block = null;
    jj_consume_token(FINALLY);
    block = Block();
    {if (true) return block;}
    throw new Error("Missing return statement in function");
  }

  final public SwitchStatement SwitchStatement() throws ParseException {
  Expression expression = null;
  List<CaseClause> caseClauses = new ArrayList<CaseClause>();
  CaseClause caseClause = null;
  DefaultClause defaultClause = null;
    jj_consume_token(SWITCH);
    jj_consume_token(LPAREN);
    expression = Expression();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_47:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CASE:
        ;
        break;
      default:
        jj_la1[113] = jj_gen;
        break label_47;
      }
      caseClause = CaseClause();
        caseClauses.add(caseClause);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case _DEFAULT:
      defaultClause = DefaultClause();
      label_48:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CASE:
          ;
          break;
        default:
          jj_la1[114] = jj_gen;
          break label_48;
        }
        caseClause = CaseClause();
          caseClauses.add(caseClause);
      }
      break;
    default:
      jj_la1[115] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
    if(caseClauses.isEmpty())
    {
      caseClauses = null;
    }
    CaseBlock block = NodeFacade.CaseBlock(popJSDoc(), defaultClause, caseClauses);
    {if (true) return NodeFacade.SwitchStatement(popJSDoc(), expression, block);}
    throw new Error("Missing return statement in function");
  }

  final public CaseClause CaseClause() throws ParseException {
  Expression expression = null;
  List<Statement> statements = null;
    jj_consume_token(CASE);
    expression = Expression();
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case DELETE:
    case FOR:
    case FUNCTION:
    case IF:
    case NEW:
    case RETURN:
    case THIS:
    case TYPEOF:
    case VAR:
    case VOID:
    case WHILE:
    case WITH:
    case CONST:
    case DEBUGGER:
    case DO:
    case SUPER:
    case SWITCH:
    case THROW:
    case TRY:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case LET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case SEMICOLON:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      statements = StatementList();
      break;
    default:
      jj_la1[116] = jj_gen;
      ;
    }
    {if (true) return NodeFacade.CaseClause(expression, statements);}
    throw new Error("Missing return statement in function");
  }

  final public DefaultClause DefaultClause() throws ParseException {
  List<Statement> statements = null;
    jj_consume_token(_DEFAULT);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case DELETE:
    case FOR:
    case FUNCTION:
    case IF:
    case NEW:
    case RETURN:
    case THIS:
    case TYPEOF:
    case VAR:
    case VOID:
    case WHILE:
    case WITH:
    case CONST:
    case DEBUGGER:
    case DO:
    case SUPER:
    case SWITCH:
    case THROW:
    case TRY:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case LET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case SEMICOLON:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      statements = StatementList();
      break;
    default:
      jj_la1[117] = jj_gen;
      ;
    }
    {if (true) return NodeFacade.DefaultClause(statements);}
    throw new Error("Missing return statement in function");
  }

  final public FunctionDeclaration FunctionDeclaration() throws ParseException {
  String name = null;
  List<Parameter> parameters = null;
  Block block = null;
    pushJSDoc();
    jj_consume_token(FUNCTION);
    name = Identifier();
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GET:
    case SET:
    case IDENTIFIER:
      parameters = FormalParameterList();
      break;
    default:
      jj_la1[118] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    block = Block();
    {if (true) return NodeFacade.FunctionDeclaration(popJSDoc(), name, parameters, block);}
    throw new Error("Missing return statement in function");
  }

  final public List<Parameter> FormalParameterList() throws ParseException {
  List<Parameter> parameters = new ArrayList<Parameter>();
  String parameter = null;
    parameter = Identifier();
      parameters.add(NodeFacade.Parameter(parameter));
    label_49:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[119] = jj_gen;
        break label_49;
      }
      jj_consume_token(COMMA);
      parameter = Identifier();
        parameters.add(NodeFacade.Parameter(parameter));
    }
    {if (true) return parameters;}
    throw new Error("Missing return statement in function");
  }

  final public CompilationUnit CompilationUnit(String name) throws ParseException {
  List<Statement> elements = new ArrayList <Statement> ();
  Statement element = null;
    label_50:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BREAK:
      case CONTINUE:
      case DELETE:
      case FOR:
      case FUNCTION:
      case IF:
      case NEW:
      case RETURN:
      case THIS:
      case TYPEOF:
      case VAR:
      case VOID:
      case WHILE:
      case WITH:
      case CONST:
      case DEBUGGER:
      case DO:
      case SUPER:
      case SWITCH:
      case THROW:
      case TRY:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case LET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case SEMICOLON:
      case BANG:
      case TILDE:
      case INCR:
      case NL_INCR:
      case DECR:
      case NL_DECR:
      case PLUS:
      case MINUS:
      case REM:
        ;
        break;
      default:
        jj_la1[120] = jj_gen;
        break label_50;
      }
      element = SourceElement();
        elements.add(element);
    }
    jj_consume_token(0);
    if(elements.isEmpty())
    {
      elements = null;
    }
        {if (true) return NodeFacade.CompilationUnit(getComments(), elements, name);}
    throw new Error("Missing return statement in function");
  }

  final public Statement SourceElement() throws ParseException {
  Statement element;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case DELETE:
    case FOR:
    case IF:
    case NEW:
    case RETURN:
    case THIS:
    case TYPEOF:
    case VAR:
    case VOID:
    case WHILE:
    case WITH:
    case CONST:
    case DEBUGGER:
    case DO:
    case SUPER:
    case SWITCH:
    case THROW:
    case TRY:
    case TRUE:
    case FALSE:
    case NULL:
    case GET:
    case SET:
    case LET:
    case DECIMAL_LITERAL:
    case HEX_LITERAL:
    case OCTAL_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case UNTERMINATED_STRING_LITERAL:
    case REGULAR_EXPRESSION_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case SEMICOLON:
    case BANG:
    case TILDE:
    case INCR:
    case NL_INCR:
    case DECR:
    case NL_DECR:
    case PLUS:
    case MINUS:
    case REM:
      element = Statement();
      break;
    case FUNCTION:
      element = FunctionDeclaration();
      break;
    default:
      jj_la1[121] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      {if (true) return element;}
    throw new Error("Missing return statement in function");
  }

  final public List<Statement> StatementList() throws ParseException {
  List<Statement> statements = new ArrayList<Statement>();
  Statement statement;
    label_51:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BREAK:
      case CONTINUE:
      case DELETE:
      case FOR:
      case IF:
      case NEW:
      case RETURN:
      case THIS:
      case TYPEOF:
      case VAR:
      case VOID:
      case WHILE:
      case WITH:
      case CONST:
      case DEBUGGER:
      case DO:
      case SUPER:
      case SWITCH:
      case THROW:
      case TRY:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case LET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case SEMICOLON:
      case BANG:
      case TILDE:
      case INCR:
      case NL_INCR:
      case DECR:
      case NL_DECR:
      case PLUS:
      case MINUS:
      case REM:
        statement = Statement();
       statements.add(statement);
        break;
      case FUNCTION:
        statement = FunctionDeclaration();
       statements.add(statement);
        break;
      default:
        jj_la1[122] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BREAK:
      case CONTINUE:
      case DELETE:
      case FOR:
      case FUNCTION:
      case IF:
      case NEW:
      case RETURN:
      case THIS:
      case TYPEOF:
      case VAR:
      case VOID:
      case WHILE:
      case WITH:
      case CONST:
      case DEBUGGER:
      case DO:
      case SUPER:
      case SWITCH:
      case THROW:
      case TRY:
      case TRUE:
      case FALSE:
      case NULL:
      case GET:
      case SET:
      case LET:
      case DECIMAL_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case REGULAR_EXPRESSION_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case SEMICOLON:
      case BANG:
      case TILDE:
      case INCR:
      case NL_INCR:
      case DECR:
      case NL_DECR:
      case PLUS:
      case MINUS:
      case REM:
        ;
        break;
      default:
        jj_la1[123] = jj_gen;
        break label_51;
      }
    }
    {if (true) return statements;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  private boolean jj_3R_178() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_186()) {
    jj_scanpos = xsp;
    if (jj_3R_187()) return true;
    }
    return false;
  }

  private boolean jj_3R_186() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  private boolean jj_3R_91() {
    if (jj_scan_token(STARASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_90() {
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_336() {
    if (jj_scan_token(FINALLY)) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_82() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_90()) {
    jj_scanpos = xsp;
    if (jj_3R_91()) {
    jj_scanpos = xsp;
    if (jj_3R_92()) {
    jj_scanpos = xsp;
    if (jj_3R_93()) {
    jj_scanpos = xsp;
    if (jj_3R_94()) {
    jj_scanpos = xsp;
    if (jj_3R_95()) {
    jj_scanpos = xsp;
    if (jj_3R_96()) {
    jj_scanpos = xsp;
    if (jj_3R_97()) {
    jj_scanpos = xsp;
    if (jj_3R_98()) {
    jj_scanpos = xsp;
    if (jj_3R_99()) {
    jj_scanpos = xsp;
    if (jj_3R_100()) {
    jj_scanpos = xsp;
    if (jj_3R_101()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_379() {
    if (jj_3R_185()) return true;
    if (jj_3R_176()) return true;
    return false;
  }

  private boolean jj_3R_322() {
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_376() {
    if (jj_3R_378()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_379()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_357() {
    if (jj_scan_token(HOOK)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_112()) return true;
    return false;
  }

  private boolean jj_3R_335() {
    if (jj_scan_token(CATCH)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_53()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_320() {
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_352() {
    if (jj_3R_356()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_357()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_304() {
    if (jj_scan_token(THROW)) return true;
    if (jj_3R_89()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_318() {
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_177() {
    if (jj_3R_185()) return true;
    if (jj_3R_176()) return true;
    return false;
  }

  private boolean jj_3R_81() {
    if (jj_scan_token(HOOK)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_70()) return true;
    return false;
  }

  private boolean jj_3R_324() {
    if (jj_3R_336()) return true;
    return false;
  }

  private boolean jj_3R_323() {
    if (jj_3R_335()) return true;
    return false;
  }

  private boolean jj_3R_166() {
    if (jj_3R_176()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_177()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_70() {
    if (jj_3R_80()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_81()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_321() {
    if (jj_3R_89()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_303() {
    if (jj_scan_token(TRY)) return true;
    if (jj_3R_222()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_323()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_324()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_193() {
    if (jj_scan_token(REM)) return true;
    return false;
  }

  private boolean jj_3R_192() {
    if (jj_scan_token(SLASH)) return true;
    return false;
  }

  private boolean jj_3R_319() {
    if (jj_3R_53()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_123() {
    if (jj_scan_token(HOOK)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_112()) return true;
    return false;
  }

  private boolean jj_3R_191() {
    if (jj_scan_token(STAR)) return true;
    return false;
  }

  private boolean jj_3R_302() {
    if (jj_scan_token(WITH)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_185() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_191()) {
    jj_scanpos = xsp;
    if (jj_3R_192()) {
    jj_scanpos = xsp;
    if (jj_3R_193()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_112() {
    if (jj_3R_122()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_123()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_317() {
    if (jj_3R_53()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_301() {
    if (jj_scan_token(RETURN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(13)) {
    jj_scanpos = xsp;
    if (jj_scan_token(92)) {
    jj_scanpos = xsp;
    if (jj_3R_321()) {
    jj_scanpos = xsp;
    if (jj_3R_322()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_381() {
    if (jj_3R_190()) return true;
    if (jj_3R_176()) return true;
    return false;
  }

  private boolean jj_3R_380() {
    if (jj_3R_382()) return true;
    return false;
  }

  private boolean jj_3R_378() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_380()) {
    jj_scanpos = xsp;
    if (jj_3R_381()) return true;
    }
    return false;
  }

  private boolean jj_3R_360() {
    if (jj_scan_token(SC_OR)) return true;
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_300() {
    if (jj_scan_token(BREAK)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(13)) {
    jj_scanpos = xsp;
    if (jj_scan_token(92)) {
    jj_scanpos = xsp;
    if (jj_3R_319()) {
    jj_scanpos = xsp;
    if (jj_3R_320()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_356() {
    if (jj_3R_359()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_360()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_184() {
    if (jj_3R_190()) return true;
    if (jj_3R_176()) return true;
    return false;
  }

  private boolean jj_3R_299() {
    if (jj_scan_token(CONTINUE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(13)) {
    jj_scanpos = xsp;
    if (jj_scan_token(92)) {
    jj_scanpos = xsp;
    if (jj_3R_317()) {
    jj_scanpos = xsp;
    if (jj_3R_318()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_183() {
    if (jj_3R_189()) return true;
    return false;
  }

  private boolean jj_3R_176() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_183()) {
    jj_scanpos = xsp;
    if (jj_3R_184()) return true;
    }
    return false;
  }

  private boolean jj_3R_88() {
    if (jj_scan_token(SC_OR)) return true;
    if (jj_3R_87()) return true;
    return false;
  }

  private boolean jj_3R_212() {
    if (jj_scan_token(BANG)) return true;
    return false;
  }

  private boolean jj_3R_80() {
    if (jj_3R_87()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_88()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_211() {
    if (jj_scan_token(TILDE)) return true;
    return false;
  }

  private boolean jj_3R_210() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_58() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(LET)) return true;
    if (jj_3R_349()) return true;
    if (jj_scan_token(IN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_209() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  private boolean jj_3R_136() {
    if (jj_scan_token(SC_OR)) return true;
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_208() {
    if (jj_scan_token(NL_DECR)) return true;
    return false;
  }

  private boolean jj_3R_207() {
    if (jj_scan_token(DECR)) return true;
    return false;
  }

  private boolean jj_3R_122() {
    if (jj_3R_135()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_136()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_206() {
    if (jj_scan_token(NL_INCR)) return true;
    return false;
  }

  private boolean jj_3R_205() {
    if (jj_scan_token(INCR)) return true;
    return false;
  }

  private boolean jj_3R_204() {
    if (jj_scan_token(TYPEOF)) return true;
    return false;
  }

  private boolean jj_3R_57() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(VAR)) return true;
    if (jj_3R_349()) return true;
    if (jj_scan_token(IN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_203() {
    if (jj_scan_token(VOID)) return true;
    return false;
  }

  private boolean jj_3R_363() {
    if (jj_scan_token(SC_AND)) return true;
    if (jj_3R_143()) return true;
    return false;
  }

  private boolean jj_3R_202() {
    if (jj_scan_token(DELETE)) return true;
    return false;
  }

  private boolean jj_3R_359() {
    if (jj_3R_362()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_363()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_201() {
    if (jj_scan_token(REM)) return true;
    return false;
  }

  private boolean jj_3R_190() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_201()) {
    jj_scanpos = xsp;
    if (jj_3R_202()) {
    jj_scanpos = xsp;
    if (jj_3R_203()) {
    jj_scanpos = xsp;
    if (jj_3R_204()) {
    jj_scanpos = xsp;
    if (jj_3R_205()) {
    jj_scanpos = xsp;
    if (jj_3R_206()) {
    jj_scanpos = xsp;
    if (jj_3R_207()) {
    jj_scanpos = xsp;
    if (jj_3R_208()) {
    jj_scanpos = xsp;
    if (jj_3R_209()) {
    jj_scanpos = xsp;
    if (jj_3R_210()) {
    jj_scanpos = xsp;
    if (jj_3R_211()) {
    jj_scanpos = xsp;
    if (jj_3R_212()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_56() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_66()) return true;
    if (jj_scan_token(IN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_110() {
    if (jj_scan_token(SC_AND)) return true;
    if (jj_3R_109()) return true;
    return false;
  }

  private boolean jj_3R_383() {
    if (jj_3R_213()) return true;
    return false;
  }

  private boolean jj_3R_348() {
    if (jj_3R_89()) return true;
    return false;
  }

  private boolean jj_3R_347() {
    if (jj_3R_89()) return true;
    return false;
  }

  private boolean jj_3R_382() {
    if (jj_3R_84()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_383()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_87() {
    if (jj_3R_109()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_110()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_334() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(LET)) return true;
    if (jj_3R_55()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_347()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    xsp = jj_scanpos;
    if (jj_3R_348()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_200() {
    if (jj_3R_213()) return true;
    return false;
  }

  private boolean jj_3R_144() {
    if (jj_scan_token(SC_AND)) return true;
    if (jj_3R_143()) return true;
    return false;
  }

  private boolean jj_3R_189() {
    if (jj_3R_66()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_200()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_346() {
    if (jj_3R_89()) return true;
    return false;
  }

  private boolean jj_3R_135() {
    if (jj_3R_143()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_144()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_345() {
    if (jj_3R_89()) return true;
    return false;
  }

  private boolean jj_3R_217() {
    if (jj_scan_token(DECR)) return true;
    return false;
  }

  private boolean jj_3R_213() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_216()) {
    jj_scanpos = xsp;
    if (jj_3R_217()) return true;
    }
    return false;
  }

  private boolean jj_3R_216() {
    if (jj_scan_token(INCR)) return true;
    return false;
  }

  private boolean jj_3R_333() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(VAR)) return true;
    if (jj_3R_55()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_345()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    xsp = jj_scanpos;
    if (jj_3R_346()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_365() {
    if (jj_3R_134()) return true;
    if (jj_3R_150()) return true;
    return false;
  }

  private boolean jj_3R_362() {
    if (jj_3R_364()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_365()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_344() {
    if (jj_3R_89()) return true;
    return false;
  }

  private boolean jj_3R_343() {
    if (jj_3R_89()) return true;
    return false;
  }

  private boolean jj_3R_342() {
    if (jj_3R_54()) return true;
    return false;
  }

  private boolean jj_3R_68() {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_61() {
    if (jj_3R_69()) return true;
    return false;
  }

  private boolean jj_3R_60() {
    if (jj_3R_68()) return true;
    return false;
  }

  private boolean jj_3R_59() {
    if (jj_3R_67()) return true;
    return false;
  }

  private boolean jj_3R_332() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_342()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    xsp = jj_scanpos;
    if (jj_3R_343()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    xsp = jj_scanpos;
    if (jj_3R_344()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_121() {
    if (jj_3R_134()) return true;
    if (jj_3R_120()) return true;
    return false;
  }

  private boolean jj_3R_52() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_59()) {
    jj_scanpos = xsp;
    if (jj_3R_60()) {
    jj_scanpos = xsp;
    if (jj_3R_61()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_109() {
    if (jj_3R_120()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_121()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(SET)) return true;
    if (jj_3R_52()) return true;
    return false;
  }

  private boolean jj_3R_256() {
    if (jj_3R_52()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_331() {
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(GET)) return true;
    if (jj_3R_52()) return true;
    return false;
  }

  private boolean jj_3R_255() {
    if (jj_scan_token(SET)) return true;
    if (jj_3R_52()) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_53()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_151() {
    if (jj_3R_134()) return true;
    if (jj_3R_150()) return true;
    return false;
  }

  private boolean jj_3R_241() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_254()) {
    jj_scanpos = xsp;
    if (jj_3R_255()) {
    jj_scanpos = xsp;
    if (jj_3R_256()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_254() {
    if (jj_scan_token(GET)) return true;
    if (jj_3R_52()) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_330() {
    if (jj_scan_token(DO)) return true;
    if (jj_3R_272()) return true;
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3_8() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(LET)) return true;
    if (jj_3R_55()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_257() {
    if (jj_3R_228()) return true;
    return false;
  }

  private boolean jj_3R_143() {
    if (jj_3R_150()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_151()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(VAR)) return true;
    if (jj_3R_55()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3_11() {
    if (jj_3R_58()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_54()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3_10() {
    if (jj_3R_57()) return true;
    return false;
  }

  private boolean jj_3R_242() {
    if (jj_scan_token(COMMA)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_257()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_9() {
    if (jj_3R_56()) return true;
    return false;
  }

  private boolean jj_3R_316() {
    if (jj_3R_334()) return true;
    return false;
  }

  private boolean jj_3R_315() {
    if (jj_3R_333()) return true;
    return false;
  }

  private boolean jj_3R_228() {
    if (jj_3R_241()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_242()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_134() {
    if (jj_scan_token(BIT_OR)) return true;
    return false;
  }

  private boolean jj_3R_314() {
    if (jj_3R_332()) return true;
    return false;
  }

  private boolean jj_3R_313() {
    if (jj_3R_332()) return true;
    return false;
  }

  private boolean jj_3R_312() {
    if (jj_3R_331()) return true;
    return false;
  }

  private boolean jj_3R_218() {
    if (jj_3R_228()) return true;
    return false;
  }

  private boolean jj_3R_311() {
    if (jj_3R_330()) return true;
    return false;
  }

  private boolean jj_3R_367() {
    if (jj_3R_142()) return true;
    if (jj_3R_155()) return true;
    return false;
  }

  private boolean jj_3R_85() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_218()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_298() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_311()) {
    jj_scanpos = xsp;
    if (jj_3R_312()) {
    jj_scanpos = xsp;
    if (jj_3R_313()) {
    jj_scanpos = xsp;
    if (jj_3R_314()) {
    jj_scanpos = xsp;
    if (jj_3R_315()) {
    jj_scanpos = xsp;
    if (jj_3R_316()) {
    jj_scanpos = xsp;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3_11()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_364() {
    if (jj_3R_366()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_367()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_310() {
    if (jj_scan_token(ELSE)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_250() {
    if (jj_3R_260()) return true;
    return false;
  }

  private boolean jj_3R_297() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_272()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_310()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_253() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_133() {
    if (jj_3R_142()) return true;
    if (jj_3R_132()) return true;
    return false;
  }

  private boolean jj_3R_240() {
    if (jj_scan_token(COMMA)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_253()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_239() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_120() {
    if (jj_3R_132()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_133()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_119() {
    if (jj_scan_token(LBRACKET)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_239()) jj_scanpos = xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_240()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_249() {
    if (jj_3R_116()) return true;
    return false;
  }

  private boolean jj_3R_328() {
    if (jj_3R_53()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_264() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_156() {
    if (jj_3R_142()) return true;
    if (jj_3R_155()) return true;
    return false;
  }

  private boolean jj_3R_238() {
    if (jj_3R_86()) return true;
    return false;
  }

  private boolean jj_3R_237() {
    if (jj_3R_118()) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_53()) return true;
    if (jj_scan_token(COLON)) return true;
    return false;
  }

  private boolean jj_3R_252() {
    if (jj_3R_243()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_264()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_150() {
    if (jj_3R_155()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_156()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_263() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_309() {
    if (jj_3R_329()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_236() {
    if (jj_3R_117()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_252()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_262() {
    if (jj_3R_85()) return true;
    return false;
  }

  private boolean jj_3R_308() {
    if (jj_3R_328()) return true;
    return false;
  }

  private boolean jj_3R_251() {
    if (jj_3R_243()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_262()) jj_scanpos = xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_263()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_296() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_308()) {
    jj_scanpos = xsp;
    if (jj_3R_309()) return true;
    }
    return false;
  }

  private boolean jj_3R_248() {
    if (jj_3R_115()) return true;
    return false;
  }

  private boolean jj_3R_261() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_142() {
    if (jj_scan_token(XOR)) return true;
    return false;
  }

  private boolean jj_3R_235() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_248()) {
    jj_scanpos = xsp;
    if (jj_3R_249()) return true;
    }
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_250()) { jj_scanpos = xsp; break; }
    }
    xsp = jj_scanpos;
    if (jj_3R_251()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_247() {
    if (jj_3R_243()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_261()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_295() {
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_246() {
    if (jj_3R_260()) return true;
    return false;
  }

  private boolean jj_3R_369() {
    if (jj_3R_149()) return true;
    if (jj_3R_164()) return true;
    return false;
  }

  private boolean jj_3R_234() {
    if (jj_scan_token(THIS)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_246()) { jj_scanpos = xsp; break; }
    }
    xsp = jj_scanpos;
    if (jj_3R_247()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_366() {
    if (jj_3R_368()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_369()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_361() {
    if (jj_scan_token(ASSIGN)) return true;
    if (jj_3R_62()) return true;
    return false;
  }

  private boolean jj_3R_118() {
    if (jj_scan_token(NEW)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_234()) {
    jj_scanpos = xsp;
    if (jj_3R_235()) {
    jj_scanpos = xsp;
    if (jj_3R_236()) {
    jj_scanpos = xsp;
    if (jj_3R_237()) {
    jj_scanpos = xsp;
    if (jj_3R_238()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_358() {
    if (jj_3R_361()) return true;
    return false;
  }

  private boolean jj_3R_268() {
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_354() {
    if (jj_3R_53()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_358()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_141() {
    if (jj_3R_149()) return true;
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3R_260() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_267()) {
    jj_scanpos = xsp;
    if (jj_3R_268()) return true;
    }
    return false;
  }

  private boolean jj_3R_267() {
    if (jj_scan_token(DOT)) return true;
    if (jj_3R_53()) return true;
    return false;
  }

  private boolean jj_3R_132() {
    if (jj_3R_140()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_141()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_83() {
    if (jj_scan_token(ASSIGN)) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_72() {
    if (jj_3R_83()) return true;
    return false;
  }

  private boolean jj_3R_269() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_165() {
    if (jj_3R_149()) return true;
    if (jj_3R_164()) return true;
    return false;
  }

  private boolean jj_3R_64() {
    if (jj_3R_53()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_72()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_265() {
    if (jj_3R_102()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_269()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_155() {
    if (jj_3R_164()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_165()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_258() {
    if (jj_3R_265()) return true;
    return false;
  }

  private boolean jj_3R_355() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_354()) return true;
    return false;
  }

  private boolean jj_3R_149() {
    if (jj_scan_token(BIT_AND)) return true;
    return false;
  }

  private boolean jj_3R_243() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_258()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_349() {
    if (jj_3R_354()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_355()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_231() {
    if (jj_scan_token(DOT)) return true;
    if (jj_3R_67()) return true;
    return false;
  }

  private boolean jj_3R_371() {
    if (jj_3R_154()) return true;
    if (jj_3R_174()) return true;
    return false;
  }

  private boolean jj_3R_65() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_64()) return true;
    return false;
  }

  private boolean jj_3R_230() {
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_368() {
    if (jj_3R_370()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_371()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_219() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_229()) {
    jj_scanpos = xsp;
    if (jj_3R_230()) {
    jj_scanpos = xsp;
    if (jj_3R_231()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_229() {
    if (jj_3R_243()) return true;
    return false;
  }

  private boolean jj_3R_55() {
    if (jj_3R_64()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_65()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_221() {
    if (jj_3R_232()) return true;
    return false;
  }

  private boolean jj_3R_148() {
    if (jj_3R_154()) return true;
    if (jj_3R_147()) return true;
    return false;
  }

  private boolean jj_3R_220() {
    if (jj_3R_53()) return true;
    return false;
  }

  private boolean jj_3R_294() {
    if (jj_scan_token(VAR)) return true;
    if (jj_3R_55()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_86() {
    if (jj_scan_token(FUNCTION)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_220()) jj_scanpos = xsp;
    if (jj_scan_token(LPAREN)) return true;
    xsp = jj_scanpos;
    if (jj_3R_221()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_140() {
    if (jj_3R_147()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_148()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_293() {
    if (jj_scan_token(CONST)) return true;
    if (jj_3R_55()) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_117() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_226() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_175() {
    if (jj_3R_154()) return true;
    if (jj_3R_174()) return true;
    return false;
  }

  private boolean jj_3R_227() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_164() {
    if (jj_3R_174()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_175()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_223() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_292() {
    if (jj_scan_token(DEBUGGER)) return true;
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_115() {
    if (jj_3R_53()) return true;
    return false;
  }

  private boolean jj_3R_225() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_215() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_224() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_163() {
    if (jj_scan_token(STRICT_NEQ)) return true;
    return false;
  }

  private boolean jj_3R_327() {
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_125() {
    if (jj_scan_token(SUPER)) return true;
    return false;
  }

  private boolean jj_3R_214() {
    if (jj_3R_219()) return true;
    return false;
  }

  private boolean jj_3R_162() {
    if (jj_scan_token(STRICT_EQ)) return true;
    return false;
  }

  private boolean jj_3R_307() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_55()) return true;
    if (jj_scan_token(RPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_327()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_124() {
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  private boolean jj_3R_114() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_124()) {
    jj_scanpos = xsp;
    if (jj_3R_125()) return true;
    }
    return false;
  }

  private boolean jj_3R_161() {
    if (jj_scan_token(NE)) return true;
    return false;
  }

  private boolean jj_3R_306() {
    if (jj_3R_55()) return true;
    return false;
  }

  private boolean jj_3R_160() {
    if (jj_scan_token(EQ)) return true;
    return false;
  }

  private boolean jj_3R_154() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_160()) {
    jj_scanpos = xsp;
    if (jj_3R_161()) {
    jj_scanpos = xsp;
    if (jj_3R_162()) {
    jj_scanpos = xsp;
    if (jj_3R_163()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_108() {
    if (jj_3R_119()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_227()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_291() {
    if (jj_scan_token(LET)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_306()) {
    jj_scanpos = xsp;
    if (jj_3R_307()) return true;
    }
    if (true) { jj_la = 0; jj_scanpos = jj_lastpos; return false;}
    return false;
  }

  private boolean jj_3R_107() {
    if (jj_3R_118()) return true;
    return false;
  }

  private boolean jj_3R_106() {
    if (jj_3R_117()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_226()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_105() {
    if (jj_3R_116()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_225()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_104() {
    if (jj_3R_115()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_224()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_245() {
    if (jj_3R_259()) return true;
    return false;
  }

  private boolean jj_3R_103() {
    if (jj_3R_114()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_223()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_84() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_103()) {
    jj_scanpos = xsp;
    if (jj_3R_104()) {
    jj_scanpos = xsp;
    if (jj_3R_105()) {
    jj_scanpos = xsp;
    if (jj_3R_106()) {
    jj_scanpos = xsp;
    if (jj_3R_107()) {
    jj_scanpos = xsp;
    if (jj_3R_108()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_233() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_245()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_373() {
    if (jj_3R_188()) return true;
    if (jj_3R_152()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(LBRACE)) return true;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_222() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3R_233()) return true;
    }
    return false;
  }

  private boolean jj_3R_75() {
    if (jj_3R_86()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_215()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_74() {
    if (jj_3R_85()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_214()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_370() {
    if (jj_3R_372()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_373()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_73() {
    if (jj_3R_84()) return true;
    return false;
  }

  private boolean jj_3R_289() {
    if (jj_3R_305()) return true;
    return false;
  }

  private boolean jj_3R_288() {
    if (jj_3R_304()) return true;
    return false;
  }

  private boolean jj_3R_66() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_73()) {
    jj_scanpos = xsp;
    if (jj_3R_74()) {
    jj_scanpos = xsp;
    if (jj_3R_75()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_287() {
    if (jj_3R_303()) return true;
    return false;
  }

  private boolean jj_3R_286() {
    if (jj_3R_302()) return true;
    return false;
  }

  private boolean jj_3R_285() {
    if (jj_3R_301()) return true;
    return false;
  }

  private boolean jj_3R_284() {
    if (jj_3R_300()) return true;
    return false;
  }

  private boolean jj_3R_283() {
    if (jj_3R_299()) return true;
    return false;
  }

  private boolean jj_3R_282() {
    if (jj_3R_298()) return true;
    return false;
  }

  private boolean jj_3R_281() {
    if (jj_3R_297()) return true;
    return false;
  }

  private boolean jj_3R_280() {
    if (jj_3R_296()) return true;
    return false;
  }

  private boolean jj_3R_279() {
    if (jj_3R_295()) return true;
    return false;
  }

  private boolean jj_3R_278() {
    if (jj_3R_294()) return true;
    return false;
  }

  private boolean jj_3R_67() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(75)) {
    jj_scanpos = xsp;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(22)) {
    jj_scanpos = xsp;
    if (jj_scan_token(23)) {
    jj_scanpos = xsp;
    if (jj_scan_token(24)) {
    jj_scanpos = xsp;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_scan_token(28)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(30)) {
    jj_scanpos = xsp;
    if (jj_scan_token(31)) {
    jj_scanpos = xsp;
    if (jj_scan_token(32)) {
    jj_scanpos = xsp;
    if (jj_scan_token(33)) {
    jj_scanpos = xsp;
    if (jj_scan_token(34)) {
    jj_scanpos = xsp;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(36)) {
    jj_scanpos = xsp;
    if (jj_scan_token(37)) {
    jj_scanpos = xsp;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(39)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) {
    jj_scanpos = xsp;
    if (jj_scan_token(44)) {
    jj_scanpos = xsp;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) {
    jj_scanpos = xsp;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_scan_token(51)) {
    jj_scanpos = xsp;
    if (jj_scan_token(52)) {
    jj_scanpos = xsp;
    if (jj_scan_token(53)) {
    jj_scanpos = xsp;
    if (jj_scan_token(54)) {
    jj_scanpos = xsp;
    if (jj_scan_token(55)) {
    jj_scanpos = xsp;
    if (jj_scan_token(56)) {
    jj_scanpos = xsp;
    if (jj_scan_token(57)) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_277() {
    if (jj_3R_293()) return true;
    return false;
  }

  private boolean jj_3R_153() {
    if (jj_3R_159()) return true;
    if (jj_3R_152()) return true;
    return false;
  }

  private boolean jj_3R_276() {
    if (jj_3R_292()) return true;
    return false;
  }

  private boolean jj_3R_275() {
    if (jj_3R_291()) return true;
    return false;
  }

  private boolean jj_3R_274() {
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_147() {
    if (jj_3R_152()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_153()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_272() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_274()) {
    jj_scanpos = xsp;
    if (jj_3R_275()) {
    jj_scanpos = xsp;
    if (jj_3R_276()) {
    jj_scanpos = xsp;
    if (jj_3R_277()) {
    jj_scanpos = xsp;
    if (jj_3R_278()) {
    jj_scanpos = xsp;
    if (jj_3R_279()) {
    jj_scanpos = xsp;
    if (jj_3R_280()) {
    jj_scanpos = xsp;
    if (jj_3R_281()) {
    jj_scanpos = xsp;
    if (jj_3R_282()) {
    jj_scanpos = xsp;
    if (jj_3R_283()) {
    jj_scanpos = xsp;
    if (jj_3R_284()) {
    jj_scanpos = xsp;
    if (jj_3R_285()) {
    jj_scanpos = xsp;
    if (jj_3R_286()) {
    jj_scanpos = xsp;
    if (jj_3R_287()) {
    jj_scanpos = xsp;
    if (jj_3R_288()) {
    jj_scanpos = xsp;
    if (jj_3R_289()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_53() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(75)) {
    jj_scanpos = xsp;
    if (jj_scan_token(56)) {
    jj_scanpos = xsp;
    if (jj_scan_token(57)) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_182() {
    if (jj_3R_188()) return true;
    if (jj_3R_152()) return true;
    return false;
  }

  private boolean jj_3R_341() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_131() {
    if (jj_scan_token(UNTERMINATED_STRING_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_130() {
    if (jj_3R_139()) return true;
    return false;
  }

  private boolean jj_3R_129() {
    if (jj_3R_138()) return true;
    return false;
  }

  private boolean jj_3R_128() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_174() {
    if (jj_3R_152()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_182()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_127() {
    if (jj_3R_68()) return true;
    return false;
  }

  private boolean jj_3R_126() {
    if (jj_3R_69()) return true;
    return false;
  }

  private boolean jj_3R_329() {
    if (jj_3R_340()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_341()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_116() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_126()) {
    jj_scanpos = xsp;
    if (jj_3R_127()) {
    jj_scanpos = xsp;
    if (jj_3R_128()) {
    jj_scanpos = xsp;
    if (jj_3R_129()) {
    jj_scanpos = xsp;
    if (jj_3R_130()) {
    jj_scanpos = xsp;
    if (jj_3R_131()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_173() {
    if (jj_scan_token(INSTANCEOF)) return true;
    return false;
  }

  private boolean jj_3R_172() {
    if (jj_scan_token(GE)) return true;
    return false;
  }

  private boolean jj_3R_139() {
    if (jj_scan_token(REGULAR_EXPRESSION_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_171() {
    if (jj_scan_token(LE)) return true;
    return false;
  }

  private boolean jj_3R_170() {
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_271() {
    if (jj_3R_273()) return true;
    return false;
  }

  private boolean jj_3R_63() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_62()) return true;
    return false;
  }

  private boolean jj_3R_138() {
    if (jj_scan_token(NULL)) return true;
    return false;
  }

  private boolean jj_3R_169() {
    if (jj_scan_token(LT)) return true;
    return false;
  }

  private boolean jj_3R_159() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_169()) {
    jj_scanpos = xsp;
    if (jj_3R_170()) {
    jj_scanpos = xsp;
    if (jj_3R_171()) {
    jj_scanpos = xsp;
    if (jj_3R_172()) {
    jj_scanpos = xsp;
    if (jj_3R_173()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_266() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_270()) {
    jj_scanpos = xsp;
    if (jj_3R_271()) return true;
    }
    return false;
  }

  private boolean jj_3R_270() {
    if (jj_3R_272()) return true;
    return false;
  }

  private boolean jj_3R_259() {
    Token xsp;
    if (jj_3R_266()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_266()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_199() {
    if (jj_scan_token(INSTANCEOF)) return true;
    return false;
  }

  private boolean jj_3R_54() {
    if (jj_3R_62()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_63()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_146() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  private boolean jj_3R_198() {
    if (jj_scan_token(IN)) return true;
    return false;
  }

  private boolean jj_3R_145() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  private boolean jj_3R_137() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_145()) {
    jj_scanpos = xsp;
    if (jj_3R_146()) return true;
    }
    return false;
  }

  private boolean jj_3R_197() {
    if (jj_scan_token(GE)) return true;
    return false;
  }

  private boolean jj_3R_79() {
    if (jj_scan_token(FLOATING_POINT_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_196() {
    if (jj_scan_token(LE)) return true;
    return false;
  }

  private boolean jj_3R_78() {
    if (jj_scan_token(HEX_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_195() {
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_111() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_77() {
    if (jj_scan_token(OCTAL_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_188() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_194()) {
    jj_scanpos = xsp;
    if (jj_3R_195()) {
    jj_scanpos = xsp;
    if (jj_3R_196()) {
    jj_scanpos = xsp;
    if (jj_3R_197()) {
    jj_scanpos = xsp;
    if (jj_3R_198()) {
    jj_scanpos = xsp;
    if (jj_3R_199()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_194() {
    if (jj_scan_token(LT)) return true;
    return false;
  }

  private boolean jj_3R_69() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_76()) {
    jj_scanpos = xsp;
    if (jj_3R_77()) {
    jj_scanpos = xsp;
    if (jj_3R_78()) {
    jj_scanpos = xsp;
    if (jj_3R_79()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_76() {
    if (jj_scan_token(DECIMAL_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_89() {
    if (jj_3R_102()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_111()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_375() {
    if (jj_3R_168()) return true;
    if (jj_3R_157()) return true;
    return false;
  }

  private boolean jj_3R_372() {
    if (jj_3R_374()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_375()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_353() {
    if (jj_3R_82()) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_244() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_53()) return true;
    return false;
  }

  private boolean jj_3R_340() {
    if (jj_3R_352()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_353()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_232() {
    if (jj_3R_53()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_244()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_158() {
    if (jj_3R_168()) return true;
    if (jj_3R_157()) return true;
    return false;
  }

  private boolean jj_3R_290() {
    if (jj_3R_232()) return true;
    return false;
  }

  private boolean jj_3R_152() {
    if (jj_3R_157()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_158()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_71() {
    if (jj_3R_82()) return true;
    if (jj_3R_62()) return true;
    return false;
  }

  private boolean jj_3R_62() {
    if (jj_3R_70()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_71()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_273() {
    if (jj_scan_token(FUNCTION)) return true;
    if (jj_3R_53()) return true;
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_290()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_181() {
    if (jj_scan_token(RUNSIGNEDSHIFT)) return true;
    return false;
  }

  private boolean jj_3R_180() {
    if (jj_scan_token(RSIGNEDSHIFT)) return true;
    return false;
  }

  private boolean jj_3R_351() {
    if (jj_3R_259()) return true;
    return false;
  }

  private boolean jj_3R_179() {
    if (jj_scan_token(LSHIFT)) return true;
    return false;
  }

  private boolean jj_3R_168() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_179()) {
    jj_scanpos = xsp;
    if (jj_3R_180()) {
    jj_scanpos = xsp;
    if (jj_3R_181()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_113() {
    if (jj_3R_82()) return true;
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_338() {
    if (jj_scan_token(_DEFAULT)) return true;
    if (jj_scan_token(COLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_351()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_102() {
    if (jj_3R_112()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_113()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_350() {
    if (jj_3R_259()) return true;
    return false;
  }

  private boolean jj_3R_377() {
    if (jj_3R_178()) return true;
    if (jj_3R_166()) return true;
    return false;
  }

  private boolean jj_3R_374() {
    if (jj_3R_376()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_377()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_337() {
    if (jj_scan_token(CASE)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(COLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_350()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_101() {
    if (jj_scan_token(ORASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_100() {
    if (jj_scan_token(XORASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_99() {
    if (jj_scan_token(ANDASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_98() {
    if (jj_scan_token(RUNSIGNEDSHIFTASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_167() {
    if (jj_3R_178()) return true;
    if (jj_3R_166()) return true;
    return false;
  }

  private boolean jj_3R_97() {
    if (jj_scan_token(RSIGNEDSHIFTASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_339() {
    if (jj_3R_337()) return true;
    return false;
  }

  private boolean jj_3R_96() {
    if (jj_scan_token(LSHIFTASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_326() {
    if (jj_3R_338()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_339()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_157() {
    if (jj_3R_166()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_167()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_95() {
    if (jj_scan_token(MINUSASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_325() {
    if (jj_3R_337()) return true;
    return false;
  }

  private boolean jj_3R_94() {
    if (jj_scan_token(PLUSASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_93() {
    if (jj_scan_token(REMASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_187() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_305() {
    if (jj_scan_token(SWITCH)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_89()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_325()) { jj_scanpos = xsp; break; }
    }
    xsp = jj_scanpos;
    if (jj_3R_326()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_92() {
    if (jj_scan_token(SLASHASSIGN)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public ASTParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[124];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static private int[] jj_la1_4;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
      jj_la1_init_3();
      jj_la1_init_4();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0xfff00000,0x0,0x0,0x52000000,0x0,0x0,0x0,0x0,0x0,0x50000000,0x40000000,0x0,0x0,0x0,0xd2400000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x52000000,0xd2400000,0x0,0xd2400000,0xfff00000,0xfff00000,0x0,0xfff00000,0xfff00000,0x0,0x0,0x0,0x80400000,0xd2400000,0xd0400000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x8000000,0x0,0x8000000,0x0,0x8000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xf5700000,0xf7700000,0x0,0xf5700000,0x0,0x0,0x0,0x0,0x0,0xd0400000,0x800000,0x0,0xd2400000,0xd2400000,0xd2400000,0xd2400000,0xd2400000,0xd2400000,0xd2400000,0x2000,0x2000,0xd2402000,0x0,0x0,0x0,0x0,0x0,0xf7700000,0xf7700000,0x0,0x0,0xf7700000,0xf7700000,0xf7700000,0xf7700000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x78000000,0x600000,0x78e00000,0x3000000,0x3ffffff,0x0,0x0,0x7be10000,0x0,0x0,0x0,0x0,0x0,0x7be10000,0x10000,0x3000000,0x3000000,0x0,0x7be10002,0x0,0x0,0x0,0x0,0x0,0x7be00000,0x0,0x0,0x0,0x0,0x0,0x0,0x7be00000,0x7be10002,0x0,0x7be10002,0x7bffffff,0x7bffffff,0x0,0x7bffffff,0x7bffffff,0x0,0x0,0x0,0x2,0x7be10002,0x7be10002,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x100000,0x100000,0x100000,0x100000,0x100000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x7fef058f,0x7fef058f,0x0,0x7fef058f,0x3000000,0x0,0x0,0x0,0x0,0x7be10002,0x0,0x404,0x7be10002,0x7be10002,0x7be10002,0x7be10002,0x7be10002,0x7be10002,0x7be10002,0x3000000,0x3000000,0x7be10002,0x20,0x4000,0x10,0x10,0x200,0x7fef058f,0x7fef058f,0x3000000,0x0,0x7fef058f,0x7fef058f,0x7fef058f,0x7fef058f,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x19,0x800,0x800,0x44400000,0x44400000,0x5400819,0x44400000,0x44400000,0x44400000,0x44400000,0x44400000,0x4400819,0x0,0x800,0x800,0x44400000,0x5400819,0x20000000,0x44000000,0x44000000,0x44400000,0x400000,0x819,0x44000000,0x1000000,0x44400000,0x400000,0x44400000,0x400000,0x400819,0x5400819,0x20000000,0x5400819,0x801,0x801,0x20000000,0x801,0x801,0x0,0x0,0x0,0x0,0x5400819,0x4400819,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x80000000,0x80000000,0x80000000,0x80000000,0x20000000,0x20000000,0x20000000,0x15400819,0x15400819,0x1000000,0x15400819,0x400800,0x20000000,0x20000000,0x80000000,0x80000000,0x4400819,0x0,0x0,0x5400819,0x5400819,0x5400819,0x5400819,0x5400819,0x5400819,0x5400819,0x10000800,0x10000800,0x15400819,0x0,0x0,0x0,0x0,0x0,0x15400819,0x15400819,0x800,0x20000000,0x15400819,0x15400819,0x15400819,0x15400819,};
   }
   private static void jj_la1_init_3() {
      jj_la1_3 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x20fc00c,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x20fc00c,0x0,0x20fc00c,0x0,0x0,0x0,0x0,0x0,0x14000,0x14000,0x14000,0x20fc00c,0x20fc00c,0x20fc00c,0x2300000,0x2300000,0x2300000,0xc0000,0xc0000,0xc0000,0x1c000000,0x1c000000,0x1c000000,0x603,0x603,0x603,0x603,0x603,0x9c0,0x9c0,0x9c0,0x9c0,0x400000,0x400000,0x400000,0x1000000,0x1000000,0x1000000,0x800000,0x800000,0x800000,0x2000,0x2000,0x2000,0x1000,0x1000,0x1000,0x10,0x10,0x10,0xe0000000,0xe0000000,0xe0000000,0xe0000000,0x0,0x0,0x0,0x20fc00c,0x20fc00c,0x0,0x20fc00c,0x0,0x0,0x0,0x0,0x0,0x20fc00c,0x0,0x0,0x20fc00c,0x20fc00c,0x20fc00c,0x20fc00c,0x20fc00c,0x20fc00c,0x20fc00c,0x0,0x0,0x20fc00c,0x0,0x0,0x0,0x0,0x0,0x20fc00c,0x20fc00c,0x0,0x0,0x20fc00c,0x20fc00c,0x20fc00c,0x20fc00c,};
   }
   private static void jj_la1_init_4() {
      jj_la1_4 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xff,0xff,0xff,0xff,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[11];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public ASTParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ASTParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ASTParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 124; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 124; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public ASTParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ASTParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 124; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 124; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public ASTParser(ASTParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 124; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ASTParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 124; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[136];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 124; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
          if ((jj_la1_4[i] & (1<<j)) != 0) {
            la1tokens[128+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 136; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 11; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
