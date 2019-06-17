package com.unitech.agile.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.Opinion;

@Repository
@Transactional
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {

	@Query("SELECT o FROM Opinion o WHERE o.place.id = :placeId")
	List<Opinion> findByPlaceId(@Param("placeId") int placeId);

	@Query("SELECT o FROM Opinion o WHERE o.id = :id")
	Opinion findById(@Param("id") int id);
}
