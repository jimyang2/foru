package com.oursite.foru;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oursite.foru.Domain.*;
import com.oursite.foru.Repository.*;

@SpringBootTest
class ForUApplicationTests {


	@Autowired
	private QuestionsRepository questionsRepository;
	
	@Test
	void testJPA() {
		
		Questions q = new Questions();
		q.setNumber(3);
		q.setQuestion("좋아하는 동물은 무엇입니까?");
		this.questionsRepository.save(q);
		
	}

}
