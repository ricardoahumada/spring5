package com.microcompany.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcompany.demo.models.AuthReqBody;
import com.microcompany.demo.models.AuthResBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);

//    TODO: uncomment
//    @Autowired
//    private AuthenticationManager authManager;

    @PostMapping("/login")
    public AuthResBody authenticate(@RequestBody AuthReqBody authReqBody) {
        logger.info("\nAuth Details: " + authReqBody);
        return null; // TODO: remove when uncomment

// TODO: uncomment

//        UsernamePasswordAuthenticationToken token = new
//                UsernamePasswordAuthenticationToken(
//                authReqBody.getUsername(),
//                authReqBody.getPassword());
//
//        logger.info("\nAuthentication Token Before Authentication: " + token);
//
//        Authentication authResult = authManager.authenticate(token);
//
//        logger.info("\nAuthentication Token After Authentication: " + authResult);
//        logger.info("\nAuthentication Token in Security Context: " + SecurityContextHolder.getContext().getAuthentication());
//
//        if (authResult.isAuthenticated()) {
//            logger.info("\nUser is Authenticated");
//            return new AuthResBody(true);
//        } else return new AuthResBody(false);


    }

}
