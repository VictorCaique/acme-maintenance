package com.acme.maintenance.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acme.maintenance.model.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Integer> {
	List<Manutencao> findByDataGreaterThan(Date date);
	List<Manutencao> findByData(Date date);
	List<Manutencao> findByMotivoManutencao(String motivo);
	@Query(value = "SELECT * FROM `manutencao` WHERE (`data` = ?) OR (`aviao_id` = ?) OR (`motivo_manutencao` LIKE '%?%') OR (`numero_manutencao` LIKE '%?%')", nativeQuery = true)
	List<Manutencao> findManutencoesPrint(Date date, int aviaoId, String motivo, int numMan);
}
