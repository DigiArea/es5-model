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

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

import com.digiarea.common.utils.SourcePrinter;
import com.digiarea.es5.visitor.CloneVisitor;
import com.digiarea.es5.visitor.EqualsVisitor;
import com.digiarea.es5.visitor.GenericVisitor;
import com.digiarea.es5.visitor.PrinterVisitor;
import com.digiarea.es5.visitor.TracePrinter;
import com.digiarea.es5.visitor.VoidVisitor;

/**
 * The Class Node.
 */
public abstract class Node {

	/**
	 * The pos begin.
	 */
	protected int posBegin = 0;

	/**
	 * The pos end.
	 */
	protected int posEnd = 0;

	/**
	 * Gets the pos begin.
	 *
	 * @return the pos begin
	 */
	public int getPosBegin() {
		return posBegin;
	}

	/**
	 * Sets the pos begin.
	 *
	 * @param posBegin the new pos begin
	 */
	public void setPosBegin(int posBegin) {
		this.posBegin = posBegin;
	}

	/**
	 * Gets the pos end.
	 *
	 * @return the pos end
	 */
	public int getPosEnd() {
		return posEnd;
	}

	/**
	 * Sets the pos end.
	 *
	 * @param posEnd the new pos end
	 */
	public void setPosEnd(int posEnd) {
		this.posEnd = posEnd;
	}

	/**
	 * Instantiates a new node.
	 */
	Node() {
		super();
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param posBegin the pos begin
	 * @param posEnd the pos end
	 */
	Node(int posBegin, int posEnd) {
		super();
		this.posBegin = posBegin;
		this.posEnd = posEnd;
	}

	/**
	 * Accept.
	 *
	 * @param <C> the generic type
	 * @param v the v
	 * @param ctx the ctx
	 * @throws Exception the exception
	 */
	public abstract <C> void accept(VoidVisitor<C> v, C ctx) throws Exception;

	/**
	 * Accept.
	 *
	 * @param <R> the generic type
	 * @param <C> the generic type
	 * @param v the v
	 * @param ctx the ctx
	 * @return the r
	 * @throws Exception the exception
	 */
	public abstract <R, C> R accept(GenericVisitor<R, C> v, C ctx)
			throws Exception;

	/**
	 * The Constant CLONE.
	 */
	private static final CloneVisitor<Void> CLONE = new CloneVisitor<Void>();

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public final Node clone() throws CloneNotSupportedException {
		try {
			return accept(CLONE, null);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(Object obj) {
		try {
			return EqualsVisitor.equals(this, (Node) obj);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * The Constant ENCODING.
	 */
	private static final String ENCODING = "UTF-8";

	/**
	 * The Constant PRINTER.
	 */
	private static final PrinterVisitor PRINTER = new PrinterVisitor();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String result = null;
		try {
			accept(PRINTER, new SourcePrinter(out, ENCODING));
			result = out.toString(ENCODING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * The Constant TRACE_PRINTER.
	 */
	private static final TracePrinter TRACE_PRINTER = new TracePrinter();

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String result = null;
		try {
			accept(TRACE_PRINTER, new SourcePrinter(out, ENCODING));
			result = out.toString(ENCODING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.hashCode();
	}

	/**
	 * The Constant CRYPTO.
	 */
	private static final String CRYPTO = "SHA-256";

	/**
	 * Trace.
	 *
	 * @return the string
	 */
	public final String trace() {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			accept(TRACE_PRINTER, new SourcePrinter(out, ENCODING));
			MessageDigest md = java.security.MessageDigest.getInstance(CRYPTO);
			md.update(out.toByteArray());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(java.lang.Integer.toString(
						(byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
