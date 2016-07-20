/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "cite", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cite.findAll", query = "SELECT c FROM Cite c"),
        @NamedQuery(name = "Cite.findById", query = "SELECT c FROM Cite c WHERE c.id = :id"),
        @NamedQuery(name = "Cite.findByDescription", query = "SELECT c FROM Cite c WHERE c.description = :description"),
        @NamedQuery(name = "Cite.findByEmail", query = "SELECT c FROM Cite c WHERE c.email = :email"),
        @NamedQuery(name = "Cite.findByEtat", query = "SELECT c FROM Cite c WHERE c.etat = :etat"),
        @NamedQuery(name = "Cite.findByNomCite", query = "SELECT c FROM Cite c WHERE c.nomCite = :nomCite"),
        @NamedQuery(name = "Cite.findByPoliceCite", query = "SELECT c FROM Cite c WHERE c.policeCite = :policeCite"),
        @NamedQuery(name = "Cite.findByPoliceContact", query = "SELECT c FROM Cite c WHERE c.policeContact = :policeContact"),
        @NamedQuery(name = "Cite.findByPoliceDescription", query = "SELECT c FROM Cite c WHERE c.policeDescription = :policeDescription"),
        @NamedQuery(name = "Cite.findBySiege", query = "SELECT c FROM Cite c WHERE c.siege = :siege"),
        @NamedQuery(name = "Cite.findByTels", query = "SELECT c FROM Cite c WHERE c.tels = :tels")})
public class Cite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_cite", nullable = false, length = 255)
    private String nomCite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "police_cite", precision = 17, scale = 17)
    private Double policeCite;
    @Column(name = "police_contact", precision = 17, scale = 17)
    private Double policeContact;
    @Column(name = "police_description", precision = 17, scale = 17)
    private Double policeDescription;
    @Size(max = 255)
    @Column(name = "siege", length = 255)
    private String siege;
    @Size(max = 255)
    @Column(name = "tels", length = 255)
    private String tels;
    @OneToMany(mappedBy = "cite")
    private List<Batiment> batimentList;
    @JoinColumn(name = "bailleur", referencedColumnName = "id")
    @ManyToOne
    private Bailleur bailleur;

    public Cite() {
    }

    public Cite(Integer id) {
        this.id = id;
    }

    public Cite(Integer id, boolean etat, String nomCite) {
        this.id = id;
        this.etat = etat;
        this.nomCite = nomCite;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getNomCite() {
        return nomCite;
    }

    public void setNomCite(String nomCite) {
        this.nomCite = nomCite;
    }

    public Double getPoliceCite() {
        return policeCite;
    }

    public void setPoliceCite(Double policeCite) {
        this.policeCite = policeCite;
    }

    public Double getPoliceContact() {
        return policeContact;
    }

    public void setPoliceContact(Double policeContact) {
        this.policeContact = policeContact;
    }

    public Double getPoliceDescription() {
        return policeDescription;
    }

    public void setPoliceDescription(Double policeDescription) {
        this.policeDescription = policeDescription;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getTels() {
        return tels;
    }

    public void setTels(String tels) {
        this.tels = tels;
    }

    @XmlTransient
    public List<Batiment> getBatimentList() {
        return batimentList;
    }

    public void setBatimentList(List<Batiment> batimentList) {
        this.batimentList = batimentList;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
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
        if (!(object instanceof Cite)) {
            return false;
        }
        Cite other = (Cite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Cite[ id=" + id + " ]";
    }

}
