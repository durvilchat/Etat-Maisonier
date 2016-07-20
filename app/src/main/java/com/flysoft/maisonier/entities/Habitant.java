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
@Table(name = "habitant", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom", "prenom"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Habitant.findAll", query = "SELECT h FROM Habitant h"),
        @NamedQuery(name = "Habitant.findById", query = "SELECT h FROM Habitant h WHERE h.id = :id"),
        @NamedQuery(name = "Habitant.findByDateDelivraisonCni", query = "SELECT h FROM Habitant h WHERE h.dateDelivraisonCni = :dateDelivraisonCni"),
        @NamedQuery(name = "Habitant.findByDateNaissance", query = "SELECT h FROM Habitant h WHERE h.dateNaissance = :dateNaissance"),
        @NamedQuery(name = "Habitant.findByEmail1", query = "SELECT h FROM Habitant h WHERE h.email1 = :email1"),
        @NamedQuery(name = "Habitant.findByEmail2", query = "SELECT h FROM Habitant h WHERE h.email2 = :email2"),
        @NamedQuery(name = "Habitant.findByGenre", query = "SELECT h FROM Habitant h WHERE h.genre = :genre"),
        @NamedQuery(name = "Habitant.findByLieuDelivraisonCni", query = "SELECT h FROM Habitant h WHERE h.lieuDelivraisonCni = :lieuDelivraisonCni"),
        @NamedQuery(name = "Habitant.findByLieuNaissance", query = "SELECT h FROM Habitant h WHERE h.lieuNaissance = :lieuNaissance"),
        @NamedQuery(name = "Habitant.findByNom", query = "SELECT h FROM Habitant h WHERE h.nom = :nom"),
        @NamedQuery(name = "Habitant.findByNomDeLaMere", query = "SELECT h FROM Habitant h WHERE h.nomDeLaMere = :nomDeLaMere"),
        @NamedQuery(name = "Habitant.findByNomDuPere", query = "SELECT h FROM Habitant h WHERE h.nomDuPere = :nomDuPere"),
        @NamedQuery(name = "Habitant.findByNumeroCNI", query = "SELECT h FROM Habitant h WHERE h.numeroCNI = :numeroCNI"),
        @NamedQuery(name = "Habitant.findByPhoto", query = "SELECT h FROM Habitant h WHERE h.photo = :photo"),
        @NamedQuery(name = "Habitant.findByPrenom", query = "SELECT h FROM Habitant h WHERE h.prenom = :prenom"),
        @NamedQuery(name = "Habitant.findByProfession", query = "SELECT h FROM Habitant h WHERE h.profession = :profession"),
        @NamedQuery(name = "Habitant.findByTel1", query = "SELECT h FROM Habitant h WHERE h.tel1 = :tel1"),
        @NamedQuery(name = "Habitant.findByTel2", query = "SELECT h FROM Habitant h WHERE h.tel2 = :tel2"),
        @NamedQuery(name = "Habitant.findByTel3", query = "SELECT h FROM Habitant h WHERE h.tel3 = :tel3"),
        @NamedQuery(name = "Habitant.findByTel4", query = "SELECT h FROM Habitant h WHERE h.tel4 = :tel4"),
        @NamedQuery(name = "Habitant.findByTitre", query = "SELECT h FROM Habitant h WHERE h.titre = :titre")})
public class Habitant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date_delivraison_cni")
    @Temporal(TemporalType.DATE)
    private Date dateDelivraisonCni;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
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
    @Size(max = 255)
    @Column(name = "lieu_naissance", length = 255)
    private String lieuNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Size(max = 255)
    @Column(name = "nom_de_la_mere", length = 255)
    private String nomDeLaMere;
    @Size(max = 255)
    @Column(name = "nom_du_pere", length = 255)
    private String nomDuPere;
    @Size(max = 255)
    @Column(name = "numero_c_n_i", length = 255)
    private String numeroCNI;
    @Size(max = 255)
    @Column(name = "photo", length = 255)
    private String photo;
    @Size(max = 255)
    @Column(name = "prenom", length = 255)
    private String prenom;
    @Size(max = 255)
    @Column(name = "profession", length = 255)
    private String profession;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitant")
    private List<Occupation> occupationList;
    @OneToMany(mappedBy = "habitant")
    private List<Facture> factureList;
    @OneToMany(mappedBy = "habitant")
    private List<ConsommationEau> consommationEauList;
    @OneToMany(mappedBy = "habitant")
    private List<ConsommationElectricite> consommationElectriciteList;

    public Habitant() {
    }

    public Habitant(Integer id) {
        this.id = id;
    }

    public Habitant(Integer id, String genre, String nom, String tel1, String titre) {
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDeLaMere() {
        return nomDeLaMere;
    }

    public void setNomDeLaMere(String nomDeLaMere) {
        this.nomDeLaMere = nomDeLaMere;
    }

    public String getNomDuPere() {
        return nomDuPere;
    }

    public void setNomDuPere(String nomDuPere) {
        this.nomDuPere = nomDuPere;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    @XmlTransient
    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitant)) {
            return false;
        }
        Habitant other = (Habitant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Habitant[ id=" + id + " ]";
    }

}
