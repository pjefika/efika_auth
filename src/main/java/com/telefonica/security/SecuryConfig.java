package com.telefonica.security;

import com.telefonica.util.FilterSimpleCors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 15/08/18 - 23:17
 */

@Configuration
@EnableWebSecurity
public class SecuryConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountAuthentication accAuthentication;

    @Override
    protected void configure(HttpSecurity httpSecurity){
        try{

            /**
             * Para definir uma rota livre adicione .permitAll()
             * para definir uma rota como restrita a autenticacao adicione .authenticated()
             * feito isso, antes do usuario acessar determinada rota ele deve fazer autenticacao pela rota logar.
             */
            httpSecurity.csrf().disable().authorizeRequests()
                    .antMatchers("/swagger-ui.html").permitAll()
                    .antMatchers(HttpMethod.POST, "/logar").permitAll()
                    .antMatchers("/usuario/setor/**").permitAll()
                    .antMatchers("/usuario/**").permitAll()
                    .antMatchers("/groups/**").authenticated()
                    .antMatchers("/group/**").permitAll()
                    .antMatchers("/cluster/**").permitAll()

                    .and()
                    .addFilterBefore(new FilterSimpleCors(),
                            UsernamePasswordAuthenticationFilter.class)
                    // filtra requisições de login
                    .addFilterBefore(new AccountJwtLoginFilter("/logar", authenticationManager()),
                            UsernamePasswordAuthenticationFilter.class)
                    // filtra outras requisições para verificar a presença do JWT no header
                    .addFilterBefore(new AccountJwtAuthenticationFilter(),
                            UsernamePasswordAuthenticationFilter.class)
                    .authenticationProvider(accAuthentication);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
