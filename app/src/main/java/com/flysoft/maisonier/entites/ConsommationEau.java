/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "consommation_eau", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ConsommationEau.findAll", query = "SELECT c FROM ConsommationEau c"),
        @NamedQuery(name = "ConsommationEau.findById", query = "SELECT c FROM ConsommationEau c WHERE c.id = :id"),
        @NamedQuery(name = "ConsommationEau.findByAncienIndex", query = "SELECT c FROM ConsommationEau c WHERE c.ancienIndex = :ancienIndex"),
        @NamedQuery(name = "ConsommationEau.findByDatePaiement", query = "SELECT c FROM ConsommationEau c WHERE c.datePaiement = :datePaiement"),
        @NamedQuery(name = "ConsommationEau.findByDateReleve", query = "SELECT c FROM ConsommationEau c WHERE c.dateReleve = :dateReleve"),
        @NamedQuery(name = "ConsommationEau.findByDescription", query = "SELECT c FROM ConsommationEau c WHERE c.description = :description"),
        @NamedQuery(name = "ConsommationEau.findByMontantPayer", query = "SELECT c FROM ConsommationEau c WHERE c.montantPayer = :montantPayer"),
        @NamedQuery(name = "ConsommationEau.findByNouveauIndex", query = "SELECT c FROM ConsommationEau c WHERE c.nouveauIndex = :nouveauIndex"),
        @NamedQuery(name = "ConsommationEau.findByObservation", query = "SELECT c FROM ConsommationEau c WHERE c.observation = :observation")})
public class ConsommationEau extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "ancien_index")
    private int ancienIndex;
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Column(name = "date_releve")
    @Temporal(TemporalType.DATE)
    private Date dateReleve;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "montant_payer")
    private double montantPayer;

    @NotNull
    @Column(name = "nouveau_index")
    private int nouveauIndex;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @OneToMany(mappedBy = "consommationEau")
    private List<ConsommationEau> consommationEauList;
    @JoinColumn(name = "consommation_eau", referencedColumnName = "id")
    @ManyToOne
    private ConsommationEau consommationEau;
    @JoinColumn(name = "habitant", referencedColumnName = "id")
    @ManyToOne
    private Habitant habitant;
    @JoinColumn(name = "logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logement logement;
    @JoinColumn(name = "mois", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mois mois;
    @JoinColumn(name = "parametre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametre parametre;

    public ConsommationEau() {
    }

    public ConsommationEau(Integer id) {
        this.id = id;
    }

    public ConsommationEau(Integer id, int ancienIndex, double montantPayer, int nouveauIndex) {
        this.id = id;
        this.ancienIndex = ancienIndex;
        this.montantPayer = montantPayer;
        this.nouveauIndex = nouveauIndex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAncienIndex() {
        return ancienIndex;
    }

    public void setAncienIndex(int ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Date getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(Date dateReleve) {
        this.dateReleve = dateReleve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontantPayer() {
        return montantPayer;
    }

    public void setMontantPayer(double montantPayer) {
        this.montantPayer = montantPayer;
    }

    public int getNouveauIndex() {
        return nouveauIndex;
    }

    public void setNouveauIndex(int nouveauIndex) {
        this.nouveauIndex = nouveauIndex;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }


    public List<ConsommationEau> getConsommationEauList() {
        return consommationEauList;
    }

    public void setConsommationEauList(List<ConsommationEau> consommationEauList) {
        this.consommationEauList = consommationEauList;
    }

    public ConsommationEau getConsommationEau() {
        return consommationEau;
    }

    public void setConsommationEau(ConsommationEau consommationEau) {
        this.consommationEau = consommationEau;
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

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsommationEau)) {
            return false;
        }
        ConsommationEau other = (ConsommationEau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.ConsommationEau[ id=" + id + " ]";
    }

}
