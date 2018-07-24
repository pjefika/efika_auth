/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telefonica.efikaauth.model.Enuns.Strin;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

/**
 *
 * @author A0077749
 */
@Entity
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, length = 10)
    private String matricula;
    //@NotNull
    private String nome;
    @Email
    private String email;
    private String cpf;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_nascimento;
    private String senha;
    private String setor;
    @JsonIgnore
    @OneToMany
    private List<PerfilModel> perfis;
    @JsonIgnore
    private boolean atualizado;
    private String telefone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_expira;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_criacao;
    private int criadoPor;

    /*
    Cidade
        id
        Nome
        sigla
    Cluster
    */
    public Date getDt_expira() {
        return dt_expira;
    }

    public void setDt_expira(Date dt_expira) {
        this.dt_expira = dt_expira;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public int getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(int criadoPor) {
        this.criadoPor = criadoPor;
    }

    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtualizado() {
        return atualizado;
    }

    public void setAtualizado(boolean atualizado) {
        this.atualizado = atualizado;
    }

    public List<PerfilModel> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<PerfilModel> perfis) {
        this.perfis = perfis;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String area) {
        this.setor = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
