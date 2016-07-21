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

@Table(database = Maisonier.class)
public class Caution extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_depot")

    private Date dateDepot;

    @NotNull
    @Column(name = "montant")
    private double montant;

    @NotNull
    @Column(name = "montant_rembourse")
    private double montantRembourse;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "statut", length = 255)
    private String statut;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;
    @JoinColumn(name = "type_caution", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeCaution typeCaution;

    public Caution() {
    }

    public Caution(Integer id) {
        this.id = id;
    }

    public Caution(Integer id, Date dateDepot, double montant, double montantRembourse, String statut) {
        this.id = id;
        this.dateDepot = dateDepot;
        this.montant = montant;
        this.montantRembourse = montantRembourse;
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantRembourse() {
        return montantRembourse;
    }

    public void setMontantRembourse(double montantRembourse) {
        this.montantRembourse = montantRembourse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public TypeCaution getTypeCaution() {
        return typeCaution;
    }

    public void setTypeCaution(TypeCaution typeCaution) {
        this.typeCaution = typeCaution;
    }


}
