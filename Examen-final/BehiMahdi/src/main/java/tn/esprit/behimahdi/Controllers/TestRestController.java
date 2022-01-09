package tn.esprit.behimahdi.Controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.behimahdi.Services.TestService;

import java.util.Date;

@RestController
@RequestMapping("/client")
public class TestRestController {

    //ACCESS SWAGGER
    //http://localhost:8089/SpringMVC/swagger-ui/index.html

    @Autowired
    TestService clientService;















    /*
    //Using Date in parameter :
    @PostMapping("/add-sprint/{Description}/{startDate}/{idProj}")
    @ResponseBody
    public void addproject(@PathVariable("Description") String description,
                           @PathVariable("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                           @PathVariable("idProj") int idProject ) {

        service.addSprintAndAssignToProject(description, startDate, idProject);
    }

    @GetMapping("/retrieve-all-clients")
    @ResponseBody
    public List<Client> getClients() {
        List<Client> listClients = clientService.retrieveAllClients();
        return listClients;

        @GetMapping("/retrieve-client/{client-id}")
        @ResponseBody
        public Client retrieveClient(@PathVariable("client-id") Long clientId) {
            return clientService.retrieveClient(clientId);
        }

        @PostMapping("/add-client")
        @ResponseBody
        public Client addClient(@RequestBody Client c) {
            Client client = clientService.addClient(c);
            return client
        }

        @DeleteMapping("/remove-client/{client-id}")
        @ResponseBody
        public void removeClient(@PathVariable("client-id") Long clientId) {
            clientService.deleteClient(clientId);
        }

        @PutMapping("/modify-client")
        @ResponseBody
        public Client modifyClient(@RequestBody Client client) {
            return clientService.updateClient(client);
        }

     */
}
