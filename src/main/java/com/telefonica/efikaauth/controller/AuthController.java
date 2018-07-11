package com.telefonica.efikaauth.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controle de login/logout para as aplicações Efika
 * @author A0077749
 */
@RestController
public class AuthController {
    
    @RequestMapping(value = "/logout",
               method = RequestMethod.GET)
    public boolean logout(){
        return true;
    }
}
