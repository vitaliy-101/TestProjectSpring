package com.kostin.first.settings.security;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    @Override
    public void commence(
        HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (request.getServletPath() != null && request.getServletPath().startsWith("/api")) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/");
            dispatcher.forward(request, response);
        }
    }
}