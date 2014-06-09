package store;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CookbookDataSourceTest {

	@Test
	public void test() {
		//
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:DataSourceApplicationContext.xml");
		
		CookbookDataSource dataSource = ac.getBean("dataSource", CookbookDataSource.class);
		
		assertThat(dataSource.getDriver(), is("org.mariadb.jdbc.Driver"));
		assertThat(dataSource.getUsername(), is("namoouser"));
		assertThat(dataSource.getPassword(), is("namoouser"));
		assertThat(dataSource.getUrl(), is("jdbc:mariadb://localhost:3306/cookbookdb"));
	}
	
	@Test
	public void test2() {
		//
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:DataSourceApplicationContext.xml");
		
		CookbookDataSource dataSource = ac.getBean("dataSource2", CookbookDataSource.class);
		
		assertThat(dataSource.getDriver(), is("org.mariadb.jdbc.Driver"));
		assertThat(dataSource.getUsername(), is("namoouser"));
		assertThat(dataSource.getPassword(), is("namoouser"));
		assertThat(dataSource.getUrl(), is("jdbc:mariadb://localhost:3306/cookbookdb"));
	}

}
