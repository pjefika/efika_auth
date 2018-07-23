/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Tarefa responsável por executar a sincronização com a base na amazon
 * @author A0077749
 */
@Service
public class SincronizacaoTask {
    
    /***
     * Executada a cada 10 minutos realizando a sincronização dos dados
     */
    @Scheduled(fixedDelay = 600000)
    public void sincronizaAWS(){
        
    }
}
