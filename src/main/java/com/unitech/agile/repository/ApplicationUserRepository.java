package com.unitech.agile.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitech.agile.entity.ApplicationUser;

@Repository
@Transactional
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

	@Query("SELECT u FROM ApplicationUser u WHERE u.login = :login AND u.password = :password")
    ApplicationUser findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
	
	@Query("SELECT u FROM ApplicationUser u WHERE u.login = :login")
    ApplicationUser findByLogin(@Param("login") String login);

	@Query("SELECT u FROM ApplicationUser u WHERE u.id = :id")
    ApplicationUser findById(@Param("id") int id);
}
