package com.oursite.foru.Domain;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UForm {
	
	@NotEmpty(message = "사용자ID는 필수항목입니다.")
	private String nickname;
	
	private int number;
}
