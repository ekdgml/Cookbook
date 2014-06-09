package cookbook.step4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChefTest {

	@Test
	public void test() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext("cookbook.step4");
		
		Chef chef = ac.getBean("chef", Chef.class);
		chef.sayRecipe();
	}
}
