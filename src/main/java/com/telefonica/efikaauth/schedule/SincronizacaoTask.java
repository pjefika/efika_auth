/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.schedule;

import com.telefonica.efikaauth.model.ClusterModel;
import com.telefonica.efikaauth.repository.ClusterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Tarefa responsável por executar a sincronização com a base na amazon
 *
 * @author A0077749
 */
@Service
public class SincronizacaoTask {

    @Autowired
    ClusterRepository clusterRepository;

    /**
     * *
     * Executada a cada 10 minutos realizando a sincronização dos dados
     */
    @Scheduled(fixedDelay = 600000)
    public void sincronizaAWS() {

    }

    public boolean sincronizaCluster() {
        Iterable<ClusterModel> clusters = clusterRepository.findAll();
        for (ClusterModel cluster : clusters) {
            RestTemplate restTemplate = new RestTemplate();
            List<ClusterModel> temp = new ArrayList<ClusterModel>();
            temp.add(cluster);
            restTemplate.postForLocation("http://localhost:8989/auth/sincronizacao/cluster", temp);
        }
        return true;
    }
}
