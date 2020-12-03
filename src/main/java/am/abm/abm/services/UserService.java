package am.abm.abm.services;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.dtos.user.UserCreateDTO;
import am.abm.abm.models.dtos.user.UserPreviewDTO;
import am.abm.abm.models.enities.User;
import am.abm.abm.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserPreviewDTO getUserDetails(Long id) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserPreviewDTO(user);
        }
        else throw new EntityNotFoundException();
    }

    public List<UserPreviewDTO> getAll() {
        return UserPreviewDTO.getUsers(userRepository.findAll());
    }

    public UserPreviewDTO saveUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setAddress(userCreateDTO.getAddress());
        user.setCity(userCreateDTO.getCity());
        user.setPassword(bCryptPasswordEncoder.encode(userCreateDTO.getPassword()));
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

    public UserPreviewDTO uploadUserAvatar(MultipartFile avatar, Long userId) throws EntityNotFoundException, IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException();
        }
        User user = optionalUser.get();
        user.setAvatar(write(avatar));
        return new UserPreviewDTO(userRepository.save(user));
    }

    public String write(MultipartFile file) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String fileName = date + file.getOriginalFilename();
        String filePath = "src/main/uploads/"  + fileName;
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User applicationUser = userRepository.findByContactName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getContactName(), applicationUser.getPassword(), emptyList());
    }
}
