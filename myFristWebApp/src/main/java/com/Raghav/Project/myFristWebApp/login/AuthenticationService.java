package com.Raghav.Project.myFristWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
public boolean authenticate(String name,String password) {
	
	boolean isValidUsername=name.equalsIgnoreCase("Raghav");
	boolean isValidPassword=password.equalsIgnoreCase("Raghav@00");
	
	return isValidUsername && isValidPassword;
	
}
}
