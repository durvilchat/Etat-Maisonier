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
@Table(name = "type_compte", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"libelle"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TypeCompte.findAll", query = "SELECT t FROM TypeCompte t"),
        @NamedQuery(name = "TypeCompte.findById", query = "SELECT t FROM TypeCompte t WHERE t.id = :id"),
        @NamedQuery(name = "TypeCompte.findByDescription", query = "SELECT t FROM TypeCompte t WHERE t.description = :description"),
        @NamedQuery(name = "TypeCompte.findByLibelle", query = "SELECT t FROM TypeCompte t WHERE t.libelle = :libelle")})
public class TypeCompte extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", length = 255)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeCompte")
    private List<Compte> compteList;

    public TypeCompte() {
    }

    public TypeCompte(Integer id) {
        this.id = id;
    }

    public TypeCompte(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public List<Compte> getCompteList() {
        return compteList;
    }

    public void setCompteList(List<Compte> compteList) {
        this.compteList = compteList;
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
        if (!(object instanceof TypeCompte)) {
            return false;
        }
        TypeCompte other = (TypeCompte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.TypeCompte[ id=" + id + " ]";
    }

}
