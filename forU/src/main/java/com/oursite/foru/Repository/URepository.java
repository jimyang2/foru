package com.oursite.foru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oursite.foru.Domain.Questions;
import com.oursite.foru.Domain.U;

public interface URepository extends JpaRepository<U, Integer>{
	
	
	@Query("SELECT u FROM U u WHERE u.name = ?1 and u.id= (Select max(emp.id) From U emp) ")
	U findByName(String name);
}
