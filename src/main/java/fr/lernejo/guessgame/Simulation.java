package fr.lernejo.guessgame;
import fr.lernejo.logger.*;

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
      System.out.println(logger);
      // Ask number
      if (player instanceof HumanPlayer) {
          System.out.println("Enter a number : ");
          long numberPlayer = ((HumanPlayer) player).console.nextInt();
          if (numberPlayer == numberToGuess)
              return true;
          else if (numberPlayer < numberToGuess)
              System.out.println("Plus grand");
          else
              System.out.println("Plus petit");
      }
    return false;
  }

  public void loopUntilPlayerSucceed() {
    while (nextRound() == false);
  }
}
