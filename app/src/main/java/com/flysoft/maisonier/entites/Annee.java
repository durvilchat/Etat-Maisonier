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

import java.util.List;

@Table(database = Maisonier.class)
public class Annee extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "annee")
    private int annee;

    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Size(max = 255)
    @Column(name = "statut", length = 255)
    private String statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annee")
    private List<Mois> moisList;

    public Annee() {
    }

    public Annee(Integer id) {
        this.id = id;
    }

    public Annee(Integer id, int annee, boolean etat) {
        this.id = id;
        this.annee = annee;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    public List<Mois> getMoisList() {
        return moisList;
    }

    public void setMoisList(List<Mois> moisList) {
        this.moisList = moisList;
    }


}
