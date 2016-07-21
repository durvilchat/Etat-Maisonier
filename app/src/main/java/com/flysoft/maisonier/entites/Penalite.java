/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

@Table(database = Maisonier.class)
public class Penalite extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_paiement")

    private Date datePaiement;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

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
    @JoinColumn(name = "type_penalite", referencedColumnName = "id")
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

}
