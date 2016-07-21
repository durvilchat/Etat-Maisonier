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

@Table(database = Maisonier.class)

public class Remise extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_attribution")

    private Date dateAttribution;
    @JoinColumn(name = "loyer", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Loyer loyer;
    @JoinColumn(name = "parametre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametre parametre;

    public Remise() {
    }

    public Remise(Integer id) {
        this.id = id;
    }

    public Remise(Integer id, Date dateAttribution) {
        this.id = id;
        this.dateAttribution = dateAttribution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Loyer getLoyer() {
        return loyer;
    }

    public void setLoyer(Loyer loyer) {
        this.loyer = loyer;
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }
}
