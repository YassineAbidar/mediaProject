/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.mediaTech.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yassine
 */
@Entity
@Table(name = "produits")
public class Produit implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "ref_prod", length = 30)
    private String ref_prod;
    @Column(name = "libelle", length = 60)
    private String libelle;
    @Column(name = "quntity_stock")
    private long quntity_stock;
    @Column(name = "prix_unitaire")
    private double prix_unitaire;
//    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "produits")
   @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private Set<LigneFacture> ligneFactures= new HashSet<>();

    public Produit(String ref_prod, String libelle, long quntity_stock, double prix_unitaire) {
        this.ref_prod = ref_prod;
        this.libelle = libelle;
        this.quntity_stock = quntity_stock;
        this.prix_unitaire = prix_unitaire;
    }

    public Produit() {
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", ref_prod=" + ref_prod + ", libelle=" + libelle + ", quntity_stock=" + quntity_stock + ", prix_unitaire=" + prix_unitaire + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef_prod() {
        return ref_prod;
    }

    public void setRef_prod(String ref_prod) {
        this.ref_prod = ref_prod;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public long getQuntity_stock() {
        return quntity_stock;
    }

    public void setQuntity_stock(long quntity_stock) {
        this.quntity_stock = quntity_stock;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

}
