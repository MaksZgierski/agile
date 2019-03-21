package com.unitech.agile.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.PlaceType;

@Repository
@Transactional
public interface PlaceTypeRepository extends JpaRepository<PlaceType, Integer> {

	@Query("SELECT pt FROM PlaceType pt WHERE pt.active = TRUE")
	List<PlaceType> findAllValid();
}
