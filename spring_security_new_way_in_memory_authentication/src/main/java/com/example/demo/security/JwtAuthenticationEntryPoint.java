package com.example.demo.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint // this method is used when any unaurtherize person is try to acces our api
// ( Method of this class is called whenever as exception is thrown due to unauthenticated user trying to access the resource that required authentication.)
{
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException authException) throws IOException, ServletException // By implementing the commence method in a custom class, you can customize 
//	the behavior of how your application handles unauthenticated requests. This allows you to provide consistent and meaningful responses to clients attempting to access protected resources without proper authentication.
	{
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	     PrintWriter writer = response.getWriter();
	     writer.println("Access Denied !! " + authException.getMessage()); 
	}
}
