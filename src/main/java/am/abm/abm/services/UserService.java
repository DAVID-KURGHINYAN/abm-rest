package am.abm.abm.services;

import am.abm.abm.models.dtos.user.UserCreateDTO;
import am.abm.abm.models.dtos.user.UserDetailsDTO;
import am.abm.abm.models.dtos.user.UserPreviewDTO;
import am.abm.abm.models.enities.User;
import am.abm.abm.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPreviewDTO getUserDetails(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserPreviewDTO(user);
        }
        return null;
    }

    public List<UserPreviewDTO> getAll() {
        return UserPreviewDTO.getUsers(userRepository.findAll());
    }

    public UserPreviewDTO saveUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setAddress(userCreateDTO.getAddress());
        user.setCity(userCreateDTO.getCity());
        user.setContactName(userCreateDTO.getContactName());
        user.setCountry(userCreateDTO.getCountry());
        user.setCustomerName(userCreateDTO.getCustomerName());
        user.setPostalCode(userCreateDTO.getPostalCode());
        return new UserPreviewDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean editUser(UserCreateDTO user, Long id) {
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
}
