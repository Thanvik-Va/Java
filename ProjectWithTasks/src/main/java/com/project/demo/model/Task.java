package com.project.demo.model;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="task_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String name;
	 private String type;
	 private String description;
	 private String status;
	 private int hours;
	 private String startDate;
	 private String endDate;
	 private String assignee;
	 
	 @JsonBackReference
	 @ManyToOne
	 @JoinColumn(name="project_id")
	 private Project project;
	 
	 
}
