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
@Table(name = "article_bail", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"numero"}),
        @UniqueConstraint(columnNames = {"libelle"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ArticleBail.findAll", query = "SELECT a FROM ArticleBail a"),
        @NamedQuery(name = "ArticleBail.findById", query = "SELECT a FROM ArticleBail a WHERE a.id = :id"),
        @NamedQuery(name = "ArticleBail.findByEtat", query = "SELECT a FROM ArticleBail a WHERE a.etat = :etat"),
        @NamedQuery(name = "ArticleBail.findByLibelle", query = "SELECT a FROM ArticleBail a WHERE a.libelle = :libelle"),
        @NamedQuery(name = "ArticleBail.findByNumero", query = "SELECT a FROM ArticleBail a WHERE a.numero = :numero")})
public class ArticleBail implements Serializable {

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
    @Column(name = "libelle", nullable = false, length = 255)
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero", nullable = false)
    private int numero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleBail")
    private List<Rubrique> rubriqueList;

    public ArticleBail() {
    }

    public ArticleBail(Integer id) {
        this.id = id;
    }

    public ArticleBail(Integer id, boolean etat, String libelle, int numero) {
        this.id = id;
        this.etat = etat;
        this.libelle = libelle;
        this.numero = numero;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<Rubrique> getRubriqueList() {
        return rubriqueList;
    }

    public void setRubriqueList(List<Rubrique> rubriqueList) {
        this.rubriqueList = rubriqueList;
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
        if (!(object instanceof ArticleBail)) {
            return false;
        }
        ArticleBail other = (ArticleBail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.ArticleBail[ id=" + id + " ]";
    }

}
