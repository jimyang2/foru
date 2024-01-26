package com.oursite.foru.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.oursite.foru.Service.PreferenceService;
import com.oursite.foru.Service.QuestionsService;
import com.oursite.foru.Service.UService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestController {
	
	@GetMapping("/fadeintest")
	public String main() {
		return "fadeintest";
	}
}
