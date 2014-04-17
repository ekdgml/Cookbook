package com.namoo.cookbook.domain;

import java.util.ArrayList;
import java.util.List;

public class Cookbook {
	//
	private String name;
	private String writer;
	private List<Recipe> recipes;

	//--------------------------------------------------------------------------
	// constructor
	
	public Cookbook() {
		//
	}
	
	public Cookbook(String name, String writer) {
		//
		this.name = name;
		this.writer = writer;
	}
	
	//--------------------------------------------------------------------------
	// methods
	
	public void addRecipe(Recipe recipe) {
		//
		if (this.recipes == null) {
			this.recipes = new ArrayList<Recipe>();
		}
		this.recipes.add(recipe);
	}

	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
}
