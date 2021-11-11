package com.bebit.userservice;

import com.bebit.userservice.domain.AppUser;
import com.bebit.userservice.domain.Role;
import com.bebit.userservice.service.UserService;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "Binod", "binod", "1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Lukas", "lukas", "1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Anil", "anil", "1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Shojibur", "shojibur", "1234",new ArrayList<>()));

			userService.addRoleToUser("binod", "ROLE_USER");
			userService.addRoleToUser("lukas", "ROLE_MANAGER");
			userService.addRoleToUser("anil", "ROLE_ADMIN");
			userService.addRoleToUser("shojibur", "ROLE_SUPER_ADMIN");
		};
	}

}
