package com.telefonica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 15/08/18 - 16:14
 */
@SuppressWarnings("all")
@Document(collection = "users")
public class User {

    //region ATRIBUTES

    @Id
    private String id;
    private String matricula;
    private String name;
    private String email;
    private String cpf;
    private Date dateBorn;
    private String password;
    private String sector;
    @JsonIgnore
    private Set<UserProfile> profiles;
    @JsonIgnore
    private Boolean isUpdated;
    private String phone;
    private Date dateExpire;
    private Date dateCreated;
    private Date dateUpdated;
    private Integer creator;
    private List<Group> groups;

    //endregion

    //region GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String naem) {
        this.name = naem;
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

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Set<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<UserProfile> profiles) {
        this.profiles = profiles;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    //endregion

    //region OVERRIDE

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", matricula='").append(matricula).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", dateBorn=").append(dateBorn);
        sb.append(", password='").append(password).append('\'');
        sb.append(", sector='").append(sector).append('\'');
        sb.append(", profiles=").append(profiles);
        sb.append(", isUpdated=").append(isUpdated);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", dateExpire=").append(dateExpire);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateUpdated=").append(dateUpdated);
        sb.append(", creator=").append(creator);
        sb.append(", groups=").append(groups);
        sb.append('}');
        return sb.toString();
    }

    //endregion
}
