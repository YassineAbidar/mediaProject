package com.fstg.mediaTech.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name = "clients")
public class Client implements Serializable {
	 @Id
	    @GeneratedValue
	    private Long id;
	    @NotEmpty
	    @Size(min = 5, max = 20)
	    @Column(unique = true)
	    private String code_client;

	    @NotEmpty
	    private String nom;
	    @NotEmpty
	    private String prenom;
	    @NotEmpty
	    @Size(min = 9, max = 11)
	    @Column(unique = true)
	    private String tele;
	    public Client() {
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCode_client() {
			return code_client;
		}
		public void setCode_client(String code_client) {
			this.code_client = code_client;
		}
		public String getNom() {
			return nom;
		}
		
		@Override
		public String toString() {
			return "Client [id=" + id + ", code_client=" + code_client + ", nom=" + nom + ", prenom=" + prenom
					+ ", tele=" + tele + "]";
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getTele() {
			return tele;
		}
		public void setTele(String tele) {
			this.tele = tele;
		}
		public Client(@NotEmpty @Size(min = 5, max = 20) String code_client, @NotEmpty String nom,
				@NotEmpty String prenom, @NotEmpty @Size(min = 9, max = 11) String tele) {
			super();
			this.code_client = code_client;
			this.nom = nom;
			this.prenom = prenom;
			this.tele = tele;
		}
	    

}
