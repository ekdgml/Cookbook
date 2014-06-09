package cookbook.step4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("gimchiRecipe")
public class Gimchi implements Recipe{
	//
	@Value("김치찌개")
	private String name;
	
	@Override
	public String[] ingredients() {
		//
		return new String[] {"김치", "돼지고기", "양파", "대파", "두부"};
	}
	
	@Override
	public String[] recipe() {
		//
		return new String[] {
				"1. 김치를 볶는다.", 
				"2. 돼지고기를 볶는다.",
				"3. 다 넣고 끓인다."
		};
	}

	@Override
	public String getRecipeName() {
		//
		return name;
	}
}
