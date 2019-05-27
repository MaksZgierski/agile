package com.unitech.agile.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.Media;

@Repository
@Transactional
public interface MediaRepository extends JpaRepository<Media, Integer> {

	@Query("SELECT m FROM Media m WHERE m.place.id = :placeId")
	List<Media> findByPlaceId(@Param("placeId") int placeId);
}
