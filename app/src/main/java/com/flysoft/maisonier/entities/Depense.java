/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "depense", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Depense.findAll", query = "SELECT d FROM Depense d"),
        @NamedQuery(name = "Depense.findById", query = "SELECT d FROM Depense d WHERE d.id = :id"),
        @NamedQuery(name = "Depense.findByDateEnregistrement", query = "SELECT d FROM Depense d WHERE d.dateEnregistrement = :dateEnregistrement"),
        @NamedQuery(name = "Depense.findByDescription", query = "SELECT d FROM Depense d WHERE d.description = :description"),
        @NamedQuery(name = "Depense.findByDesignation", query = "SELECT d FROM Depense d WHERE d.designation = :designation"),
        @NamedQuery(name = "Depense.findByMontant", query = "SELECT d FROM Depense d WHERE d.montant = :montant")})
public class Depense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;
    @Size(max = 255)
    @Column(name = "designation", length = 255)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant", nullable = false)
    private double montant;
    @JoinColumn(name = "bailleur", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Bailleur bailleur;
    @JoinColumn(name = "batiment", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Batiment batiment;
    @JoinColumn(name = "mois", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Mois mois;

    public Depense() {
    }

    public Depense(Integer id) {
        this.id = id;
    }

    public Depense(Integer id, double montant) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
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
        if (!(object instanceof Depense)) {
            return false;
        }
        Depense other = (Depense) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Depense[ id=" + id + " ]";
    }

}
