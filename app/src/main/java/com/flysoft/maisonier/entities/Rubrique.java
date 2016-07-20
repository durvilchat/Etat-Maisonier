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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rubrique", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"article_bail", "numero"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Rubrique.findAll", query = "SELECT r FROM Rubrique r"),
        @NamedQuery(name = "Rubrique.findById", query = "SELECT r FROM Rubrique r WHERE r.id = :id"),
        @NamedQuery(name = "Rubrique.findByEtat", query = "SELECT r FROM Rubrique r WHERE r.etat = :etat"),
        @NamedQuery(name = "Rubrique.findByLibelle", query = "SELECT r FROM Rubrique r WHERE r.libelle = :libelle"),
        @NamedQuery(name = "Rubrique.findByNumero", query = "SELECT r FROM Rubrique r WHERE r.numero = :numero"),
        @NamedQuery(name = "Rubrique.findByValeur", query = "SELECT r FROM Rubrique r WHERE r.valeur = :valeur")})
public class Rubrique implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur", nullable = false)
    private boolean valeur;
    @JoinColumn(name = "article_bail", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ArticleBail articleBail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubrique")
    private List<ContratRubrique> contratRubriqueList;

    public Rubrique() {
    }

    public Rubrique(Integer id) {
        this.id = id;
    }

    public Rubrique(Integer id, boolean etat, String libelle, int numero, boolean valeur) {
        this.id = id;
        this.etat = etat;
        this.libelle = libelle;
        this.numero = numero;
        this.valeur = valeur;
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

    public boolean getValeur() {
        return valeur;
    }

    public void setValeur(boolean valeur) {
        this.valeur = valeur;
    }

    public ArticleBail getArticleBail() {
        return articleBail;
    }

    public void setArticleBail(ArticleBail articleBail) {
        this.articleBail = articleBail;
    }

    @XmlTransient
    public List<ContratRubrique> getContratRubriqueList() {
        return contratRubriqueList;
    }

    public void setContratRubriqueList(List<ContratRubrique> contratRubriqueList) {
        this.contratRubriqueList = contratRubriqueList;
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
        if (!(object instanceof Rubrique)) {
            return false;
        }
        Rubrique other = (Rubrique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Rubrique[ id=" + id + " ]";
    }

}
