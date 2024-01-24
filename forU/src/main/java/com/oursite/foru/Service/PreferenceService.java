
package com.oursite.foru.Service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.oursite.foru.Domain.Preference;
import com.oursite.foru.Domain.Questions;
import com.oursite.foru.Domain.U;
import com.oursite.foru.Repository.PreferenceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PreferenceService {

	private final PreferenceRepository preferenceRepository;
	
	public void create(U u, Questions q ) {
		Preference p = new Preference();
		
		p.setUser(u);
		p.setQnum(q.getNumber());
		p.setAnswer(q.getQuestion());
		p.setScore(q.getScore());
		
		this.preferenceRepository.save(p); 
	}
	
	public List<Preference> showResult(U user) {
		U u = new U();
		u = user;
		
		
		return this.preferenceRepository.findByUserOrderByQnum(u);
	}
	
	// 그냥 테스트겸
	public List<Preference> showResultAndAnswer(U user) {
		
		return this.preferenceRepository.findByUser(user);
	}
	
}
