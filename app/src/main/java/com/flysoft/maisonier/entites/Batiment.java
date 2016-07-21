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
public class Batiment extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code", length = 255)
    private String code;

    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @JoinColumn(name = "cite", referencedColumnName = "id")
    @ManyToOne
    private Cite cite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batiment")
    private List<Logement> logementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batiment")
    private List<PhotoBatiment> photoBatimentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batiment")
    private List<Depense> depenseList;

    public Batiment() {
    }

    public Batiment(Integer id) {
        this.id = id;
    }

    public Batiment(Integer id, String code, boolean etat) {
        this.id = id;
        this.code = code;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Cite getCite() {
        return cite;
    }

    public void setCite(Cite cite) {
        this.cite = cite;
    }


    public List<Logement> getLogementList() {
        return logementList;
    }

    public void setLogementList(List<Logement> logementList) {
        this.logementList = logementList;
    }


    public List<PhotoBatiment> getPhotoBatimentList() {
        return photoBatimentList;
    }

    public void setPhotoBatimentList(List<PhotoBatiment> photoBatimentList) {
        this.photoBatimentList = photoBatimentList;
    }


    public List<Depense> getDepenseList() {
        return depenseList;
    }

    public void setDepenseList(List<Depense> depenseList) {
        this.depenseList = depenseList;
    }



}
