package com.oursite.foru.Service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.oursite.foru.Domain.Preference;
import com.oursite.foru.Domain.U;
import com.oursite.foru.Repository.PreferenceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PreferenceService {

	private final PreferenceRepository preferenceRepository;
	
	public void create(U u, int qnum, String answer ) {
		Preference p = new Preference();
		
		p.setUser(u);
		p.setQnum(qnum);
		p.setAnswer(answer);
		
		this.preferenceRepository.save(p); 
	}
	
	public String showResult(U user) {
		U u = new U();
		u = user;
		
		List<Preference> answerList = this.preferenceRepository.findByUserOrderByQnum(u);
		
		
		
	
		
		return "입력하시에";
	}
	
	
}
