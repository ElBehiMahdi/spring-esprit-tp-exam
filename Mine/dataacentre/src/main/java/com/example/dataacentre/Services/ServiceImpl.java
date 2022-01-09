package com.example.dataacentre.Services;

import com.example.dataacentre.Entities.Datacenter;
import com.example.dataacentre.Entities.Etat;
import com.example.dataacentre.Entities.Utilisateur;
import com.example.dataacentre.Entities.VirtualMachine;
import com.example.dataacentre.Repositories.DatacenterRepo;
import com.example.dataacentre.Repositories.UtilisateurRepo;
import com.example.dataacentre.Repositories.VirtualMachineRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@org.springframework.stereotype.Service
@Slf4j
public class ServiceImpl implements Service{

    @Autowired
    DatacenterRepo datacenterRepo;

    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Autowired
    VirtualMachineRepo virtualMachineRepo;

    @Override
    public void ajouterUser(Utilisateur u) {
        utilisateurRepo.save(u);
    }

    @Override
    public void ajouterDc(Datacenter datacenter) {
        datacenterRepo.save(datacenter);
    }

    @Override
    public int ajouterVm(VirtualMachine vm) {

        return virtualMachineRepo.save(vm).getIdVm();
    }

    @Override
    public void affecterVmuser(int idvm, int iduser) {
        VirtualMachine vm =virtualMachineRepo.findById(idvm).orElse(null);
        Utilisateur usr = utilisateurRepo.findById(iduser).orElse(null);
        usr.getVms().add(vm);

        utilisateurRepo.save(usr);
    }

    @Transactional
    @Override
    public void affecterVm(int idvm) {
        VirtualMachine vm = virtualMachineRepo.findById(idvm).orElse(null);
        for (Datacenter datacenter:datacenterRepo.findAll()){
            if (datacenter.getEspaceLibreDisque() > vm.getTailleDisque()){
                int newEspaceLibre = datacenter.getEspaceLibreDisque() -vm.getTailleDisque();
                datacenter.setEspaceLibreDisque(newEspaceLibre);
                vm.setDataCenter(datacenter);
            }
        }
    }

    @Override
    public void demarrerInstanceUser(int idvm) {
        VirtualMachine virtualMachine =virtualMachineRepo.findById(idvm).orElse(null);
        virtualMachine.setEtat(Etat.RUNNING);
        virtualMachineRepo.save(virtualMachine);
    }

    @Override
    public void arreterInstanceUser(int idvm) {
        VirtualMachine vm = virtualMachineRepo.findById(idvm).orElse(null);
        vm.setEtat(Etat.STOPPED);
        virtualMachineRepo.save(vm);
    }

    @Override
    public List<Datacenter> listerDatacenter(){return datacenterRepo.listerDataCenters();}

    @Scheduled(cron = "*/10 * * * * *")
    public void getDataCenters(){
        for (Datacenter datacenter:listerDatacenter()){
            log.info("Data Center : "+datacenter.getRegion());
            for (VirtualMachine vm:datacenter.getVms()){
                log.info("OS :"+vm.getOs());
            }
        }
    }
}
