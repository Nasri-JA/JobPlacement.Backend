package de.JOBPLACEMENT.jobPlacement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findById(Long id);
    List<Job> findAll();
    List<Job> findByTitle(String title);
    List<Job> findByCompanyName(String companyName);
    List<Job> findByTitleAndLocation(String title, String location);
    List<Job> findByCompanyNameOrLocation(String companyName, String location);

}

