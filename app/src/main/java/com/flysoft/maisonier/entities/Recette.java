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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "recette", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r"),
        @NamedQuery(name = "Recette.findById", query = "SELECT r FROM Recette r WHERE r.id = :id"),
        @NamedQuery(name = "Recette.findByDepot", query = "SELECT r FROM Recette r WHERE r.depot = :depot"),
        @NamedQuery(name = "Recette.findByEau", query = "SELECT r FROM Recette r WHERE r.eau = :eau"),
        @NamedQuery(name = "Recette.findByElectricite", query = "SELECT r FROM Recette r WHERE r.electricite = :electricite"),
        @NamedQuery(name = "Recette.findByMois", query = "SELECT r FROM Recette r WHERE r.mois = :mois"),
        @NamedQuery(name = "Recette.findByReferenc", query = "SELECT r FROM Recette r WHERE r.referenc = :referenc")})
public class Recette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "depot", precision = 17, scale = 17)
    private Double depot;
    @Column(name = "eau", precision = 17, scale = 17)
    private Double eau;
    @Column(name = "electricite", precision = 17, scale = 17)
    private Double electricite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mois", nullable = false, length = 255)
    private String mois;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "referenc", nullable = false, length = 255)
    private String referenc;

    public Recette() {
    }

    public Recette(Integer id) {
        this.id = id;
    }

    public Recette(Integer id, String mois, String referenc) {
        this.id = id;
        this.mois = mois;
        this.referenc = referenc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDepot() {
        return depot;
    }

    public void setDepot(Double depot) {
        this.depot = depot;
    }

    public Double getEau() {
        return eau;
    }

    public void setEau(Double eau) {
        this.eau = eau;
    }

    public Double getElectricite() {
        return electricite;
    }

    public void setElectricite(Double electricite) {
        this.electricite = electricite;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getReferenc() {
        return referenc;
    }

    public void setReferenc(String referenc) {
        this.referenc = referenc;
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
        if (!(object instanceof Recette)) {
            return false;
        }
        Recette other = (Recette) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Recette[ id=" + id + " ]";
    }

}
