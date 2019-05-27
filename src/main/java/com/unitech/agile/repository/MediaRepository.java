package com.unitech.agile.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.Media;

@Repository
@Transactional
public interface MediaRepository extends JpaRepository<Media, Integer> {

}
