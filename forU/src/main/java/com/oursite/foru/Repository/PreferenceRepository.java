package com.oursite.foru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oursite.foru.Domain.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Integer>{
	

}
