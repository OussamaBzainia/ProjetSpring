package com.example.tp.services;

import com.example.tp.entities.Client;
import com.example.tp.entities.Facture;
import com.example.tp.entities.CategorieClient;
import com.example.tp.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

@Service
public class IClientServiceIMP implements IClientService{
    @Autowired
    IClientRepository iClientRepository;


    @Override
    public List<Client> retrieveAllClients() {
        return iClientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return iClientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
      iClientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return iClientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return iClientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client client= iClientRepository.findById(idClient).orElse(null);

        return client.getFactures();

    }
   
   @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        List<Client> list = clientRepository.getClientsByCategorieClient(categorieClient);
        float s = 0;
        for(Client c : list)
            s += sommeFacture(c,startDate, endDate);
        return s;
    }

    private float sommeFacture(Client client, Date startDate, Date endDate)
    {
        return (float) client.getFactures()
                .stream()
                .filter(facture -> !facture.getActive() && facture.getDateFacture().after(startDate)  && facture.getDateFacture().before(endDate))
                .collect(Collectors.summarizingDouble(Facture::getMontantFacture))
                .getSum();
    }

}
