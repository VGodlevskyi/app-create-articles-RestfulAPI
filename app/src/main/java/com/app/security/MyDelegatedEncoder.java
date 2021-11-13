package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;

@Configuration
public class MyDelegatedEncoder {

  @Bean
  public static PasswordEncoder build() {
    return new DelegatingPasswordEncoder("pbkdf2",
        new HashMap<String, PasswordEncoder>(1) {{
          put("pbkdf2", new org.springframework.security.crypto.password.Pbkdf2PasswordEncoder());
        }}
    );
  }
}
