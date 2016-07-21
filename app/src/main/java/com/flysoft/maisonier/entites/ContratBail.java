/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

@Table(database = Maisonier.class)
public class ContratBail extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_etablissement")

    private Date dateEtablissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratBail")
    private List<ContratRubrique> contratRubriqueList;
    @JoinColumn(name = "bailleur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bailleur bailleur;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;

    public ContratBail() {
    }

    public ContratBail(Integer id) {
        this.id = id;
    }

    public ContratBail(Integer id, Date dateEtablissement) {
        this.id = id;
        this.dateEtablissement = dateEtablissement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }


    public List<ContratRubrique> getContratRubriqueList() {
        return contratRubriqueList;
    }

    public void setContratRubriqueList(List<ContratRubrique> contratRubriqueList) {
        this.contratRubriqueList = contratRubriqueList;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

}
