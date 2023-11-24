package com.project.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="project_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(name="parent_pro_id")
	 private int projectId;
	 
	 @Column(name="pro_name")
	 private String name;
	 
	 @Column(name="pro_type")
	 private String type;
	 
	 @Column(name="pro_description")
	 private String description;
	 
	 @Column(name="pro_hrs")
	 private int hours;
	 
	 @Column(name="pro_start_date")
	 private String startDate;
	 
	 @Column(name="pro_end_date")
	 private String endDate;
	 
	 @Column(name="pro_status")
	 private String status;
	 
	 
	 private String lead;
	 private List<String> employees;
	 
	 @JsonManagedReference
	 @OneToMany(mappedBy="project",cascade = CascadeType.ALL)
	 private List<Task> tasks;
	 
	 
	
	

}
