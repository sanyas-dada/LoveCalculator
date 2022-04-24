package com.sanyasdada.ic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sanyasdad.ic.dto.EmailDTO;
import com.sanyasdad.ic.dto.UserInfoDTO;
import com.sanyasdada.ic.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {

    @Autowired
	private LCAppEmailServiceImpl lcAppEmailService;
	

	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {

		// @ModelAttribute("emailDTO") EmailDTO emailDTO,replacing this code into below
		//
		model.addAttribute("emailDTO", new EmailDTO());
		// model.addAttribute("userName", userName.toUpperCase());

		return "send-email-page";

	}

	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO,
			@ModelAttribute("emailDTO") EmailDTO emailDTO) {

		// calling the sendEmail method
		lcAppEmailService.sendEmail(userInfoDTO.getUserName(), emailDTO.getUserEmail(), userInfoDTO.getResult());

		return "process-email-page";
	}

}
