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
@Table(name = "type_penalite", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"libelle"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TypePenalite.findAll", query = "SELECT t FROM TypePenalite t"),
        @NamedQuery(name = "TypePenalite.findById", query = "SELECT t FROM TypePenalite t WHERE t.id = :id"),
        @NamedQuery(name = "TypePenalite.findByDelai", query = "SELECT t FROM TypePenalite t WHERE t.delai = :delai"),
        @NamedQuery(name = "TypePenalite.findByEtat", query = "SELECT t FROM TypePenalite t WHERE t.etat = :etat"),
        @NamedQuery(name = "TypePenalite.findByLibelle", query = "SELECT t FROM TypePenalite t WHERE t.libelle = :libelle"),
        @NamedQuery(name = "TypePenalite.findByTaux", query = "SELECT t FROM TypePenalite t WHERE t.taux = :taux")})
public class TypePenalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delai", nullable = false)
    private int delai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", nullable = false, length = 255)
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taux", nullable = false)
    private double taux;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typePenalite")
    private List<Penalite> penaliteList;

    public TypePenalite() {
    }

    public TypePenalite(Integer id) {
        this.id = id;
    }

    public TypePenalite(Integer id, int delai, boolean etat, String libelle, double taux) {
        this.id = id;
        this.delai = delai;
        this.etat = etat;
        this.libelle = libelle;
        this.taux = taux;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
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

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @XmlTransient
    public List<Penalite> getPenaliteList() {
        return penaliteList;
    }

    public void setPenaliteList(List<Penalite> penaliteList) {
        this.penaliteList = penaliteList;
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
        if (!(object instanceof TypePenalite)) {
            return false;
        }
        TypePenalite other = (TypePenalite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.TypePenalite[ id=" + id + " ]";
    }

}
