package com.digiarea.fxml.io;

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

import com.digiarea.fxml.Fxml;
import com.digiarea.fxml.Project;
import com.digiarea.fxml.parser.ASTParser;

public class Input implements Runnable {

	private static final String ENCODING = "UTF-8";

	private static final String EXT = ".fxml";

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
		final List<Fxml> compilationUnits = new ArrayList<>();
		final Path p = Paths.get(path);
		final FileVisitor<Path> fv = new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				if (recursive || dir.equals(p)) {
					return FileVisitResult.CONTINUE;
				} else {
					return FileVisitResult.SKIP_SUBTREE;
				}
			}

			@Override
			public FileVisitResult visitFile(Path item,
					BasicFileAttributes attrs) throws IOException {
				File file = item.toFile();
				if (item.toString().endsWith(EXT)) {
					//System.out.println(item);
					try (FileInputStream stream = new FileInputStream(file)) {
						compilationUnits.add(new ASTParser(stream, encoding)
								.parse(getUnitName(file)));
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
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
		project.setFxmls(compilationUnits);
	}

	private String getUnitName(File file) {
		String fName = file.getName();
		int offset = EXT.length();
		return fName.substring(0, fName.length() - offset);
	}

}
