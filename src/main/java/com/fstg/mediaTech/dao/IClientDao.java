package com.fstg.mediaTech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fstg.mediaTech.bean.Client;
@Repository
public interface IClientDao extends JpaRepository<Client, Long> {
	@Query("select c from Client c where c.nom like:x ")
	public List<Client> findBymotCle(@Param("x") String motCle);

	@Query("select c from Client c where c.id=:id")
	public Client chercheById(@Param("id") Long id);

	@Query("select c from Client c where c.code_client=:code_client")
	public Client findBycode_client(@Param("code_client") String code_client);

	@Query(value = "UPDATE CLIENTS SET nom=:nom,tele=:tele,prenom=:prenom where CLIENTS.code_client=:code_client", nativeQuery = true)
	public void updateClient(@Param("nom") String nom, @Param("tele") String tele, @Param("prenom") String prenom,
			@Param("code_client") String code_client);
}
