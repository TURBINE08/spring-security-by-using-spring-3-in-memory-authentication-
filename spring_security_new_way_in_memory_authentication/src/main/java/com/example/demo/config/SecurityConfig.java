package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtAuthenticationFilter;

import jakarta.websocket.Session;

@Configuration
public class SecurityConfig {
	
	@Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
    			 http.csrf(csrf->csrf.disable())
    			.cors(cors->cors.disable())
    			.authorizeHttpRequests(auth->auth.requestMatchers("/home/**")
    	
    			.authenticated().requestMatchers("/auth/login").permitAll()
    			.anyRequest().authenticated())
    			.exceptionHandling(ex->ex.authenticationEntryPoint(point))
    			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    	;
    			 
//    			 http.csrf(csrf->csrf.disable())
//     			.cors(cors->cors.disable())
////     			.authorizeHttpRequests(auth->auth.requestMatchers("/home/**")
//     			.authorizeHttpRequests(auth->auth.requestMatchers("/home/users").hasRole("/ADMIN")
//     			.requestMatchers("/home/getname").hasRole("/STUDENT")
//     			.requestMatchers("/home/get-curren-user").hasAnyRole("/ADMIN","/STUDENT")
//     			.requestMatchers("/auth/login").permitAll()
//     			.anyRequest().authenticated())
//     			.exceptionHandling(ex->ex.authenticationEntryPoint(point))
//     			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//     	;
    			 
    			 
    	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
    	
    	
    	return http.build();
    	
    }


}
