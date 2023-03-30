package com.wissen.user.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter  {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println("Header : " + authorizationHeader);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
            throw new AuthorizationServiceException("Invalid token");

        final String token = authorizationHeader.substring(7);
        System.out.println("Token : " +token);
        Claims claims = Jwts.parser().setSigningKey("wissen").parseClaimsJws(token).getBody();
        System.out.println("Claims" + claims);
        request.setAttribute("claims", claims);
        filterChain.doFilter(request, response);
    }
}
