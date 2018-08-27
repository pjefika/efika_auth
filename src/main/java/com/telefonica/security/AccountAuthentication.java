package com.telefonica.security;

import com.telefonica.dao.UserDao;
import com.telefonica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 15/08/18 - 22:29
 */
@Service
public class AccountAuthentication implements AuthenticationProvider {

    @Autowired private UserDao userDao;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try{

            String user = authentication.getName();
            String password = authentication.getCredentials().toString();
            User mUser = userDao.findByMatriculaAndPassword(user, password);

            if(mUser != null){
                return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
            }else{
                throw new BadCredentialsException("Falha ao autenticar usuário !!");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new BadCredentialsException("Falha ao autenticar usuário !!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
