package cookbook.step3;

public class Chef {
	//
	private Recipe recipe;
	
	public Chef() {
		//
	}
	
	public void sayIngredients() {
		//
		StringBuffer sb = new StringBuffer();
		for (String ingredient : recipe.ingredients()) {
			sb.append(ingredient);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public void sayRecipe() {
		//
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
