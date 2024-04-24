package de.JOBPLACEMENT.jobPlacement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        Job newJob = new Job();
        newJob.setTitle(job.getTitle());
        newJob.setCompanyName(job.getCompanyName());
        newJob.setLocation(job.getLocation());
        newJob.setSalary(job.getSalary());
        newJob.setDescription(job.getDescription());

        return jobRepository.save(job);
    }
}


