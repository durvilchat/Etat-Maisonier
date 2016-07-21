/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = Maisonier.class)
public class CaracteristiqueLogement extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "valeur", length = 255)
    private String valeur;
    @JoinColumn(name = "caracteristique", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Caracteristique caracteristique;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;

    public CaracteristiqueLogement() {
    }

    public CaracteristiqueLogement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }


}
