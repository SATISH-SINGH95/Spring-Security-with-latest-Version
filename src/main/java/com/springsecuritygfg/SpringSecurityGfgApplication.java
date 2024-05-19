package com.springsecuritygfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springsecuritygfg.model.User;
import com.springsecuritygfg.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityGfgApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityGfgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User adminUser = userRepository.findByAuthority("ADMIN");

		if(adminUser == null){
			User user = new User();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setEmail("admin@gmail.com");
			user.setPhoneNumber("999999999");
			user.setAuthority("ADMIN");
			userRepository.save(user);
		}



	}




}
