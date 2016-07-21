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
public class Depot extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "compensation")
    private boolean compensation;

    @NotNull
    @Column(name = "date_depot")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant", precision = 17, scale = 17)
    private Double montant;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @JoinColumn(name = "mois", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mois mois;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;

    public Depot() {
    }

    public Depot(Integer id) {
        this.id = id;
    }

    public Depot(Integer id, boolean compensation, Date dateDepot) {
        this.id = id;
        this.compensation = compensation;
        this.dateDepot = dateDepot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getCompensation() {
        return compensation;
    }

    public void setCompensation(boolean compensation) {
        this.compensation = compensation;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

}
