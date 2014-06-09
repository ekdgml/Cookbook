package cookbook.step3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChefConfig {
	//
	@Bean
	public Chef chef() {
		//
		Chef chef = new Chef();
		chef.setRecipe(recipe());
		return chef;
	}
	
	@Bean
	public Chef chef2() {
		//
		Chef chef = new Chef();
		chef.setRecipe(recipe2());
		return chef;
	}
	
	@Bean
	public Recipe recipe() {
		//
		return new Gimchi();
	}
	
	@Bean
	public Recipe recipe2() {
		//
		return new Donjang();
	}
}
