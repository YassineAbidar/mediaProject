/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.mediaTech.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yassine
 */
@Entity(name = "factures")
@Table(name = "factures")
public class Facture implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "ref_facture", length = 60)
    private String ref_facture;
    @Column(name = "date_facture")
    private Date date_facture;
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private Set<LigneFacture> ligneFactures= new HashSet<>();

    public Facture() {
    }

    public Facture(String ref_facture, Date date_facture) {
        this.ref_facture = ref_facture;
        this.date_facture = date_facture;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef_facture() {
        return ref_facture;
    }

    public void setRef_facture(String ref_facture) {
        this.ref_facture = ref_facture;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = date_facture;
    }

    public Set<LigneFacture> getLigneFactures() {
        return ligneFactures;
    }

    public void setLigneFactures(Set<LigneFacture> ligneFactures) {
        this.ligneFactures = ligneFactures;
    }
    
}
