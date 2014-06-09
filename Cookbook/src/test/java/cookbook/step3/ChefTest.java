package cookbook.step3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChefTest {

	@Test
	public void test() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext("cookbook.step3");
		
		Chef chef = ac.getBean("chef", Chef.class);
		chef.sayRecipe();
	}
	
	@Test
	public void test_2() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext("cookbook.step3");
		
		Chef chef = ac.getBean("chef2", Chef.class);
		chef.sayRecipe();
	}
	
	@Test
	public void test2() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext(ChefConfig.class);
		
		Chef chef = ac.getBean("chef", Chef.class);
		chef.sayRecipe();
	}

}
