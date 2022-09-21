package com.company.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView loginPage() {
	
		ModelAndView mv = new ModelAndView("login.jsp");
		return mv;
	}
	
	

	/*@RequestMapping("/logout-success")
	public ModelAndView logoutPage() {
		ModelAndView mv = new ModelAndView("logout.jsp");
		return mv;}*/
	
}
