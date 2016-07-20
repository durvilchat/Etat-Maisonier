/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "logement", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"reference"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Logement.findAll", query = "SELECT l FROM Logement l"),
        @NamedQuery(name = "Logement.findById", query = "SELECT l FROM Logement l WHERE l.id = :id"),
        @NamedQuery(name = "Logement.findByDatecreation", query = "SELECT l FROM Logement l WHERE l.datecreation = :datecreation"),
        @NamedQuery(name = "Logement.findByDescription", query = "SELECT l FROM Logement l WHERE l.description = :description"),
        @NamedQuery(name = "Logement.findByEtat", query = "SELECT l FROM Logement l WHERE l.etat = :etat"),
        @NamedQuery(name = "Logement.findByPrixMax", query = "SELECT l FROM Logement l WHERE l.prixMax = :prixMax"),
        @NamedQuery(name = "Logement.findByPrixMin", query = "SELECT l FROM Logement l WHERE l.prixMin = :prixMin"),
        @NamedQuery(name = "Logement.findByReference", query = "SELECT l FROM Logement l WHERE l.reference = :reference")})
public class Logement extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "datecreation")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Column(name = "prix_max")
    private double prixMax;

    @NotNull
    @Column(name = "prix_min")
    private double prixMin;
    @Size(max = 255)
    @Column(name = "reference", length = 255)
    private String reference;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logement")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logement")
    private List<PhotoLogement> photoLogementList;
    @JoinColumn(name = "batiment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batiment batiment;
    @JoinColumn(name = "type_logement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeLogement typeLogement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logement")
    private List<ConsommationEau> consommationEauList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logement")
    private List<ConsommationElectricite> consommationElectriciteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logement")
    private List<CaracteristiqueLogement> caracteristiqueLogementList;

    public Logement() {
    }

    public Logement(Integer id) {
        this.id = id;
    }

    public Logement(Integer id, Date datecreation, boolean etat, double prixMax, double prixMin) {
        this.id = id;
        this.datecreation = datecreation;
        this.etat = etat;
        this.prixMax = prixMax;
        this.prixMin = prixMin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
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

    public double getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }

    public double getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }


    public List<PhotoLogement> getPhotoLogementList() {
        return photoLogementList;
    }

    public void setPhotoLogementList(List<PhotoLogement> photoLogementList) {
        this.photoLogementList = photoLogementList;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public TypeLogement getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(TypeLogement typeLogement) {
        this.typeLogement = typeLogement;
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


    public List<CaracteristiqueLogement> getCaracteristiqueLogementList() {
        return caracteristiqueLogementList;
    }

    public void setCaracteristiqueLogementList(List<CaracteristiqueLogement> caracteristiqueLogementList) {
        this.caracteristiqueLogementList = caracteristiqueLogementList;
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
        if (!(object instanceof Logement)) {
            return false;
        }
        Logement other = (Logement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Logement[ id=" + id + " ]";
    }

}
