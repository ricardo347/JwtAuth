package br.com.zerosystems.jwtAuth.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


public class LogFilter extends AbstractRequestLoggingFilter{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public LogFilter() {
		// TODO Auto-generated constructor stub
		this.setIncludeClientInfo(true);		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {		
		super.doFilterInternal(request, response, filterChain);
	}
	
	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {		
		logger.info("%%%%%%% ===================== %%%%%%%%%%%%%%%  antes da requisiçaõ");
	}
	
	@Override
	protected void afterRequest(HttpServletRequest request, String message) {		
		logger.info("%%%%%%% ===================== %%%%%%%%%%%%%%%  depois da requisiçaõ");
	}
	 
}
