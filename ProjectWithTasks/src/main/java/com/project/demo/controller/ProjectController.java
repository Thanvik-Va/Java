package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Project;
import com.project.demo.pojo.ProjectPojo;
import com.project.demo.service.ProjectServiceInter;

@RestController
@RequestMapping(path="/project")
@CrossOrigin("http://localhost:4200/")
public class ProjectController {
	
	@Autowired
	private ProjectServiceInter projectServiceInter;
	
	@PostMapping("/createProject")
	public Project createProject(@RequestBody Project project)
	{
		return projectServiceInter.createProject(project);
	}
	
	@GetMapping("/getProjectByName/{projectname}")
	public ProjectPojo getProjectByName(@PathVariable("projectname") String projectName)
	{
		return projectServiceInter.getProject(projectName);
	}
	
	@GetMapping("/getAllProjects")
	public List<ProjectPojo> getAllProjects()
	{
		return projectServiceInter.getAllProjects();
	}
	
	@GetMapping("/getAllParentProjects")
	public List<Object> getAllParentProjects()
	{
		return projectServiceInter.getAllParentProjects();
	}

}
