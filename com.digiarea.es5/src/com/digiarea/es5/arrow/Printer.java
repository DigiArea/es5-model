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
package com.digiarea.es5.arrow;

import com.digiarea.common.Arrow;
import com.digiarea.es5.Project;
import com.digiarea.es5.io.Output;

/**
 * The Class Printer.
 */
public class Printer extends Output implements Arrow<Project, Project> {

	/**
	 * Instantiates a new printer.
	 * 
	 * @param encoding
	 *            the encoding
	 * @param path
	 *            the path
	 */
	public Printer(String encoding, String path) {
		super(encoding, path, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.digiarea.common.Arrow#arrow(java.lang.Object)
	 */
	@Override
	public Project arrow(Project project) throws Exception {
		setProject(project);
		run();
		return project;
	}

}
