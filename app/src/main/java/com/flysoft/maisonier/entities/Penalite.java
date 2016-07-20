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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "penalite", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"type_penalite", "occupation", "mois"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Penalite.findAll", query = "SELECT p FROM Penalite p"),
        @NamedQuery(name = "Penalite.findById", query = "SELECT p FROM Penalite p WHERE p.id = :id"),
        @NamedQuery(name = "Penalite.findByDatePaiement", query = "SELECT p FROM Penalite p WHERE p.datePaiement = :datePaiement"),
        @NamedQuery(name = "Penalite.findByEtat", query = "SELECT p FROM Penalite p WHERE p.etat = :etat"),
        @NamedQuery(name = "Penalite.findByMontant", query = "SELECT p FROM Penalite p WHERE p.montant = :montant"),
        @NamedQuery(name = "Penalite.findByMontantPayer", query = "SELECT p FROM Penalite p WHERE p.montantPayer = :montantPayer"),
        @NamedQuery(name = "Penalite.findByObservation", query = "SELECT p FROM Penalite p WHERE p.observation = :observation")})
public class Penalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_paiement", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant", nullable = false)
    private double montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_payer", nullable = false)
    private double montantPayer;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @JoinColumn(name = "mois", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Mois mois;
    @JoinColumn(name = "occupation", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Occupation occupation;
    @JoinColumn(name = "type_penalite", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TypePenalite typePenalite;

    public Penalite() {
    }

    public Penalite(Integer id) {
        this.id = id;
    }

    public Penalite(Integer id, Date datePaiement, boolean etat, double montant, double montantPayer) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.etat = etat;
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

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
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

    public TypePenalite getTypePenalite() {
        return typePenalite;
    }

    public void setTypePenalite(TypePenalite typePenalite) {
        this.typePenalite = typePenalite;
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
        if (!(object instanceof Penalite)) {
            return false;
        }
        Penalite other = (Penalite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Penalite[ id=" + id + " ]";
    }

}
