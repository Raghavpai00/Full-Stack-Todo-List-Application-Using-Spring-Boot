package com.Raghav.Project.myFristWebApp.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
		//LDAP or Database
	    //In Memory
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails...users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
	
	
	UserDetails userDetails1 = createNewUser("myFristWebApp", "Raghav@00");
	UserDetails userDetails2 = createNewUser("Raghavendra", "Raghav@123");
	UserDetails userDetails3 = createNewUser("Tridha", "Tridha@123");

	return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
		}
		private UserDetails createNewUser(String username, String password) {
		      	Function<String, String> passwordEncoder
			=input -> passwordEncoder().encode(input);
			
			UserDetails userDetails	=User.builder()
				.passwordEncoder(passwordEncoder)	
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
			return userDetails;
		}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // disable CSRF
	        .headers(headers -> headers.frameOptions(frame -> frame.disable())) // disable frameOptions
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/h2-console/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(withDefaults()); // keep form login enabled
  
	    http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
	    
	    return http.build();
	}

	
}




























