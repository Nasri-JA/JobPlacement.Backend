package de.JOBPLACEMENT.jobPlacement.user;

import de.JOBPLACEMENT.jobPlacement.user.User;
import de.JOBPLACEMENT.jobPlacement.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
}
