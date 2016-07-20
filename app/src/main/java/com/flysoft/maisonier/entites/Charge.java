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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "charge", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Charge.findAll", query = "SELECT c FROM Charge c"),
        @NamedQuery(name = "Charge.findById", query = "SELECT c FROM Charge c WHERE c.id = :id"),
        @NamedQuery(name = "Charge.findByDatePaiement", query = "SELECT c FROM Charge c WHERE c.datePaiement = :datePaiement"),
        @NamedQuery(name = "Charge.findByDesignation", query = "SELECT c FROM Charge c WHERE c.designation = :designation"),
        @NamedQuery(name = "Charge.findByMontant", query = "SELECT c FROM Charge c WHERE c.montant = :montant"),
        @NamedQuery(name = "Charge.findByMontantPayer", query = "SELECT c FROM Charge c WHERE c.montantPayer = :montantPayer"),
        @NamedQuery(name = "Charge.findByObservation", query = "SELECT c FROM Charge c WHERE c.observation = :observation")})
public class Charge extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "designation", length = 255)
    private String designation;

    @NotNull
    @Column(name = "montant")
    private double montant;

    @NotNull
    @Column(name = "montant_payer")
    private double montantPayer;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @JoinColumn(name = "mois", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mois mois;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;
    @JoinColumn(name = "type_charge", referencedColumnName = "id")
    @ManyToOne
    private TypeCharge typeCharge;

    public Charge() {
    }

    public Charge(Integer id) {
        this.id = id;
    }

    public Charge(Integer id, String designation, double montant, double montantPayer) {
        this.id = id;
        this.designation = designation;
        this.montant = montant;
        this.montantPayer = montantPayer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
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

    public double getMontantPayer() {
        return montantPayer;
    }

    public void setMontantPayer(double montantPayer) {
        this.montantPayer = montantPayer;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public TypeCharge getTypeCharge() {
        return typeCharge;
    }

    public void setTypeCharge(TypeCharge typeCharge) {
        this.typeCharge = typeCharge;
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
        if (!(object instanceof Charge)) {
            return false;
        }
        Charge other = (Charge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Charge[ id=" + id + " ]";
    }

}
