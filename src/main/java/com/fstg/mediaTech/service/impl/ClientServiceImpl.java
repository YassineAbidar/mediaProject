package com.fstg.mediaTech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.mediaTech.bean.Client;
import com.fstg.mediaTech.dao.IClientDao;
import com.fstg.mediaTech.service.IClientService;
@Service
public class ClientServiceImpl implements IClientService {
	 @Autowired
	    private IClientDao clientDao;

	    @Override
	    public void save(Client client) {
	        clientDao.save(client);
	    }
	    @Override
	    public List<Client> findAll() {
	        return clientDao.findAll();
	    }

	    @Override
	    public Client findById(Long id) {
//	        return (Client) clientDao.findById(id);
	        return null;
	    }

	    @Override
	    public int update(Client client, String ref) {
	        Client c = clientDao.findBycode_client(ref);
	        int rep = 0;
	        if (c != null) {
	            client.setCode_client(ref);
	            client.setNom(c.getNom());
	            client.setPrenom(c.getPrenom());
	            client.setTele(c.getTele());
	            clientDao.save(client);
	            rep = 1;
	        }
	        return rep;
	    }

	    @Override
	    public int delete(String ref) {
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	        return 0;
	    }

	    @Override
	    public List<Client> findBymotCle(String motcle) {
	        return clientDao.findBymotCle(motcle);
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public void delete(long id) {
	        clientDao.deleteById(id);
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public Client chercheById(Long id) {
	        return clientDao.chercheById(id);
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public Client findBycode_client(String codeClient) {
	        return clientDao.findBycode_client(codeClient);
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public void updateClient(String nom, String tele, String prenom, String ref) {

	        clientDao.updateClient(nom, tele, prenom, ref);
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }


}
