package com.example.dataacentre.Controller;

import com.example.dataacentre.Entities.Datacenter;
import com.example.dataacentre.Entities.Utilisateur;
import com.example.dataacentre.Entities.VirtualMachine;
import com.example.dataacentre.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/app")
public class RestController {

    @Autowired
    Service service;

    @PostMapping("/ajouter-user")
    public void ajouterUser(@RequestBody Utilisateur user){
        service.ajouterUser(user);
    }
    @PostMapping("/ajouter-dc")
    public void ajouterDc(@RequestBody Datacenter dataCenter){
        service.ajouterDc(dataCenter);
    }
    @PostMapping("/ajouter-vm")
    public void ajouterVm(@RequestBody VirtualMachine vm){
        service.ajouterVm(vm);
    }

    @PutMapping("/affecter-vm-user/{id-vm}/{id-user}")
    public void affecterVmUser(@PathVariable("id-vm") int idVm, @PathVariable("id-user") int idUser){
        service.affecterVm(idVm);
    }

    @PutMapping("/affecter-vm/{id-vm}")
    public void affecterVm(@PathVariable("id-vm") int idVm){
        service.affecterVm(idVm);
    }
    @PutMapping("/demarrer-vm/{id-vm}")
    public void demarrerVm(@PathVariable("id-vm") int idVm){
        service.demarrerInstanceUser(idVm);;
    }
    @PutMapping("/arreter-vm/{id-vm}")
    public void arreterVm(@PathVariable("id-vm") int idVm){
        service.arreterInstanceUser(idVm);
    }
    @GetMapping("/getDataCenters")
    public List<Datacenter> getDataCenter(){
        return service.listerDatacenter();
    }
}
