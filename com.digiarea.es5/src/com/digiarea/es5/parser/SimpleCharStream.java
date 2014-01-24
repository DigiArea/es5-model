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
/* JavaCCOptions:STATIC=false,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.digiarea.es5.parser;

/**
 * An implementation of interface CharStream, where the stream is assumed to
 * contain only ASCII characters (without unicode processing).
 */

public class SimpleCharStream
{
/** Whether parser is static. */
  public static final boolean staticFlag = false;
  
  /**
   * The bufsize.
   */
  int bufsize;
  
  /**
   * The available.
   */
  int available;
  
  /**
   * The token begin.
   */
  int tokenBegin;
/** Position in buffer. */
  public int bufpos = -1;
  
  /**
   * The bufline.
   */
  protected int bufline[];
  
  /**
   * The bufcolumn.
   */
  protected int bufcolumn[];

  /**
   * The column.
   */
  protected int column = 0;
  
  /**
   * The line.
   */
  protected int line = 1;

  /**
   * The prev char is cr.
   */
  protected boolean prevCharIsCR = false;
  
  /**
   * The prev char is lf.
   */
  protected boolean prevCharIsLF = false;

  /**
   * The input stream.
   */
  protected java.io.Reader inputStream;

  /**
   * The buffer.
   */
  protected char[] buffer;
  
  /**
   * The max next char ind.
   */
  protected int maxNextCharInd = 0;
  
  /**
   * The in buf.
   */
  protected int inBuf = 0;
  
  /**
   * The tab size.
   */
  protected int tabSize = 8;

  /**
   * Sets the tab size.
   *
   * @param i the new tab size
   */
  protected void setTabSize(int i) { tabSize = i; }
  
  /**
   * Gets the tab size.
   *
   * @param i the i
   * @return the tab size
   */
  protected int getTabSize(int i) { return tabSize; }


  /**
   * Expand buff.
   *
   * @param wrapAround the wrap around
   */
  protected void ExpandBuff(boolean wrapAround)
  {
    char[] newbuffer = new char[bufsize + 2048];
    int newbufline[] = new int[bufsize + 2048];
    int newbufcolumn[] = new int[bufsize + 2048];

    try
    {
      if (wrapAround)
      {
        System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
        System.arraycopy(buffer, 0, newbuffer, bufsize - tokenBegin, bufpos);
        buffer = newbuffer;

        System.arraycopy(bufline, tokenBegin, newbufline, 0, bufsize - tokenBegin);
        System.arraycopy(bufline, 0, newbufline, bufsize - tokenBegin, bufpos);
        bufline = newbufline;

        System.arraycopy(bufcolumn, tokenBegin, newbufcolumn, 0, bufsize - tokenBegin);
        System.arraycopy(bufcolumn, 0, newbufcolumn, bufsize - tokenBegin, bufpos);
        bufcolumn = newbufcolumn;

        maxNextCharInd = (bufpos += (bufsize - tokenBegin));
      }
      else
      {
        System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
        buffer = newbuffer;

        System.arraycopy(bufline, tokenBegin, newbufline, 0, bufsize - tokenBegin);
        bufline = newbufline;

        System.arraycopy(bufcolumn, tokenBegin, newbufcolumn, 0, bufsize - tokenBegin);
        bufcolumn = newbufcolumn;

        maxNextCharInd = (bufpos -= tokenBegin);
      }
    }
    catch (Throwable t)
    {
      throw new Error(t.getMessage());
    }


    bufsize += 2048;
    available = bufsize;
    tokenBegin = 0;
  }

  /**
   * Fill buff.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  protected void FillBuff() throws java.io.IOException
  {
    if (maxNextCharInd == available)
    {
      if (available == bufsize)
      {
        if (tokenBegin > 2048)
        {
          bufpos = maxNextCharInd = 0;
          available = tokenBegin;
        }
        else if (tokenBegin < 0)
          bufpos = maxNextCharInd = 0;
        else
          ExpandBuff(false);
      }
      else if (available > tokenBegin)
        available = bufsize;
      else if ((tokenBegin - available) < 2048)
        ExpandBuff(true);
      else
        available = tokenBegin;
    }

    int i;
    try {
      if ((i = inputStream.read(buffer, maxNextCharInd, available - maxNextCharInd)) == -1)
      {
        inputStream.close();
        throw new java.io.IOException();
      }
      else
        maxNextCharInd += i;
      return;
    }
    catch(java.io.IOException e) {
      --bufpos;
      backup(0);
      if (tokenBegin == -1)
        tokenBegin = bufpos;
      throw e;
    }
  }

/**
 *  Start.
 *
 * @return the char
 * @throws IOException Signals that an I/O exception has occurred.
 */
  public char BeginToken() throws java.io.IOException
  {
    tokenBegin = -1;
    char c = readChar();
    tokenBegin = bufpos;

    return c;
  }

  /**
   * Update line column.
   *
   * @param c the c
   */
  protected void UpdateLineColumn(char c)
  {
    column++;

    if (prevCharIsLF)
    {
      prevCharIsLF = false;
      line += (column = 1);
    }
    else if (prevCharIsCR)
    {
      prevCharIsCR = false;
      if (c == '\n')
      {
        prevCharIsLF = true;
      }
      else
        line += (column = 1);
    }

    switch (c)
    {
      case '\r' :
        prevCharIsCR = true;
        break;
      case '\n' :
        prevCharIsLF = true;
        break;
      case '\t' :
        column--;
        column += (tabSize - (column % tabSize));
        break;
      default :
        break;
    }

    bufline[bufpos] = line;
    bufcolumn[bufpos] = column;
  }

/**
 *  Read a character.
 *
 * @return the char
 * @throws IOException Signals that an I/O exception has occurred.
 */
  public char readChar() throws java.io.IOException
  {
    if (inBuf > 0)
    {
      --inBuf;

      if (++bufpos == bufsize)
        bufpos = 0;

      return buffer[bufpos];
    }

    if (++bufpos >= maxNextCharInd)
      FillBuff();

    char c = buffer[bufpos];

    UpdateLineColumn(c);
    return c;
  }

  /**
   * Gets the column.
   *
   * @return the column
   */
  @Deprecated
  /**
   * @deprecated
   * @see #getEndColumn
   */

  public int getColumn() {
    return bufcolumn[bufpos];
  }

  /**
   * Gets the line.
   *
   * @return the line
   */
  @Deprecated
  /**
   * @deprecated
   * @see #getEndLine
   */

  public int getLine() {
    return bufline[bufpos];
  }

  /**
   *  Get token end column number.
   *
   * @return the end column
   */
  public int getEndColumn() {
    return bufcolumn[bufpos];
  }

  /**
   *  Get token end line number.
   *
   * @return the end line
   */
  public int getEndLine() {
     return bufline[bufpos];
  }

  /**
   *  Get token beginning column number.
   *
   * @return the begin column
   */
  public int getBeginColumn() {
    return bufcolumn[tokenBegin];
  }

  /**
   *  Get token beginning line number.
   *
   * @return the begin line
   */
  public int getBeginLine() {
    return bufline[tokenBegin];
  }

/**
 *  Backup a number of characters.
 *
 * @param amount the amount
 */
  public void backup(int amount) {

    inBuf += amount;
    if ((bufpos -= amount) < 0)
      bufpos += bufsize;
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @param buffersize the buffersize
   */
  public SimpleCharStream(java.io.Reader dstream, int startline,
  int startcolumn, int buffersize)
  {
    inputStream = dstream;
    line = startline;
    column = startcolumn - 1;

    available = bufsize = buffersize;
    buffer = new char[buffersize];
    bufline = new int[buffersize];
    bufcolumn = new int[buffersize];
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   */
  public SimpleCharStream(java.io.Reader dstream, int startline,
                          int startcolumn)
  {
    this(dstream, startline, startcolumn, 4096);
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   */
  public SimpleCharStream(java.io.Reader dstream)
  {
    this(dstream, 1, 1, 4096);
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @param buffersize the buffersize
   */
  public void ReInit(java.io.Reader dstream, int startline,
  int startcolumn, int buffersize)
  {
    inputStream = dstream;
    line = startline;
    column = startcolumn - 1;

    if (buffer == null || buffersize != buffer.length)
    {
      available = bufsize = buffersize;
      buffer = new char[buffersize];
      bufline = new int[buffersize];
      bufcolumn = new int[buffersize];
    }
    prevCharIsLF = prevCharIsCR = false;
    tokenBegin = inBuf = maxNextCharInd = 0;
    bufpos = -1;
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   */
  public void ReInit(java.io.Reader dstream, int startline,
                     int startcolumn)
  {
    ReInit(dstream, startline, startcolumn, 4096);
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   */
  public void ReInit(java.io.Reader dstream)
  {
    ReInit(dstream, 1, 1, 4096);
  }
  
  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param encoding the encoding
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @param buffersize the buffersize
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public SimpleCharStream(java.io.InputStream dstream, String encoding, int startline,
  int startcolumn, int buffersize) throws java.io.UnsupportedEncodingException
  {
    this(encoding == null ? new java.io.InputStreamReader(dstream) : new java.io.InputStreamReader(dstream, encoding), startline, startcolumn, buffersize);
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @param buffersize the buffersize
   */
  public SimpleCharStream(java.io.InputStream dstream, int startline,
  int startcolumn, int buffersize)
  {
    this(new java.io.InputStreamReader(dstream), startline, startcolumn, buffersize);
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param encoding the encoding
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public SimpleCharStream(java.io.InputStream dstream, String encoding, int startline,
                          int startcolumn) throws java.io.UnsupportedEncodingException
  {
    this(dstream, encoding, startline, startcolumn, 4096);
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   */
  public SimpleCharStream(java.io.InputStream dstream, int startline,
                          int startcolumn)
  {
    this(dstream, startline, startcolumn, 4096);
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   * @param encoding the encoding
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public SimpleCharStream(java.io.InputStream dstream, String encoding) throws java.io.UnsupportedEncodingException
  {
    this(dstream, encoding, 1, 1, 4096);
  }

  /**
   *  Constructor.
   *
   * @param dstream the dstream
   */
  public SimpleCharStream(java.io.InputStream dstream)
  {
    this(dstream, 1, 1, 4096);
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param encoding the encoding
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @param buffersize the buffersize
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public void ReInit(java.io.InputStream dstream, String encoding, int startline,
                          int startcolumn, int buffersize) throws java.io.UnsupportedEncodingException
  {
    ReInit(encoding == null ? new java.io.InputStreamReader(dstream) : new java.io.InputStreamReader(dstream, encoding), startline, startcolumn, buffersize);
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @param buffersize the buffersize
   */
  public void ReInit(java.io.InputStream dstream, int startline,
                          int startcolumn, int buffersize)
  {
    ReInit(new java.io.InputStreamReader(dstream), startline, startcolumn, buffersize);
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param encoding the encoding
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public void ReInit(java.io.InputStream dstream, String encoding) throws java.io.UnsupportedEncodingException
  {
    ReInit(dstream, encoding, 1, 1, 4096);
  }

  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   */
  public void ReInit(java.io.InputStream dstream)
  {
    ReInit(dstream, 1, 1, 4096);
  }
  
  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param encoding the encoding
   * @param startline the startline
   * @param startcolumn the startcolumn
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public void ReInit(java.io.InputStream dstream, String encoding, int startline,
                     int startcolumn) throws java.io.UnsupportedEncodingException
  {
    ReInit(dstream, encoding, startline, startcolumn, 4096);
  }
  
  /**
   *  Reinitialise.
   *
   * @param dstream the dstream
   * @param startline the startline
   * @param startcolumn the startcolumn
   */
  public void ReInit(java.io.InputStream dstream, int startline,
                     int startcolumn)
  {
    ReInit(dstream, startline, startcolumn, 4096);
  }
  
  /**
   *  Get token literal value.
   *
   * @return the string
   */
  public String GetImage()
  {
    if (bufpos >= tokenBegin)
      return new String(buffer, tokenBegin, bufpos - tokenBegin + 1);
    else
      return new String(buffer, tokenBegin, bufsize - tokenBegin) +
                            new String(buffer, 0, bufpos + 1);
  }

  /**
   *  Get the suffix.
   *
   * @param len the len
   * @return the char[]
   */
  public char[] GetSuffix(int len)
  {
    char[] ret = new char[len];

    if ((bufpos + 1) >= len)
      System.arraycopy(buffer, bufpos - len + 1, ret, 0, len);
    else
    {
      System.arraycopy(buffer, bufsize - (len - bufpos - 1), ret, 0,
                                                        len - bufpos - 1);
      System.arraycopy(buffer, 0, ret, len - bufpos - 1, bufpos + 1);
    }

    return ret;
  }

  /** Reset buffer when finished. */
  public void Done()
  {
    buffer = null;
    bufline = null;
    bufcolumn = null;
  }

  /**
   * Method to adjust line and column numbers for the start of a token.
   *
   * @param newLine the new line
   * @param newCol the new col
   */
  public void adjustBeginLineColumn(int newLine, int newCol)
  {
    int start = tokenBegin;
    int len;

    if (bufpos >= tokenBegin)
    {
      len = bufpos - tokenBegin + inBuf + 1;
    }
    else
    {
      len = bufsize - tokenBegin + bufpos + 1 + inBuf;
    }

    int i = 0, j = 0, k = 0;
    int nextColDiff = 0, columnDiff = 0;

    while (i < len && bufline[j = start % bufsize] == bufline[k = ++start % bufsize])
    {
      bufline[j] = newLine;
      nextColDiff = columnDiff + bufcolumn[k] - bufcolumn[j];
      bufcolumn[j] = newCol + columnDiff;
      columnDiff = nextColDiff;
      i++;
    }

    if (i < len)
    {
      bufline[j] = newLine++;
      bufcolumn[j] = newCol + columnDiff;

      while (i++ < len)
      {
        if (bufline[j = start % bufsize] != bufline[++start % bufsize])
          bufline[j] = newLine++;
        else
          bufline[j] = newLine;
      }
    }

    line = bufline[j];
    column = bufcolumn[j];
  }

}
/* JavaCC - OriginalChecksum=7da2c7b734e8c494a8302eb2ddf2d188 (do not edit this line) */
