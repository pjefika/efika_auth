/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.Enuns.Setores;
import com.telefonica.efikaauth.model.UsuarioModel;
import com.telefonica.efikaauth.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import jdk.nashorn.internal.objects.NativeArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A0077749
 */
@RequestMapping("/usuario")
@RestController
@Service
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public UsuarioModel create(@RequestBody UsuarioModel usuario) throws Exception {
        try {
            usuario.setId(0);
            UsuarioModel usuarioCriado = usuarioRepository.save(usuario);
            return usuarioCriado;
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new Exception("Já existe um usuário com a matricula informada", e);
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public UsuarioModel update(@RequestBody UsuarioModel usuario) throws Exception {
        try {
            if (usuario.getId() == 0) {
                throw new Exception("Usuário não está cadastrado");
            }
            UsuarioModel usuariobanco = usuarioRepository.findById(usuario.getId()).get();
            if (usuariobanco == null) {
                throw new Exception("Usuário não está cadastrado");
            }
            if (!usuariobanco.getMatricula().equalsIgnoreCase(usuario.getMatricula())) {
                usuario.setMatricula(usuariobanco.getMatricula());
            }
            UsuarioModel usuarioCriado = usuarioRepository.save(usuario);
            return usuarioCriado;
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new Exception("Já existe um usuário com a matricula informada", e);
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }

    @RequestMapping(value = "/get",
            method = RequestMethod.GET)
    public UsuarioModel get(int uid) throws Exception {
        UsuarioModel usuario = usuarioRepository.findById(uid).get();
        if (usuario == null) {
            throw new Exception("Usuário não encontrado");
        }
        return usuario;
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE)
    public boolean delete(int uid) throws Exception {
        try {
            UsuarioModel usuario = usuarioRepository.findById(uid).get();
            if (usuario == null) {
                throw new Exception("Usuário não encontrado");
            }
            usuarioRepository.deleteById(uid);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    public List<UsuarioModel> list(int page, int count, int size) {
        Iterable<UsuarioModel> usuarios = usuarioRepository.findAll();
        List<UsuarioModel> model = new ArrayList<UsuarioModel>();
        for (UsuarioModel usuario : usuarios) {
            model.add(usuario);
        }
        return model;
    }
    
    @RequestMapping(value = "/setores",
            method = RequestMethod.GET)
    public List<Setores> getSetores(){
        return Arrays.asList(Setores.values());
    }
}
