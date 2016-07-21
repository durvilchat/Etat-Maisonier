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
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

@Table(database = Maisonier.class)
public class ConsommationEau extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "ancien_index")
    private int ancienIndex;
    @Column(name = "date_paiement")

    private Date datePaiement;
    @Column(name = "date_releve")

    private Date dateReleve;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "montant_payer")
    private double montantPayer;

    @NotNull
    @Column(name = "nouveau_index")
    private int nouveauIndex;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @OneToMany(mappedBy = "consommationEau")
    private List<ConsommationEau> consommationEauList;
    @JoinColumn(name = "consommation_eau", referencedColumnName = "id")
    @ManyToOne
    private ConsommationEau consommationEau;
    @JoinColumn(name = "habitant", referencedColumnName = "id")
    @ManyToOne
    private Habitant habitant;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;
    @JoinColumn(name = "mois", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mois mois;
    @JoinColumn(name = "parametre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametre parametre;

    public ConsommationEau() {
    }

    public ConsommationEau(Integer id) {
        this.id = id;
    }

    public ConsommationEau(Integer id, int ancienIndex, double montantPayer, int nouveauIndex) {
        this.id = id;
        this.ancienIndex = ancienIndex;
        this.montantPayer = montantPayer;
        this.nouveauIndex = nouveauIndex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAncienIndex() {
        return ancienIndex;
    }

    public void setAncienIndex(int ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Date getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(Date dateReleve) {
        this.dateReleve = dateReleve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontantPayer() {
        return montantPayer;
    }

    public void setMontantPayer(double montantPayer) {
        this.montantPayer = montantPayer;
    }

    public int getNouveauIndex() {
        return nouveauIndex;
    }

    public void setNouveauIndex(int nouveauIndex) {
        this.nouveauIndex = nouveauIndex;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }


    public List<ConsommationEau> getConsommationEauList() {
        return consommationEauList;
    }

    public void setConsommationEauList(List<ConsommationEau> consommationEauList) {
        this.consommationEauList = consommationEauList;
    }

    public ConsommationEau getConsommationEau() {
        return consommationEau;
    }

    public void setConsommationEau(ConsommationEau consommationEau) {
        this.consommationEau = consommationEau;
    }

    public Habitant getHabitant() {
        return habitant;
    }

    public void setHabitant(Habitant habitant) {
        this.habitant = habitant;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }


}
