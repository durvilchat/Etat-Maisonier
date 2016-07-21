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

import java.util.List;

@Table(database = Maisonier.class)
public class TypePenalite extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "delai")
    private int delai;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", length = 255)
    private String libelle;

    @NotNull
    @Column(name = "taux")
    private double taux;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typePenalite")
    private List<Penalite> penaliteList;

    public TypePenalite() {
    }

    public TypePenalite(Integer id) {
        this.id = id;
    }

    public TypePenalite(Integer id, int delai, boolean etat, String libelle, double taux) {
        this.id = id;
        this.delai = delai;
        this.etat = etat;
        this.libelle = libelle;
        this.taux = taux;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }


    public List<Penalite> getPenaliteList() {
        return penaliteList;
    }

    public void setPenaliteList(List<Penalite> penaliteList) {
        this.penaliteList = penaliteList;
    }


}
