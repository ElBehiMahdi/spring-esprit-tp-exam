package com.example.dataacentre.Repositories;

import com.example.dataacentre.Entities.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualMachineRepo extends JpaRepository<VirtualMachine, Integer> {
}
