package com.namoo.cookbook.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.namoo.cookbook.domain.ImageFile;
import com.namoo.cookbook.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-test.xml"})
public class RecipeDaoTest {
	//
	@Autowired
	private RecipeDao dao;
	
	@Test
	public void testReadAllRecipes() {
		//
		List<Recipe> recipes  = dao.readAllRecipes();
		assertThat(recipes.size(), is(2));
		Recipe recipe = recipes.get(0);
		assertThat(recipe.getName(), is("김치찌개"));
	}

	@Test
	public void testReadRecipe() {
		//
		Recipe recipe = dao.readRecipe("된장찌개");
		
		assertThat(recipe.getName(), is("된장찌개"));
		assertThat(recipe.getIngredients(), is("된장, 돼지고기, 양파, 마늘"));
	}

	@Test
	public void testInsertRecipe() {
		//
		String recipeName = "마르게리따 피자";
		String ingredients = "치즈, 밀가루, 토마토, 마늘";
		String procedure = "1. 오븐에 굽는다.";
		ImageFile recipeImage = new ImageFile("image/jpg", "20140417171110123.jpg");
		
		Recipe recipe = new Recipe(recipeName, ingredients, procedure);
		recipe.setRecipeImage(recipeImage);
		dao.insertRecipe(recipe);
		
		//assertion
		recipe = dao.readRecipe(recipeName);
		assertThat(recipe.getName(), is(recipeName));
		assertThat(recipe.getIngredients(), is(ingredients));
		assertThat(recipe.getProcedure(), is(procedure));
		
		recipeImage = recipe.getRecipeImage();
		assertThat(recipeImage.getContentType(), is("image/jpg"));
		assertThat(recipeImage.getFileName(), is("20140417171110123.jpg"));
	}

	@Test
	public void testUpdateRecipe() {
		//
		Recipe recipe = dao.readRecipe("김치찌개");
		recipe.setIngredients("중국산 김치, 호주산 돼지고기, MSG");
		dao.updateRecipe(recipe);
		
		//assertion
		recipe = dao.readRecipe("김치찌개");
		assertThat(recipe.getIngredients(), is("중국산 김치, 호주산 돼지고기, MSG"));
	}

	@Test
	public void testDeleteRecipe() {
		//
		dao.deleteRecipe("된장찌개");
		
		//assertion
		assertNull(dao.readRecipe("된장찌개"));
	}

}
