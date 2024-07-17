package com.forohubapi.infra.security;

import com.forohubapi.domain.autenticacion.UsuarioAutenticacionRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioAutenticacionRepository usuarioAutenticacionRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");//.replace("Bearer","");
        System.out.println(authHeader);
        if(authHeader != null){
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = tokenService.getSubject(token);
            if(nombreUsuario != null){
                var usuario = usuarioAutenticacionRepository.findByLogin(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken
                        (usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
