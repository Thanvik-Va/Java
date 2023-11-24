package com.project.demo.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPojo {
	
	 private int id;
	 private int projectId;
	 private String name;
	 private String type;
	 private String description;
	 private int hours;
	 private String startDate;
	 private String endDate;
	 private String status;
	 private String lead;
	 private List<String> employees;
	 private List<SubProjects> subProjects;

}
