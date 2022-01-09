package tn.esprit.behimahdi.Services;

import tn.esprit.behimahdi.Entities.Entity;

import java.util.List;

public interface TestService {

    List<Entity> retrieveAllClients();
    Entity addClient(Entity c);
    void deleteClient(Long id);
    Entity updateClient(Entity c);
    Entity retrieveClient(Long id);
}
