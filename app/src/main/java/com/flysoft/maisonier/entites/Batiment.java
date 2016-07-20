/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "batiment", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Batiment.findAll", query = "SELECT b FROM Batiment b"),
        @NamedQuery(name = "Batiment.findById", query = "SELECT b FROM Batiment b WHERE b.id = :id"),
        @NamedQuery(name = "Batiment.findByCode", query = "SELECT b FROM Batiment b WHERE b.code = :code"),
        @NamedQuery(name = "Batiment.findByEtat", query = "SELECT b FROM Batiment b WHERE b.etat = :etat"),
        @NamedQuery(name = "Batiment.findByNom", query = "SELECT b FROM Batiment b WHERE b.nom = :nom")})
public class Batiment extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code", length = 255)
    private String code;

    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @JoinColumn(name = "cite", referencedColumnName = "id")
    @ManyToOne
    private Cite cite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batiment")
    private List<Logement> logementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batiment")
    private List<PhotoBatiment> photoBatimentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batiment")
    private List<Depense> depenseList;

    public Batiment() {
    }

    public Batiment(Integer id) {
        this.id = id;
    }

    public Batiment(Integer id, String code, boolean etat) {
        this.id = id;
        this.code = code;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Cite getCite() {
        return cite;
    }

    public void setCite(Cite cite) {
        this.cite = cite;
    }


    public List<Logement> getLogementList() {
        return logementList;
    }

    public void setLogementList(List<Logement> logementList) {
        this.logementList = logementList;
    }


    public List<PhotoBatiment> getPhotoBatimentList() {
        return photoBatimentList;
    }

    public void setPhotoBatimentList(List<PhotoBatiment> photoBatimentList) {
        this.photoBatimentList = photoBatimentList;
    }


    public List<Depense> getDepenseList() {
        return depenseList;
    }

    public void setDepenseList(List<Depense> depenseList) {
        this.depenseList = depenseList;
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
        if (!(object instanceof Batiment)) {
            return false;
        }
        Batiment other = (Batiment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Batiment[ id=" + id + " ]";
    }

}
