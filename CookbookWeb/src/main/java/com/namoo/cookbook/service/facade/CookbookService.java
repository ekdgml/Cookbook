package com.namoo.cookbook.service.facade;

import com.namoo.cookbook.domain.Cookbook;
import com.namoo.cookbook.domain.Recipe;

public interface CookbookService {
	//
	/**
	 * 요리책을 조회한다.
	 * 
	 * @return {@link Cookbook}
	 */
	Cookbook getCookbook();
	
	/**
	 * 조리법을 등록한다.
	 * 
	 * @param recipe 조리법
	 */
	void registerRecipe(Recipe recipe);
	
	/**
	 * 조리법을 수정한다.
	 * 
	 * @param recipe 조리법
	 */
	void modifyRecipe(Recipe recipe);
	
	/**
	 * 조리법을 삭제한다.
	 * 
	 * @param recipeName 조리명
	 */
	void removeRecipe(String recipeName);
	
	/**
	 * 조리명으로 조리법을 조회한다.
	 * 
	 * @param recipeName 조리명
	 * @return {@link Recipe} 조리법
	 */
	Recipe getRecipe(String recipeName);
}
