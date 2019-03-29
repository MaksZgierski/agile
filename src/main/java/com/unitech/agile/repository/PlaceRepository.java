package com.unitech.agile.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.Place;

@Repository
@Transactional
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	@Query("SELECT p FROM Place p WHERE p.active = TRUE")
	List<Place> findAllValid();
	
	@Query("SELECT p FROM Place p WHERE p.id = :id")
	Place findById(@Param("id") int id);
}
