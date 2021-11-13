package com.app.entity;

import com.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class UserDetails {

  private final UserRepository userRepo;

  private org.springframework.security.core.userdetails.UserDetails mapper(User x) {
    List<GrantedAuthority> allRoles = Arrays.stream(x.getRoles())
      .map(s -> (GrantedAuthority) () -> s)           // hasRole
      .map(s -> (GrantedAuthority) () -> "ROLE_" + s) // hasAuthority
      .collect(Collectors.toList());

    return org.springframework.security.core.userdetails.User
      .withUsername(x.getUsername())
      .password(x.getPassword())
      .authorities(allRoles)
      .build();
  }

  @Bean
  public UserDetailsService uds() {

//    UserDetailsService uds = (username) -> userRepo.findByUsername(username)
//      .map(u -> mapper(u))
//      .orElseThrow(() -> new UsernameNotFoundException(username));

    return new UserDetailsService() {
      @Override
      public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
          .map(u -> mapper(u))
          .orElseThrow(() -> new UsernameNotFoundException(username));
      }
    };

  }

}
