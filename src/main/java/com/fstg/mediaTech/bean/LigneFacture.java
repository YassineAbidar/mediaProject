/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.mediaTech.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 *
 * @author yassine
 */
@Entity
@Table(name = "ligne_factures")
public class LigneFacture implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn
	private Facture facture;

	@Id
	@ManyToOne
	@JoinColumn
	private Produit produit;

	private double quantity;

	public LigneFacture(Facture facture, Produit produit, double quantity) {
		this.facture = facture;
		this.produit = produit;
		this.quantity = quantity;
	}

	public LigneFacture() {
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
