package com.oursite.foru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oursite.foru.Domain.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
		Questions findByNumber(int number);
}
