package com.unitech.agile.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.Convenience;

@Repository
@Transactional
public interface ConvenienceRepository extends JpaRepository<Convenience, Integer> {

	@Query("SELECT c FROM Convenience c WHERE c.active = TRUE")
	List<Convenience> findAllValid();
	
	@Query("SELECT c FROM Convenience c WHERE c.id = :id")
	Convenience findById(@Param("id") int id);
}
