package com.oursite.foru.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oursite.foru.Domain.Preference;
import com.oursite.foru.Domain.U;

public interface PreferenceRepository extends JpaRepository<Preference, Integer>{
	
	List<Preference> findByUserOrderByQnum(U u);
}
