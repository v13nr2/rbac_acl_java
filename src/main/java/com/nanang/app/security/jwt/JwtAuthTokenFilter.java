package com.nanang.app.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nanang.app.security.service.UserDetailsServiceImpl;





public class JwtAuthTokenFilter extends OncePerRequestFilter {

	@Autowired
    private JwtProvider tokenProvider;
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	        	
			   
	            String jwt = getJwt(request);
//	            System.out.println("===================================================================================");
//	            System.out.println("jwt " + jwt);
//	            System.out.println("===================================================================================");
//	            
	            if (jwt!=null && tokenProvider.validateJwtToken(jwt)) {
	                String username = tokenProvider.getBodyTokenFromJwtToken(jwt);
	                
	                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	                
	                UsernamePasswordAuthenticationToken authentication 
	                		= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	 
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            }
	        } catch (Exception e) {
	            logger.error("Can NOT set user authentication -> Message: {}", e);
	        }
	 
	        filterChain.doFilter(request, response);
		
	}
	 private String getJwt(HttpServletRequest request) {
	        String authHeader = request.getHeader("Authorization");
//	        System.out.println("============================================");
//	        System.out.println("auth header" + authHeader);
	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	        	return authHeader.replace("Bearer ","");
	        }
	 
	        return null;
	    }

}
