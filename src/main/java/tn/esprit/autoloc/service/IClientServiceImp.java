package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IClientServiceImp implements IClientService{

    private final ClientRepository clientRepository;
    @Override
    public Client ajouterClient(Client client) {
        return  clientRepository.save(client);
    }

    @Override
    public Client modifierClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> afficherToutesClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client afficherClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);

    }
}
