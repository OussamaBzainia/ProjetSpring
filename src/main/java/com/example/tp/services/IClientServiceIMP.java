package com.example.tp.services;

import com.example.tp.entities.Client;
import com.example.tp.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
