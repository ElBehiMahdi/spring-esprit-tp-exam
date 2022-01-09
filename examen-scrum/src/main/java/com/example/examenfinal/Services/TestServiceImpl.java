package com.example.examenfinal.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@Slf4j
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

    /*
    public void getDataCenters(){
        for (Datacenter datacenter:listerDatacenter()){
            log.info("Data Center : "+datacenter.getRegion());
            for (VirtualMachine vm:datacenter.getVms()){
                log.info("OS :"+vm.getOs());
            }
        }
    }

     */

    //
    /*

    public Integer getFormateurRenumerationByDate(Integer idFormateur, Date dateDebut, Date dateFin){
        int solde=0;
        Formateur formateur = this.formateurRepository.findById(idFormateur).orElse(null);

        if(formateur != null){
            for(Formation formation:formateur.getFormations()){
                if(formation.getDateDebut().after(dateDebut)&&formation.getDateFin().before(dateFin)){
                    solde+=formateur.getTarifHoraire()*formation.getNbrHeures();
                }
        }
        return solde;
    }
     */

    // 0 * * * *	every hour
	// */15 * * * *	every 15 mins
	// 0 */2 * * *	every 2 hours
	// 0 18 * * 0-6	every week Mon-Sat at 6pm
	// 10 2 * * 6,7	every Sat and Sun on 2:10am
	// 0 0 * * 0	every Sunday midnight

	// *	all values
	// ,	separate individual values
	// -	a range of values
	// /	divide a value into steps

    //@Scheduled(cron = "*/30 * * * * *")
    /*
    public void getNbrApprenantByFormation() {
        for(Formation formation :this.formationRepository.findAll())
        {
            log.info("formation  : "+formation.getTitre()+" "+ formation.getApprenants().size());

        }
    }
     */

}
