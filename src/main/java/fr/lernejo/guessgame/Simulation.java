package fr.lernejo.guessgame;

import java.text.SimpleDateFormat;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        logger.log("You guess: " + guess);
        if (guess == numberToGuess) {
            logger.log("Congratulation you found the number !");
            return true;
        }
        else if (guess < numberToGuess) {
            player.respond(true);
        }
        else if (guess > numberToGuess) {
            player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxLoop) {
        boolean end;
        long timeBegin = System.currentTimeMillis();
        do {
            end = this.nextRound();
            maxLoop--;
        }while (!end && maxLoop > 0);
        long timeEnd = System.currentTimeMillis();
        SimpleDateFormat f = new SimpleDateFormat("mm:ss:SSS");
        String time = f.format(timeEnd-timeBegin);
        if (end) {
            this.logger.log("Fin de partie, gagné en " + time);
        } else {
            this.logger.log("Fin de partie, perdu en " + time);
        }
    }
}
