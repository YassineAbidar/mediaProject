package com.fstg.mediaTech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fstg.mediaTech.bean.Produit;

public interface IProduitDao extends JpaRepository<Produit, Long> {

}
