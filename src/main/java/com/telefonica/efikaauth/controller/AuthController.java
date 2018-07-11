package com.telefonica.efikaauth.controller;
import com.telefonica.efikaauth.application.Greeting;
import com.telefonica.efikaauth.model.UsuarioModel;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
