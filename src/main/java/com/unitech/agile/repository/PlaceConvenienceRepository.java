package com.unitech.agile.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.PlaceConvenience;

@Repository
@Transactional
public interface PlaceConvenienceRepository extends JpaRepository<PlaceConvenience, Integer> {

	@Query("SELECT pc FROM PlaceConvenience pc WHERE pc.active = TRUE AND pc.place.id = :placeId")
	List<PlaceConvenience> findByPlaceId(@Param("placeId") int placeId);
}
