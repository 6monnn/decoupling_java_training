package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("computer");
    private boolean higher;
    private long min;
    private long max;
    private long input;
    public ComputerPlayer(Long parseLong) {
        higher = false;
        input = 0;
        min = -1;
        max = parseLong;
    }


    @Override
    public long askNextGuess() {
        if (this.min == -1L) {
            this.input = this.max / 2;
            this.min = 0;
        }
        else {
            this.min = !this.higher ? input : this.min;
            this.max = this.higher ? input : this.max;
            input = (this.min + this.max) / 2;
        }

        this.logger.log("Answer : " + input);
        return input;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.higher = lowerOrGreater;
        if (lowerOrGreater) {
            this.logger.log("+ petit");
        }
        else{
            this.logger.log("+ grand");
        }
    }

}
