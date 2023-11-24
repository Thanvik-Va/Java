package com.project.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Project;
import com.project.demo.model.Task;
import com.project.demo.pojo.ProjectPojo;
import com.project.demo.pojo.SubProjects;
import com.project.demo.pojo.TaskPojo;
import com.project.demo.repository.ProjectRepository;

@Service
public class ProjectService implements ProjectServiceInter {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) {
		// TODO Auto-generated method stub

		return projectRepository.save(project);
	}

	public ProjectPojo getProject(String projectName) {
		Project project = projectRepository.findByName(projectName);
		ProjectPojo pojo = new ProjectPojo();
		BeanUtils.copyProperties(project, pojo);
		List<SubProjects> subProjects = new ArrayList<>();
		List<Task> tasks = project.getTasks();
		for (Task task : tasks) {
			SubProjects projects = new SubProjects();
			BeanUtils.copyProperties(task, projects);
			projects.setCheckType("parent-Task");
			subProjects.add(projects);
		}
		
		extracted(pojo, subProjects);
		pojo.setSubProjects(subProjects);
		return pojo;
	}

	private void extracted(ProjectPojo pojo, List<SubProjects> subProjects) {
		List<Project> listOfChildProjects = projectRepository.findByProjectId(pojo.getId());
		if (listOfChildProjects.size() != 0 ) {

			for (Project p : listOfChildProjects) {
				SubProjects projects = new SubProjects();

				BeanUtils.copyProperties(p, projects);
				projects.setParenttId(p.getProjectId());
				projects.setCheckType("Child-Project ");
				System.out.println(projects.toString());
				subProjects.add(projects);
				// subProjects.stream().forEach(x->System.out.println(x));

				List<Task> listOfTasks = p.getTasks();
				List<TaskPojo> listOfTaskPojo = new ArrayList<>();
				listOfTasks.stream().forEach(task -> {
					TaskPojo tPojo = new TaskPojo();
					BeanUtils.copyProperties(task, tPojo);
					listOfTaskPojo.add(tPojo);

				});
				projects.setTask(listOfTaskPojo);
	
			}
		}
	}

	@Override
	public List<ProjectPojo> getAllProjects() {
		
		
		List<Project> listOProjects = projectRepository.findAll();
		List<ProjectPojo> projectpojos=new ArrayList<>();
		listOProjects.stream().forEach(project->{
			ProjectPojo pojo = new ProjectPojo();
			BeanUtils.copyProperties(project, pojo);
			List<SubProjects> subProjects = new ArrayList<>();
			List<Task> tasks = project.getTasks();
			for (Task task : tasks) {
				SubProjects projects = new SubProjects();
				BeanUtils.copyProperties(task, projects);
				projects.setCheckType("parent-Task");
				subProjects.add(projects);
			}
			
			extracted(pojo, subProjects);
			pojo.setSubProjects(subProjects);
			projectpojos.add(pojo);
		
			
		});
		return projectpojos;
	}
	
	
	public List<Object> getAllParentProjects()
	{
		List<Project> listOfParentProjects = projectRepository.findByProjectId(0);
		List<Object> projectPojos=new ArrayList<>();
		projectPojos.addAll(listOfParentProjects);
		return projectPojos;
	}
	
	

}
