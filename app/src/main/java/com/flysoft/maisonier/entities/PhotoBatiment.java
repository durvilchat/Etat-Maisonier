/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "photo_batiment", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PhotoBatiment.findAll", query = "SELECT p FROM PhotoBatiment p"),
        @NamedQuery(name = "PhotoBatiment.findById", query = "SELECT p FROM PhotoBatiment p WHERE p.id = :id"),
        @NamedQuery(name = "PhotoBatiment.findByEtat", query = "SELECT p FROM PhotoBatiment p WHERE p.etat = :etat"),
        @NamedQuery(name = "PhotoBatiment.findByNom", query = "SELECT p FROM PhotoBatiment p WHERE p.nom = :nom")})
public class PhotoBatiment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @JoinColumn(name = "batiment", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Batiment batiment;

    public PhotoBatiment() {
    }

    public PhotoBatiment(Integer id) {
        this.id = id;
    }

    public PhotoBatiment(Integer id, boolean etat, String nom) {
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

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
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
        if (!(object instanceof PhotoBatiment)) {
            return false;
        }
        PhotoBatiment other = (PhotoBatiment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.PhotoBatiment[ id=" + id + " ]";
    }

}
