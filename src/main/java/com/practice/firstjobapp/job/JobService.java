package com.practice.firstjobapp.job;

import java.util.List;

public interface JobService {
	
	List<Job> findAll();
	void createJOb(Job job);
	Job getJobById(Long id);
	boolean deleteJobById(Long id);
	boolean updateJob(Long id, Job updateJob); 

}
