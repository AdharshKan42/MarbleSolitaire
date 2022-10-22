package cs3500.marblesolitaire.controller;

/**
 * Controller for Marble Solitaire game, handles communication between the
 * MarbleSolitaireModel and the MarbleSolitaireView while playing the game.
 */
public interface MarbleSolitaireController {

  /**
   * Method to initialize and start playing the MarbleSolitaire game, reads input from Readable,
   * performs actions using MarbleSolitaireModel, and outputs game state and messages using the
   * MarbleSolitaireView.
   *
   * @throws IllegalStateException only if the controller is unable to successfully read
   *                               input or transmit output
   */
  void playGame() throws IllegalStateException;

}
