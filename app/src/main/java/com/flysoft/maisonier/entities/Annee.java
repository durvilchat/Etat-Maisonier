/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "annee", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"annee"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Annee.findAll", query = "SELECT a FROM Annee a"),
        @NamedQuery(name = "Annee.findById", query = "SELECT a FROM Annee a WHERE a.id = :id"),
        @NamedQuery(name = "Annee.findByAnnee", query = "SELECT a FROM Annee a WHERE a.annee = :annee"),
        @NamedQuery(name = "Annee.findByEtat", query = "SELECT a FROM Annee a WHERE a.etat = :etat"),
        @NamedQuery(name = "Annee.findByStatut", query = "SELECT a FROM Annee a WHERE a.statut = :statut")})
public class Annee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee", nullable = false)
    private int annee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @Size(max = 255)
    @Column(name = "statut", length = 255)
    private String statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annee")
    private List<Mois> moisList;

    public Annee() {
    }

    public Annee(Integer id) {
        this.id = id;
    }

    public Annee(Integer id, int annee, boolean etat) {
        this.id = id;
        this.annee = annee;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @XmlTransient
    public List<Mois> getMoisList() {
        return moisList;
    }

    public void setMoisList(List<Mois> moisList) {
        this.moisList = moisList;
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
        if (!(object instanceof Annee)) {
            return false;
        }
        Annee other = (Annee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Annee[ id=" + id + " ]";
    }

}
