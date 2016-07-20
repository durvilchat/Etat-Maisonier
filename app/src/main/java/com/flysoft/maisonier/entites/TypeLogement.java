/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "type_logement", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code"}),
        @UniqueConstraint(columnNames = {"libelle"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TypeLogement.findAll", query = "SELECT t FROM TypeLogement t"),
        @NamedQuery(name = "TypeLogement.findById", query = "SELECT t FROM TypeLogement t WHERE t.id = :id"),
        @NamedQuery(name = "TypeLogement.findByCode", query = "SELECT t FROM TypeLogement t WHERE t.code = :code"),
        @NamedQuery(name = "TypeLogement.findByDescription", query = "SELECT t FROM TypeLogement t WHERE t.description = :description"),
        @NamedQuery(name = "TypeLogement.findByEtat", query = "SELECT t FROM TypeLogement t WHERE t.etat = :etat"),
        @NamedQuery(name = "TypeLogement.findByLibelle", query = "SELECT t FROM TypeLogement t WHERE t.libelle = :libelle")})
public class TypeLogement extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code", length = 255)
    private String code;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", length = 255)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeLogement")
    private List<Logement> logementList;

    public TypeLogement() {
    }

    public TypeLogement(Integer id) {
        this.id = id;
    }

    public TypeLogement(Integer id, String code, boolean etat, String libelle) {
        this.id = id;
        this.code = code;
        this.etat = etat;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public List<Logement> getLogementList() {
        return logementList;
    }

    public void setLogementList(List<Logement> logementList) {
        this.logementList = logementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLogement)) {
            return false;
        }
        TypeLogement other = (TypeLogement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.TypeLogement[ id=" + id + " ]";
    }

}
