package de.JOBPLACEMENT.jobPlacement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job updateJob(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setCompanyName(job.getCompanyName());
            existingJob.setLocation(job.getLocation());
            existingJob.setSalary(job.getSalary());
            existingJob.setDescription(job.getDescription());
            return jobRepository.save(existingJob);
        } else {
            throw new NotFoundException("Job mit der ID: " + id + " nicht gefunden!");
        }
    }

    public Job partialUpdateJob(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();
            if (job.getTitle() != null) {
                existingJob.setTitle(job.getTitle());
            }
            if (job.getCompanyName() != null) {
                existingJob.setCompanyName(job.getCompanyName());
            }
            if (job.getLocation() != null) {
                existingJob.setLocation(job.getLocation());
            }
            if (job.getSalary() != null) {
                existingJob.setSalary(job.getSalary());
            }
            if (job.getDescription() != null) {
                existingJob.setDescription(job.getDescription());
            }
            return jobRepository.save(existingJob);
        } else {
            throw new NotFoundException("Job mit der ID: " + id + " nicht gefunden!");
        }
    }

    public void deleteJob(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
        } else {
            throw new NotFoundException("Job mit der ID: " + id + " nicht gefunden!");
        }
    }

}


