package com.unitech.agile.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.UserSession;

@Repository
@Transactional
public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {

	@Query("SELECT us FROM UserSession us WHERE us.token = :token")
	UserSession findByToken(@Param("token") String token, Sort sort);
}
