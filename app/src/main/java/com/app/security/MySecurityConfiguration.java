package com.app.security;

import com.app.entity.UsersInitial;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UsersInitial initial;

    public MySecurityConfiguration(UsersInitial initial) {
        this.initial = initial;
        initial.create();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/articles/statistic").hasAuthority("ADMIN")
                .antMatchers("/articles/create").hasRole("USER")
                .antMatchers("/articles/all").hasRole("USER")
                .anyRequest().authenticated();

        http
                .formLogin()
                .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}
