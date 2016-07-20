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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "contrat_rubrique", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ContratRubrique.findAll", query = "SELECT c FROM ContratRubrique c"),
        @NamedQuery(name = "ContratRubrique.findById", query = "SELECT c FROM ContratRubrique c WHERE c.id = :id"),
        @NamedQuery(name = "ContratRubrique.findByValeur", query = "SELECT c FROM ContratRubrique c WHERE c.valeur = :valeur")})
public class ContratRubrique extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "valeur", length = 255)
    private String valeur;
    @JoinColumn(name = "contrat_bail", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContratBail contratBail;
    @JoinColumn(name = "rubrique", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rubrique rubrique;

    public ContratRubrique() {
    }

    public ContratRubrique(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public ContratBail getContratBail() {
        return contratBail;
    }

    public void setContratBail(ContratBail contratBail) {
        this.contratBail = contratBail;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
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
        if (!(object instanceof ContratRubrique)) {
            return false;
        }
        ContratRubrique other = (ContratRubrique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.ContratRubrique[ id=" + id + " ]";
    }

}
