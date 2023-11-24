package com.project.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskPojo {
	
	  private int id;
	  private String name;
	  private String type;
	  private String description;
	  private String status;
	  private int hours;
	  private String startDate;
	  private String endDate;
	  private String assignee;
	  private int projectId;
	  private String findType;

}
