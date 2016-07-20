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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "bailleur", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom", "prenom"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Bailleur.findAll", query = "SELECT b FROM Bailleur b"),
        @NamedQuery(name = "Bailleur.findById", query = "SELECT b FROM Bailleur b WHERE b.id = :id"),
        @NamedQuery(name = "Bailleur.findByDateDelivraisonCni", query = "SELECT b FROM Bailleur b WHERE b.dateDelivraisonCni = :dateDelivraisonCni"),
        @NamedQuery(name = "Bailleur.findByEmail1", query = "SELECT b FROM Bailleur b WHERE b.email1 = :email1"),
        @NamedQuery(name = "Bailleur.findByEmail2", query = "SELECT b FROM Bailleur b WHERE b.email2 = :email2"),
        @NamedQuery(name = "Bailleur.findByGenre", query = "SELECT b FROM Bailleur b WHERE b.genre = :genre"),
        @NamedQuery(name = "Bailleur.findByLieuDelivraisonCni", query = "SELECT b FROM Bailleur b WHERE b.lieuDelivraisonCni = :lieuDelivraisonCni"),
        @NamedQuery(name = "Bailleur.findByNom", query = "SELECT b FROM Bailleur b WHERE b.nom = :nom"),
        @NamedQuery(name = "Bailleur.findByNumeroCNI", query = "SELECT b FROM Bailleur b WHERE b.numeroCNI = :numeroCNI"),
        @NamedQuery(name = "Bailleur.findByPhoto", query = "SELECT b FROM Bailleur b WHERE b.photo = :photo"),
        @NamedQuery(name = "Bailleur.findByPrenom", query = "SELECT b FROM Bailleur b WHERE b.prenom = :prenom"),
        @NamedQuery(name = "Bailleur.findByTel1", query = "SELECT b FROM Bailleur b WHERE b.tel1 = :tel1"),
        @NamedQuery(name = "Bailleur.findByTel2", query = "SELECT b FROM Bailleur b WHERE b.tel2 = :tel2"),
        @NamedQuery(name = "Bailleur.findByTel3", query = "SELECT b FROM Bailleur b WHERE b.tel3 = :tel3"),
        @NamedQuery(name = "Bailleur.findByTel4", query = "SELECT b FROM Bailleur b WHERE b.tel4 = :tel4"),
        @NamedQuery(name = "Bailleur.findByTitre", query = "SELECT b FROM Bailleur b WHERE b.titre = :titre")})
public class Bailleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date_delivraison_cni")
    @Temporal(TemporalType.DATE)
    private Date dateDelivraisonCni;
    @Size(max = 255)
    @Column(name = "email1", length = 255)
    private String email1;
    @Size(max = 255)
    @Column(name = "email2", length = 255)
    private String email2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "genre", nullable = false, length = 255)
    private String genre;
    @Size(max = 255)
    @Column(name = "lieu_delivraison_cni", length = 255)
    private String lieuDelivraisonCni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Size(max = 255)
    @Column(name = "numero_c_n_i", length = 255)
    private String numeroCNI;
    @Size(max = 255)
    @Column(name = "photo", length = 255)
    private String photo;
    @Size(max = 255)
    @Column(name = "prenom", length = 255)
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tel1", nullable = false, length = 255)
    private String tel1;
    @Size(max = 255)
    @Column(name = "tel2", length = 255)
    private String tel2;
    @Size(max = 255)
    @Column(name = "tel3", length = 255)
    private String tel3;
    @Size(max = 255)
    @Column(name = "tel4", length = 255)
    private String tel4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titre", nullable = false, length = 255)
    private String titre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bailleur")
    private List<ContratBail> contratBailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bailleur")
    private List<Depense> depenseList;
    @OneToMany(mappedBy = "bailleur")
    private List<Cite> citeList;

    public Bailleur() {
    }

    public Bailleur(Integer id) {
        this.id = id;
    }

    public Bailleur(Integer id, String genre, String nom, String tel1, String titre) {
        this.id = id;
        this.genre = genre;
        this.nom = nom;
        this.tel1 = tel1;
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDelivraisonCni() {
        return dateDelivraisonCni;
    }

    public void setDateDelivraisonCni(Date dateDelivraisonCni) {
        this.dateDelivraisonCni = dateDelivraisonCni;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLieuDelivraisonCni() {
        return lieuDelivraisonCni;
    }

    public void setLieuDelivraisonCni(String lieuDelivraisonCni) {
        this.lieuDelivraisonCni = lieuDelivraisonCni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroCNI() {
        return numeroCNI;
    }

    public void setNumeroCNI(String numeroCNI) {
        this.numeroCNI = numeroCNI;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public String getTel4() {
        return tel4;
    }

    public void setTel4(String tel4) {
        this.tel4 = tel4;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlTransient
    public List<ContratBail> getContratBailList() {
        return contratBailList;
    }

    public void setContratBailList(List<ContratBail> contratBailList) {
        this.contratBailList = contratBailList;
    }

    @XmlTransient
    public List<Depense> getDepenseList() {
        return depenseList;
    }

    public void setDepenseList(List<Depense> depenseList) {
        this.depenseList = depenseList;
    }

    @XmlTransient
    public List<Cite> getCiteList() {
        return citeList;
    }

    public void setCiteList(List<Cite> citeList) {
        this.citeList = citeList;
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
        if (!(object instanceof Bailleur)) {
            return false;
        }
        Bailleur other = (Bailleur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Bailleur[ id=" + id + " ]";
    }

}
