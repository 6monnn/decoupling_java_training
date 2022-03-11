package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("player");
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    @Override
    public long askNextGuess() {
        long result = scanner.nextLong();
        scanner.nextLine();
        return result;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Greater");
        }
        else {
            logger.log("Lower");
        }
    }
}
