package com.fstg.mediaTech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fstg.mediaTech.bean.Facture;

public interface IFacture extends JpaRepository<Facture, Long> {

}
