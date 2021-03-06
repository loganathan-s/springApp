package guess.thenumber.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class GameImpl implements Game {

	//== constants ==
	private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

	//== fields ==
	@Autowired //Class will be initated by the spring  container, no need to initialize manually
	private NumberGenerator numberGenerator;

	@Autowired
	@GuessCount
	private int guessCount;

	@Autowired
	@MinNumber
	private int minNumber;

	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

//	public GameImpl(NumberGenerator numberGenerator) {
//		this.numberGenerator = numberGenerator;
//	}

	// == init ==

	@PostConstruct
	@Override
	public void reset () {
		smallest = numberGenerator.getMinNumber();
		guess = numberGenerator.getMinNumber();
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number =  numberGenerator.next();
		log.debug("the number is {}", number);
	}

	@PreDestroy
	public void preDestroy() {
		log.debug("pre destroy called");
	}

	//== public methods ==
//	public void setNumberGenerator(NumberGenerator numberGenerator) {
//		this.numberGenerator = numberGenerator;
//	}

	@Override
	public int getNumber () {
		return number;
	}

	@Override
	public int getGuess () {
		return guess;
	}

	@Override
	public void setGuess (int guess) {
		this.guess = guess;
	}

	@Override
	public int getSmallest () {
		return smallest;
	}

	@Override
	public int getBiggest () {
		return biggest;
	}

	@Override
	public int getRemainingGuesses () {
		return remainingGuesses;
	}

	@Override
	public void check () {
		checkValidNumberRange();

		if(validNumberRange) {

			if(guess > number) {
				biggest = guess - 1;
			}

			if(guess < number) {
				biggest = guess + 1;
			}

			remainingGuesses--;
		}
	}

	@Override
	public boolean isValidNumberRange () {
		return validNumberRange;
	}

	@Override
	public boolean isGameWon () {
		return guess == number;
	}

	@Override
	public boolean isGameLost () {
		return !isGameWon() && remainingGuesses <= 0;
	}

	@Override
	public int getGuessCount () {
		return 10;
	}

	// == private methods ==
	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}
}
