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
		
//		Questions qq = new Questions();
//		qq.setNumber(1);
//		qq.setQuestion("가장 좋아하는 과일은 무엇입니까? 1");
//		qq.setQorA("Q");
//		
//		this.questionsRepository.save(qq);
//		
//		Questions q = new Questions();
//		q.setNumber(1);
//		q.setQuestion("사과");
//		q.setQorA("A");
//		q.setAnum("1");
//		this.questionsRepository.save(q);
//		
//		Questions q2 = new Questions();
//		q2.setNumber(1);
//		q2.setQuestion("메론");
//		q2.setQorA("A");
//		q2.setAnum("2");
//		this.questionsRepository.save(q2);
//		
//		Questions q3 = new Questions();
//		q3.setNumber(1);
//		q3.setQuestion("귤");
//		q3.setQorA("A");
//		q3.setAnum("3");
//		this.questionsRepository.save(q3);	
//		
//		Questions q4 = new Questions();
//		q4.setNumber(1);
//		q4.setQuestion("딸기");
//		q4.setQorA("A");
//		q4.setAnum("4");
//		this.questionsRepository.save(q4);		
		
	}

}
