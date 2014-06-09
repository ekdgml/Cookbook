package cookbook.step2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ChefTest {

	@Test
	public void test() {
		//
		GenericApplicationContext ac = new GenericXmlApplicationContext("classpath:Step2_ApplicationContext.xml");
		
		//Chef chef = (Chef) ac.getBean("chef");
		Chef chef = ac.getBean("chef", Chef.class);
		chef.sayRecipe();
		ac.destroy();
		
	}
	
	@Test
	public void test2() {
		//
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:Step2_ApplicationContext.xml");
		
		Chef chef = ac.getBean("chef2", Chef.class);
		chef.sayRecipe();
		
		//
		Recipe gimchiRecipe = ac.getBean("gimchiRecipe", Recipe.class);
		for (String ingredient : gimchiRecipe.ingredients()) {
			System.out.println(ingredient);
		}
	}
	
	@Test
	public void test3() {
		//
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:Step2_ApplicationContext.xml");
		
		Chef chef = ac.getBean("chef3", Chef.class);
		chef.sayRecipe();
	}
	
	@Test
	public void testScope() {
		//
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:Step2_ApplicationContext.xml");
		
		Chef chef = ac.getBean("chef", Chef.class);
		Chef chef2 = ac.getBean("chef", Chef.class);
		
		assertTrue(chef == chef2);
		
		assertThat(chef, is(sameInstance(chef2)));
	}

}
