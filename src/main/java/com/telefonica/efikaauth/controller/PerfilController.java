/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.PerfilModel;
import com.telefonica.efikaauth.model.UsuarioModel;
import com.telefonica.efikaauth.repository.PerfilRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A0077749
 */
@RequestMapping("/perfil")
@RestController
public class PerfilController {
    
    @Autowired
    PerfilRepository perfilRepository;
    
    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public PerfilModel create(@RequestBody PerfilModel perfil) throws Exception{
        try {
            perfil.setId(0);
            PerfilModel perfilCriado = perfilRepository.save(perfil);
            return perfilCriado;
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }
    
    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    public List<PerfilModel> list() throws Exception{
        Iterable<PerfilModel> perfis = perfilRepository.findAll();
        List<PerfilModel> model = new ArrayList<PerfilModel>();
        for (PerfilModel perfil : perfis) {
            model.add(perfil);
        }
        return model;
    }
}
