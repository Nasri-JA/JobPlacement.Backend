package de.JOBPLACEMENT.jobPlacement.user;

import  de.JOBPLACEMENT.jobPlacement.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
