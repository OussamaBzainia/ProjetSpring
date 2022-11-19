package com.example.tp.services;

import com.example.tp.entities.Client;
import com.example.tp.entities.Facture;

import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
    float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);

    List<Facture> getFacturesByClient(Long idClient);
}
