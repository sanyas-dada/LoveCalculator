package com.sanyasdada.ic.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanyasdad.ic.dto.CommunicationDTO;
import com.sanyasdad.ic.dto.Phone;
import com.sanyasdad.ic.dto.UserRegistrationDTO;
import com.sanyasdada.ic.Validator.EmailValidator;
import com.sanyasdada.ic.Validator.UserNameValidator;
import com.sanyasdada.ic.propertyeditor.NamePropertyEditor;

@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO dto) {

		/*
		 * dto.setName("Kaushiladidi"); dto.setUserName("sanyasdada");
		 * 
		 * 
		 */
		System.out.println("inside showREgistrationPage method");

		// load the saved user data from the database

		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("1234736363");

		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);

		dto.setCommunicationDTO(communicationDTO);
		return "user-registration-page";
	}

	@RequestMapping("/registration-success")
	public String processUserReg(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto, BindingResult result) {
		System.out.println("Name value enetered by the user is:" + "|" + dto.getName() + "|");

		if (result.hasErrors()) {
			System.out.println("My page has errors");
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "user-registration-page";
		}
		System.out.println("inside processUSerRegister method");

		// save the dto object in to our database

		return "registration-success";

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside the inint binnder method");
		// binder.setDisallowedFields("name");
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);

		NamePropertyEditor nameEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", nameEditor);

		// binder.registerCustomEditor(String.class, nameEditor);

		// for userName
		UserNameValidator validators = new UserNameValidator();
		binder.addValidators(validators);
		
		binder.addValidators(new EmailValidator());
	}

}
