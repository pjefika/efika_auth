package com.telefonica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 16/08/18 - 08:37
 */
@Document(collection = "cluster")
public class Cluster {

    //region ATRIBUTES
    @Id
    private Integer id;
    private String cidade;
    private String cluster;
    private String regional;
    private String estado;
    //endregion

    //region GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //endregion

    //region OVERRIDE

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cluster{");
        sb.append("id=").append(id);
        sb.append(", cidade='").append(cidade).append('\'');
        sb.append(", cluster='").append(cluster).append('\'');
        sb.append(", regional='").append(regional).append('\'');
        sb.append(", estado='").append(estado).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //endregion
}
