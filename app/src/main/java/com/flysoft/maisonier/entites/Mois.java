/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = Maisonier.class)
public class Mois extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "mois", length = 255)
    private String mois;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<Penalite> penaliteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<Depot> depotList;
    @OneToMany(mappedBy = "mois")
    private List<Facture> factureList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<Cable> cableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<Loyer> loyerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<ConsommationEau> consommationEauList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<ConsommationElectricite> consommationElectriciteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<Charge> chargeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mois")
    private List<Depense> depenseList;
    @JoinColumn(name = "annee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Annee annee;

    public Mois() {
    }

    public Mois(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }


    public List<Penalite> getPenaliteList() {
        return penaliteList;
    }

    public void setPenaliteList(List<Penalite> penaliteList) {
        this.penaliteList = penaliteList;
    }


    public List<Depot> getDepotList() {
        return depotList;
    }

    public void setDepotList(List<Depot> depotList) {
        this.depotList = depotList;
    }


    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
    }


    public List<Cable> getCableList() {
        return cableList;
    }

    public void setCableList(List<Cable> cableList) {
        this.cableList = cableList;
    }


    public List<Loyer> getLoyerList() {
        return loyerList;
    }

    public void setLoyerList(List<Loyer> loyerList) {
        this.loyerList = loyerList;
    }


    public List<ConsommationEau> getConsommationEauList() {
        return consommationEauList;
    }

    public void setConsommationEauList(List<ConsommationEau> consommationEauList) {
        this.consommationEauList = consommationEauList;
    }


    public List<ConsommationElectricite> getConsommationElectriciteList() {
        return consommationElectriciteList;
    }

    public void setConsommationElectriciteList(List<ConsommationElectricite> consommationElectriciteList) {
        this.consommationElectriciteList = consommationElectriciteList;
    }


    public List<Charge> getChargeList() {
        return chargeList;
    }

    public void setChargeList(List<Charge> chargeList) {
        this.chargeList = chargeList;
    }


    public List<Depense> getDepenseList() {
        return depenseList;
    }

    public void setDepenseList(List<Depense> depenseList) {
        this.depenseList = depenseList;
    }

    public Annee getAnnee() {
        return annee;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

}
