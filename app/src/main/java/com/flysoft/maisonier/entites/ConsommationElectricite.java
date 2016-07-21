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
public class ConsommationElectricite extends BaseModel {


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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_payer", precision = 17, scale = 17)
    private Double montantPayer;

    @NotNull
    @Column(name = "nouveau_index")
    private int nouveauIndex;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @OneToMany(mappedBy = "consommationElectricite")
    private List<ConsommationElectricite> consommationElectriciteList;
    @JoinColumn(name = "consommation_electricite", referencedColumnName = "id")
    @ManyToOne
    private ConsommationElectricite consommationElectricite;
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

    public ConsommationElectricite() {
    }

    public ConsommationElectricite(Integer id) {
        this.id = id;
    }

    public ConsommationElectricite(Integer id, int ancienIndex, int nouveauIndex) {
        this.id = id;
        this.ancienIndex = ancienIndex;
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

    public Double getMontantPayer() {
        return montantPayer;
    }

    public void setMontantPayer(Double montantPayer) {
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


    public List<ConsommationElectricite> getConsommationElectriciteList() {
        return consommationElectriciteList;
    }

    public void setConsommationElectriciteList(List<ConsommationElectricite> consommationElectriciteList) {
        this.consommationElectriciteList = consommationElectriciteList;
    }

    public ConsommationElectricite getConsommationElectricite() {
        return consommationElectricite;
    }

    public void setConsommationElectricite(ConsommationElectricite consommationElectricite) {
        this.consommationElectricite = consommationElectricite;
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
