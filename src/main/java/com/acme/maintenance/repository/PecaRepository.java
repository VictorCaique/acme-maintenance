package com.acme.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.maintenance.model.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Integer>{

}
