package guess.thenumber.core.config;

import guess.thenumber.core.GuessCount;
import guess.thenumber.core.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
	private int maxNumber = 50;

	private int guessCount = 8;

	// == Bean Methods ==
	@Bean
	@MaxNumber
	public int maxNumber() {
		return maxNumber;
	}

	// = Method name should be same as field name vice versa unless you create custom annotation
//	@Bean
//	public int guessCount() {
//		return guessCount;
//	}

	// = Any Method name can be given for custom annotation
	@Bean
	@GuessCount
	public int guessCounter() {
		return guessCount;
	}
}
