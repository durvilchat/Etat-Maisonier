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

@Table(database = Maisonier.class)
public class Recette extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "depot", precision = 17, scale = 17)
    private Double depot;
    @Column(name = "eau", precision = 17, scale = 17)
    private Double eau;
    @Column(name = "electricite", precision = 17, scale = 17)
    private Double electricite;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mois", length = 255)
    private String mois;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "referenc", length = 255)
    private String referenc;

    public Recette() {
    }

    public Recette(Integer id) {
        this.id = id;
    }

    public Recette(Integer id, String mois, String referenc) {
        this.id = id;
        this.mois = mois;
        this.referenc = referenc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDepot() {
        return depot;
    }

    public void setDepot(Double depot) {
        this.depot = depot;
    }

    public Double getEau() {
        return eau;
    }

    public void setEau(Double eau) {
        this.eau = eau;
    }

    public Double getElectricite() {
        return electricite;
    }

    public void setElectricite(Double electricite) {
        this.electricite = electricite;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getReferenc() {
        return referenc;
    }

    public void setReferenc(String referenc) {
        this.referenc = referenc;
    }



}
