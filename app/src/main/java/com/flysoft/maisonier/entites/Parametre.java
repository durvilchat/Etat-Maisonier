/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

@Table(database = Maisonier.class)
public class Parametre extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "cablage")
    private double cablage;

    @NotNull
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @NotNull
    @Column(name = "entretient_eau")
    private double entretientEau;

    @NotNull
    @Column(name = "entretient_electricite")
    private double entretientElectricite;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Column(name = "prix_unitaire_eau")
    private double prixUnitaireEau;

    @NotNull
    @Column(name = "prix_unitaire_electricite")
    private double prixUnitaireElectricite;
    @Size(max = 255)
    @Column(name = "repertoire_photo_batiment", length = 255)
    private String repertoirePhotoBatiment;
    @Size(max = 255)
    @Column(name = "repertoire_photo_habitant", length = 255)
    private String repertoirePhotoHabitant;
    @Size(max = 255)
    @Column(name = "repertoire_photo_logement", length = 255)
    private String repertoirePhotoLogement;
    @Size(max = 255)
    @Column(name = "repertoire_photo_personnel", length = 255)
    private String repertoirePhotoPersonnel;

    @NotNull
    @Column(name = "t_v_a")
    private double tVA;

    @NotNull
    @Column(name = "taux_remise")
    private double tauxRemise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametre")
    private List<Cable> cableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametre")
    private List<ConsommationEau> consommationEauList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametre")
    private List<ConsommationElectricite> consommationElectriciteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametre")
    private List<Remise> remiseList;

    public Parametre() {
    }

    public Parametre(Integer id) {
        this.id = id;
    }

    public Parametre(Integer id, double cablage, Date dateEnregistrement, double entretientEau, double entretientElectricite, boolean etat, double prixUnitaireEau, double prixUnitaireElectricite, double tVA, double tauxRemise) {
        this.id = id;
        this.cablage = cablage;
        this.dateEnregistrement = dateEnregistrement;
        this.entretientEau = entretientEau;
        this.entretientElectricite = entretientElectricite;
        this.etat = etat;
        this.prixUnitaireEau = prixUnitaireEau;
        this.prixUnitaireElectricite = prixUnitaireElectricite;
        this.tVA = tVA;
        this.tauxRemise = tauxRemise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCablage() {
        return cablage;
    }

    public void setCablage(double cablage) {
        this.cablage = cablage;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public double getEntretientEau() {
        return entretientEau;
    }

    public void setEntretientEau(double entretientEau) {
        this.entretientEau = entretientEau;
    }

    public double getEntretientElectricite() {
        return entretientElectricite;
    }

    public void setEntretientElectricite(double entretientElectricite) {
        this.entretientElectricite = entretientElectricite;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public double getPrixUnitaireEau() {
        return prixUnitaireEau;
    }

    public void setPrixUnitaireEau(double prixUnitaireEau) {
        this.prixUnitaireEau = prixUnitaireEau;
    }

    public double getPrixUnitaireElectricite() {
        return prixUnitaireElectricite;
    }

    public void setPrixUnitaireElectricite(double prixUnitaireElectricite) {
        this.prixUnitaireElectricite = prixUnitaireElectricite;
    }

    public String getRepertoirePhotoBatiment() {
        return repertoirePhotoBatiment;
    }

    public void setRepertoirePhotoBatiment(String repertoirePhotoBatiment) {
        this.repertoirePhotoBatiment = repertoirePhotoBatiment;
    }

    public String getRepertoirePhotoHabitant() {
        return repertoirePhotoHabitant;
    }

    public void setRepertoirePhotoHabitant(String repertoirePhotoHabitant) {
        this.repertoirePhotoHabitant = repertoirePhotoHabitant;
    }

    public String getRepertoirePhotoLogement() {
        return repertoirePhotoLogement;
    }

    public void setRepertoirePhotoLogement(String repertoirePhotoLogement) {
        this.repertoirePhotoLogement = repertoirePhotoLogement;
    }

    public String getRepertoirePhotoPersonnel() {
        return repertoirePhotoPersonnel;
    }

    public void setRepertoirePhotoPersonnel(String repertoirePhotoPersonnel) {
        this.repertoirePhotoPersonnel = repertoirePhotoPersonnel;
    }

    public double getTVA() {
        return tVA;
    }

    public void setTVA(double tVA) {
        this.tVA = tVA;
    }

    public double getTauxRemise() {
        return tauxRemise;
    }

    public void setTauxRemise(double tauxRemise) {
        this.tauxRemise = tauxRemise;
    }


    public List<Cable> getCableList() {
        return cableList;
    }

    public void setCableList(List<Cable> cableList) {
        this.cableList = cableList;
    }


    public List<ConsommationEau> getConsommationEauList() {
        return consommationEauList;
    }

    public void setConsommationEauList(List<ConsommationEau> consommationEauList) {
        this.consommationEauList = consommationEauList;
    }


    public List<ConsommationElectricite> getConsommationElectriciteList() {
        return consommationElectriciteList;
    }

    public void setConsommationElectriciteList(List<ConsommationElectricite> consommationElectriciteList) {
        this.consommationElectriciteList = consommationElectriciteList;
    }


    public List<Remise> getRemiseList() {
        return remiseList;
    }

    public void setRemiseList(List<Remise> remiseList) {
        this.remiseList = remiseList;
    }


}
