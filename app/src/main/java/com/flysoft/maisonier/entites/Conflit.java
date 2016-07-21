/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;


import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = Maisonier.class)
public class Conflit extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "privilege1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilege1;
    @JoinColumn(name = "privilege2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilege2;

    public Conflit() {
    }

    public Conflit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Privilege getPrivilege1() {
        return privilege1;
    }

    public void setPrivilege1(Privilege privilege1) {
        this.privilege1 = privilege1;
    }

    public Privilege getPrivilege2() {
        return privilege2;
    }

    public void setPrivilege2(Privilege privilege2) {
        this.privilege2 = privilege2;
    }


}
