package com.namoo.cookbook.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.namoo.cookbook.domain.Cookbook;
import com.namoo.cookbook.domain.Recipe;
import com.namoo.cookbook.service.facade.CookbookService;

/**
 * 요리책 컨트롤러
 * 
 * @author HaroldKim
 */
@Controller
public class CookbookController {
	
	@Autowired
	private CookbookService cookbookService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView cookbook() {
		//
		Cookbook cookbook = cookbookService.getCookbook();
		return new ModelAndView("cookbook", "cookbook", cookbook);
	}
	
	@RequestMapping(value = "/recipe/{recipeName}", method = RequestMethod.GET)
	public ModelAndView recipe(@PathVariable("recipeName") String recipeName) {
		//
		Recipe recipe = cookbookService.getRecipe(recipeName);
		return new ModelAndView("recipe", "recipe", recipe);
	}
	
	@RequestMapping(value = "/recipe/add", method = RequestMethod.GET)
	public String addRecipe() {
		return "register";
	}
	
	@RequestMapping(value = "/recipe/add", method = RequestMethod.POST)
	public View addRecipe(Recipe recipe) {
		//
		cookbookService.registerRecipe(recipe);
		return new RedirectView("/main", true);
	}
}
