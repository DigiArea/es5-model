package com.digiarea.es5.io;

import java.io.File;
import java.io.FileOutputStream;

import com.digiarea.common.FileExtensions;
import com.digiarea.common.SourcePrinter;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.NodeList;
import com.digiarea.es5.Project;
import com.digiarea.es5.visitor.PrinterVisitor;

public class Output implements Runnable {

	private static final String ENCODING = "UTF-8";

	private static final String EXT = FileExtensions.JS.END;

	private String encoding = null;
	private String path = null;
	private Project project = null;

	public Output() {
		super();
	}

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

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

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

	private String getName(CompilationUnit unit) {
		return unit.getName();
	}

	private String getPath(String path, String name) {
		return path + createPathFromQName(name) + "." + EXT;
	}

	private static String createPathFromQName(String name) {
		String[] split = name.split("\\.");
		String ret = File.separatorChar + split[0];
		for (int i = 1; i < split.length; i++) {
			ret += File.separatorChar + split[i];
		}
		return ret;
	}

}
