package am.abm.abm.controllers;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.ResponseModel;
import am.abm.abm.models.dtos.user.UserCreateDTO;
import am.abm.abm.models.dtos.user.UserPreviewDTO;
import am.abm.abm.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController()
@RequestMapping("user/")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public List<UserPreviewDTO> userList() {
        return userService.getAll();
    }

    @PostMapping("add")
    public UserPreviewDTO addUser(@Valid @RequestBody UserCreateDTO user) {
        return userService.saveUser(user);
    }

    @PostMapping("avatar")
    public ResponseModel uploadUserAvatar(@RequestParam("avatar") MultipartFile avatar, @RequestParam("id") Long userId){
        try {
            return createResult(userService.uploadUserAvatar(avatar, userId), "User avatar was uploaded successfully");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

    @PutMapping("edit/{id}")
    public boolean editUser(@RequestBody UserCreateDTO user, @PathVariable Long id) {
        return userService.editUser(user, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("details/{id}")
    public ResponseModel details(@Valid @PathVariable @Min(1) Long id) {
        try {
            return createResult(userService.getUserDetails(id), "Product details was retrieved successfully");
        } catch (EntityNotFoundException e) {
            return createErrorResult(e);
        }
    }

    @PostMapping("/image")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
///https://dzone.com/articles/java-springboot-rest-api-to-uploaddownload-file-on
        return "redirect:/";
    }
}