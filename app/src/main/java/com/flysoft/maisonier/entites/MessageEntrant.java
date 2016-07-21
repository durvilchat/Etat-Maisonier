/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = Maisonier.class)
public class MessageEntrant extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "contenu", length = 255)
    private String contenu;
    @Size(max = 255)
    @Column(name = "numero_emetteur", length = 255)
    private String numeroEmetteur;
    @JoinColumn(name = "telephone", referencedColumnName = "id")
    @ManyToOne
    private Telephone telephone;

    public MessageEntrant() {
    }

    public MessageEntrant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getNumeroEmetteur() {
        return numeroEmetteur;
    }

    public void setNumeroEmetteur(String numeroEmetteur) {
        this.numeroEmetteur = numeroEmetteur;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

}
