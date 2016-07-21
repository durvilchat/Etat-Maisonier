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
public class PhotoLogement extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;

    public PhotoLogement() {
    }

    public PhotoLogement(Integer id) {
        this.id = id;
    }

    public PhotoLogement(Integer id, boolean etat, String nom) {
        this.id = id;
        this.etat = etat;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

}
