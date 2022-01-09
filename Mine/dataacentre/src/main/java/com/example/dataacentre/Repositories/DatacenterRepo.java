package com.example.dataacentre.Repositories;

import com.example.dataacentre.Entities.Datacenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DatacenterRepo extends JpaRepository<Datacenter,Integer> {

    @Query("select dc from Datacenter dc where dc.dateFabriquation > '2019-11-01'")
    List<Datacenter> listerDataCenters();
}
