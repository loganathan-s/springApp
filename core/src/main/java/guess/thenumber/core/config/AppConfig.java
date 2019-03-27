package guess.thenumber.core.config;

import guess.thenumber.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


//  XMl way (bean.xml)
//    <context:component-scan base-package="guess.thenumber" />

// == Annotation way
@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "guess.thenumber")
public class AppConfig {

	//== Instead of component annotation you can use Bean methods too ==
	//== Name of the bean is the name of the bean method
	//== bean methods ==
	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGeneratorImpl();
	}

	@Bean
	public Game game() {
		return new GameImpl();
		}

	@Bean
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl();
	}
 }
