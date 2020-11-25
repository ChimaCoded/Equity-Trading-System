package com.alpha.client.Client.service;

import com.alpha.client.Client.model.Client;
import com.alpha.client.Client.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    @Autowired
    private ClientRepository clientRepo;



    public List<Client> getAllClient(){
        List<Client> clients = new ArrayList<>();
        clientRepo.findAll().forEach(clients::add);
        return clients;
    }

    public void deleteClient(long id) {
        clientRepo.deleteById(id);
    }

    public double getBankBalance(long id) {
        return clientRepo.findById(id).get().getBankBalance();
    }

    public void updateBankBalance(long id, double balance) {
        Client temp = clientRepo.findById(id).get();
        temp.setBankBalance(balance);
        clientRepo.save(temp);
    }

    public boolean clientExists(long id) {
        if (clientRepo.findById(id)==null)
            return false;
        return true;
    }



}
