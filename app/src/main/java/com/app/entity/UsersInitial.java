package com.app.entity;

import com.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class UsersInitial {

  private final UserRepository userRepository;
  private final PasswordEncoder enc;

  public void create() {
    userRepository.saveAll(Arrays.asList(
       new User("user",  enc.encode("user"), "USER"),
       new User("admin", enc.encode("admin"), "ADMIN"),
       new User("ivan", enc.encode("ivan"), "")
    ));
  }
}
