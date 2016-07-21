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

import java.util.Date;
import java.util.List;

@Table(database = Maisonier.class)
public class Habitant extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_delivraison_cni")

    private Date dateDelivraisonCni;
    @Column(name = "date_naissance")

    private Date dateNaissance;
    @Size(max = 255)
    @Column(name = "email1", length = 255)
    private String email1;
    @Size(max = 255)
    @Column(name = "email2", length = 255)
    private String email2;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "genre", length = 255)
    private String genre;
    @Size(max = 255)
    @Column(name = "lieu_delivraison_cni", length = 255)
    private String lieuDelivraisonCni;
    @Size(max = 255)
    @Column(name = "lieu_naissance", length = 255)
    private String lieuNaissance;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @Size(max = 255)
    @Column(name = "nom_de_la_mere", length = 255)
    private String nomDeLaMere;
    @Size(max = 255)
    @Column(name = "nom_du_pere", length = 255)
    private String nomDuPere;
    @Size(max = 255)
    @Column(name = "numero_c_n_i", length = 255)
    private String numeroCNI;
    @Size(max = 255)
    @Column(name = "photo", length = 255)
    private String photo;
    @Size(max = 255)
    @Column(name = "prenom", length = 255)
    private String prenom;
    @Size(max = 255)
    @Column(name = "profession", length = 255)
    private String profession;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tel1", length = 255)
    private String tel1;
    @Size(max = 255)
    @Column(name = "tel2", length = 255)
    private String tel2;
    @Size(max = 255)
    @Column(name = "tel3", length = 255)
    private String tel3;
    @Size(max = 255)
    @Column(name = "tel4", length = 255)
    private String tel4;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titre", length = 255)
    private String titre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitant")
    private List<Occupation> occupationList;
    @OneToMany(mappedBy = "habitant")
    private List<Facture> factureList;
    @OneToMany(mappedBy = "habitant")
    private List<ConsommationEau> consommationEauList;
    @OneToMany(mappedBy = "habitant")
    private List<ConsommationElectricite> consommationElectriciteList;

    public Habitant() {
    }

    public Habitant(Integer id) {
        this.id = id;
    }

    public Habitant(Integer id, String genre, String nom, String tel1, String titre) {
        this.id = id;
        this.genre = genre;
        this.nom = nom;
        this.tel1 = tel1;
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDelivraisonCni() {
        return dateDelivraisonCni;
    }

    public void setDateDelivraisonCni(Date dateDelivraisonCni) {
        this.dateDelivraisonCni = dateDelivraisonCni;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLieuDelivraisonCni() {
        return lieuDelivraisonCni;
    }

    public void setLieuDelivraisonCni(String lieuDelivraisonCni) {
        this.lieuDelivraisonCni = lieuDelivraisonCni;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDeLaMere() {
        return nomDeLaMere;
    }

    public void setNomDeLaMere(String nomDeLaMere) {
        this.nomDeLaMere = nomDeLaMere;
    }

    public String getNomDuPere() {
        return nomDuPere;
    }

    public void setNomDuPere(String nomDuPere) {
        this.nomDuPere = nomDuPere;
    }

    public String getNumeroCNI() {
        return numeroCNI;
    }

    public void setNumeroCNI(String numeroCNI) {
        this.numeroCNI = numeroCNI;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public String getTel4() {
        return tel4;
    }

    public void setTel4(String tel4) {
        this.tel4 = tel4;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }


    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
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

}
