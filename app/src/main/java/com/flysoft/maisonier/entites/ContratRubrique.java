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
public class ContratRubrique extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "valeur", length = 255)
    private String valeur;
    @JoinColumn(name = "contrat_bail", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContratBail contratBail;
    @JoinColumn(name = "rubrique", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rubrique rubrique;

    public ContratRubrique() {
    }

    public ContratRubrique(Integer id) {
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

    public ContratBail getContratBail() {
        return contratBail;
    }

    public void setContratBail(ContratBail contratBail) {
        this.contratBail = contratBail;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

}
