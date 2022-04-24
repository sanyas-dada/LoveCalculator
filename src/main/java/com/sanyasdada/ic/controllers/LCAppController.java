package com.sanyasdada.ic.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanyasdad.ic.dto.UserInfoDTO;
import com.sanyasdada.ic.service.LCAppService;

@Controller
@SessionAttributes({"userInfo"})
public class LCAppController {

	@Autowired
	private LCAppService lcappService;

	@RequestMapping("/")
	public String showHomePage(Model model) {

		model.addAttribute("userInfo", new UserInfoDTO());

		/*
		 * Cookie[] cookies = request.getCookies(); for(Cookie temp : cookies) {
		 * 
		 * if("lcApp.userName".equals(temp.getName())) {
		 * 
		 * String myUserName = temp.getValue(); userInfodto.setUserName(myUserName); }
		 * 
		 * }
		 */
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String showResultPage(Model model, @Valid UserInfoDTO userInfoDTO, BindingResult result) {
		model.addAttribute("userInfo", userInfoDTO);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfo", result);
		System.out.println(userInfoDTO.isTermAndCondition());
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			return "home-page";

		}

		String appResult = lcappService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		userInfoDTO.setResult(appResult);

		return "result-page";

	}

}
