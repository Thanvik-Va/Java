package com.project.demo.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubProjects {
	
	  private int id;
	  private int parenttId;
	  private String name;
	  private String type;
	  private String description;
	  private int hours;
	  private String startDate;
	  private String endDate;
	  private String status;
	  private String lead;
	  private List<String> employees;
	  private String checkType;
	  private List<TaskPojo> task;
	

}
