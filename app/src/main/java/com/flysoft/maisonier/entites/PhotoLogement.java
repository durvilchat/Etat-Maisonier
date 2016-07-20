/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "photo_logement", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PhotoLogement.findAll", query = "SELECT p FROM PhotoLogement p"),
        @NamedQuery(name = "PhotoLogement.findById", query = "SELECT p FROM PhotoLogement p WHERE p.id = :id"),
        @NamedQuery(name = "PhotoLogement.findByEtat", query = "SELECT p FROM PhotoLogement p WHERE p.etat = :etat"),
        @NamedQuery(name = "PhotoLogement.findByNom", query = "SELECT p FROM PhotoLogement p WHERE p.nom = :nom")})
public class PhotoLogement extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;

    public PhotoLogement() {
    }

    public PhotoLogement(Integer id) {
        this.id = id;
    }

    public PhotoLogement(Integer id, boolean etat, String nom) {
        this.id = id;
        this.etat = etat;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
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
        if (!(object instanceof PhotoLogement)) {
            return false;
        }
        PhotoLogement other = (PhotoLogement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.PhotoLogement[ id=" + id + " ]";
    }

}
