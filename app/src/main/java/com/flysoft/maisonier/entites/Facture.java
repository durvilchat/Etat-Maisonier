/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "facture", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"habitant", "mois"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
        @NamedQuery(name = "Facture.findById", query = "SELECT f FROM Facture f WHERE f.id = :id"),
        @NamedQuery(name = "Facture.findByDateEnregistrement", query = "SELECT f FROM Facture f WHERE f.dateEnregistrement = :dateEnregistrement"),
        @NamedQuery(name = "Facture.findByMontant", query = "SELECT f FROM Facture f WHERE f.montant = :montant"),
        @NamedQuery(name = "Facture.findByObservation", query = "SELECT f FROM Facture f WHERE f.observation = :observation")})
public class Facture extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;

    @NotNull
    @Column(name = "montant")
    private double montant;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @JoinColumn(name = "habitant", referencedColumnName = "id")
    @ManyToOne
    private Habitant habitant;
    @JoinColumn(name = "mois", referencedColumnName = "id")
    @ManyToOne
    private Mois mois;

    public Facture() {
    }

    public Facture(Integer id) {
        this.id = id;
    }

    public Facture(Integer id, Date dateEnregistrement, double montant) {
        this.id = id;
        this.dateEnregistrement = dateEnregistrement;
        this.montant = montant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Habitant getHabitant() {
        return habitant;
    }

    public void setHabitant(Habitant habitant) {
        this.habitant = habitant;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Facture[ id=" + id + " ]";
    }

}
