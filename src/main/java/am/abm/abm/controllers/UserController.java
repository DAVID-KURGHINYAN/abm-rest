package am.abm.abm.controllers;

import am.abm.abm.models.dtos.UserCreateDTO;
import am.abm.abm.models.dtos.UserDetailsDTO;
import am.abm.abm.models.enities.User;
import am.abm.abm.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public List<User> userList() {
        return userService.getAll();
    }

    @PostMapping("add")
    public User addUser(@RequestBody UserCreateDTO user) {
        return userService.saveUser(user);
    }

    @PutMapping("edit/{id}")
    public boolean editUser(@RequestBody UserCreateDTO user, @PathVariable Long id) {
      return userService.editUser(user,id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("details/{id}")
    public UserDetailsDTO details (@PathVariable Long id) {
        return userService.getUserDetails(id);
    }
}
