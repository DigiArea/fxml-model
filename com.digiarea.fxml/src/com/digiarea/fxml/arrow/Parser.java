package com.digiarea.fxml.arrow;

import com.digiarea.fxml.Project;
import com.digiarea.fxml.io.Input;

public class Parser extends Input {

	public Parser(String encoding, boolean recursive, String paths) {
		super(encoding, recursive, paths, null);
	}

	public Project arrow(Project project) throws Exception {
		setProject(project);
		run();
		return project;
	}

}
