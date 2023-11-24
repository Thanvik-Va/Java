package com.project.demo.service;


import java.util.List;

import com.project.demo.model.Project;
import com.project.demo.pojo.ProjectPojo;

public interface ProjectServiceInter {
	
	
	// To create project
	public Project createProject(Project project);
	
	// To get projetc
	
	public ProjectPojo  getProject(String projectName);
	
	public List<ProjectPojo> getAllProjects();
	
	public List<Object> getAllParentProjects();

}
