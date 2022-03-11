package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;

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

    private boolean nextRound() {
        long guess = this.player.askNextGuess();
        if (guess == this.numberToGuess) {
            this.logger.log("Player won");
            return true;
        }
        this.player.respond(guess > this.numberToGuess);
        this.logger.log("Player lose");
        return false;
    }

    public void waitForPlayerToWin(long maxLoop) {
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
