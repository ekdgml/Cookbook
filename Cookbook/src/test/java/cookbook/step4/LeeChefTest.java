package cookbook.step4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LeeChefTest {

	@Test
	public void test() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext("cookbook.step4");
		
		LeeChef leechef = ac.getBean("leeChef", LeeChef.class);   //class명에서 첫글자만 소문자!
		leechef.sayRecipe();
	}

}
