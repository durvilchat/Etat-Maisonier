/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

public class BoiteEnvoi extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_reception")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReception;
    @Size(max = 255)
    @Column(name = "numero_destinataire", length = 255)
    private String numeroDestinataire;
    @JoinColumn(name = "message_sortant", referencedColumnName = "id")
    @ManyToOne
    private MessageSortant messageSortant;
    @JoinColumn(name = "telephone", referencedColumnName = "id")
    @ManyToOne
    private Telephone telephone;

    public BoiteEnvoi() {
    }

    public BoiteEnvoi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public String getNumeroDestinataire() {
        return numeroDestinataire;
    }

    public void setNumeroDestinataire(String numeroDestinataire) {
        this.numeroDestinataire = numeroDestinataire;
    }

    public MessageSortant getMessageSortant() {
        return messageSortant;
    }

    public void setMessageSortant(MessageSortant messageSortant) {
        this.messageSortant = messageSortant;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof BoiteEnvoi)) {
            return false;
        }
        BoiteEnvoi other = (BoiteEnvoi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.BoiteEnvoi[ id=" + id + " ]";
    }

}
