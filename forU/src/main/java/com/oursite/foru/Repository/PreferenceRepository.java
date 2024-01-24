package com.oursite.foru.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oursite.foru.Domain.Preference;
import com.oursite.foru.Domain.U;

public interface PreferenceRepository extends JpaRepository<Preference, Integer>{
	
	List<Preference> findByUserOrderByQnum(U u);
	
	
	// 그냥 테스트겸 
	@Query("SELECT p FROM Preference p INNER JOIN Questions q ON p.qnum = q.number and p.answer = q.question WHERE p.user = ?1")
	List<Preference> findByUser(U u);
}
