/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.TelaModel;
import com.telefonica.efikaauth.model.TelaModel;
import com.telefonica.efikaauth.repository.TelaRepository;
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
 * @author A0067675
 */
@RequestMapping("/tela")
@RestController
public class TelaController {
    
    @Autowired
    TelaRepository telaRepository;
    
    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public TelaModel create(@RequestBody TelaModel tela) throws Exception{
        try {
            tela.setId(0);
            TelaModel telaCriado = TelaRepository.save(tela);
            return telaCriado;
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }
    
    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    public List<TelaModel> list() throws Exception{
        Iterable<TelaModel> perfis = TelaRepository.findAll();
        List<TelaModel> model = new ArrayList<TelaModel>();
        for (TelaModel tela : perfis) {
            model.add(tela);
        }
        return model;
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public TelaModel update(@RequestBody TelaModel tela) throws Exception {
        try {
            if (tela.getId() == 0) {
                throw new Exception("Tela não está cadastrada");
            }
            TelaModel telabanco = TelaRepository.findById(tela.getId()).get();
            if (telabanco == null) {
                throw new Exception("Tela não está cadastrada");
            }
            if (!telabanco.getNome().equalsIgnoreCase(tela.getNome())) {
                tela.setNome(telabanco.getNome());
            }
            tela.setAtualizado(true);
            TelaModel telaCriado = TelaRepository.save(tela);
            return telaCriado;
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new Exception("Já existe uma tela com este nome", e);
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE)
    public boolean delete(int uid) throws Exception {
        try {
            TelaModel tela = TelaRepository.findById(uid).get();
            if (tela == null) {
                throw new Exception("Tela não encontrada");
            }
            TelaRepository.deleteById(uid);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
