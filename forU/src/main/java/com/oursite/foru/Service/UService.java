package com.oursite.foru.Service;

import org.springframework.stereotype.Service;

import com.oursite.foru.Domain.U;
import com.oursite.foru.Repository.URepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UService {
	
	private final URepository uRepository;

    public void create(String nickname) {
    	U u = new U();
    	u.setName(nickname);
    	this.uRepository.save(u);
    	
    }
    
    public U findU(String name) {
    	U u = new U();
    	u = uRepository.findByName(name);
    	
    	return u;
    }
    
}
