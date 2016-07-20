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
@Table(name = "caracteristique_logement", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CaracteristiqueLogement.findAll", query = "SELECT c FROM CaracteristiqueLogement c"),
        @NamedQuery(name = "CaracteristiqueLogement.findById", query = "SELECT c FROM CaracteristiqueLogement c WHERE c.id = :id"),
        @NamedQuery(name = "CaracteristiqueLogement.findByValeur", query = "SELECT c FROM CaracteristiqueLogement c WHERE c.valeur = :valeur")})
public class CaracteristiqueLogement extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "valeur", length = 255)
    private String valeur;
    @JoinColumn(name = "caracteristique", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Caracteristique caracteristique;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;

    public CaracteristiqueLogement() {
    }

    public CaracteristiqueLogement(Integer id) {
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

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
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
        if (!(object instanceof CaracteristiqueLogement)) {
            return false;
        }
        CaracteristiqueLogement other = (CaracteristiqueLogement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.CaracteristiqueLogement[ id=" + id + " ]";
    }

}
