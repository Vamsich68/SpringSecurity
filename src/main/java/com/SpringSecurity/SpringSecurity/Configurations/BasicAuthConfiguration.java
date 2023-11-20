package com.SpringSecurity.SpringSecurity.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableMethodSecurity(jsr250Enabled = true,securedEnabled = true)
//@EnableWebSecurity
public class BasicAuthConfiguration {
    /*@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(auth -> {auth.requestMatchers("/users").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated();});
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));
        return http.build();
    }*/
    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests( auth-> auth.anyRequest().authenticated());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(withDefaults());
        //http.csrf(AbstractHttpConfigurer::disable);
        http.csrf(csrf ->csrf.disable());
        //http.headers(Customizer.withDefaults()).frameOptions().sameOrigin();
        http.headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }
   // @Bean
    public InMemoryUserDetailsManager createUserDetails(){
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
