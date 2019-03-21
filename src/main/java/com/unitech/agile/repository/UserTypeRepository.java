package com.unitech.agile.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.UserType;

@Repository
@Transactional
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

	@Query("SELECT ut FROM UserType ut WHERE ut.id = :id")
    UserType findById(@Param("id") int id);
}