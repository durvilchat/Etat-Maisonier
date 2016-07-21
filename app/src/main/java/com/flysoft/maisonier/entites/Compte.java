/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Table;

import java.util.Date;

@Table(database = Maisonier.class)
public class Compte extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateoperaion")

    private Date dateoperaion;

    @NotNull
    @Column(name = "solde")
    private double solde;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;
    @JoinColumn(name = "type_compte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeCompte typeCompte;

    public Compte() {
    }

    public Compte(Integer id) {
        this.id = id;
    }

    public Compte(Integer id, double solde) {
        this.id = id;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateoperaion() {
        return dateoperaion;
    }

    public void setDateoperaion(Date dateoperaion) {
        this.dateoperaion = dateoperaion;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }



}
