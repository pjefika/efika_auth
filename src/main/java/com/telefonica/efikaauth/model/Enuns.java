/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.model;

/**
 *
 * @author A0077749
 */
public class Enuns {
    
    public enum Strin{
        CheckList("Check List"),
        RALO("R.A.L.O");
        
        private String nome;
        private Strin(String nomeFantasia){
            nome = nomeFantasia;
        }
        
        @Override
        public String toString(){
            return this.nome;
        }
    }
}
