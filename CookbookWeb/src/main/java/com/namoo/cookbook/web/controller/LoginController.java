package com.namoo.cookbook.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.namoo.cookbook.web.session.SessionManager;

@Controller
@RequestMapping(value="/login")
public class LoginController{
	//
	
	@RequestMapping(method=RequestMethod.GET)
	public String login() {
		//
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, @RequestParam("userId")String userId, @RequestParam("password")String password) {
		//
		SessionManager manager = new SessionManager(req);
		if (manager.login(userId, password)) {
			return new ModelAndView(new RedirectView("/main", true));  //true로 주면 앞에 contextpath가 저절로 붙어서 나옴!
		} else {
			return new ModelAndView("login");
		}
	}
}
