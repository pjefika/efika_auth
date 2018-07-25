/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.controller;

import com.telefonica.efikaauth.model.ClusterModel;
import com.telefonica.efikaauth.repository.ClusterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author A0077749
 */
@RequestMapping("/cluster")
@RestController
@Service
public class ClusterController {
 
    @Autowired
    ClusterRepository repository;
    
    @RequestMapping(value = "/cidades",
            method = RequestMethod.GET)
    public List<String> getCidades(){
        return repository.cidades();
    }
    
    @RequestMapping(value = "/cluster/{cidade}",
            method = RequestMethod.GET)
    public List<String> getCluster(@PathVariable("cidade") String cidade){
        return repository.cluster(cidade);
    }
    
    @RequestMapping(value = "/cidades/{cluster}",
            method = RequestMethod.GET)
    public List<String> getCidades(@PathVariable("cluster") String cluster){
        return repository.cidades(cluster);
    }
    
    @RequestMapping(value = "/cluster",
            method = RequestMethod.GET)
    public List<String> getCluster(){
        return repository.cluster();
    }
    
    @RequestMapping(value = "/sincroniza",
            method = RequestMethod.GET)
    public boolean sincronizaCluster() {
        /*Iterable<ClusterModel> clusters = repository.findAll();
        for (ClusterModel cluster : clusters) {
            RestTemplate restTemplate = new RestTemplate();
            List<ClusterModel> temp = new ArrayList<ClusterModel>();
            temp.add(cluster);
            restTemplate.postForLocation("http://localhost:8989/auth/sincronizacao/cluster", temp);
        }*/
        return true;
    }
}
