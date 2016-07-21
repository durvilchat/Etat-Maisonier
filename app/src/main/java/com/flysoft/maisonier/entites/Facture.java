/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

@Table(database = Maisonier.class)
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


}
