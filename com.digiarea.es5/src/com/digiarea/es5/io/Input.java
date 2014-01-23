package com.digiarea.es5.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import com.digiarea.common.utils.FileExtensions;
import com.digiarea.es5.CompilationUnit;
import com.digiarea.es5.NodeFacade;
import com.digiarea.es5.Project;
import com.digiarea.es5.parser.ASTParser;

public class Input implements Runnable {

	private static final String ENCODING = "UTF-8";

	private static final String EXT = FileExtensions.JS.END;

	private String encoding = null;
	private boolean recursive = false;
	private String path = null;
	private Project project = null;

	public Input() {
		super();
	}

	public Input(String encoding, boolean recursive, String path,
			Project project) {
		super();
		if (encoding == null) {
			this.encoding = ENCODING;
		} else {
			this.encoding = encoding;
		}
		this.recursive = recursive;
		this.path = path;
		this.project = project;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isRecursive() {
		return recursive;
	}

	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
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
		final List<CompilationUnit> compilationUnits = new ArrayList<>();
		final Path p = Paths.get(path);
		final FileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path item,
					BasicFileAttributes attrs) throws IOException {
				// System.out.println(file);
				File file = item.toFile();
				if (file.isDirectory()) {
					return recursive ? FileVisitResult.CONTINUE
							: FileVisitResult.SKIP_SUBTREE;
				} else if (item.toString().endsWith(EXT)) {
					try (FileInputStream stream = new FileInputStream(file)) {
						compilationUnits
								.add(new ASTParser(stream, encoding)
										.CompilationUnit(item.getFileName()
												.toString()));
						stream.close();
					} catch (Exception e) {
						throw new Error(e.getMessage());
					}
				}
				return FileVisitResult.CONTINUE;
			}
		};
		try {
			Files.walkFileTree(p, fv);
		} catch (Exception e) {
			throw new Error(e.getMessage());
		}
		project.setCompilationUnits(NodeFacade.NodeList(compilationUnits,
				0, 0));
	}

}
