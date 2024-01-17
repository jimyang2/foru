package com.oursite.foru.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oursite.foru.Domain.Preference;
import com.oursite.foru.Domain.Questions;
import com.oursite.foru.Domain.UForm;
import com.oursite.foru.Service.QuestionsService;
import com.oursite.foru.Service.UService;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DefaultController {

	private final UService uService;
	private final QuestionsService questionsService;

	@GetMapping("/foru/main")
	public String main() {
		return "main";
	}

	@GetMapping("/")
	public String root() {
		return "redirect:/foru/main";
	}

	@GetMapping("/foru/nickname")
	public String setNickname(UForm uForm) {
		return "nickname";
	}
	
	// 나중에 삭제하세요 (+수정)
	@PostMapping("/foru/page/{number}")
	public String setTest(HttpServletRequest request) {
		System.out.println("dkssud");
		
		int num = Integer.parseInt(request.getParameter("qnum"))+1;
		
	    System.out.println(request.getParameter("answer"));	
	    System.out.println(request.getParameter("qnum"));	
	    
	    
	    
	    
		return "redirect:/foru/page/"+String.valueOf(num);
	}	
	

	@PostMapping("/foru/nickname")
	public String goFirstpage(@Valid UForm uForm, BindingResult bindingResult, HttpServletRequest request) {
		this.uService.create(uForm.getNickname());

		HttpSession session = request.getSession();
		session.setAttribute("sessionName", uForm.getNickname());

		return "redirect:/foru/page/1";
	}

	@GetMapping("/foru/page/{number}")
	public String getPage1(Model model, HttpServletRequest request, @PathVariable("number") int number) {
		System.out.println("들어왔엉");
		HttpSession session = request.getSession(false);
		String sessionName = (String) session.getAttribute("sessionName");
		model.addAttribute("sessionName", sessionName);

		Questions q = this.questionsService.getQuestionbyNumber(number);
		model.addAttribute("question",q);
		
		
		return "page";
	}

}
