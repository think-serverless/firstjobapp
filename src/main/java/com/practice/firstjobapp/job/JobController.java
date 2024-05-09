package com.practice.firstjobapp.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/jobs")
public class JobController {

	private JobService jobService;
	
	
	
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Job>> findAll(){
		return ResponseEntity.ok(jobService.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJOb(job);
		return new ResponseEntity<>("job created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job = jobService.getJobById(id);
		if(job != null) {
			return new ResponseEntity<>(job, HttpStatus.OK);
		}
		return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id){
		
		boolean isDeleted = jobService.deleteJobById(id);
		if(isDeleted) {
			return ResponseEntity.ok("Deleted Successfully");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job updateJob){
		boolean updated = jobService.updateJob(id, updateJob);
		if(updated) {
			return new ResponseEntity<Job>(updateJob, HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		
	}
}
