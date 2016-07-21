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
public class ArticleBail extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", length = 255)
    private String libelle;

    @NotNull
    @Column(name = "numero")
    private int numero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleBail")
    private List<Rubrique> rubriqueList;

    public ArticleBail() {
    }

    public ArticleBail(Integer id) {
        this.id = id;
    }

    public ArticleBail(Integer id, boolean etat, String libelle, int numero) {
        this.id = id;
        this.etat = etat;
        this.libelle = libelle;
        this.numero = numero;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public List<Rubrique> getRubriqueList() {
        return rubriqueList;
    }

    public void setRubriqueList(List<Rubrique> rubriqueList) {
        this.rubriqueList = rubriqueList;
    }


}
