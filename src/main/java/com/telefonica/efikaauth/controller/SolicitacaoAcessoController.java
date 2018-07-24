/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.SolicitacaoAcessoModel;
import com.telefonica.efikaauth.model.UsuarioModel;
import com.telefonica.efikaauth.repository.SolicitacaoAcessoRepository;
import com.telefonica.efikaauth.repository.UsuarioRepository;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 *
 * @author A0077749
 */
@RestController
public class SolicitacaoAcessoController {

    @Autowired
    SolicitacaoAcessoRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/get",
            method = RequestMethod.GET)
    public SolicitacaoAcessoModel get(int uid) throws Exception {
        try {
            SolicitacaoAcessoModel solicitacao = repository.findById(uid).get();
            if (solicitacao != null) {
                return solicitacao;
            }
            throw new Exception("Solicitação não encontrada");
        } catch (Exception e) {
            throw new Exception("Erro ao processar solicitação: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public SolicitacaoAcessoModel create(@RequestBody SolicitacaoAcessoModel solicitacao) throws Exception {
        try {
            SolicitacaoAcessoModel sol = repository.validate(solicitacao.getCpf(), solicitacao.getEmail(), solicitacao.getMatricula());
            if (sol != null) {
                throw new Exception("Já existe uma solicitação aberta");
            }
            SolicitacaoAcessoModel novasol = repository.save(solicitacao);
            return novasol;
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new Exception("Já existe uma solicitação com a matricula informada", e);
        } catch (org.springframework.transaction.TransactionSystemException e) {
            throw new Exception(
                    ((ConstraintViolation) ((ConstraintViolationException) ((RollbackException) e.getCause()).getCause()).
                            getConstraintViolations().toArray()[0]).getMessage(),
                    e);
        }
    }
    
    @RequestMapping(value = "/aprova",
            method = RequestMethod.POST)
    public UsuarioModel aprova(int uidSolicitacao, UsuarioModel usuario, String aprovador){        
        try {
            SolicitacaoAcessoModel solicitacao = repository.findById(uidSolicitacao).get();
            if(solicitacao == null)
                throw new Exception("Solicitação não encontrada");
            
            usuario.setId(0);
            usuario.setAtualizado(true);
            UsuarioModel usuarioSalvo = usuarioRepository.save(usuario);
            solicitacao.setUsuario_id(usuarioSalvo.getId());
            solicitacao.setAtendido(true);
        } catch (Exception e) {
        }
        return null;
    }
}
