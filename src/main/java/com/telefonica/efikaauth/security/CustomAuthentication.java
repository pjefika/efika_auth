/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.security;

import com.telefonica.efikaauth.model.UsuarioModel;
import com.telefonica.efikaauth.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author A0077749
 */
@Service
public class CustomAuthentication implements AuthenticationProvider {

    @Autowired
    UsuarioRepository usuariorep;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String user = authentication.getName();
            String password = authentication.getCredentials().toString();
            UsuarioModel usuario = usuariorep.findByUsuarioSenha(user, password);
            if ( usuario != null) {// replace your custom code here for custom authentication
                return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
            } else {
                throw new BadCredentialsException("External system authentication failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("External system authentication failed");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
