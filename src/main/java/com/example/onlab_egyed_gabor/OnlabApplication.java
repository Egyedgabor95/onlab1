package com.example.onlab_egyed_gabor;

import com.example.onlab_egyed_gabor.data.entities.UserEntity;
import com.example.onlab_egyed_gabor.data.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlabApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlabApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			userRepository.save(new UserEntity("admin", encoder.encode("adminpass"), "ADMIN,USER"));
			userRepository.save(new UserEntity("user", encoder.encode("user"), "USER"));
		};
	}

}
