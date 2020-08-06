package am.abm.abm.controllers;

import am.abm.abm.enities.User;
import am.abm.abm.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("edit/{id}")
    public boolean editUser(@RequestBody User user, @PathVariable Long id) {
      Optional<User> optionalUser = userRepository.findById(id);
      if (optionalUser.isPresent()) {
          User oldUser = optionalUser.get();
          oldUser.setAddress(user.getAddress());
          oldUser.setCity(user.getCity());
          oldUser.setContactName(user.getContactName());
          oldUser.setCountry(user.getCountry());
          oldUser.setCustomerName(user.getCustomerName());
          oldUser.setPostalCode(user.getPostalCode());
          userRepository.save(oldUser);
          return true;
      }
      return false;
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser (@RequestBody User user, @PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
