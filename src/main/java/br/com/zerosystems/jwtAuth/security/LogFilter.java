package br.com.zerosystems.jwtAuth.security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


public class LogFilter extends CommonsRequestLoggingFilter{

	Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		// TODO Auto-generated method stub
		super.beforeRequest(request, message);
		logger.info("antes da requisiçaõ");
	}
	
	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		// TODO Auto-generated method stub
		super.afterRequest(request, message);
		logger.info("depois da requisiçaõ");
	}
	 
}
