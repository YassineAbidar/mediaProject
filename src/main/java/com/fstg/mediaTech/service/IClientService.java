package com.fstg.mediaTech.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fstg.mediaTech.bean.Client;

public interface IClientService {
	public void save(Client client);

    public List<Client> findAll();

    public Client findById(Long id);

    public int update(Client client, String ref);

    public int delete(String ref);

    public List<Client> findBymotCle(String motcle);

    public void delete(long id);

    public Client chercheById(Long id);

    public Client findBycode_client(String codeClient);
    @Transactional
    public void updateClient(String nom, String tele, String prenom, String ref);

}
