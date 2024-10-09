package com.example.jobproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    public Job add (Job job){
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job job) {
        if (jobRepository.findById(id).isPresent()) {
            Job existingJob = jobRepository.findById(id).get();
            existingJob.setService(job.getService());
            existingJob.setEtat(job.getEtat());
            return jobRepository.save(job);
        } else
            return null;
    }

    public String deleteJob(Long id) {
        if (jobRepository.findById(id).isPresent()) {
            jobRepository.deleteById(id);
            return "job supprimé";
        } else
            return "job non supprimé";
    }

    public Job updateJobEtat(Long id, Boolean newState) {
        Job job = jobRepository.findById(id).orElse(null);
        job.setEtat(newState);
        return jobRepository.save(job);
    }

}
