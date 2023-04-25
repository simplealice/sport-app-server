package com.server.sport.user;

import com.server.sport.model.News;
import com.server.sport.model.UserResponse;
import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public UserResponse getUser(String email) {
    var userFromDB = userRepository.findByEmail(email).orElseThrow(
        () -> new UsernameNotFoundException("User not found")
    );

    return new UserResponse(userFromDB.getId(), userFromDB.getRole().name(), userFromDB.getEmail(),
        userFromDB.getSurname(), userFromDB.getName(), userFromDB.getBirthDate(), userFromDB.getCategory(),
        userFromDB.getKuDan(), userFromDB.getMajor(), userFromDB.getTeam(), userFromDB.getMedals());
  }

  public User editUser(Integer id, String newSurname, String newName, LocalDate newBirthDate,
      String newCategory, String newKuDan, String newMajor, String newTeam, String newMedals) {
    User user = userRepository.getReferenceById(id);
    if (newSurname != null) {
      user.setSurname(newSurname);
    }
    if (newName != null) {
      user.setName(newName);
    }
    if (newBirthDate != null) {
      user.setBirthDate(newBirthDate);
    }
    if (newCategory != null) {
      user.setCategory(newCategory);
    }
    if (newKuDan != null) {
      user.setKuDan(newKuDan);
    }
    if (newMajor != null) {
      user.setMajor(newMajor);
    }
    if (newTeam != null) {
      user.setTeam(newTeam);
    }
    if (newMedals != null) {
      user.setMedals(newMedals);
    }
    return userRepository.save(user);
  }
}
