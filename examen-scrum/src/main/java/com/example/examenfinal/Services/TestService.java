package com.example.examenfinal.Services;

import javax.persistence.Entity;
import java.util.List;

public interface TestService {

    List<Entity> retrieveAllClients();
    Entity addClient(Entity c);
    void deleteClient(Long id);
    Entity updateClient(Entity c);
    Entity retrieveClient(Long id);
}
