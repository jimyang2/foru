package com.oursite.foru.Service;

import org.springframework.stereotype.Service;

import com.oursite.foru.Domain.Questions;
import com.oursite.foru.Repository.QuestionsRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuestionsService {
	
	private final QuestionsRepository questionsRepository;
	
	public Questions getQuestionbyNumber(int number) {
		return this.questionsRepository.findByNumber(number);
		
	}
}
