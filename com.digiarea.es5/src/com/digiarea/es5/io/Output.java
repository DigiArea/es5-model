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
package com.digiarea.es5.io;

import java.io.File;
import java.io.FileOutputStream;

import com.digiarea.common.utils.FileExtensions;
import com.digiarea.common.utils.SourcePrinter;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Project;
import com.digiarea.es5.visitor.PrinterVisitor;

/**
 * The Class Output.
 */
public class Output implements Runnable {

	/**
	 * The Constant ENCODING.
	 */
	private static final String ENCODING = "UTF-8";

	/**
	 * The Constant EXT.
	 */
	private static final String EXT = FileExtensions.JS.END;

	/**
	 * The encoding.
	 */
	private String encoding = null;
	
	/**
	 * The path.
	 */
	private String path = null;
	
	/**
	 * The project.
	 */
	private Project project = null;

	/**
	 * Instantiates a new output.
	 */
	public Output() {
		super();
	}

	/**
	 * Instantiates a new output.
	 *
	 * @param encoding the encoding
	 * @param path the path
	 * @param project the project
	 */
	public Output(String encoding, String path, Project project) {
		super();
		if (encoding == null) {
			this.encoding = ENCODING;
		} else {
			this.encoding = encoding;
		}
		this.path = path;
		this.project = project;
	}

	/**
	 * Gets the encoding.
	 *
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Sets the encoding.
	 *
	 * @param encoding the new encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project the new project
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		NodeList<CompilationUnit> compilationUnits = project
				.getCompilationUnits();
		if (compilationUnits != null) {
			for (CompilationUnit unit : compilationUnits) {
				// System.out.println("OUT: " + getName(unit));
				String dir = getPath(path, getName(unit));
				File distFile = new File(dir);
				distFile.getParentFile().mkdirs();
				try (FileOutputStream out = new FileOutputStream(distFile)) {
					unit.accept(new PrinterVisitor(), new SourcePrinter(out,
							encoding));
				} catch (Exception e) {
					throw new Error(e.getMessage());
				}
			}
		}
	}

	/**
	 * Gets the name.
	 *
	 * @param unit the unit
	 * @return the name
	 */
	private String getName(CompilationUnit unit) {
		return unit.getName();
	}

	/**
	 * Gets the path.
	 *
	 * @param path the path
	 * @param name the name
	 * @return the path
	 */
	private String getPath(String path, String name) {
		return path + createPathFromQName(name) + "." + EXT;
	}

	/**
	 * Creates the path from q name.
	 *
	 * @param name the name
	 * @return the string
	 */
	private static String createPathFromQName(String name) {
		String[] split = name.split("\\.");
		String ret = File.separatorChar + split[0];
		for (int i = 1; i < split.length; i++) {
			ret += File.separatorChar + split[i];
		}
		return ret;
	}

}
