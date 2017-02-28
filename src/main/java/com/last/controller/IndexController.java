package com.last.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("")
	public String welcome(Model model) {
		System.out.println("welcomedd");
		model.addAttribute("plouf", "youloupddsdsddlouf");
		return "index";
	}
	
	@RequestMapping("/seconde")
	public String seconde(Model model){
		return "second";
	}


}
