package cookbook.step5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pizzaRecipe")
public class Pizza implements Recipe{
	//
	private String name;
	
	@Autowired
	public Pizza(@Value("페퍼로니 피자") String name) {
		//
		this.name = name;
	}
	
	@Override
	public String[] ingredients() {
		//
		return new String[] {"피자도우", "토마토소스", "페퍼로니", "기타토핑", "치즈"};
	}

	@Override
	public String[] recipe() {
		//
		return new String[] {
				"1. 오븐에 구워요"
		};
	}

	@Override
	public String getRecipeName() {
		//
		return name;
	}

}
