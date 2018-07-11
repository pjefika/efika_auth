/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.repository;

import com.telefonica.efikaauth.model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author A0077749
 */
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer>{
    
  @Query("select u from UsuarioModel u where u.matricula = ?1 and u.senha = ?2")
  UsuarioModel findByUsuarioSenha(String usuario, String senha);
  @Query("select u from UsuarioModel u where u.matricula = ?1 ")
  UsuarioModel findByUsuario(String usuario);
}
