package printer;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloTest {

	@Test
	public void testSayHello() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext("printer");
		
		Hello hello = ac.getBean("hello", Hello.class);
		hello.setName("홍길동");
		hello.sayHello();
	}
	
	@Test
	public void testScope() {
		//
		ApplicationContext ac = new AnnotationConfigApplicationContext("printer");
		
		Hello hello = ac.getBean("hello", Hello.class);
		Hello hello2 = ac.getBean("hello", Hello.class);
		
		assertThat(hello, is(not(sameInstance(hello2))));
	}

}
