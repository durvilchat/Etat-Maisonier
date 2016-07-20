/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "parametre", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Parametre.findAll", query = "SELECT p FROM Parametre p"),
        @NamedQuery(name = "Parametre.findById", query = "SELECT p FROM Parametre p WHERE p.id = :id"),
        @NamedQuery(name = "Parametre.findByCablage", query = "SELECT p FROM Parametre p WHERE p.cablage = :cablage"),
        @NamedQuery(name = "Parametre.findByDateEnregistrement", query = "SELECT p FROM Parametre p WHERE p.dateEnregistrement = :dateEnregistrement"),
        @NamedQuery(name = "Parametre.findByDateModification", query = "SELECT p FROM Parametre p WHERE p.dateModification = :dateModification"),
        @NamedQuery(name = "Parametre.findByEntretientEau", query = "SELECT p FROM Parametre p WHERE p.entretientEau = :entretientEau"),
        @NamedQuery(name = "Parametre.findByEntretientElectricite", query = "SELECT p FROM Parametre p WHERE p.entretientElectricite = :entretientElectricite"),
        @NamedQuery(name = "Parametre.findByEtat", query = "SELECT p FROM Parametre p WHERE p.etat = :etat"),
        @NamedQuery(name = "Parametre.findByPrixUnitaireEau", query = "SELECT p FROM Parametre p WHERE p.prixUnitaireEau = :prixUnitaireEau"),
        @NamedQuery(name = "Parametre.findByPrixUnitaireElectricite", query = "SELECT p FROM Parametre p WHERE p.prixUnitaireElectricite = :prixUnitaireElectricite"),
        @NamedQuery(name = "Parametre.findByRepertoirePhotoBatiment", query = "SELECT p FROM Parametre p WHERE p.repertoirePhotoBatiment = :repertoirePhotoBatiment"),
        @NamedQuery(name = "Parametre.findByRepertoirePhotoHabitant", query = "SELECT p FROM Parametre p WHERE p.repertoirePhotoHabitant = :repertoirePhotoHabitant"),
        @NamedQuery(name = "Parametre.findByRepertoirePhotoLogement", query = "SELECT p FROM Parametre p WHERE p.repertoirePhotoLogement = :repertoirePhotoLogement"),
        @NamedQuery(name = "Parametre.findByRepertoirePhotoPersonnel", query = "SELECT p FROM Parametre p WHERE p.repertoirePhotoPersonnel = :repertoirePhotoPersonnel"),
        @NamedQuery(name = "Parametre.findByTVA", query = "SELECT p FROM Parametre p WHERE p.tVA = :tVA"),
        @NamedQuery(name = "Parametre.findByTauxRemise", query = "SELECT p FROM Parametre p WHERE p.tauxRemise = :tauxRemise")})
public class Parametre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cablage", nullable = false)
    private double cablage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_enregistrement", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entretient_eau", nullable = false)
    private double entretientEau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entretient_electricite", nullable = false)
    private double entretientElectricite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_unitaire_eau", nullable = false)
    private double prixUnitaireEau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_unitaire_electricite", nullable = false)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_v_a", nullable = false)
    private double tVA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taux_remise", nullable = false)
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

    @XmlTransient
    public List<Cable> getCableList() {
        return cableList;
    }

    public void setCableList(List<Cable> cableList) {
        this.cableList = cableList;
    }

    @XmlTransient
    public List<ConsommationEau> getConsommationEauList() {
        return consommationEauList;
    }

    public void setConsommationEauList(List<ConsommationEau> consommationEauList) {
        this.consommationEauList = consommationEauList;
    }

    @XmlTransient
    public List<ConsommationElectricite> getConsommationElectriciteList() {
        return consommationElectriciteList;
    }

    public void setConsommationElectriciteList(List<ConsommationElectricite> consommationElectriciteList) {
        this.consommationElectriciteList = consommationElectriciteList;
    }

    @XmlTransient
    public List<Remise> getRemiseList() {
        return remiseList;
    }

    public void setRemiseList(List<Remise> remiseList) {
        this.remiseList = remiseList;
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
        if (!(object instanceof Parametre)) {
            return false;
        }
        Parametre other = (Parametre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Parametre[ id=" + id + " ]";
    }

}
