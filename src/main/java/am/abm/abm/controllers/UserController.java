package am.abm.abm.controllers;

import am.abm.abm.enities.User;
import am.abm.abm.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("user/")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("list")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @PostMapping("add")
    public User addUser(User user){
        return userRepository.save(user);
    }
}
