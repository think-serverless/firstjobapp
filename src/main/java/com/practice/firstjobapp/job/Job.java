package com.practice.firstjobapp.job;

import com.practice.firstjobapp.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
//@Table(name="JOB_TABLE")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String title;
	public Long minSalary;
	public String description;
	public Long maxSalalry;
	public String location;
	
	@ManyToOne
	private Company company;
	
	public Job() {
		super();
	}
	public Job(Long id, String title, Long minSalary, String description, Long maxSalalry, String location) {
		super();
		this.id = id;
		this.title = title;
		this.minSalary = minSalary;
		this.description = description;
		this.maxSalalry = maxSalalry;
		this.location = location;
	}
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getMaxSalalry() {
		return maxSalalry;
	}
	public void setMaxSalalry(Long maxSalalry) {
		this.maxSalalry = maxSalalry;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	

}
