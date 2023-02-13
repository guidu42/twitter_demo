package com.hb.guillaume_jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hb.guillaume_jason.dto.TwitterUserDTO;
import com.hb.guillaume_jason.dto.TwitterUserFormDTO;
import com.hb.guillaume_jason.service.TwitterUserService;

import jakarta.validation.Valid;

@Controller
public class TwitterUserController {

	private TwitterUserService userService;

	public TwitterUserController(TwitterUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public ModelAndView getRegistrationForm() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new TwitterUserDTO("", "", null));
		return mav;
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") TwitterUserFormDTO user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		userService.saveUser(user);
		return "redirect:/login";
	}

}