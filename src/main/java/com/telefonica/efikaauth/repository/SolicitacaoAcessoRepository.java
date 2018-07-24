/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.repository;

import com.telefonica.efikaauth.model.SolicitacaoAcessoModel;
import com.telefonica.efikaauth.model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author A0077749
 */
public interface SolicitacaoAcessoRepository extends CrudRepository<SolicitacaoAcessoModel, Integer> {

    @Query("select s from SolicitacaoAcessoModel s where s.cpf = ?1 or s.email = ?2 or s.matricula = ?3 ")
    SolicitacaoAcessoModel validate(String cpf, String email, String matricula);
}
