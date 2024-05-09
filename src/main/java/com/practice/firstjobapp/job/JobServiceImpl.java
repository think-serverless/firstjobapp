package com.practice.firstjobapp.job;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
	
	//private List<Job> jobs = new ArrayList<Job>();'
	
	JobRepository jobRepository;
	

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Override
	public void createJOb(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
		
	}

	@Override
	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		// TODO Auto-generated method stub
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}

	@Override
	public boolean updateJob(Long id, Job updateJob) {
		// TODO Auto-generated method stub
		Optional<Job> optionalJob = jobRepository.findById(id);
		if(optionalJob.isPresent()) {
			Job job = optionalJob.get();
			job.setDescription(updateJob.getDescription());
			job.setLocation(updateJob.getLocation());
			job.setMaxSalalry(updateJob.getMaxSalalry());
			job.setMinSalary(updateJob.getMinSalary());
			job.setTitle(updateJob.getTitle());
			jobRepository.save(job);
			return true;
		}
		return false;

	}

}
