/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = Maisonier.class)
public class MessageSortant extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "contenu", length = 255)
    private String contenu;
    @Size(max = 255)
    @Column(name = "type_message", length = 255)
    private String typeMessage;
    @OneToMany(mappedBy = "messageSortant")
    private List<BoiteEnvoi> boiteEnvoiList;

    public MessageSortant() {
    }

    public MessageSortant(Integer id) {
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

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }


    public List<BoiteEnvoi> getBoiteEnvoiList() {
        return boiteEnvoiList;
    }

    public void setBoiteEnvoiList(List<BoiteEnvoi> boiteEnvoiList) {
        this.boiteEnvoiList = boiteEnvoiList;
    }

}
