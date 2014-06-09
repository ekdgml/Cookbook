package cookbook.step2_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CookbookTest {

	@Test
	public void test() {
		//
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:Step2_1_ApplicationContext.xml");
		
		Cookbook cookbook = ac.getBean("cookbook", Cookbook.class);
		
		assertThat("정효진", is(cookbook.getWriter()));
		assertThat(cookbook.getChapters().size(), is(4));
		assertThat(cookbook.getChapters().get(3), is("양념치킨"));
		
		Recipe recipe = cookbook.findRecipeByName("양념치킨");
		assertThat(recipe.getRecipeName(), is("양념치킨"));
	}

}
