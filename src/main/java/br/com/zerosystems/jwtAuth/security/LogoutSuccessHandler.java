package br.com.zerosystems.jwtAuth.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler implements LogoutHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	   // Just for setting the default target URL
	
	public LogoutSuccessHandler() {
		
	}	  

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		 logger.info("Chegando no fim da request1");
		    logger.debug("Chegando no fim da request1");		
	}
	}