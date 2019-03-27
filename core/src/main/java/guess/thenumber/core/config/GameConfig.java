package guess.thenumber.core.config;

import guess.thenumber.core.GuessCount;
import guess.thenumber.core.MaxNumber;
import guess.thenumber.core.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
	@Value("${game.maxNumber:200}")
	private int maxNumber;

	@Value("${game.guessCount:4}")
	private int guessCount;

	@Value("${game.minNumber:200}")
	private int minNumber;

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

	// = Any Method name can be given for custom annotation
	@Bean
	@MinNumber
	public int sendMinNumber() {
		return minNumber;
	}
}
