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
public class Caracteristique extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", length = 255)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristique")
    private List<CaracteristiqueLogement> caracteristiqueLogementList;

    public Caracteristique() {
    }

    public Caracteristique(Integer id) {
        this.id = id;
    }

    public Caracteristique(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public List<CaracteristiqueLogement> getCaracteristiqueLogementList() {
        return caracteristiqueLogementList;
    }

    public void setCaracteristiqueLogementList(List<CaracteristiqueLogement> caracteristiqueLogementList) {
        this.caracteristiqueLogementList = caracteristiqueLogementList;
    }


}
