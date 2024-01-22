package com.oursite.foru.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oursite.foru.Domain.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
		Questions findByNumber(int number);
		Questions findByNumberAndQA(int number,String QA);
		Questions findByNumberAndQAAndAnum(int number, String QA, String Anum);
		List<Questions> findByQAAndNumberOrderById(String QA,int number);
		
}
