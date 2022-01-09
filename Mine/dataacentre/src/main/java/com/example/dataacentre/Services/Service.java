package com.example.dataacentre.Services;

import com.example.dataacentre.Entities.Datacenter;
import com.example.dataacentre.Entities.Utilisateur;
import com.example.dataacentre.Entities.VirtualMachine;

import java.util.List;

public interface Service {
    public void ajouterUser(Utilisateur u);
    public void ajouterDc(Datacenter datacenter);
    public int ajouterVm(VirtualMachine vm);
    public void affecterVmuser(int idvm, int iduser);
    public void affecterVm(int idvm);
    public void demarrerInstanceUser(int idvm);
    public void arreterInstanceUser(int idvm);
    public List<Datacenter> listerDatacenter(); // Avec Schedular
}
