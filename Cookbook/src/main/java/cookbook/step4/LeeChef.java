package cookbook.step4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LeeChef {
	//
	private Recipe recipe;
	
	public LeeChef() {
		//
	}
	
	@Autowired
	public LeeChef(@Qualifier("pizzaRecipe") Recipe recipe) {
		//
		this.recipe = recipe;
	}
	
	public void sayIngredients() {
		//
		System.out.println("요리명 : " + recipe.getRecipeName());

		StringBuffer sb = new StringBuffer();
		for (String ingredient : recipe.ingredients()) {
			sb.append(ingredient);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public void sayRecipe() {
		//
		System.out.println("요리명 : " + recipe.getRecipeName());

		StringBuffer sb = new StringBuffer();
		for (String step : recipe.recipe()) {
			sb.append(step);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
