package com.acme.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.acme.maintenance.model.Tecnico;

@Service
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
