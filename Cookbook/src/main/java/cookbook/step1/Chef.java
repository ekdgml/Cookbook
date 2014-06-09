package cookbook.step1;

public class Chef {
	//
	private Recipe recipe;
	
	public Chef() {
		//
		// recipe = new Gimchi();
		recipe = new Donjang();
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
}
