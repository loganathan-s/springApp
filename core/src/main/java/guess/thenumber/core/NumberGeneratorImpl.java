package guess.thenumber.core;

import java.util.Random;

//  XMl way (bean.xml)
//<bean id="numberGenerator" class="guess.thenumber.NumberGeneratorImpl"/>

// == Annotation way
//@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator {

	//== fields ==
  private final Random random = new Random();

  private int maxNumber = 100;

  //== public methods ==
	@Override
	public int next () {
		return random.nextInt(maxNumber);
	}

	@Override
	public int getMaxNumber () {
		return maxNumber;
	}

}
