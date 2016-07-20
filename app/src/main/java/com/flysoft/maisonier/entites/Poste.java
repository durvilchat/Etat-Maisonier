/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "poste", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Poste.findAll", query = "SELECT p FROM Poste p"),
        @NamedQuery(name = "Poste.findById", query = "SELECT p FROM Poste p WHERE p.id = :id"),
        @NamedQuery(name = "Poste.findByDescription", query = "SELECT p FROM Poste p WHERE p.description = :description"),
        @NamedQuery(name = "Poste.findByEtat", query = "SELECT p FROM Poste p WHERE p.etat = :etat"),
        @NamedQuery(name = "Poste.findByLibelle", query = "SELECT p FROM Poste p WHERE p.libelle = :libelle")})
public class Poste extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;

    @NotNull
    @Column(name = "etat")
    private boolean etat;

    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "libelle", length = 254)
    private String libelle;
    @OneToMany(mappedBy = "poste")
    private List<Personnel> personnelList;

    public Poste() {
    }

    public Poste(Integer id) {
        this.id = id;
    }

    public Poste(Integer id, boolean etat, String libelle) {
        this.id = id;
        this.etat = etat;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
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
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Poste[ id=" + id + " ]";
    }

}
