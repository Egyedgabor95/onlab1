package com.example.onlab_egyed_gabor.config;

import com.example.onlab_egyed_gabor.service.implementation.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JpaUserDetailsService myUserDetailsService;

    public SecurityConfiguration(JpaUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.ignoringAntMatchers("/api/**", "/h2-console/**", "/login", "/logout"))
                .formLogin(formLoginConfigurer -> formLoginConfigurer
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login")
                )
                .authorizeRequests(auth -> auth
                        .antMatchers("/admin", "/admin/**").hasAnyAuthority("ADMIN")
                        .antMatchers("/user", "/user/**").hasAnyAuthority("USER")
                        .antMatchers("/login", "/h2-console/**", "/error").permitAll()
                        .mvcMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()

                )
                .userDetailsService(myUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}