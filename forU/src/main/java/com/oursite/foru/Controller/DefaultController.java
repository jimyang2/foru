
package com.oursite.foru.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.oursite.foru.Domain.Preference;
import com.oursite.foru.Domain.Questions;
import com.oursite.foru.Domain.U;
import com.oursite.foru.Domain.UForm;
import com.oursite.foru.Service.PreferenceService;
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
	private final PreferenceService preferenceService;

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
		System.out.println(number);
		
		HttpSession session = request.getSession(false);
		String sessionName = (String) session.getAttribute("sessionName");
		model.addAttribute("sessionName", sessionName);

		Questions q = this.questionsService.getQuestionbyNumber(number);
		model.addAttribute("question",q);
		
		List<Questions> a = this.questionsService.getAnswerListbyNumber(number);
		model.addAttribute("answer", a);
		
		
		return "page";
	}	

	@PostMapping("/foru/page/{number}")
	public String setTest(HttpServletRequest request,@PathVariable("number") int number) {
		System.out.println("dkssud");
		System.out.println(number);
		
		// 세션으로 U 검색
		HttpSession session = request.getSession(false);
		String sessionName = (String) session.getAttribute("sessionName");
	    U u = new U();
	    u = this.uService.findU(sessionName);
	    
		Questions answerresult = this.questionsService.getAnswer(number,request.getParameter("answer"));
	    this.preferenceService.create(u, answerresult);
	    
	    // 다음 페이지로 이동
	    if (number == 3) {
	    	System.out.println("마지막페이지로");
	    	return "redirect:/foru/result";
	    }
	    
	    number = number + 1;
	    
		return "redirect:/foru/page/"+String.valueOf(number);
	}	
	


	
	@GetMapping("foru/result")
	public String Last(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String sessionName = (String) session.getAttribute("sessionName");
	    U u = new U();
	    u = this.uService.findU(sessionName);
	    
	    List<Preference> resultList = new ArrayList<>();
	    resultList = this.preferenceService.showResult(u);

	    // 점수
	    Stream<Preference> preferenceStream = resultList.stream();
	    DoubleStream scoreStream = preferenceStream.mapToDouble(preference -> Double.parseDouble(preference.getScore()));
	    double sum1 = scoreStream.sum();
	    model.addAttribute("result", sum1);
	    System.out.println(sum1);
	    
	    // 답변리스트
	    
	    List<Preference> result = this.preferenceService.showResult(u);
	    List<Questions> answer = this.questionsService.getAllAnswer("1");
	   
	    model.addAttribute("result", result);
	    model.addAttribute("answer", answer);
	    
	    // 그냥 테스트 겸
//	    for(Preference p : ResultAndAnswer) {
//	    	System.out.println(p.getId()+"\t"+p.getUser()+"\t"+p.getQnum()+"\t"+p.getAnswer()
//	    	+"\t"+p.getScore()+"\t\t"+p.getClass().getName());  // 모르겠음 Join 해서 Questions을 어케가져오는지 ㅠ
//	    	System.out.println("안녕");
//	    }
	    
	    model.addAttribute("test",result);
	    
	    System.out.println("왜안돼");
		return "result";
	}
	
	
}

