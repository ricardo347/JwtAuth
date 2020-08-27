package br.com.zerosystems.jwtAuth.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthenticationFilter extends GenericFilterBean {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//Authentication authentication = TokenAuthenticationService
		//	.getAuthentication((HttpServletRequest) request);
		logger.info("PASSOU PELO FILTRO JWTAuthenticationFilter");
		Authentication authentication = new TokenAuthenticationService().authRequest(request);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		logger.info("##########--------------------################  jwtAuth    INICIO  dofilter");	
		filterChain.doFilter(request, response);
		logger.info("##########--------------------################   jwtAuth     FIM  dofilter");	
	}

}