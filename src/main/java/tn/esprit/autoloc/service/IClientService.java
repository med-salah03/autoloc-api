package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {

    Client ajouterClient(Client client);

    Client modifierClient(Client client);

    List<Client> afficherToutesClients();

    Client afficherClientById(Long id);

    void supprimerClient(Long id);
}
