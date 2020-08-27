package br.com.zerosystems.jwtAuth.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicLogFilter implements Filter{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("##########--------------------################      INICIO dofilter");
		chain.doFilter(request, response);
		logger.info("##########--------------------################      FIM  dofilter");		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		logger.info("init");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("destroy");
		Filter.super.destroy();
	}

}
