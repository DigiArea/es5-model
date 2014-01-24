/*
 * 
 */
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

public abstract class Node {

	protected int posBegin = 0;

	protected int posEnd = 0;

	public int getPosBegin() {
		return posBegin;
	}

	public void setPosBegin(int posBegin) {
		this.posBegin = posBegin;
	}

	public int getPosEnd() {
		return posEnd;
	}

	public void setPosEnd(int posEnd) {
		this.posEnd = posEnd;
	}

	Node() {
		super();
	}

	Node(int posBegin, int posEnd) {
		super();
		this.posBegin = posBegin;
		this.posEnd = posEnd;
	}

	public abstract <C> void accept(VoidVisitor<C> v, C ctx) throws Exception;

	public abstract <R, C> R accept(GenericVisitor<R, C> v, C ctx)
			throws Exception;

	private static final CloneVisitor<Void> CLONE = new CloneVisitor<Void>();

	@Override
	public final Node clone() throws CloneNotSupportedException {
		try {
			return accept(CLONE, null);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public final boolean equals(Object obj) {
		try {
			return EqualsVisitor.equals(this, (Node) obj);
		} catch (Exception e) {
			return false;
		}
	}

	private static final String ENCODING = "UTF-8";

	private static final PrinterVisitor PRINTER = new PrinterVisitor();

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

	private static final TracePrinter TRACE_PRINTER = new TracePrinter();

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

	private static final String CRYPTO = "SHA-256";

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
