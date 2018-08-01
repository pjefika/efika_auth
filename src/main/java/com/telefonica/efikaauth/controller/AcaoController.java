/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.AcaoModel;
import com.telefonica.efikaauth.model.AcaoModel;
import com.telefonica.efikaauth.repository.AcaoRepository;
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
@RequestMapping("/acao")
@RestController
public class AcaoController {
    
    @Autowired
    AcaoRepository acaoRepository;
    
    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public AcaoModel create(@RequestBody AcaoModel acao) throws Exception{
        try {
            acao.setId(0);
            AcaoModel acaoCriado = AcaoRepository.save(acao);
            return acaoCriado;
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }
    
    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    public List<AcaoModel> list() throws Exception{
        Iterable<AcaoModel> perfis = AcaoRepository.findAll();
        List<AcaoModel> model = new ArrayList<AcaoModel>();
        for (AcaoModel acao : perfis) {
            model.add(acao);
        }
        return model;
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public AcaoModel update(@RequestBody AcaoModel acao) throws Exception {
        try {
            if (acao.getId() == 0) {
                throw new Exception("Ação não está cadastrada");
            }
            AcaoModel acaobanco = AcaoRepository.findById(acao.getId()).get();
            if (acaobanco == null) {
                throw new Exception("Ação não está cadastrada");
            }
            if (!acaobanco.getNome().equalsIgnoreCase(acao.getNome())) {
                acao.setNome(acaobanco.getNome());
            }
            acao.setAtualizado(true);
            AcaoModel acaoCriado = AcaoRepository.save(acao);
            return acaoCriado;
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new Exception("Já existe uma ação com este nome", e);
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
            AcaoModel acao = AcaoRepository.findById(uid).get();
            if (acao == null) {
                throw new Exception("Ação não encontrada");
            }
            AcaoRepository.deleteById(uid);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
