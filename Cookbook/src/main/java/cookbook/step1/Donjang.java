package cookbook.step1;

public class Donjang implements Recipe{
	//
	@Override
	public String[] ingredients() {
		//
		return new String[] {"된장","두부","감자","마늘","대파"};
	}

	@Override
	public String[] recipe() {
		//
		return new String[] {
				"1. 육수를 끓인다.",
				"2. 된장을 육수에 넣는다.",
				"3. 다른 거 다 넣고 끓인다."
				};
	}

}
