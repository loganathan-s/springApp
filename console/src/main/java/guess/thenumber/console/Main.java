package guess.thenumber.console;

import guess.thenumber.core.config.AppConfig;
import guess.thenumber.core.Game;
import guess.thenumber.core.MessageGenerator;
import guess.thenumber.core.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	// Used for XMl way configurations (bean.xml)
	// private static final String CONFIG_LOCATION = "beans.xml";

	public static void main (String[] args) {
		log.info("Guess the number game");

	// create context (Container) using XML file
	//		ConfigurableApplicationContext context
	//			= new ClassPathXmlApplicationContext(CONFIG_LOCATION);

		ConfigurableApplicationContext context
			= new AnnotationConfigApplicationContext(AppConfig.class);


		// By default the spring will auto generate name for component,
		// but we can name it manually(numberGenerator) in bean.ml or using the @component annotation
		// NumberGenerator numberGenerator
		//	= context.getBean("numberGenerator", NumberGenerator.class);

		// Instead of name we can get the bean by its type
//		NumberGenerator numberGenerator
//			= context.getBean( NumberGenerator.class);

		//call method next() to get random number

//		int number = numberGenerator.next();

//		log.info("number = {}", number);


		// get game bean from context(container)
//		Game game = context.getBean(Game.class);

		//call reset method
		//game.reset();
		// get message generator bean from context (container)
//		MessageGenerator messageGenerator =
//			context.getBean(MessageGenerator.class);
//		log.info("getMainMessage= {}", messageGenerator.getMainMessage());
//		log.info("getResultMessage= {}", messageGenerator.getResultMessage());

		//close context
		context.close();

	}
}
