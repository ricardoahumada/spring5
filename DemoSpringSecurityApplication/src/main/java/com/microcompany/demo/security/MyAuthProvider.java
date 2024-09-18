package com.microcompany.demo.security;

import com.microcompany.demo.rest.AuthController;
import com.microcompany.demo.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

// TODO: uncomment
//@Component
public class MyAuthProvider implements AuthenticationProvider {

    Logger logger = LoggerFactory.getLogger(MyAuthProvider.class);

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        logger.info("\nIn MyAuthProvider.authenticate(): ");

        // TODO: uncomment

		/*// Get the User from UserDetailsService
		String providedUsername = authentication.getPrincipal().toString();
		UserDetails user = userDetailsService.loadUserByUsername(providedUsername);
		logger.info("User Details from UserService based on username-" + providedUsername + " : " + user);
		
		String providedPassword = authentication.getCredentials().toString();
		String correctPassword = user.getPassword();
		
		logger.info("Provided Password - " + providedPassword + " Correct Password: " + correctPassword);
		
		// Authenticate 
		// If Passwords don't match throw and exception
		if(!providedPassword.equals(correctPassword))
			throw new RuntimeException("Incorrect Credentials");
		
		logger.info("Passwords Match....\n");
		
		// return Authentication Object
		Authentication authenticationResult = 
				new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
		return authenticationResult;*/
        return null; // TODO: remove when uncomment
    }

    @Override
    public boolean supports(Class<?> authentication) {
        logger.info("\nIn MyAuthProvider.supports(): ");
        logger.info("\nChecking whether MyAuthProvider supports Authentication type\n");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
