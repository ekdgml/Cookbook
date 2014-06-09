package cookbook.step5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cookbook.step5.printer.Printer;

@Component
public class Chef {
	//
	@Autowired
	@Qualifier("donjangRecipe")
	private Recipe recipe;
	
	@Autowired
	@Qualifier("htmlPrinter")
	private Printer printer;
	
	public Chef() {
		//
	}
	
	public void sayIngredients() {
		//
		System.out.println("요리명 : " + recipe.getRecipeName());
		printer.print(recipe.ingredients());
	}
	
	public void sayRecipe() {
		//
		System.out.println("요리명 : " + recipe.getRecipeName());
		printer.print(recipe.recipe());
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
}
