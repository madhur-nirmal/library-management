package com.wissen.authservice.security.config;

import com.wissen.authservice.appuser.AppUser;
import com.wissen.authservice.appuser.AppUserService;
import com.wissen.authservice.utility.JWTUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private JWTUtility jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        final String userName;
        final String jwt;

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authorizationHeader.substring(7);
        userName = jwtUtil.getUsernameFromToken(jwt);
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            AppUser appUser = (AppUser) appUserService.loadUserByUsername(userName);
            final boolean isTokenValid = jwtUtil.validateToken(jwt, appUser);
            if (isTokenValid) {
                UsernamePasswordAuthenticationToken token =
                        new UsernamePasswordAuthenticationToken(appUser, null, appUser.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token);
            }

        }
        filterChain.doFilter(request, response);
    }
}
