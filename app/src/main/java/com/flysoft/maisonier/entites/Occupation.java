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
public class Occupation extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_entree")

    private Date dateEntree;
    @Column(name = "date_sortie")

    private Date dateSortie;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Column(name = "forfait_eau")
    private Boolean forfaitEau;
    @Column(name = "forfait_electricte")
    private Boolean forfaitElectricte;

    @NotNull
    @Column(name = "loyer_base")
    private double loyerBase;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mode_paiement", length = 255)
    private String modePaiement;

    @NotNull
    @Column(name = "paie_cable")
    private boolean paieCable;

    @NotNull
    @Column(name = "paie_eau")
    private boolean paieEau;

    @NotNull
    @Column(name = "paie_electricite")
    private boolean paieElectricite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Penalite> penaliteList;
    @JoinColumn(name = "habitant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Habitant habitant;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Depot> depotList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Cable> cableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Loyer> loyerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Caution> cautionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Charge> chargeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<ContratBail> contratBailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<Compte> compteList;

    public Occupation() {
    }

    public Occupation(Integer id) {
        this.id = id;
    }

    public Occupation(Integer id, Date dateEntree, boolean etat, double loyerBase, String modePaiement, boolean paieCable, boolean paieEau, boolean paieElectricite) {
        this.id = id;
        this.dateEntree = dateEntree;
        this.etat = etat;
        this.loyerBase = loyerBase;
        this.modePaiement = modePaiement;
        this.paieCable = paieCable;
        this.paieEau = paieEau;
        this.paieElectricite = paieElectricite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Boolean getForfaitEau() {
        return forfaitEau;
    }

    public void setForfaitEau(Boolean forfaitEau) {
        this.forfaitEau = forfaitEau;
    }

    public Boolean getForfaitElectricte() {
        return forfaitElectricte;
    }

    public void setForfaitElectricte(Boolean forfaitElectricte) {
        this.forfaitElectricte = forfaitElectricte;
    }

    public double getLoyerBase() {
        return loyerBase;
    }

    public void setLoyerBase(double loyerBase) {
        this.loyerBase = loyerBase;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public boolean getPaieCable() {
        return paieCable;
    }

    public void setPaieCable(boolean paieCable) {
        this.paieCable = paieCable;
    }

    public boolean getPaieEau() {
        return paieEau;
    }

    public void setPaieEau(boolean paieEau) {
        this.paieEau = paieEau;
    }

    public boolean getPaieElectricite() {
        return paieElectricite;
    }

    public void setPaieElectricite(boolean paieElectricite) {
        this.paieElectricite = paieElectricite;
    }


    public List<Penalite> getPenaliteList() {
        return penaliteList;
    }

    public void setPenaliteList(List<Penalite> penaliteList) {
        this.penaliteList = penaliteList;
    }

    public Habitant getHabitant() {
        return habitant;
    }

    public void setHabitant(Habitant habitant) {
        this.habitant = habitant;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }


    public List<Depot> getDepotList() {
        return depotList;
    }

    public void setDepotList(List<Depot> depotList) {
        this.depotList = depotList;
    }


    public List<Cable> getCableList() {
        return cableList;
    }

    public void setCableList(List<Cable> cableList) {
        this.cableList = cableList;
    }


    public List<Loyer> getLoyerList() {
        return loyerList;
    }

    public void setLoyerList(List<Loyer> loyerList) {
        this.loyerList = loyerList;
    }


    public List<Caution> getCautionList() {
        return cautionList;
    }

    public void setCautionList(List<Caution> cautionList) {
        this.cautionList = cautionList;
    }


    public List<Charge> getChargeList() {
        return chargeList;
    }

    public void setChargeList(List<Charge> chargeList) {
        this.chargeList = chargeList;
    }


    public List<ContratBail> getContratBailList() {
        return contratBailList;
    }

    public void setContratBailList(List<ContratBail> contratBailList) {
        this.contratBailList = contratBailList;
    }


    public List<Compte> getCompteList() {
        return compteList;
    }

    public void setCompteList(List<Compte> compteList) {
        this.compteList = compteList;
    }

}
