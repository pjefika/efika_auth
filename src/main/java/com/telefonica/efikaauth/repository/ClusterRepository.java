/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.repository;

import com.telefonica.efikaauth.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author A0077749
 */
public interface ClusterRepository extends CrudRepository<ClusterModel, Integer> {

    @Query("select distinct u.cidade from ClusterModel u")
    List<String> cidades();
    @Query("select distinct u.cluster from ClusterModel u where u.cidade = ?1")
    List<String> cluster(String cidade);
}
