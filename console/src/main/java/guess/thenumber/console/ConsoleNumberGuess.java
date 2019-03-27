package guess.thenumber.console;

import guess.thenumber.core.Game;
import guess.thenumber.core.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess  {

	private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

	@Autowired
	private Game game;

	@Autowired
	private MessageGenerator messageGenerator;

	// == events ==
	// Published whenapplication context is initialized or refereshed
	// After postconstruct and others..
	@EventListener(ContextRefreshedEvent.class)
	public void start (ContextRefreshedEvent event) {
		log.info("Container Ready for use");
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println(messageGenerator.getMainMessage());
			System.out.println(messageGenerator.getResultMessage());

			int guess = scanner.nextInt();
			scanner.nextLine();
			game.setGuess(guess);
			game.check();

			if(game.isGameLost() || game.isGameWon()) {
				System.out.println(messageGenerator.getResultMessage());
				System.out.println("play again y/n?");

				String playAgainString = scanner.nextLine().trim();
				if(!playAgainString.equalsIgnoreCase("y")) {
					break;
				}
				game.reset();
			}
		}
	}


}
