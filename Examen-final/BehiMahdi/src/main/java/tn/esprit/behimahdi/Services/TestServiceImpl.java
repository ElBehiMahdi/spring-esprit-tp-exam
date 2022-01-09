package tn.esprit.behimahdi.Services;

import org.springframework.stereotype.Service;
import tn.esprit.behimahdi.Entities.Entity;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Override
    public List<Entity> retrieveAllClients() {
        return null;
    }

    @Override
    public Entity addClient(Entity c) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public Entity updateClient(Entity c) {
        return null;
    }

    @Override
    public Entity retrieveClient(Long id) {
        return null;
    }
}
