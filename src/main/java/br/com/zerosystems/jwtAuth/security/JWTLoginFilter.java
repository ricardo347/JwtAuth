package br.com.zerosystems.jwtAuth.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		/*setRequiresAuthenticationRequestMatcher(new OrRequestMatcher(                                                                                     
		        new AntPathRequestMatcher("/login")                                                                                   
		        , new AntPathRequestMatcher("/secret")                                                                            
		     ));*/
		setAuthenticationManager(authManager);
	}	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		logger.info("PASSOU PELO FILTRO JWTloginFilter");
		logger.info(request.getRequestURI());
		if(request.getRequestURI().equals("/saasdf"))	{			
			logger.info("url estranha");
			AccountCredentials credentials = new AccountCredentials();
			credentials.setUsername("admin");
			credentials.setPassword("password");
			
			Authentication auth = getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(
							credentials.getUsername(), 
							credentials.getPassword(), 
							Collections.emptyList()
							)
					);			
			return auth;			
			//return new UsernamePasswordAuthenticationToken("admin", "password", Collections.emptyList());		
		}
	
		AccountCredentials credentials = new ObjectMapper()
				.readValue(request.getInputStream(), AccountCredentials.class);	
		logger.info("url correspondente");
		logger.info(credentials.getUsername());
		logger.info(credentials.getPassword());
		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						credentials.getUsername(), 
						credentials.getPassword(), 
						Collections.emptyList()
						)
				);
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterChain,
			Authentication auth) throws IOException, ServletException {
		logger.info("foi autenticado");
		logger.info(auth.isAuthenticated());
		logger.info(response.getStatus());
		
		//SecurityContext context = SecurityContextHolder.createEmptyContext();
       // context.setAuthentication(auth);
        //SecurityContextHolder.getContext().setAuthentication(auth);
        //filterChain.doFilter(request, response);
		//TokenAuthenticationService.addAuthentication(response, auth.getName());
	}
	/*@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
		logger.info("nao foi autenticado");
		
	}*/

}