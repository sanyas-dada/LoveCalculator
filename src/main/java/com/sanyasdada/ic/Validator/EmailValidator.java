package com.sanyasdada.ic.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sanyasdad.ic.dto.UserRegistrationDTO;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		
		// wheather the email is ending with sanyasdada.com
		 
		String email = ((UserRegistrationDTO)target).getCommunicationDTO().getEmail();
		if(email.contains("sanyasdada.com")) {
			errors.rejectValue("communicationDTO.email", "email.invalidDomain");
		}
			
		
	}

}
