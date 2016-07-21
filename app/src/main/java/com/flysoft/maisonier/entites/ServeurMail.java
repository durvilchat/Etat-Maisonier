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
public class ServeurMail extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "hote", length = 255)
    private String hote;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serveurMail")
    private List<AdresseMail> adresseMailList;

    public ServeurMail() {
    }

    public ServeurMail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHote() {
        return hote;
    }

    public void setHote(String hote) {
        this.hote = hote;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public List<AdresseMail> getAdresseMailList() {
        return adresseMailList;
    }

    public void setAdresseMailList(List<AdresseMail> adresseMailList) {
        this.adresseMailList = adresseMailList;
    }
}
