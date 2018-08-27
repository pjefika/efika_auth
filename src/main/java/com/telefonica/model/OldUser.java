package com.telefonica.model;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
@SuppressWarnings("all")
@Document(collection = "OldUsers")
public class OldUser {

    @Id
    private String id;
    @SerializedName("GP_EXTERNAL_ID")
    private String gpExternalId;
    @SerializedName("gp_xr_tech_cpf")
    private String gpXrTechCpf;
    //@SerializedName("gp_provider_active")
    private String gpProviderActive;
    //@SerializedName("gp_xr_company_name")
    private String gpXrTechName;
    //@SerializedName("gp_xr_tech_gender")
    private String gpXrTechGender;
    //@SerializedName("gp_xr_tech_type")
    private String gpXrTechType;
    //@SerializedName("gp_xr_tech_home_coordy")
    private String gpXrTechHomeCoordy;
    //@SerializedName("gp_xr_tech_home_coordx")
    private String gpXrTechHomeCoordx;
    //@SerializedName("gp_parent_level")
    private String gpParentLevel;
    //@SerializedName("gp_owner_id")
    private String gpOwnerId;
    //@SerializedName("gp_xr_technician_type")
    private String gpXrTechnicianType;
    //@SerializedName("gp_timestamp")
    private String gpTimestamp;
    //@SerializedName("GP_OWNER_NAME")
    private String gpOwnerName;
    @SerializedName("GP_PROVIDER_NAME")
    private String gpProviderName;
    //@SerializedName("gp_provider_ch_id")
    private String gpProviderChId;
    //@SerializedName("gp_xr_tech_credence")
    private String gpXrTechCredence;
    @SerializedName("gp_provider_phone")
    private String gpProviderPhone;
    //@SerializedName("gp_xr_tech_aux_tech")
    private String gpXrtechAuxTech;
    //@SerializedName("gp_xr_tech_company")
    private String gpXrTechCompany;
    //@SerializedName("gp_xr_tech_field_super_name")
    private String gpXrTechFieldSuperName;
    //@SerializedName("GP_PROVIDER_TYPE")
    private String gpProviderType;
    //@SerializedName("gp_xr_tech_field_supervisor_id")
    private String gpXrTechFieldSupervisorId;
    @SerializedName("gp_xr_tech_field_super_email")
    private String gpXrTechFieldSuperEmail;
    //@SerializedName("gp_xr_tech_field_super_numbe")
    private String gpXrTechFieldSuperNumbe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGpExternalId() {
        return gpExternalId;
    }

    public void setGpExternalId(String gpExternalId) {
        this.gpExternalId = gpExternalId;
    }

    public String getGpXrTechCpf() {
        return gpXrTechCpf;
    }

    public void setGpXrTechCpf(String gpXrTechCpf) {
        this.gpXrTechCpf = gpXrTechCpf;
    }

    public String getGpProviderActive() {
        return gpProviderActive;
    }

    public void setGpProviderActive(String gpProviderActive) {
        this.gpProviderActive = gpProviderActive;
    }

    public String getGpXrTechName() {
        return gpXrTechName;
    }

    public void setGpXrTechName(String gpXrTechName) {
        this.gpXrTechName = gpXrTechName;
    }

    public String getGpXrTechGender() {
        return gpXrTechGender;
    }

    public void setGpXrTechGender(String gpXrTechGender) {
        this.gpXrTechGender = gpXrTechGender;
    }

    public String getGpXrTechType() {
        return gpXrTechType;
    }

    public void setGpXrTechType(String gpXrTechType) {
        this.gpXrTechType = gpXrTechType;
    }

    public String getGpXrTechHomeCoordy() {
        return gpXrTechHomeCoordy;
    }

    public void setGpXrTechHomeCoordy(String gpXrTechHomeCoordy) {
        this.gpXrTechHomeCoordy = gpXrTechHomeCoordy;
    }

    public String getGpXrTechHomeCoordx() {
        return gpXrTechHomeCoordx;
    }

    public void setGpXrTechHomeCoordx(String gpXrTechHomeCoordx) {
        this.gpXrTechHomeCoordx = gpXrTechHomeCoordx;
    }

    public String getGpParentLevel() {
        return gpParentLevel;
    }

    public void setGpParentLevel(String gpParentLevel) {
        this.gpParentLevel = gpParentLevel;
    }

    public String getGpOwnerId() {
        return gpOwnerId;
    }

    public void setGpOwnerId(String gpOwnerId) {
        this.gpOwnerId = gpOwnerId;
    }

    public String getGpXrTechnicianType() {
        return gpXrTechnicianType;
    }

    public void setGpXrTechnicianType(String gpXrTechnicianType) {
        this.gpXrTechnicianType = gpXrTechnicianType;
    }

    public String getGpTimestamp() {
        return gpTimestamp;
    }

    public void setGpTimestamp(String gpTimestamp) {
        this.gpTimestamp = gpTimestamp;
    }

    public String getGpOwnerName() {
        return gpOwnerName;
    }

    public void setGpOwnerName(String gpOwnerName) {
        this.gpOwnerName = gpOwnerName;
    }

    public String getGpProviderName() {
        return gpProviderName;
    }

    public void setGpProviderName(String gpProviderName) {
        this.gpProviderName = gpProviderName;
    }

    public String getGpProviderChId() {
        return gpProviderChId;
    }

    public void setGpProviderChId(String gpProviderChId) {
        this.gpProviderChId = gpProviderChId;
    }

    public String getGpXrTechCredence() {
        return gpXrTechCredence;
    }

    public void setGpXrTechCredence(String gpXrTechCredence) {
        this.gpXrTechCredence = gpXrTechCredence;
    }

    public String getGpProviderPhone() {
        return gpProviderPhone;
    }

    public void setGpProviderPhone(String gpProviderPhone) {
        this.gpProviderPhone = gpProviderPhone;
    }

    public String getGpXrtechAuxTech() {
        return gpXrtechAuxTech;
    }

    public void setGpXrtechAuxTech(String gpXrtechAuxTech) {
        this.gpXrtechAuxTech = gpXrtechAuxTech;
    }

    public String getGpXrTechCompany() {
        return gpXrTechCompany;
    }

    public void setGpXrTechCompany(String gpXrTechCompany) {
        this.gpXrTechCompany = gpXrTechCompany;
    }

    public String getGpXrTechFieldSuperName() {
        return gpXrTechFieldSuperName;
    }

    public void setGpXrTechFieldSuperName(String gpXrTechFieldSuperName) {
        this.gpXrTechFieldSuperName = gpXrTechFieldSuperName;
    }

    public String getGpProviderType() {
        return gpProviderType;
    }

    public void setGpProviderType(String gpProviderType) {
        this.gpProviderType = gpProviderType;
    }

    public String getGpXrTechFieldSupervisorId() {
        return gpXrTechFieldSupervisorId;
    }

    public void setGpXrTechFieldSupervisorId(String gpXrTechFieldSupervisorId) {
        this.gpXrTechFieldSupervisorId = gpXrTechFieldSupervisorId;
    }

    public String getGpXrTechFieldSuperEmail() {
        return gpXrTechFieldSuperEmail;
    }

    public void setGpXrTechFieldSuperEmail(String gpXrTechFieldSuperEmail) {
        this.gpXrTechFieldSuperEmail = gpXrTechFieldSuperEmail;
    }

    public String getGpXrTechFieldSuperNumbe() {
        return gpXrTechFieldSuperNumbe;
    }

    public void setGpXrTechFieldSuperNumbe(String gpXrTechFieldSuperNumbe) {
        this.gpXrTechFieldSuperNumbe = gpXrTechFieldSuperNumbe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OldUser{");
        sb.append("id='").append(id).append('\'');
        sb.append(", gpExternalId='").append(gpExternalId).append('\'');
        sb.append(", gpXrTechCpf='").append(gpXrTechCpf).append('\'');
        sb.append(", gpProviderActive='").append(gpProviderActive).append('\'');
        sb.append(", gpXrTechName='").append(gpXrTechName).append('\'');
        sb.append(", gpXrTechGender='").append(gpXrTechGender).append('\'');
        sb.append(", gpXrTechType='").append(gpXrTechType).append('\'');
        sb.append(", gpXrTechHomeCoordy='").append(gpXrTechHomeCoordy).append('\'');
        sb.append(", gpXrTechHomeCoordx='").append(gpXrTechHomeCoordx).append('\'');
        sb.append(", gpParentLevel='").append(gpParentLevel).append('\'');
        sb.append(", gpOwnerId='").append(gpOwnerId).append('\'');
        sb.append(", gpXrTechnicianType='").append(gpXrTechnicianType).append('\'');
        sb.append(", gpTimestamp='").append(gpTimestamp).append('\'');
        sb.append(", gpOwnerName='").append(gpOwnerName).append('\'');
        sb.append(", gpProviderName='").append(gpProviderName).append('\'');
        sb.append(", gpProviderChId='").append(gpProviderChId).append('\'');
        sb.append(", gpXrTechCredence='").append(gpXrTechCredence).append('\'');
        sb.append(", gpProviderPhone='").append(gpProviderPhone).append('\'');
        sb.append(", gpXrtechAuxTech='").append(gpXrtechAuxTech).append('\'');
        sb.append(", gpXrTechCompany='").append(gpXrTechCompany).append('\'');
        sb.append(", gpXrTechFieldSuperName='").append(gpXrTechFieldSuperName).append('\'');
        sb.append(", gpProviderType='").append(gpProviderType).append('\'');
        sb.append(", gpXrTechFieldSupervisorId='").append(gpXrTechFieldSupervisorId).append('\'');
        sb.append(", gpXrTechFieldSuperEmail='").append(gpXrTechFieldSuperEmail).append('\'');
        sb.append(", gpXrTechFieldSuperNumbe='").append(gpXrTechFieldSuperNumbe).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
