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

/** Token Manager. */
public class ASTParserTokenManager implements ASTParserConstants
{
  private List < Comment > comments;

  private final Stack < JSDocComment > jsdocStack = new Stack < JSDocComment > ();

  private JSDocComment lastJSDoc;

  void pushJSDoc()
  {
    jsdocStack.push(lastJSDoc);
  }
  JSDocComment popJSDoc()
  {
    if (jsdocStack.empty())
    {
      return null;
    } else
    {
      return jsdocStack.pop();
    }
  }
  List < Comment > getComments()
  {
    return comments;
  }

  void clearComments()
  {
    comments = null;
    jsdocStack.clear();
    lastJSDoc = null;
  }

  private void CommonTokenAction(Token token)
  {
    lastJSDoc = null;
    if (token.specialToken != null)
    {
      if (comments == null)
      {
        comments = new LinkedList < Comment > ();
      }
      Token special = token.specialToken;
      if (special.kind == JS_DOC_COMMENT)
      {
        lastJSDoc = NodeFacade.JSDocComment(special.image.substring(3, special.image.length() - 2));
        comments.add(lastJSDoc);
      }
      else if (special.kind == SINGLE_LINE_COMMENT)
      {
        LineComment comment = NodeFacade.LineComment(special.image.substring(2));
        comments.add(comment);
      }
      else if (special.kind == MULTI_LINE_COMMENT)
      {
        BlockComment comment = NodeFacade.BlockComment(special.image.substring(2, special.image.length() - 2));
        comments.add(comment);
      }
    }
  }

  /** Fake getter :) */
  int getLengthOfMatch() {
    return lengthOfMatch;
  }

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1, long active2)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x10000L) != 0L || (active1 & 0x20000000000000L) != 0L || (active2 & 0x1L) != 0L)
            return 60;
         if ((active0 & 0x7fffffffff00000L) != 0L)
         {
            jjmatchedKind = 75;
            return 103;
         }
         if ((active1 & 0x40000000L) != 0L)
            return 7;
         return -1;
      case 1:
         if ((active0 & 0x7effbfff3f00000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 75;
               jjmatchedPos = 1;
            }
            return 103;
         }
         if ((active0 & 0x1004000c000000L) != 0L)
            return 103;
         if ((active0 & 0x10000L) != 0L)
            return 62;
         if ((active2 & 0x1L) != 0L)
            return 104;
         return -1;
      case 2:
         if ((active0 & 0x708000111000000L) != 0L)
            return 103;
         if ((active0 & 0xf7fbfee2f00000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 75;
               jjmatchedPos = 2;
            }
            return 103;
         }
         return -1;
      case 3:
         if ((active0 & 0x57f3e4a2700000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 3;
            return 103;
         }
         if ((active0 & 0xa0081a40800000L) != 0L)
            return 103;
         return -1;
      case 4:
         if ((active0 & 0x12f300a2600000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 4;
            return 103;
         }
         if ((active0 & 0x4500e400100000L) != 0L)
            return 103;
         return -1;
      case 5:
         if ((active0 & 0x29000a0400000L) != 0L)
            return 103;
         if ((active0 & 0x10630002200000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 5;
            return 103;
         }
         return -1;
      case 6:
         if ((active0 & 0x10010002200000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 6;
            return 103;
         }
         if ((active0 & 0x620000000000L) != 0L)
            return 103;
         return -1;
      case 7:
         if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 7;
            return 103;
         }
         if ((active0 & 0x10002200000L) != 0L)
            return 103;
         return -1;
      case 8:
         if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 8;
            return 103;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1, long active2)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1, active2), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 98;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x88000000000L, 0x0L);
      case 37:
         jjmatchedKind = 121;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x10L);
      case 38:
         jjmatchedKind = 118;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x200000000000L, 0x2L);
      case 40:
         return jjStopAtPos(0, 86);
      case 41:
         return jjStopAtPos(0, 87);
      case 42:
         jjmatchedKind = 116;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x8000000000000000L, 0x0L);
      case 43:
         jjmatchedKind = 114;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000400000000000L, 0x0L);
      case 44:
         return jjStopAtPos(0, 93);
      case 45:
         jjmatchedKind = 115;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x4001000000000000L, 0x0L);
      case 46:
         return jjStartNfaWithStates_0(0, 94, 7);
      case 47:
         jjmatchedKind = 117;
         return jjMoveStringLiteralDfa1_0(0x10000L, 0x0L, 0x1L);
      case 58:
         return jjStopAtPos(0, 101);
      case 59:
         return jjStopAtPos(0, 92);
      case 60:
         jjmatchedKind = 97;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x400020000000000L, 0x20L);
      case 61:
         jjmatchedKind = 95;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x14000000000L, 0x0L);
      case 62:
         jjmatchedKind = 96;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1800040000000000L, 0xc0L);
      case 63:
         return jjStopAtPos(0, 100);
      case 91:
         return jjStopAtPos(0, 90);
      case 93:
         return jjStopAtPos(0, 91);
      case 94:
         jjmatchedKind = 120;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x8L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x100000L, 0x0L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0xf000200000L, 0x0L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x70000400000L, 0x0L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x380000800000L, 0x0L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x40400003000000L, 0x0L, 0x0L);
      case 103:
         return jjMoveStringLiteralDfa1_0(0x100000000000000L, 0x0L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x1080000c000000L, 0x0L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x400000000000000L, 0x0L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x80000010000000L, 0x0L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x20000000L, 0x0L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x203000000000000L, 0x0L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x2c0000c0000000L, 0x0L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x300000000L, 0x0L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0xc00000000L, 0x0L, 0x0L);
      case 123:
         return jjStopAtPos(0, 88);
      case 124:
         jjmatchedKind = 119;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x100000000000L, 0x4L);
      case 125:
         return jjStopAtPos(0, 89);
      case 126:
         return jjStopAtPos(0, 99);
      case 160:
         return jjStopAtPos(0, 5);
      case 65279:
         return jjStopAtPos(0, 6);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0, long active1, long active2)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1, active2);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 109);
         break;
      case 42:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 16, 62);
         break;
      case 43:
         if ((active1 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 110);
         break;
      case 45:
         if ((active1 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 112);
         break;
      case 60:
         if ((active1 & 0x400000000000000L) != 0L)
         {
            jjmatchedKind = 122;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0L, active2, 0x20L);
      case 61:
         if ((active1 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 104;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 105);
         else if ((active1 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 106);
         else if ((active1 & 0x80000000000L) != 0L)
         {
            jjmatchedKind = 107;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(1, 125);
         else if ((active1 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 126);
         else if ((active1 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 127);
         else if ((active2 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(1, 128, 104);
         else if ((active2 & 0x2L) != 0L)
            return jjStopAtPos(1, 129);
         else if ((active2 & 0x4L) != 0L)
            return jjStopAtPos(1, 130);
         else if ((active2 & 0x8L) != 0L)
            return jjStopAtPos(1, 131);
         else if ((active2 & 0x10L) != 0L)
            return jjStopAtPos(1, 132);
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0xc000000000L, active2, 0L);
      case 62:
         if ((active1 & 0x800000000000000L) != 0L)
         {
            jjmatchedKind = 123;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x1000000000000000L, active2, 0xc0L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x40003100000000L, active1, 0L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x700030030400000L, active1, 0L, active2, 0L);
      case 102:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(1, 26, 103);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000440000000L, active1, 0L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x400800000000L, active1, 0L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000800000L, active1, 0L, active2, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000000L, active1, 0L, active2, 0L);
      case 110:
         if ((active0 & 0x8000000L) != 0L)
         {
            jjmatchedKind = 27;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x10080000000000L, active1, 0L, active2, 0L);
      case 111:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 42, 103);
         return jjMoveStringLiteralDfa2_0(active0, 0x8201200000L, active1, 0L, active2, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x28000000100000L, active1, 0L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x81000002000000L, active1, 0L, active2, 0L);
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000000000L, active1, 0L, active2, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x300000000000L, active1, 0L, active2, 0L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L, active1, 0L, active2, 0L);
      case 124:
         if ((active1 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 108);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1, active2);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(0, old0, old1, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1, active2);
      return 2;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x4000000000L) != 0L)
            return jjStopAtPos(2, 102);
         else if ((active1 & 0x8000000000L) != 0L)
            return jjStopAtPos(2, 103);
         else if ((active2 & 0x20L) != 0L)
            return jjStopAtPos(2, 133);
         else if ((active2 & 0x40L) != 0L)
            return jjStopAtPos(2, 134);
         break;
      case 62:
         if ((active1 & 0x1000000000000000L) != 0L)
         {
            jjmatchedKind = 124;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0L, active2, 0x80L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L, active1, 0L, active2, 0L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L, active1, 0L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000L, active1, 0L, active2, 0L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000000L, active1, 0L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000640000000L, active1, 0L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0xc0000000400000L, active1, 0L, active2, 0L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x408002200000L, active1, 0L, active2, 0L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x1900080000000L, active1, 0L, active2, 0L);
      case 114:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 103);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(2, 32, 103);
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000000L, active1, 0L, active2, 0L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x10001000800000L, active1, 0L, active2, 0L);
      case 116:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 56, 103);
         else if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 57, 103);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 58, 103);
         return jjMoveStringLiteralDfa3_0(active0, 0x202820000000L, active1, 0L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x20080000000000L, active1, 0L, active2, 0L);
      case 119:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(2, 28, 103);
         break;
      case 121:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 51, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1, active2);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(1, old0, old1, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L, active2);
      return 3;
   }
   switch(curChar)
   {
      case 61:
         if ((active2 & 0x80L) != 0L)
            return jjStopAtPos(3, 135);
         break;
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x420000100000L, active2, 0L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x2002000000L, active2, 0L);
      case 100:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 33, 103);
         break;
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(3, 23, 103);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 36, 103);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 53, 103);
         return jjMoveStringLiteralDfa4_0(active0, 0x1200080400000L, active2, 0L);
      case 104:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(3, 35, 103);
         break;
      case 108:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 55, 103);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000L, active2, 0L);
      case 109:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 43, 103);
         break;
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x4900000000000L, active2, 0L);
      case 115:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(3, 30, 103);
         return jjMoveStringLiteralDfa4_0(active0, 0x4000c000000000L, active2, 0L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x12000000200000L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x10020000000L, active2, 0L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L, active2);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0, long old2, long active2)
{
   if (((active0 &= old0) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(2, old0, 0L, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000000000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000000000L);
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(4, 34, 103);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 54, 103);
         break;
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000000L);
      case 104:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 37, 103);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 107:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(4, 20, 103);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000000000L);
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 114:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 48, 103);
         return jjMoveStringLiteralDfa5_0(active0, 0x900020000000L);
      case 115:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 38, 103);
         break;
      case 116:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 39, 103);
         return jjMoveStringLiteralDfa5_0(active0, 0x2400000L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000000L);
      case 119:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 50, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000000000L);
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(5, 22, 103);
         break;
      case 102:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 103);
         break;
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000000L);
      case 104:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 49, 103);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000L);
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x420000000000L);
      case 110:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(5, 29, 103);
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000200000L);
      case 116:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 44, 103);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 47, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000000000000L);
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000000000L);
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000000L);
      case 115:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 45, 103);
         break;
      case 116:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 41, 103);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x200000L);
      case 121:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 46, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(7, 21, 103);
         return jjMoveStringLiteralDfa8_0(active0, 0x10000000000000L);
      case 110:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(7, 25, 103);
         break;
      case 114:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 40, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa9_0(active0, 0x10000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, 0L, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 52, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0, 0L, 0L);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0x1L, 0x0L
};
static final long[] jjbitVec1 = {
   0x4000L, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec2 = {
   0x8000000007ffL, 0x80000000L, 0x0L, 0x0L
};
static final long[] jjbitVec3 = {
   0x1L, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec4 = {
   0x30000000000L, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec5 = {
   0xfffffffefffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec7 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec8 = {
   0xfffffcffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec9 = {
   0x200002L, 0x0L, 0xf00000000L, 0x1200000000000000L
};
static final long[] jjbitVec10 = {
   0x10000000000000L, 0x4000L, 0x100000000000L, 0x0L
};
static final long[] jjbitVec11 = {
   0x0L, 0x0L, 0x420040000000000L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec12 = {
   0xffffcffffffffL, 0xffffffffffff0000L, 0xf9ff3fffffffffffL, 0x401f00030003L
};
static final long[] jjbitVec13 = {
   0xffffffffffffffffL, 0x400000700007fffL, 0xfffffffbffffd740L, 0xffffffcff7fffL
};
static final long[] jjbitVec14 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffffff07bL, 0x33fffffffff199fL
};
static final long[] jjbitVec15 = {
   0xfffe000000000000L, 0xfffffffe027fffffL, 0xbbfffffbfffe00ffL, 0x707ffffff0016L
};
static final long[] jjbitVec16 = {
   0x7fffffe00000000L, 0xffff03ff003fffffL, 0xffffffffffffffffL, 0x1fff3dff9fefffffL
};
static final long[] jjbitVec17 = {
   0xffff1fffffff0000L, 0x7ffL, 0x1ffffffffffffL, 0x0L
};
static final long[] jjbitVec18 = {
   0xf3ffffffffffffeeL, 0xffcfff1f3fffL, 0xf3c5fdfffff99feeL, 0x3ffcfb080399fL
};
static final long[] jjbitVec19 = {
   0xd36dfdfffff987e4L, 0x1fffc05e003987L, 0xf3edfdfffffbafeeL, 0xffc100013bbfL
};
static final long[] jjbitVec20 = {
   0xf3cdfdfffff99feeL, 0xffc3b0c0398fL, 0xc3bfc718d63dc7ecL, 0xff8000803dc7L
};
static final long[] jjbitVec21 = {
   0xc3effdfffffddfeeL, 0xffc300603ddfL, 0xc3effdfffffddfecL, 0xffc340603ddfL
};
static final long[] jjbitVec22 = {
   0xc3fffdfffffddfecL, 0xffc300803dcfL, 0x2ffbfffffc7fffecL, 0xc0000ff5f847fL
};
static final long[] jjbitVec23 = {
   0x7fffffffffffffeL, 0x3ff7fffL, 0xfbffecaefef02596L, 0x33ff3f5fL
};
static final long[] jjbitVec24 = {
   0xc2a003ff03000001L, 0xfffe07ffffffffffL, 0x1ffffffffeff0fdfL, 0x40L
};
static final long[] jjbitVec25 = {
   0x3c7f6fbffffffffL, 0x3ff03ffL, 0xffffffff00000000L, 0x7fffffffff003fL
};
static final long[] jjbitVec26 = {
   0xffffffffffffffffL, 0xffffffff83ffffffL, 0xffffff07ffffffffL, 0x3ffffffffffffffL
};
static final long[] jjbitVec27 = {
   0xffffffffffffff7fL, 0xffffffff3d7f3d7fL, 0x7f3d7fffffff3d7fL, 0xffff7fffff7f7f3dL
};
static final long[] jjbitVec28 = {
   0xffffffff7f3d7fffL, 0x3fe0007ffff7fL, 0xffffffff00000000L, 0x1fffffffffffffL
};
static final long[] jjbitVec29 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec30 = {
   0xffffffffffffffffL, 0x7fffffffffffffL, 0xffffffff07fffffeL, 0x7ffffffffffL
};
static final long[] jjbitVec31 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0x3ff000fffffL
};
static final long[] jjbitVec32 = {
   0xffffffff03ff0000L, 0xffffffffffffffL, 0x3ffffffffffL, 0x0L
};
static final long[] jjbitVec33 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffff0fffffffL, 0x3ffffffffffffffL
};
static final long[] jjbitVec34 = {
   0xffffffff3f3fffffL, 0x3fffffffaaff3f3fL, 0x5fdfffffffffffffL, 0x1fdc1fff0fcf1fdcL
};
static final long[] jjbitVec35 = {
   0x8000000000003000L, 0x8000000000000001L, 0x0L, 0x21fff0000L
};
static final long[] jjbitVec36 = {
   0x3fbbd503e2ffc84L, 0xffffffff00000000L, 0xfL, 0x0L
};
static final long[] jjbitVec37 = {
   0x73efffe000000e0L, 0xfffffffffffffffeL, 0xfffffffe661fffffL, 0x7fffffffffffffffL
};
static final long[] jjbitVec38 = {
   0xfffe1fffffffffe0L, 0xffffffffffffffffL, 0xffffff00007fffL, 0x0L
};
static final long[] jjbitVec39 = {
   0x0L, 0x0L, 0x20000000000000L, 0x0L
};
static final long[] jjbitVec40 = {
   0x0L, 0x0L, 0x2000000000L, 0x0L
};
static final long[] jjbitVec41 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x1fffL, 0x0L
};
static final long[] jjbitVec42 = {
   0x0L, 0x0L, 0x800000000L, 0x0L
};
static final long[] jjbitVec43 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec44 = {
   0x5f7ffdffe0f8007fL, 0xffffffffffffffdbL, 0x3ffffffffffffL, 0xfffffffffff80000L
};
static final long[] jjbitVec45 = {
   0x3fffffffffffffffL, 0xffffffffffff0000L, 0xfffffffffffcffffL, 0xfff0000000000ffL
};
static final long[] jjbitVec46 = {
   0x18000f00000000L, 0xffd700000000e000L, 0xffffffffffffffffL, 0x1fffffffffffffffL
};
static final long[] jjbitVec47 = {
   0x87fffffe03ff0000L, 0xffffffe007fffffeL, 0x7fffffffffffffffL, 0x1cfcfcfcL
};
static final long[] jjbitVec48 = {
   0x0L, 0x400000000000000L, 0xfffffffbffffd740L, 0xffffffcff7fffL
};
static final long[] jjbitVec49 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffffff003L, 0x33fffffffff199fL
};
static final long[] jjbitVec50 = {
   0xfffe000000000000L, 0xfffffffe027fffffL, 0xffL, 0x707ffffff0000L
};
static final long[] jjbitVec51 = {
   0x7fffffe00000000L, 0xfffe0000000007ffL, 0xffffffffffffffffL, 0x1c000060002fffffL
};
static final long[] jjbitVec52 = {
   0x1ffffffd0000L, 0x0L, 0x3fffffffffL, 0x0L
};
static final long[] jjbitVec53 = {
   0x23ffffffffffffe0L, 0x3ff010000L, 0x3c5fdfffff99fe0L, 0x30003b0000000L
};
static final long[] jjbitVec54 = {
   0x36dfdfffff987e0L, 0x1c00005e000000L, 0x23edfdfffffbafe0L, 0x100010000L
};
static final long[] jjbitVec55 = {
   0x23cdfdfffff99fe0L, 0x3b0000000L, 0x3bfc718d63dc7e0L, 0x0L
};
static final long[] jjbitVec56 = {
   0x3effdfffffddfe0L, 0x300000000L, 0x3effdfffffddfe0L, 0x340000000L
};
static final long[] jjbitVec57 = {
   0x3fffdfffffddfe0L, 0x300000000L, 0x2ffbfffffc7fffe0L, 0x7fL
};
static final long[] jjbitVec58 = {
   0xdfffffffffffeL, 0x7fL, 0xe00decaefef02596L, 0x3000005fL
};
static final long[] jjbitVec59 = {
   0x1L, 0x7ffffffffffL, 0xf00L, 0x0L
};
static final long[] jjbitVec60 = {
   0x6fbffffffffL, 0x3f0000L, 0xffffffff00000000L, 0x7fffffffff003fL
};
static final long[] jjbitVec61 = {
   0xffffffff7f3d7fffL, 0x7ffff7fL, 0xffffffff00000000L, 0x1fffffffffffffL
};
static final long[] jjbitVec62 = {
   0x0L, 0x0L, 0xfffffffffffffL, 0x0L
};
static final long[] jjbitVec63 = {
   0xffffffff00000000L, 0xffffffffffffffL, 0x1ffffffffffL, 0x0L
};
static final long[] jjbitVec64 = {
   0x0L, 0x8000000000000000L, 0x0L, 0x0L
};
static final long[] jjbitVec65 = {
   0x73e03fe000000e0L, 0xfffffffffffffffeL, 0xfffffffe601fffffL, 0x77ffffffffffffffL
};
static final long[] jjbitVec66 = {
   0x5f7ffdffa0f8007fL, 0xffffffffffffffdbL, 0x3ffffffffffffL, 0xfffffffffff80000L
};
static final long[] jjbitVec67 = {
   0x0L, 0xffd7000000000000L, 0xffffffffffffffffL, 0x1fffffffffffffffL
};
static final long[] jjbitVec68 = {
   0x7fffffe00000000L, 0xffffffc007fffffeL, 0x7fffffffffffffffL, 0x1cfcfcfcL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 103;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 60:
                  if ((0xffff7bffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 62;
                  else if (curChar == 47)
                  {
                     if (kind > 14)
                        kind = 14;
                     jjCheckNAdd(61);
                  }
                  break;
               case 103:
               case 35:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 104:
                  if ((0xffff7fffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 47)
                  {
                     if (kind > 68)
                        kind = 68;
                     jjCheckNAddTwoStates(22, 23);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 62)
                        kind = 62;
                     jjCheckNAddStates(4, 7);
                  }
                  else if ((0x2400L & l) != 0L)
                     jjAddStates(8, 9);
                  else if (curChar == 39)
                     jjCheckNAddStates(10, 15);
                  else if (curChar == 34)
                     jjCheckNAddStates(16, 21);
                  else if (curChar == 47)
                     jjAddStates(22, 23);
                  else if (curChar == 36)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(7);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 85)
                        kind = 85;
                  }
                  else if (curChar == 47)
                     jjAddStates(24, 26);
                  else if (curChar == 10)
                  {
                     if (kind > 12)
                        kind = 12;
                  }
                  else if (curChar == 13)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjstateSet[jjnewStateCnt++] = 2;
                  }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 59)
                        kind = 59;
                     jjCheckNAdd(5);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 61)
                        kind = 61;
                     jjCheckNAddTwoStates(66, 68);
                  }
                  break;
               case 1:
                  if (curChar != 13)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 2:
                  if (curChar == 10 && kind > 12)
                     kind = 12;
                  break;
               case 3:
                  if (curChar == 10 && kind > 12)
                     kind = 12;
                  break;
               case 4:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(5);
                  break;
               case 6:
                  if (curChar == 46)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(7, 8);
                  break;
               case 9:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(10);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if (curChar == 47)
                     jjAddStates(24, 26);
                  break;
               case 12:
                  if ((0xffff7bffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 13:
                  if ((0xffff7fffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 15:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 17:
               case 19:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(27, 29);
                  break;
               case 21:
                  if (curChar != 47)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 22:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 25:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 31:
               case 33:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(30, 32);
                  break;
               case 34:
                  if (curChar != 36)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 39:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 40:
               case 46:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(41);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 45:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 47:
                  if ((0x3ff000000000000L & l) != 0L && kind > 85)
                     kind = 85;
                  break;
               case 48:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddStates(4, 7);
                  break;
               case 49:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(49, 50);
                  break;
               case 50:
                  if (curChar != 46)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(51, 52);
                  break;
               case 51:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(51, 52);
                  break;
               case 53:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(54);
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(54);
                  break;
               case 55:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(55, 56);
                  break;
               case 57:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(58);
                  break;
               case 58:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(58);
                  break;
               case 59:
                  if (curChar == 47)
                     jjAddStates(22, 23);
                  break;
               case 61:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAdd(61);
                  break;
               case 62:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 63:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 15)
                     kind = 15;
                  break;
               case 64:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 65:
                  if (curChar != 48)
                     break;
                  if (kind > 61)
                     kind = 61;
                  jjCheckNAddTwoStates(66, 68);
                  break;
               case 67:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 68:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 61)
                     kind = 61;
                  jjCheckNAdd(68);
                  break;
               case 69:
                  if (curChar == 34)
                     jjCheckNAddStates(16, 21);
                  break;
               case 70:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 71:
                  if (curChar == 34 && kind > 64)
                     kind = 64;
                  break;
               case 73:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 74:
                  if (curChar == 10)
                     jjCheckNAddStates(33, 35);
                  break;
               case 75:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 74;
                  break;
               case 76:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 77:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 78:
                  if ((0x2400L & l) != 0L && kind > 67)
                     kind = 67;
                  break;
               case 80:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 81:
                  if (curChar == 10)
                     jjCheckNAddStates(36, 38);
                  break;
               case 82:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 81;
                  break;
               case 83:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 84:
                  if (curChar == 39)
                     jjCheckNAddStates(10, 15);
                  break;
               case 85:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 86:
                  if (curChar == 39 && kind > 64)
                     kind = 64;
                  break;
               case 88:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 89:
                  if (curChar == 10)
                     jjCheckNAddStates(39, 41);
                  break;
               case 90:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 89;
                  break;
               case 91:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 92:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 94:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 95:
                  if (curChar == 10)
                     jjCheckNAddStates(42, 44);
                  break;
               case 96:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 95;
                  break;
               case 97:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 98:
                  if ((0x2400L & l) != 0L)
                     jjAddStates(8, 9);
                  break;
               case 99:
                  if (curChar == 43 && kind > 111)
                     kind = 111;
                  break;
               case 100:
                  if (curChar == 43)
                     jjstateSet[jjnewStateCnt++] = 99;
                  break;
               case 101:
                  if (curChar == 45 && kind > 113)
                     kind = 113;
                  break;
               case 102:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 101;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 60:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 91)
                     jjCheckNAddStates(30, 32);
                  else if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 103:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  else if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 104:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 91)
                     jjCheckNAddStates(27, 29);
                  else if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  else if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 43;
                  if ((0x7e0000007eL & l) != 0L)
                  {
                     if (kind > 85)
                        kind = 85;
                  }
                  break;
               case 8:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(45, 46);
                  break;
               case 12:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 13:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 14:
                  if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 15:
                  jjCheckNAddStates(0, 3);
                  break;
               case 16:
                  if (curChar == 91)
                     jjCheckNAddStates(27, 29);
                  break;
               case 17:
                  if ((0xffffffffcfffffffL & l) != 0L)
                     jjCheckNAddStates(27, 29);
                  break;
               case 18:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 19:
                  jjCheckNAddStates(27, 29);
                  break;
               case 20:
                  if (curChar == 93)
                     jjCheckNAddStates(0, 3);
                  break;
               case 22:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 23:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 24:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 25;
                  break;
               case 25:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 26:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 27:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 28:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 29:
                  if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 30:
                  if (curChar == 91)
                     jjCheckNAddStates(30, 32);
                  break;
               case 31:
                  if ((0xffffffffcfffffffL & l) != 0L)
                     jjCheckNAddStates(30, 32);
                  break;
               case 32:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 33:
                  jjCheckNAddStates(30, 32);
                  break;
               case 34:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 35:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 36:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 37:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 38:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 39:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 40:
               case 46:
                  if ((0x7e0000007eL & l) != 0L)
                     jjCheckNAdd(41);
                  break;
               case 41:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 42:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 43:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 44:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 45:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 47:
                  if ((0x7e0000007eL & l) != 0L && kind > 85)
                     kind = 85;
                  break;
               case 52:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(47, 48);
                  break;
               case 56:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(49, 50);
                  break;
               case 61:
                  if (kind > 14)
                     kind = 14;
                  jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (kind > 15)
                     kind = 15;
                  break;
               case 66:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(67);
                  break;
               case 67:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjCheckNAdd(67);
                  break;
               case 70:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 72:
                  if (curChar == 92)
                     jjAddStates(51, 53);
                  break;
               case 73:
                  jjCheckNAddStates(33, 35);
                  break;
               case 77:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 79:
                  if (curChar == 92)
                     jjAddStates(54, 56);
                  break;
               case 80:
                  jjCheckNAddStates(36, 38);
                  break;
               case 85:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 87:
                  if (curChar == 92)
                     jjAddStates(57, 59);
                  break;
               case 88:
                  jjCheckNAddStates(39, 41);
                  break;
               case 92:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 93:
                  if (curChar == 92)
                     jjAddStates(60, 62);
                  break;
               case 94:
                  jjCheckNAddStates(42, 44);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 60:
               case 15:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(0, 3);
                  break;
               case 103:
               case 35:
                  if (!jjCanMove_3(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 104:
               case 13:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(0, 3);
                  break;
               case 0:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 12)
                        kind = 12;
                  }
                  if (jjCanMove_4(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(8, 9);
                  break;
               case 3:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 12)
                     kind = 12;
                  break;
               case 17:
               case 19:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(27, 29);
                  break;
               case 22:
                  if (!jjCanMove_3(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjAddStates(63, 64);
                  break;
               case 31:
               case 33:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(30, 32);
                  break;
               case 34:
                  if (!jjCanMove_4(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 61:
                  if (!jjCanMove_2(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (jjCanMove_5(hiByte, i1, i2, l1, l2) && kind > 15)
                     kind = 15;
                  break;
               case 70:
               case 73:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(33, 35);
                  break;
               case 76:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(33, 35);
                  break;
               case 77:
               case 80:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(36, 38);
                  break;
               case 78:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 67)
                     kind = 67;
                  break;
               case 83:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(36, 38);
                  break;
               case 85:
               case 88:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(39, 41);
                  break;
               case 91:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(39, 41);
                  break;
               case 92:
               case 94:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(42, 44);
                  break;
               case 97:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(42, 44);
                  break;
               case 98:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(8, 9);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 103 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_4()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_4(0x40000L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_4(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(1, 18);
         break;
      default :
         return 2;
   }
   return 2;
}
private final int jjStopStringLiteralDfa_1(int pos, long active0, long active1, long active2)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7fffffffff00000L) != 0L)
         {
            jjmatchedKind = 75;
            return 80;
         }
         if ((active1 & 0x40000000L) != 0L)
            return 7;
         if ((active0 & 0x10000L) != 0L || (active1 & 0x20000000000000L) != 0L || (active2 & 0x1L) != 0L)
            return 37;
         return -1;
      case 1:
         if ((active0 & 0x1004000c000000L) != 0L)
            return 80;
         if ((active0 & 0x7effbfff3f00000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 75;
               jjmatchedPos = 1;
            }
            return 80;
         }
         if ((active0 & 0x10000L) != 0L)
            return 39;
         return -1;
      case 2:
         if ((active0 & 0x708000111000000L) != 0L)
            return 80;
         if ((active0 & 0xf7fbfee2f00000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 75;
               jjmatchedPos = 2;
            }
            return 80;
         }
         return -1;
      case 3:
         if ((active0 & 0x57f3e4a2700000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 3;
            return 80;
         }
         if ((active0 & 0xa0081a40800000L) != 0L)
            return 80;
         return -1;
      case 4:
         if ((active0 & 0x4500e400100000L) != 0L)
            return 80;
         if ((active0 & 0x12f300a2600000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 4;
            return 80;
         }
         return -1;
      case 5:
         if ((active0 & 0x29000a0400000L) != 0L)
            return 80;
         if ((active0 & 0x10630002200000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 5;
            return 80;
         }
         return -1;
      case 6:
         if ((active0 & 0x10010002200000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 6;
            return 80;
         }
         if ((active0 & 0x620000000000L) != 0L)
            return 80;
         return -1;
      case 7:
         if ((active0 & 0x10002200000L) != 0L)
            return 80;
         if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 7;
            return 80;
         }
         return -1;
      case 8:
         if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 8;
            return 80;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_1(int pos, long active0, long active1, long active2)
{
   return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0, active1, active2), pos + 1);
}
private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 98;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x88000000000L, 0x0L);
      case 37:
         jjmatchedKind = 121;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x0L, 0x10L);
      case 38:
         jjmatchedKind = 118;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x200000000000L, 0x2L);
      case 40:
         return jjStopAtPos(0, 86);
      case 41:
         return jjStopAtPos(0, 87);
      case 42:
         jjmatchedKind = 116;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x8000000000000000L, 0x0L);
      case 43:
         jjmatchedKind = 114;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x2000400000000000L, 0x0L);
      case 44:
         return jjStopAtPos(0, 93);
      case 45:
         jjmatchedKind = 115;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x4001000000000000L, 0x0L);
      case 46:
         return jjStartNfaWithStates_1(0, 94, 7);
      case 47:
         jjmatchedKind = 117;
         return jjMoveStringLiteralDfa1_1(0x10000L, 0x0L, 0x1L);
      case 58:
         return jjStopAtPos(0, 101);
      case 59:
         return jjStopAtPos(0, 92);
      case 60:
         jjmatchedKind = 97;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x400020000000000L, 0x20L);
      case 61:
         jjmatchedKind = 95;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x14000000000L, 0x0L);
      case 62:
         jjmatchedKind = 96;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x1800040000000000L, 0xc0L);
      case 63:
         return jjStopAtPos(0, 100);
      case 91:
         return jjStopAtPos(0, 90);
      case 93:
         return jjStopAtPos(0, 91);
      case 94:
         jjmatchedKind = 120;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x0L, 0x8L);
      case 98:
         return jjMoveStringLiteralDfa1_1(0x100000L, 0x0L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_1(0xf000200000L, 0x0L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_1(0x70000400000L, 0x0L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_1(0x380000800000L, 0x0L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_1(0x40400003000000L, 0x0L, 0x0L);
      case 103:
         return jjMoveStringLiteralDfa1_1(0x100000000000000L, 0x0L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_1(0x1080000c000000L, 0x0L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_1(0x400000000000000L, 0x0L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_1(0x80000010000000L, 0x0L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_1(0x20000000L, 0x0L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_1(0x203000000000000L, 0x0L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_1(0x2c0000c0000000L, 0x0L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_1(0x300000000L, 0x0L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_1(0xc00000000L, 0x0L, 0x0L);
      case 123:
         return jjStopAtPos(0, 88);
      case 124:
         jjmatchedKind = 119;
         return jjMoveStringLiteralDfa1_1(0x0L, 0x100000000000L, 0x4L);
      case 125:
         return jjStopAtPos(0, 89);
      case 126:
         return jjStopAtPos(0, 99);
      case 160:
         return jjStopAtPos(0, 5);
      case 65279:
         return jjStopAtPos(0, 6);
      default :
         return jjMoveNfa_1(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_1(long active0, long active1, long active2)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(0, active0, active1, active2);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 109);
         break;
      case 42:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_1(1, 16, 39);
         break;
      case 43:
         if ((active1 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 110);
         break;
      case 45:
         if ((active1 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 112);
         break;
      case 60:
         if ((active1 & 0x400000000000000L) != 0L)
         {
            jjmatchedKind = 122;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_1(active0, 0L, active1, 0L, active2, 0x20L);
      case 61:
         if ((active1 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 104;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 105);
         else if ((active1 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 106);
         else if ((active1 & 0x80000000000L) != 0L)
         {
            jjmatchedKind = 107;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(1, 125);
         else if ((active1 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 126);
         else if ((active1 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 127);
         else if ((active2 & 0x1L) != 0L)
            return jjStopAtPos(1, 128);
         else if ((active2 & 0x2L) != 0L)
            return jjStopAtPos(1, 129);
         else if ((active2 & 0x4L) != 0L)
            return jjStopAtPos(1, 130);
         else if ((active2 & 0x8L) != 0L)
            return jjStopAtPos(1, 131);
         else if ((active2 & 0x10L) != 0L)
            return jjStopAtPos(1, 132);
         return jjMoveStringLiteralDfa2_1(active0, 0L, active1, 0xc000000000L, active2, 0L);
      case 62:
         if ((active1 & 0x800000000000000L) != 0L)
         {
            jjmatchedKind = 123;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_1(active0, 0L, active1, 0x1000000000000000L, active2, 0xc0L);
      case 97:
         return jjMoveStringLiteralDfa2_1(active0, 0x40003100000000L, active1, 0L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_1(active0, 0x700030030400000L, active1, 0L, active2, 0L);
      case 102:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_1(1, 26, 80);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_1(active0, 0x4000440000000L, active1, 0L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_1(active0, 0x400800000000L, active1, 0L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_1(active0, 0x4000800000L, active1, 0L, active2, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_1(active0, 0x800000000000L, active1, 0L, active2, 0L);
      case 110:
         if ((active0 & 0x8000000L) != 0L)
         {
            jjmatchedKind = 27;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_1(active0, 0x10080000000000L, active1, 0L, active2, 0L);
      case 111:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_1(1, 42, 80);
         return jjMoveStringLiteralDfa2_1(active0, 0x8201200000L, active1, 0L, active2, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_1(active0, 0x28000000100000L, active1, 0L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_1(active0, 0x81000002000000L, active1, 0L, active2, 0L);
      case 119:
         return jjMoveStringLiteralDfa2_1(active0, 0x2000000000000L, active1, 0L, active2, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_1(active0, 0x300000000000L, active1, 0L, active2, 0L);
      case 121:
         return jjMoveStringLiteralDfa2_1(active0, 0x80000000L, active1, 0L, active2, 0L);
      case 124:
         if ((active1 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 108);
         break;
      default :
         break;
   }
   return jjStartNfa_1(0, active0, active1, active2);
}
private int jjMoveStringLiteralDfa2_1(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_1(0, old0, old1, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(1, active0, active1, active2);
      return 2;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x4000000000L) != 0L)
            return jjStopAtPos(2, 102);
         else if ((active1 & 0x8000000000L) != 0L)
            return jjStopAtPos(2, 103);
         else if ((active2 & 0x20L) != 0L)
            return jjStopAtPos(2, 133);
         else if ((active2 & 0x40L) != 0L)
            return jjStopAtPos(2, 134);
         break;
      case 62:
         if ((active1 & 0x1000000000000000L) != 0L)
         {
            jjmatchedKind = 124;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_1(active0, 0L, active1, 0L, active2, 0x80L);
      case 97:
         return jjMoveStringLiteralDfa3_1(active0, 0x4000000000L, active1, 0L, active2, 0L);
      case 98:
         return jjMoveStringLiteralDfa3_1(active0, 0x10000000000L, active1, 0L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa3_1(active0, 0x100000L, active1, 0L, active2, 0L);
      case 102:
         return jjMoveStringLiteralDfa3_1(active0, 0x20000000000L, active1, 0L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa3_1(active0, 0x2000640000000L, active1, 0L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa3_1(active0, 0xc0000000400000L, active1, 0L, active2, 0L);
      case 110:
         return jjMoveStringLiteralDfa3_1(active0, 0x408002200000L, active1, 0L, active2, 0L);
      case 112:
         return jjMoveStringLiteralDfa3_1(active0, 0x1900080000000L, active1, 0L, active2, 0L);
      case 114:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_1(2, 24, 80);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_1(2, 32, 80);
         return jjMoveStringLiteralDfa3_1(active0, 0x4000000000000L, active1, 0L, active2, 0L);
      case 115:
         return jjMoveStringLiteralDfa3_1(active0, 0x10001000800000L, active1, 0L, active2, 0L);
      case 116:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_1(2, 56, 80);
         else if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_1(2, 57, 80);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_1(2, 58, 80);
         return jjMoveStringLiteralDfa3_1(active0, 0x202820000000L, active1, 0L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa3_1(active0, 0x20080000000000L, active1, 0L, active2, 0L);
      case 119:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_1(2, 28, 80);
         break;
      case 121:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_1(2, 51, 80);
         break;
      default :
         break;
   }
   return jjStartNfa_1(1, active0, active1, active2);
}
private int jjMoveStringLiteralDfa3_1(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_1(1, old0, old1, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(2, active0, 0L, active2);
      return 3;
   }
   switch(curChar)
   {
      case 61:
         if ((active2 & 0x80L) != 0L)
            return jjStopAtPos(3, 135);
         break;
      case 97:
         return jjMoveStringLiteralDfa4_1(active0, 0x420000100000L, active2, 0L);
      case 99:
         return jjMoveStringLiteralDfa4_1(active0, 0x2002000000L, active2, 0L);
      case 100:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_1(3, 33, 80);
         break;
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_1(3, 23, 80);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 36, 80);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 53, 80);
         return jjMoveStringLiteralDfa4_1(active0, 0x1200080400000L, active2, 0L);
      case 104:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_1(3, 35, 80);
         break;
      case 108:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 55, 80);
         return jjMoveStringLiteralDfa4_1(active0, 0x400000000L, active2, 0L);
      case 109:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 43, 80);
         break;
      case 111:
         return jjMoveStringLiteralDfa4_1(active0, 0x4900000000000L, active2, 0L);
      case 115:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_1(3, 30, 80);
         return jjMoveStringLiteralDfa4_1(active0, 0x4000c000000000L, active2, 0L);
      case 116:
         return jjMoveStringLiteralDfa4_1(active0, 0x12000000200000L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa4_1(active0, 0x10020000000L, active2, 0L);
      default :
         break;
   }
   return jjStartNfa_1(2, active0, 0L, active2);
}
private int jjMoveStringLiteralDfa4_1(long old0, long active0, long old2, long active2)
{
   if (((active0 &= old0) | (active2 &= old2)) == 0L)
      return jjStartNfa_1(2, old0, 0L, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(3, active0, 0L, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_1(active0, 0x10000000000000L);
      case 99:
         return jjMoveStringLiteralDfa5_1(active0, 0x2000000000000L);
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_1(4, 34, 80);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 54, 80);
         break;
      case 103:
         return jjMoveStringLiteralDfa5_1(active0, 0x10000000000L);
      case 104:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 37, 80);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_1(active0, 0x200000L);
      case 107:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_1(4, 20, 80);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_1(active0, 0x400000000000L);
      case 110:
         return jjMoveStringLiteralDfa5_1(active0, 0x200000000000L);
      case 111:
         return jjMoveStringLiteralDfa5_1(active0, 0x80000000L);
      case 114:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 48, 80);
         return jjMoveStringLiteralDfa5_1(active0, 0x900020000000L);
      case 115:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 38, 80);
         break;
      case 116:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 39, 80);
         return jjMoveStringLiteralDfa5_1(active0, 0x2400000L);
      case 117:
         return jjMoveStringLiteralDfa5_1(active0, 0x20000000000L);
      case 119:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 50, 80);
         break;
      default :
         break;
   }
   return jjStartNfa_1(3, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa5_1(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(3, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(4, active0, 0L, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa6_1(active0, 0x200000000000L);
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_1(5, 22, 80);
         break;
      case 102:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_1(5, 31, 80);
         break;
      case 103:
         return jjMoveStringLiteralDfa6_1(active0, 0x10000000000L);
      case 104:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_1(5, 49, 80);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_1(active0, 0x2000000L);
      case 108:
         return jjMoveStringLiteralDfa6_1(active0, 0x420000000000L);
      case 110:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_1(5, 29, 80);
         return jjMoveStringLiteralDfa6_1(active0, 0x10000000200000L);
      case 116:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_1(5, 44, 80);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_1(5, 47, 80);
         break;
      default :
         break;
   }
   return jjStartNfa_1(4, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa6_1(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(4, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(5, active0, 0L, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa7_1(active0, 0x10000000000000L);
      case 101:
         return jjMoveStringLiteralDfa7_1(active0, 0x10000000000L);
      case 111:
         return jjMoveStringLiteralDfa7_1(active0, 0x2000000L);
      case 115:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_1(6, 45, 80);
         break;
      case 116:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_1(6, 41, 80);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_1(active0, 0x200000L);
      case 121:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_1(6, 46, 80);
         break;
      default :
         break;
   }
   return jjStartNfa_1(5, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa7_1(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(5, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(6, active0, 0L, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_1(7, 21, 80);
         return jjMoveStringLiteralDfa8_1(active0, 0x10000000000000L);
      case 110:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_1(7, 25, 80);
         break;
      case 114:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_1(7, 40, 80);
         break;
      default :
         break;
   }
   return jjStartNfa_1(6, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa8_1(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(6, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(7, active0, 0L, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa9_1(active0, 0x10000000000000L);
      default :
         break;
   }
   return jjStartNfa_1(7, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa9_1(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(7, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(8, active0, 0L, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_1(9, 52, 80);
         break;
      default :
         break;
   }
   return jjStartNfa_1(8, active0, 0L, 0L);
}
private int jjStartNfaWithStates_1(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_1(state, pos + 1);
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 80;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 80:
               case 12:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 37:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 39;
                  else if (curChar == 47)
                  {
                     if (kind > 14)
                        kind = 14;
                     jjCheckNAdd(38);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 62)
                        kind = 62;
                     jjCheckNAddStates(65, 68);
                  }
                  else if ((0x2400L & l) != 0L)
                     jjAddStates(69, 70);
                  else if (curChar == 39)
                     jjCheckNAddStates(71, 76);
                  else if (curChar == 34)
                     jjCheckNAddStates(77, 82);
                  else if (curChar == 47)
                     jjAddStates(83, 84);
                  else if (curChar == 36)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(12, 13);
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(7);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 85)
                        kind = 85;
                  }
                  else if (curChar == 10)
                  {
                     if (kind > 12)
                        kind = 12;
                  }
                  else if (curChar == 13)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjstateSet[jjnewStateCnt++] = 2;
                  }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 59)
                        kind = 59;
                     jjCheckNAdd(5);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 61)
                        kind = 61;
                     jjCheckNAddTwoStates(43, 45);
                  }
                  break;
               case 1:
                  if (curChar != 13)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 2:
                  if (curChar == 10 && kind > 12)
                     kind = 12;
                  break;
               case 3:
                  if (curChar == 10 && kind > 12)
                     kind = 12;
                  break;
               case 4:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(5);
                  break;
               case 6:
                  if (curChar == 46)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(7, 8);
                  break;
               case 9:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(10);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if (curChar != 36)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 17:
               case 23:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(18);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) != 0L && kind > 85)
                     kind = 85;
                  break;
               case 25:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddStates(65, 68);
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(26, 27);
                  break;
               case 27:
                  if (curChar != 46)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(28, 29);
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(28, 29);
                  break;
               case 30:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(31);
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(31);
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(32, 33);
                  break;
               case 34:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(35);
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(35);
                  break;
               case 36:
                  if (curChar == 47)
                     jjAddStates(83, 84);
                  break;
               case 38:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAdd(38);
                  break;
               case 39:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 40:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 15)
                     kind = 15;
                  break;
               case 41:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 42:
                  if (curChar != 48)
                     break;
                  if (kind > 61)
                     kind = 61;
                  jjCheckNAddTwoStates(43, 45);
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 45:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 61)
                     kind = 61;
                  jjCheckNAdd(45);
                  break;
               case 46:
                  if (curChar == 34)
                     jjCheckNAddStates(77, 82);
                  break;
               case 47:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(85, 87);
                  break;
               case 48:
                  if (curChar == 34 && kind > 64)
                     kind = 64;
                  break;
               case 50:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(85, 87);
                  break;
               case 51:
                  if (curChar == 10)
                     jjCheckNAddStates(85, 87);
                  break;
               case 52:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 51;
                  break;
               case 53:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(85, 87);
                  break;
               case 54:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(88, 90);
                  break;
               case 55:
                  if ((0x2400L & l) != 0L && kind > 67)
                     kind = 67;
                  break;
               case 57:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(88, 90);
                  break;
               case 58:
                  if (curChar == 10)
                     jjCheckNAddStates(88, 90);
                  break;
               case 59:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 58;
                  break;
               case 60:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(88, 90);
                  break;
               case 61:
                  if (curChar == 39)
                     jjCheckNAddStates(71, 76);
                  break;
               case 62:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(91, 93);
                  break;
               case 63:
                  if (curChar == 39 && kind > 64)
                     kind = 64;
                  break;
               case 65:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(91, 93);
                  break;
               case 66:
                  if (curChar == 10)
                     jjCheckNAddStates(91, 93);
                  break;
               case 67:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 66;
                  break;
               case 68:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(91, 93);
                  break;
               case 69:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(94, 96);
                  break;
               case 71:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(94, 96);
                  break;
               case 72:
                  if (curChar == 10)
                     jjCheckNAddStates(94, 96);
                  break;
               case 73:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 72;
                  break;
               case 74:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(94, 96);
                  break;
               case 75:
                  if ((0x2400L & l) != 0L)
                     jjAddStates(69, 70);
                  break;
               case 76:
                  if (curChar == 43 && kind > 111)
                     kind = 111;
                  break;
               case 77:
                  if (curChar == 43)
                     jjstateSet[jjnewStateCnt++] = 76;
                  break;
               case 78:
                  if (curChar == 45 && kind > 113)
                     kind = 113;
                  break;
               case 79:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 78;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 80:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(12, 13);
                  }
                  else if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(12, 13);
                  }
                  else if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 20;
                  if ((0x7e0000007eL & l) != 0L)
                  {
                     if (kind > 85)
                        kind = 85;
                  }
                  break;
               case 8:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(45, 46);
                  break;
               case 11:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 12:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 13:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 14:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 15:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 16:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 17:
               case 23:
                  if ((0x7e0000007eL & l) != 0L)
                     jjCheckNAdd(18);
                  break;
               case 18:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 19:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 20:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 21:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 22:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 24:
                  if ((0x7e0000007eL & l) != 0L && kind > 85)
                     kind = 85;
                  break;
               case 29:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(97, 98);
                  break;
               case 33:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(99, 100);
                  break;
               case 38:
                  if (kind > 14)
                     kind = 14;
                  jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 40:
                  if (kind > 15)
                     kind = 15;
                  break;
               case 43:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(44);
                  break;
               case 44:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjCheckNAdd(44);
                  break;
               case 47:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(85, 87);
                  break;
               case 49:
                  if (curChar == 92)
                     jjAddStates(101, 103);
                  break;
               case 50:
                  jjCheckNAddStates(85, 87);
                  break;
               case 54:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(88, 90);
                  break;
               case 56:
                  if (curChar == 92)
                     jjAddStates(104, 106);
                  break;
               case 57:
                  jjCheckNAddStates(88, 90);
                  break;
               case 62:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(91, 93);
                  break;
               case 64:
                  if (curChar == 92)
                     jjAddStates(107, 109);
                  break;
               case 65:
                  jjCheckNAddStates(91, 93);
                  break;
               case 69:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(94, 96);
                  break;
               case 70:
                  if (curChar == 92)
                     jjAddStates(110, 112);
                  break;
               case 71:
                  jjCheckNAddStates(94, 96);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 80:
               case 12:
                  if (!jjCanMove_3(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 0:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 12)
                        kind = 12;
                  }
                  if (jjCanMove_4(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(12, 13);
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(69, 70);
                  break;
               case 3:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 12)
                     kind = 12;
                  break;
               case 11:
                  if (!jjCanMove_4(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 38:
                  if (!jjCanMove_2(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 40:
                  if (jjCanMove_5(hiByte, i1, i2, l1, l2) && kind > 15)
                     kind = 15;
                  break;
               case 47:
               case 50:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(85, 87);
                  break;
               case 53:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(85, 87);
                  break;
               case 54:
               case 57:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(88, 90);
                  break;
               case 55:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 67)
                     kind = 67;
                  break;
               case 60:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(88, 90);
                  break;
               case 62:
               case 65:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(91, 93);
                  break;
               case 68:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(91, 93);
                  break;
               case 69:
               case 71:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(94, 96);
                  break;
               case 74:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(94, 96);
                  break;
               case 75:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(69, 70);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 80 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjStopStringLiteralDfa_2(int pos, long active0, long active1, long active2)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x10000L) != 0L || (active1 & 0x20000000000000L) != 0L || (active2 & 0x1L) != 0L)
            return 60;
         if ((active0 & 0x7fffffffff00000L) != 0L)
         {
            jjmatchedKind = 75;
            return 103;
         }
         if ((active1 & 0x40000000L) != 0L)
            return 7;
         return -1;
      case 1:
         if ((active0 & 0x7effbfff3f00000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 75;
               jjmatchedPos = 1;
            }
            return 103;
         }
         if ((active0 & 0x1004000c000000L) != 0L)
            return 103;
         if ((active0 & 0x10000L) != 0L)
            return 62;
         if ((active2 & 0x1L) != 0L)
            return 104;
         return -1;
      case 2:
         if ((active0 & 0x708000111000000L) != 0L)
            return 103;
         if ((active0 & 0xf7fbfee2f00000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 75;
               jjmatchedPos = 2;
            }
            return 103;
         }
         return -1;
      case 3:
         if ((active0 & 0x57f3e4a2700000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 3;
            return 103;
         }
         if ((active0 & 0xa0081a40800000L) != 0L)
            return 103;
         return -1;
      case 4:
         if ((active0 & 0x12f300a2600000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 4;
            return 103;
         }
         if ((active0 & 0x4500e400100000L) != 0L)
            return 103;
         return -1;
      case 5:
         if ((active0 & 0x29000a0400000L) != 0L)
            return 103;
         if ((active0 & 0x10630002200000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 5;
            return 103;
         }
         return -1;
      case 6:
         if ((active0 & 0x10010002200000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 6;
            return 103;
         }
         if ((active0 & 0x620000000000L) != 0L)
            return 103;
         return -1;
      case 7:
         if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 7;
            return 103;
         }
         if ((active0 & 0x10002200000L) != 0L)
            return 103;
         return -1;
      case 8:
         if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 75;
            jjmatchedPos = 8;
            return 103;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_2(int pos, long active0, long active1, long active2)
{
   return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0, active1, active2), pos + 1);
}
private int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 98;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x88000000000L, 0x0L);
      case 37:
         jjmatchedKind = 121;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x0L, 0x10L);
      case 38:
         jjmatchedKind = 118;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x200000000000L, 0x2L);
      case 40:
         return jjStopAtPos(0, 86);
      case 41:
         return jjStopAtPos(0, 87);
      case 42:
         jjmatchedKind = 116;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x8000000000000000L, 0x0L);
      case 43:
         jjmatchedKind = 114;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x2000400000000000L, 0x0L);
      case 44:
         return jjStopAtPos(0, 93);
      case 45:
         jjmatchedKind = 115;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x4001000000000000L, 0x0L);
      case 46:
         return jjStartNfaWithStates_2(0, 94, 7);
      case 47:
         jjmatchedKind = 117;
         return jjMoveStringLiteralDfa1_2(0x10000L, 0x0L, 0x1L);
      case 58:
         return jjStopAtPos(0, 101);
      case 59:
         return jjStopAtPos(0, 92);
      case 60:
         jjmatchedKind = 97;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x400020000000000L, 0x20L);
      case 61:
         jjmatchedKind = 95;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x14000000000L, 0x0L);
      case 62:
         jjmatchedKind = 96;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x1800040000000000L, 0xc0L);
      case 63:
         return jjStopAtPos(0, 100);
      case 91:
         return jjStopAtPos(0, 90);
      case 93:
         return jjStopAtPos(0, 91);
      case 94:
         jjmatchedKind = 120;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x0L, 0x8L);
      case 98:
         return jjMoveStringLiteralDfa1_2(0x100000L, 0x0L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_2(0xf000200000L, 0x0L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_2(0x70000400000L, 0x0L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_2(0x380000800000L, 0x0L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_2(0x40400003000000L, 0x0L, 0x0L);
      case 103:
         return jjMoveStringLiteralDfa1_2(0x100000000000000L, 0x0L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_2(0x1080000c000000L, 0x0L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_2(0x400000000000000L, 0x0L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_2(0x80000010000000L, 0x0L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_2(0x20000000L, 0x0L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_2(0x203000000000000L, 0x0L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_2(0x2c0000c0000000L, 0x0L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_2(0x300000000L, 0x0L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_2(0xc00000000L, 0x0L, 0x0L);
      case 123:
         return jjStopAtPos(0, 88);
      case 124:
         jjmatchedKind = 119;
         return jjMoveStringLiteralDfa1_2(0x0L, 0x100000000000L, 0x4L);
      case 125:
         return jjStopAtPos(0, 89);
      case 126:
         return jjStopAtPos(0, 99);
      case 160:
         return jjStopAtPos(0, 5);
      case 65279:
         return jjStopAtPos(0, 6);
      default :
         return jjMoveNfa_2(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_2(long active0, long active1, long active2)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(0, active0, active1, active2);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 109);
         break;
      case 42:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_2(1, 16, 62);
         break;
      case 43:
         if ((active1 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 110);
         break;
      case 45:
         if ((active1 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 112);
         break;
      case 60:
         if ((active1 & 0x400000000000000L) != 0L)
         {
            jjmatchedKind = 122;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_2(active0, 0L, active1, 0L, active2, 0x20L);
      case 61:
         if ((active1 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 104;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 105);
         else if ((active1 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 106);
         else if ((active1 & 0x80000000000L) != 0L)
         {
            jjmatchedKind = 107;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(1, 125);
         else if ((active1 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 126);
         else if ((active1 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 127);
         else if ((active2 & 0x1L) != 0L)
            return jjStartNfaWithStates_2(1, 128, 104);
         else if ((active2 & 0x2L) != 0L)
            return jjStopAtPos(1, 129);
         else if ((active2 & 0x4L) != 0L)
            return jjStopAtPos(1, 130);
         else if ((active2 & 0x8L) != 0L)
            return jjStopAtPos(1, 131);
         else if ((active2 & 0x10L) != 0L)
            return jjStopAtPos(1, 132);
         return jjMoveStringLiteralDfa2_2(active0, 0L, active1, 0xc000000000L, active2, 0L);
      case 62:
         if ((active1 & 0x800000000000000L) != 0L)
         {
            jjmatchedKind = 123;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_2(active0, 0L, active1, 0x1000000000000000L, active2, 0xc0L);
      case 97:
         return jjMoveStringLiteralDfa2_2(active0, 0x40003100000000L, active1, 0L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_2(active0, 0x700030030400000L, active1, 0L, active2, 0L);
      case 102:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_2(1, 26, 103);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_2(active0, 0x4000440000000L, active1, 0L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_2(active0, 0x400800000000L, active1, 0L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_2(active0, 0x4000800000L, active1, 0L, active2, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_2(active0, 0x800000000000L, active1, 0L, active2, 0L);
      case 110:
         if ((active0 & 0x8000000L) != 0L)
         {
            jjmatchedKind = 27;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_2(active0, 0x10080000000000L, active1, 0L, active2, 0L);
      case 111:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_2(1, 42, 103);
         return jjMoveStringLiteralDfa2_2(active0, 0x8201200000L, active1, 0L, active2, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_2(active0, 0x28000000100000L, active1, 0L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_2(active0, 0x81000002000000L, active1, 0L, active2, 0L);
      case 119:
         return jjMoveStringLiteralDfa2_2(active0, 0x2000000000000L, active1, 0L, active2, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_2(active0, 0x300000000000L, active1, 0L, active2, 0L);
      case 121:
         return jjMoveStringLiteralDfa2_2(active0, 0x80000000L, active1, 0L, active2, 0L);
      case 124:
         if ((active1 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 108);
         break;
      default :
         break;
   }
   return jjStartNfa_2(0, active0, active1, active2);
}
private int jjMoveStringLiteralDfa2_2(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_2(0, old0, old1, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(1, active0, active1, active2);
      return 2;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x4000000000L) != 0L)
            return jjStopAtPos(2, 102);
         else if ((active1 & 0x8000000000L) != 0L)
            return jjStopAtPos(2, 103);
         else if ((active2 & 0x20L) != 0L)
            return jjStopAtPos(2, 133);
         else if ((active2 & 0x40L) != 0L)
            return jjStopAtPos(2, 134);
         break;
      case 62:
         if ((active1 & 0x1000000000000000L) != 0L)
         {
            jjmatchedKind = 124;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_2(active0, 0L, active1, 0L, active2, 0x80L);
      case 97:
         return jjMoveStringLiteralDfa3_2(active0, 0x4000000000L, active1, 0L, active2, 0L);
      case 98:
         return jjMoveStringLiteralDfa3_2(active0, 0x10000000000L, active1, 0L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa3_2(active0, 0x100000L, active1, 0L, active2, 0L);
      case 102:
         return jjMoveStringLiteralDfa3_2(active0, 0x20000000000L, active1, 0L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa3_2(active0, 0x2000640000000L, active1, 0L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa3_2(active0, 0xc0000000400000L, active1, 0L, active2, 0L);
      case 110:
         return jjMoveStringLiteralDfa3_2(active0, 0x408002200000L, active1, 0L, active2, 0L);
      case 112:
         return jjMoveStringLiteralDfa3_2(active0, 0x1900080000000L, active1, 0L, active2, 0L);
      case 114:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_2(2, 24, 103);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_2(2, 32, 103);
         return jjMoveStringLiteralDfa3_2(active0, 0x4000000000000L, active1, 0L, active2, 0L);
      case 115:
         return jjMoveStringLiteralDfa3_2(active0, 0x10001000800000L, active1, 0L, active2, 0L);
      case 116:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_2(2, 56, 103);
         else if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_2(2, 57, 103);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_2(2, 58, 103);
         return jjMoveStringLiteralDfa3_2(active0, 0x202820000000L, active1, 0L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa3_2(active0, 0x20080000000000L, active1, 0L, active2, 0L);
      case 119:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_2(2, 28, 103);
         break;
      case 121:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_2(2, 51, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_2(1, active0, active1, active2);
}
private int jjMoveStringLiteralDfa3_2(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_2(1, old0, old1, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(2, active0, 0L, active2);
      return 3;
   }
   switch(curChar)
   {
      case 61:
         if ((active2 & 0x80L) != 0L)
            return jjStopAtPos(3, 135);
         break;
      case 97:
         return jjMoveStringLiteralDfa4_2(active0, 0x420000100000L, active2, 0L);
      case 99:
         return jjMoveStringLiteralDfa4_2(active0, 0x2002000000L, active2, 0L);
      case 100:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_2(3, 33, 103);
         break;
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_2(3, 23, 103);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_2(3, 36, 103);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_2(3, 53, 103);
         return jjMoveStringLiteralDfa4_2(active0, 0x1200080400000L, active2, 0L);
      case 104:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_2(3, 35, 103);
         break;
      case 108:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_2(3, 55, 103);
         return jjMoveStringLiteralDfa4_2(active0, 0x400000000L, active2, 0L);
      case 109:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_2(3, 43, 103);
         break;
      case 111:
         return jjMoveStringLiteralDfa4_2(active0, 0x4900000000000L, active2, 0L);
      case 115:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_2(3, 30, 103);
         return jjMoveStringLiteralDfa4_2(active0, 0x4000c000000000L, active2, 0L);
      case 116:
         return jjMoveStringLiteralDfa4_2(active0, 0x12000000200000L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa4_2(active0, 0x10020000000L, active2, 0L);
      default :
         break;
   }
   return jjStartNfa_2(2, active0, 0L, active2);
}
private int jjMoveStringLiteralDfa4_2(long old0, long active0, long old2, long active2)
{
   if (((active0 &= old0) | (active2 &= old2)) == 0L)
      return jjStartNfa_2(2, old0, 0L, old2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(3, active0, 0L, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_2(active0, 0x10000000000000L);
      case 99:
         return jjMoveStringLiteralDfa5_2(active0, 0x2000000000000L);
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_2(4, 34, 103);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_2(4, 54, 103);
         break;
      case 103:
         return jjMoveStringLiteralDfa5_2(active0, 0x10000000000L);
      case 104:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_2(4, 37, 103);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_2(active0, 0x200000L);
      case 107:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_2(4, 20, 103);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_2(active0, 0x400000000000L);
      case 110:
         return jjMoveStringLiteralDfa5_2(active0, 0x200000000000L);
      case 111:
         return jjMoveStringLiteralDfa5_2(active0, 0x80000000L);
      case 114:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_2(4, 48, 103);
         return jjMoveStringLiteralDfa5_2(active0, 0x900020000000L);
      case 115:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_2(4, 38, 103);
         break;
      case 116:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_2(4, 39, 103);
         return jjMoveStringLiteralDfa5_2(active0, 0x2400000L);
      case 117:
         return jjMoveStringLiteralDfa5_2(active0, 0x20000000000L);
      case 119:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_2(4, 50, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_2(3, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa5_2(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_2(3, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(4, active0, 0L, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa6_2(active0, 0x200000000000L);
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_2(5, 22, 103);
         break;
      case 102:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_2(5, 31, 103);
         break;
      case 103:
         return jjMoveStringLiteralDfa6_2(active0, 0x10000000000L);
      case 104:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_2(5, 49, 103);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_2(active0, 0x2000000L);
      case 108:
         return jjMoveStringLiteralDfa6_2(active0, 0x420000000000L);
      case 110:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_2(5, 29, 103);
         return jjMoveStringLiteralDfa6_2(active0, 0x10000000200000L);
      case 116:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_2(5, 44, 103);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_2(5, 47, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_2(4, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa6_2(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_2(4, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(5, active0, 0L, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa7_2(active0, 0x10000000000000L);
      case 101:
         return jjMoveStringLiteralDfa7_2(active0, 0x10000000000L);
      case 111:
         return jjMoveStringLiteralDfa7_2(active0, 0x2000000L);
      case 115:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_2(6, 45, 103);
         break;
      case 116:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_2(6, 41, 103);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_2(active0, 0x200000L);
      case 121:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_2(6, 46, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_2(5, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa7_2(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_2(5, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(6, active0, 0L, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_2(7, 21, 103);
         return jjMoveStringLiteralDfa8_2(active0, 0x10000000000000L);
      case 110:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_2(7, 25, 103);
         break;
      case 114:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_2(7, 40, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_2(6, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa8_2(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_2(6, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(7, active0, 0L, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa9_2(active0, 0x10000000000000L);
      default :
         break;
   }
   return jjStartNfa_2(7, active0, 0L, 0L);
}
private int jjMoveStringLiteralDfa9_2(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_2(7, old0, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(8, active0, 0L, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_2(9, 52, 103);
         break;
      default :
         break;
   }
   return jjStartNfa_2(8, active0, 0L, 0L);
}
private int jjStartNfaWithStates_2(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_2(state, pos + 1);
}
private int jjMoveNfa_2(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 103;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 60:
                  if ((0xffff7bffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 62;
                  else if (curChar == 47)
                  {
                     if (kind > 14)
                        kind = 14;
                     jjCheckNAdd(61);
                  }
                  break;
               case 103:
               case 35:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 104:
                  if ((0xffff7fffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 47)
                  {
                     if (kind > 68)
                        kind = 68;
                     jjCheckNAddTwoStates(22, 23);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 62)
                        kind = 62;
                     jjCheckNAddStates(4, 7);
                  }
                  else if ((0x2400L & l) != 0L)
                     jjAddStates(8, 9);
                  else if (curChar == 39)
                     jjCheckNAddStates(10, 15);
                  else if (curChar == 34)
                     jjCheckNAddStates(16, 21);
                  else if (curChar == 47)
                     jjAddStates(22, 23);
                  else if (curChar == 36)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(7);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 85)
                        kind = 85;
                  }
                  else if (curChar == 47)
                     jjAddStates(24, 26);
                  else if (curChar == 10)
                  {
                     if (kind > 13)
                        kind = 13;
                  }
                  else if (curChar == 13)
                  {
                     if (kind > 13)
                        kind = 13;
                     jjstateSet[jjnewStateCnt++] = 2;
                  }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 59)
                        kind = 59;
                     jjCheckNAdd(5);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 61)
                        kind = 61;
                     jjCheckNAddTwoStates(66, 68);
                  }
                  break;
               case 1:
                  if (curChar != 13)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 2:
                  if (curChar == 10 && kind > 13)
                     kind = 13;
                  break;
               case 3:
                  if (curChar == 10 && kind > 13)
                     kind = 13;
                  break;
               case 4:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(5);
                  break;
               case 6:
                  if (curChar == 46)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(7, 8);
                  break;
               case 9:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(10);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if (curChar == 47)
                     jjAddStates(24, 26);
                  break;
               case 12:
                  if ((0xffff7bffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 13:
                  if ((0xffff7fffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 15:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 17:
               case 19:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(27, 29);
                  break;
               case 21:
                  if (curChar != 47)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 22:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 25:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 31:
               case 33:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(30, 32);
                  break;
               case 34:
                  if (curChar != 36)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 39:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 40:
               case 46:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(41);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 45:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 47:
                  if ((0x3ff000000000000L & l) != 0L && kind > 85)
                     kind = 85;
                  break;
               case 48:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddStates(4, 7);
                  break;
               case 49:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(49, 50);
                  break;
               case 50:
                  if (curChar != 46)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(51, 52);
                  break;
               case 51:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(51, 52);
                  break;
               case 53:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(54);
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(54);
                  break;
               case 55:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAddTwoStates(55, 56);
                  break;
               case 57:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(58);
                  break;
               case 58:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 62)
                     kind = 62;
                  jjCheckNAdd(58);
                  break;
               case 59:
                  if (curChar == 47)
                     jjAddStates(22, 23);
                  break;
               case 61:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAdd(61);
                  break;
               case 62:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 63:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 15)
                     kind = 15;
                  break;
               case 64:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 65:
                  if (curChar != 48)
                     break;
                  if (kind > 61)
                     kind = 61;
                  jjCheckNAddTwoStates(66, 68);
                  break;
               case 67:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 68:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 61)
                     kind = 61;
                  jjCheckNAdd(68);
                  break;
               case 69:
                  if (curChar == 34)
                     jjCheckNAddStates(16, 21);
                  break;
               case 70:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 71:
                  if (curChar == 34 && kind > 64)
                     kind = 64;
                  break;
               case 73:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 74:
                  if (curChar == 10)
                     jjCheckNAddStates(33, 35);
                  break;
               case 75:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 74;
                  break;
               case 76:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 77:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 78:
                  if ((0x2400L & l) != 0L && kind > 67)
                     kind = 67;
                  break;
               case 80:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 81:
                  if (curChar == 10)
                     jjCheckNAddStates(36, 38);
                  break;
               case 82:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 81;
                  break;
               case 83:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 84:
                  if (curChar == 39)
                     jjCheckNAddStates(10, 15);
                  break;
               case 85:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 86:
                  if (curChar == 39 && kind > 64)
                     kind = 64;
                  break;
               case 88:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 89:
                  if (curChar == 10)
                     jjCheckNAddStates(39, 41);
                  break;
               case 90:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 89;
                  break;
               case 91:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 92:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 94:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 95:
                  if (curChar == 10)
                     jjCheckNAddStates(42, 44);
                  break;
               case 96:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 95;
                  break;
               case 97:
                  if ((0x2400L & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 98:
                  if ((0x2400L & l) != 0L)
                     jjAddStates(8, 9);
                  break;
               case 99:
                  if (curChar == 43 && kind > 111)
                     kind = 111;
                  break;
               case 100:
                  if (curChar == 43)
                     jjstateSet[jjnewStateCnt++] = 99;
                  break;
               case 101:
                  if (curChar == 45 && kind > 113)
                     kind = 113;
                  break;
               case 102:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 101;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 60:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 91)
                     jjCheckNAddStates(30, 32);
                  else if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 103:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  else if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 104:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  else if (curChar == 91)
                     jjCheckNAddStates(27, 29);
                  else if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  else if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 43;
                  if ((0x7e0000007eL & l) != 0L)
                  {
                     if (kind > 85)
                        kind = 85;
                  }
                  break;
               case 8:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(45, 46);
                  break;
               case 12:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 13:
                  if ((0xffffffffe7ffffffL & l) != 0L)
                     jjCheckNAddStates(0, 3);
                  break;
               case 14:
                  if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 15:
                  jjCheckNAddStates(0, 3);
                  break;
               case 16:
                  if (curChar == 91)
                     jjCheckNAddStates(27, 29);
                  break;
               case 17:
                  if ((0xffffffffcfffffffL & l) != 0L)
                     jjCheckNAddStates(27, 29);
                  break;
               case 18:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 19:
                  jjCheckNAddStates(27, 29);
                  break;
               case 20:
                  if (curChar == 93)
                     jjCheckNAddStates(0, 3);
                  break;
               case 22:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 23:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 24:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 25;
                  break;
               case 25:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 26:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 27:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 28:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 29:
                  if (curChar == 92)
                     jjCheckNAdd(15);
                  break;
               case 30:
                  if (curChar == 91)
                     jjCheckNAddStates(30, 32);
                  break;
               case 31:
                  if ((0xffffffffcfffffffL & l) != 0L)
                     jjCheckNAddStates(30, 32);
                  break;
               case 32:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 33:
                  jjCheckNAddStates(30, 32);
                  break;
               case 34:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 35:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 36:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 37:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 38:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 39:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 40:
               case 46:
                  if ((0x7e0000007eL & l) != 0L)
                     jjCheckNAdd(41);
                  break;
               case 41:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 42:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 43:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 44:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 45:
                  if ((0x7e0000007eL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 47:
                  if ((0x7e0000007eL & l) != 0L && kind > 85)
                     kind = 85;
                  break;
               case 52:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(47, 48);
                  break;
               case 56:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(49, 50);
                  break;
               case 61:
                  if (kind > 14)
                     kind = 14;
                  jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (kind > 15)
                     kind = 15;
                  break;
               case 66:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(67);
                  break;
               case 67:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjCheckNAdd(67);
                  break;
               case 70:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(33, 35);
                  break;
               case 72:
                  if (curChar == 92)
                     jjAddStates(51, 53);
                  break;
               case 73:
                  jjCheckNAddStates(33, 35);
                  break;
               case 77:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(36, 38);
                  break;
               case 79:
                  if (curChar == 92)
                     jjAddStates(54, 56);
                  break;
               case 80:
                  jjCheckNAddStates(36, 38);
                  break;
               case 85:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(39, 41);
                  break;
               case 87:
                  if (curChar == 92)
                     jjAddStates(57, 59);
                  break;
               case 88:
                  jjCheckNAddStates(39, 41);
                  break;
               case 92:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(42, 44);
                  break;
               case 93:
                  if (curChar == 92)
                     jjAddStates(60, 62);
                  break;
               case 94:
                  jjCheckNAddStates(42, 44);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 60:
               case 15:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(0, 3);
                  break;
               case 103:
               case 35:
                  if (!jjCanMove_3(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 104:
               case 13:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(0, 3);
                  break;
               case 0:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 13)
                        kind = 13;
                  }
                  if (jjCanMove_4(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 75)
                        kind = 75;
                     jjCheckNAddTwoStates(35, 36);
                  }
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(8, 9);
                  break;
               case 3:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 13)
                     kind = 13;
                  break;
               case 17:
               case 19:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(27, 29);
                  break;
               case 22:
                  if (!jjCanMove_3(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 68)
                     kind = 68;
                  jjAddStates(63, 64);
                  break;
               case 31:
               case 33:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(30, 32);
                  break;
               case 34:
                  if (!jjCanMove_4(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 75)
                     kind = 75;
                  jjCheckNAddTwoStates(35, 36);
                  break;
               case 61:
                  if (!jjCanMove_2(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (jjCanMove_5(hiByte, i1, i2, l1, l2) && kind > 15)
                     kind = 15;
                  break;
               case 70:
               case 73:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(33, 35);
                  break;
               case 76:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(33, 35);
                  break;
               case 77:
               case 80:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(36, 38);
                  break;
               case 78:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 67)
                     kind = 67;
                  break;
               case 83:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(36, 38);
                  break;
               case 85:
               case 88:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(39, 41);
                  break;
               case 91:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(39, 41);
                  break;
               case 92:
               case 94:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(42, 44);
                  break;
               case 97:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(42, 44);
                  break;
               case 98:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(8, 9);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 103 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_3()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_3(0x20000L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_3(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(1, 17);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   13, 14, 16, 21, 49, 50, 55, 56, 100, 102, 85, 86, 92, 78, 93, 87, 
   70, 71, 77, 78, 79, 72, 60, 64, 12, 29, 30, 17, 18, 20, 31, 32, 
   20, 70, 71, 72, 77, 78, 79, 85, 86, 87, 92, 78, 93, 9, 10, 53, 
   54, 57, 58, 73, 75, 76, 80, 82, 83, 88, 90, 91, 94, 96, 97, 22, 
   23, 26, 27, 32, 33, 77, 79, 62, 63, 69, 55, 70, 64, 47, 48, 54, 
   55, 56, 49, 37, 41, 47, 48, 49, 54, 55, 56, 62, 63, 64, 69, 55, 
   70, 30, 31, 34, 35, 50, 52, 53, 57, 59, 60, 65, 67, 68, 71, 73, 
   74, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 22:
         return ((jjbitVec0[i2] & l2) != 0L);
      case 24:
         return ((jjbitVec1[i2] & l2) != 0L);
      case 32:
         return ((jjbitVec2[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec3[i2] & l2) != 0L);
      default :
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 32:
         return ((jjbitVec4[i2] & l2) != 0L);
      default :
         return false;
   }
}
private static final boolean jjCanMove_2(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 32:
         return ((jjbitVec8[i2] & l2) != 0L);
      default :
         if ((jjbitVec5[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_3(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec11[i2] & l2) != 0L);
      case 2:
         return ((jjbitVec12[i2] & l2) != 0L);
      case 3:
         return ((jjbitVec13[i2] & l2) != 0L);
      case 4:
         return ((jjbitVec14[i2] & l2) != 0L);
      case 5:
         return ((jjbitVec15[i2] & l2) != 0L);
      case 6:
         return ((jjbitVec16[i2] & l2) != 0L);
      case 7:
         return ((jjbitVec17[i2] & l2) != 0L);
      case 9:
         return ((jjbitVec18[i2] & l2) != 0L);
      case 10:
         return ((jjbitVec19[i2] & l2) != 0L);
      case 11:
         return ((jjbitVec20[i2] & l2) != 0L);
      case 12:
         return ((jjbitVec21[i2] & l2) != 0L);
      case 13:
         return ((jjbitVec22[i2] & l2) != 0L);
      case 14:
         return ((jjbitVec23[i2] & l2) != 0L);
      case 15:
         return ((jjbitVec24[i2] & l2) != 0L);
      case 16:
         return ((jjbitVec25[i2] & l2) != 0L);
      case 17:
         return ((jjbitVec26[i2] & l2) != 0L);
      case 18:
         return ((jjbitVec27[i2] & l2) != 0L);
      case 19:
         return ((jjbitVec28[i2] & l2) != 0L);
      case 20:
         return ((jjbitVec29[i2] & l2) != 0L);
      case 22:
         return ((jjbitVec30[i2] & l2) != 0L);
      case 23:
         return ((jjbitVec31[i2] & l2) != 0L);
      case 24:
         return ((jjbitVec32[i2] & l2) != 0L);
      case 30:
         return ((jjbitVec33[i2] & l2) != 0L);
      case 31:
         return ((jjbitVec34[i2] & l2) != 0L);
      case 32:
         return ((jjbitVec35[i2] & l2) != 0L);
      case 33:
         return ((jjbitVec36[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec37[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec38[i2] & l2) != 0L);
      case 77:
         return ((jjbitVec39[i2] & l2) != 0L);
      case 159:
         return ((jjbitVec40[i2] & l2) != 0L);
      case 164:
         return ((jjbitVec41[i2] & l2) != 0L);
      case 215:
         return ((jjbitVec42[i2] & l2) != 0L);
      case 250:
         return ((jjbitVec43[i2] & l2) != 0L);
      case 251:
         return ((jjbitVec44[i2] & l2) != 0L);
      case 253:
         return ((jjbitVec45[i2] & l2) != 0L);
      case 254:
         return ((jjbitVec46[i2] & l2) != 0L);
      case 255:
         return ((jjbitVec47[i2] & l2) != 0L);
      default :
         if ((jjbitVec10[i1] & l1) != 0L)
            if ((jjbitVec3[i2] & l2) == 0L)
               return false;
            else
            return true;
         if ((jjbitVec9[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_4(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec11[i2] & l2) != 0L);
      case 2:
         return ((jjbitVec12[i2] & l2) != 0L);
      case 3:
         return ((jjbitVec48[i2] & l2) != 0L);
      case 4:
         return ((jjbitVec49[i2] & l2) != 0L);
      case 5:
         return ((jjbitVec50[i2] & l2) != 0L);
      case 6:
         return ((jjbitVec51[i2] & l2) != 0L);
      case 7:
         return ((jjbitVec52[i2] & l2) != 0L);
      case 9:
         return ((jjbitVec53[i2] & l2) != 0L);
      case 10:
         return ((jjbitVec54[i2] & l2) != 0L);
      case 11:
         return ((jjbitVec55[i2] & l2) != 0L);
      case 12:
         return ((jjbitVec56[i2] & l2) != 0L);
      case 13:
         return ((jjbitVec57[i2] & l2) != 0L);
      case 14:
         return ((jjbitVec58[i2] & l2) != 0L);
      case 15:
         return ((jjbitVec59[i2] & l2) != 0L);
      case 16:
         return ((jjbitVec60[i2] & l2) != 0L);
      case 17:
         return ((jjbitVec26[i2] & l2) != 0L);
      case 18:
         return ((jjbitVec27[i2] & l2) != 0L);
      case 19:
         return ((jjbitVec61[i2] & l2) != 0L);
      case 20:
         return ((jjbitVec29[i2] & l2) != 0L);
      case 22:
         return ((jjbitVec30[i2] & l2) != 0L);
      case 23:
         return ((jjbitVec62[i2] & l2) != 0L);
      case 24:
         return ((jjbitVec63[i2] & l2) != 0L);
      case 30:
         return ((jjbitVec33[i2] & l2) != 0L);
      case 31:
         return ((jjbitVec34[i2] & l2) != 0L);
      case 32:
         return ((jjbitVec64[i2] & l2) != 0L);
      case 33:
         return ((jjbitVec36[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec65[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec38[i2] & l2) != 0L);
      case 77:
         return ((jjbitVec39[i2] & l2) != 0L);
      case 159:
         return ((jjbitVec40[i2] & l2) != 0L);
      case 164:
         return ((jjbitVec41[i2] & l2) != 0L);
      case 215:
         return ((jjbitVec42[i2] & l2) != 0L);
      case 250:
         return ((jjbitVec43[i2] & l2) != 0L);
      case 251:
         return ((jjbitVec66[i2] & l2) != 0L);
      case 253:
         return ((jjbitVec45[i2] & l2) != 0L);
      case 254:
         return ((jjbitVec67[i2] & l2) != 0L);
      case 255:
         return ((jjbitVec68[i2] & l2) != 0L);
      default :
         if ((jjbitVec10[i1] & l1) != 0L)
            if ((jjbitVec3[i2] & l2) == 0L)
               return false;
            else
            return true;
         if ((jjbitVec9[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_5(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec7[i2] & l2) != 0L);
      default :
         if ((jjbitVec29[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, "\142\162\145\141\153", 
"\143\157\156\164\151\156\165\145", "\144\145\154\145\164\145", "\145\154\163\145", "\146\157\162", 
"\146\165\156\143\164\151\157\156", "\151\146", "\151\156", "\156\145\167", "\162\145\164\165\162\156", 
"\164\150\151\163", "\164\171\160\145\157\146", "\166\141\162", "\166\157\151\144", 
"\167\150\151\154\145", "\167\151\164\150", "\143\141\163\145", "\143\141\164\143\150", 
"\143\154\141\163\163", "\143\157\156\163\164", "\144\145\142\165\147\147\145\162", 
"\144\145\146\141\165\154\164", "\144\157", "\145\156\165\155", "\145\170\160\157\162\164", 
"\145\170\164\145\156\144\163", "\146\151\156\141\154\154\171", "\151\155\160\157\162\164", 
"\163\165\160\145\162", "\163\167\151\164\143\150", "\164\150\162\157\167", "\164\162\171", 
"\151\156\163\164\141\156\143\145\157\146", "\164\162\165\145", "\146\141\154\163\145", "\156\165\154\154", 
"\147\145\164", "\163\145\164", "\154\145\164", null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, "\50", "\51", "\173", "\175", "\133", "\135", "\73", 
"\54", "\56", "\75", "\76", "\74", "\41", "\176", "\77", "\72", "\75\75\75", 
"\41\75\75", "\75\75", "\74\75", "\76\75", "\41\75", "\174\174", "\46\46", "\53\53", null, 
"\55\55", null, "\53", "\55", "\52", "\57", "\46", "\174", "\136", "\45", "\74\74", 
"\76\76", "\76\76\76", "\53\75", "\55\75", "\52\75", "\57\75", "\46\75", "\174\75", 
"\136\75", "\45\75", "\74\74\75", "\76\76\75", "\76\76\76\75", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "NOREGEXP",
   "NOEOL",
   "IN_JS_DOC_COMMENT",
   "IN_MULTI_LINE_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, 4, 0, 0, -1, 2, 2, 0, 0, 0, 
   0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
   2, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 
   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
};
static final long[] jjtoToken = {
   0x7ffffffffff02001L, 0xffffffffffe00819L, 0xffL, 
};
static final long[] jjtoSkip = {
   0x650feL, 0x0L, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x65000L, 0x0L, 0x0L, 
};
static final long[] jjtoMore = {
   0x98000L, 0x0L, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[103];
private final int[] jjstateSet = new int[206];
private final StringBuilder jjimage = new StringBuilder();
private StringBuilder image = jjimage;
private int jjimageLen;
private int lengthOfMatch;
protected char curChar;
/** Constructor. */
public ASTParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ASTParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 103; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 5 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   t.image = curTokenImage;

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      CommonTokenAction(matchedToken);
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100001a00L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100001a00L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         break;
       case 2:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100001a00L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         break;
       case 3:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_3();
         if (jjmatchedPos == 0 && jjmatchedKind > 19)
         {
            jjmatchedKind = 19;
         }
         break;
       case 4:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_4();
         if (jjmatchedPos == 0 && jjmatchedKind > 19)
         {
            jjmatchedKind = 19;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
           TokenLexicalActions(matchedToken);
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           CommonTokenAction(matchedToken);
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        MoreLexicalActions();
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      case 15 :
         image.append(input_stream.GetSuffix(jjimageLen));
         jjimageLen = 0;
    input_stream.backup(1);
         break;
      default :
         break;
   }
}
void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 110 :
        image.append(jjstrLiteralImages[110]);
        lengthOfMatch = jjstrLiteralImages[110].length();
                   if (matchedToken.specialToken != null && matchedToken.specialToken.kind == EOL) { matchedToken.kind = NL_INCR; }
         break;
      case 112 :
        image.append(jjstrLiteralImages[112]);
        lengthOfMatch = jjstrLiteralImages[112].length();
                   if (matchedToken.specialToken != null && matchedToken.specialToken.kind == EOL) { matchedToken.kind = NL_DECR; }
         break;
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
