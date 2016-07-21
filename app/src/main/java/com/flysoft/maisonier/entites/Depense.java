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
public class Depense extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
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

    @NotNull
    @Column(name = "montant")
    private double montant;
    @JoinColumn(name = "bailleur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bailleur bailleur;
    @JoinColumn(name = "batiment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batiment batiment;
    @JoinColumn(name = "mois", referencedColumnName = "id")
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


}
