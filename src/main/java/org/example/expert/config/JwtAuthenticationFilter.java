package org.example.expert.config;
// Custom JWT Authentication Filter
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.expert.config.JwtUtil;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.user.enums.UserRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

@Component
class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtUtil.resolveToken(request);

        if (token != null && jwtUtil.validateToken(token)) {
            Claims claims = jwtUtil.extractClaims(token);
            UserRole userRole = UserRole.valueOf(claims.get("userRole", String.class));

//            String username = jwtUtil.getUsernameFromToken(token);
//            UserRole userRole = jwtUtil.getRolesFromToken(token);

//            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(userRole.name()));
//
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                    username, null, authorities
//            );
//
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            AuthUser authUser = new AuthUser(Long.parseLong(claims.getSubject()), "", (String) claims.get("email"), List.of(userRole::name));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(authUser,null,authUser.getAuthorities()));
        }

        filterChain.doFilter(request, response);
    }


}