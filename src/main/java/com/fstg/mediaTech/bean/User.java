package com.fstg.mediaTech.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	@Column
	@NotEmpty
	private String nom;
	@Column(name = "role")
	@NotEmpty
	private String role;
	@Column(unique=true)
	@NotEmpty
	private String user_name;
	@Column
	@NotEmpty
	private String password;
	public User(long id, String nom, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.role = role;
	}
	public User(String nom, String role) {
		super();
		this.nom = nom;
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
