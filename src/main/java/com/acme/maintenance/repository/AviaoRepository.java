package com.acme.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.maintenance.model.Aviao;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Integer> {
	Aviao findBynserie(int nserie);
}
