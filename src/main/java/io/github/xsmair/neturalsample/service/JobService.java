package io.github.xsmair.neturalsample.service;

import io.github.xsmair.neturalsample.exception.ResourceNotFoundException;
import io.github.xsmair.neturalsample.model.Job;
import io.github.xsmair.neturalsample.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job job) {
        Job jobToUpdate = getJobById(id);
        jobToUpdate.setName(job.getName());
        jobToUpdate.setDescription(job.getDescription());
        return jobRepository.save(jobToUpdate);
    }

    public void deleteJob(Long id) {
        jobRepository.delete(getJobById(id));
    }
}
