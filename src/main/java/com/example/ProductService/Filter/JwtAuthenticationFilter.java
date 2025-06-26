package com.example.ProductService.Filter;

import com.example.ProductService.Service.JwtValidator;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

@Component
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtValidator jwtValidator;

    public JwtAuthenticationFilter(JwtValidator jwtValidator) {

        this.jwtValidator = jwtValidator;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest http = (HttpServletRequest) request;

        String authHeader = http.getHeader("Authorization");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if(jwtValidator.validateToken(token)) {

                String username = jwtValidator.getUsername(token);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username,null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request,response);

    }

}
