package com.SpringSecurity.SpringSecurity.Configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;
//@Configuration
public class SecurityConfiguration {
    //@Bean
    public InMemoryUserDetailsManager  createUserDetails(){
        UserDetails user1 = createNewUser("vamsi","vamsi");
        UserDetails user2 = createNewUser("a","a");

        return new InMemoryUserDetailsManager(user1,user2);

    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input ->passwordEncoder().encode(input);
        return User.builder()
                .passwordEncoder(passwordEncoder)
                .password(password)
                .username(username)
                .roles("user","admin")
                .build();
    }
    //@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
