package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Controller implementation for Marble Solitaire game (controls inputs and transmits outputs),
 * Takes in some form of MarbleSolitaireModel, reads from the readable input, and transmits the
 * appropriate board state and messages to the given view. This controls the actual "start" of
 * playing the game for the user after getting what type of game will be played by the Main
 * MarbleSolitaire class in the marblesolitaire package.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable input;

  /**
   * Main Constructor for MarbleSolitaireControllerImpl, instantiates readable (game inputs),
   * game inputs from  the model to perform actions on specific game, instantiates view to render
   * played moves and board states.
   *
   * @param model inputted model to perform move operations from, of type MarbleSolitaire model
   * @param view  MarbleSolitaireView output for controller to render played moves and board states
   * @param input input from the client in the form of a Readable
   * @throws IllegalArgumentException if any of the inputted parameters in the constructor are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view,
                                       Readable input)
          throws IllegalArgumentException {
    if ((model == null) || (view == null) || (input == null)) {
      throw new IllegalArgumentException();
    }
    this.model = model;
    this.view = view;
    this.input = input;
  }

  /**
   * Method to initialize and start playing the MarbleSolitaire game, reads input from Readable,
   * performs actions using MarbleSolitaireModel, and outputs game state and messages using the
   * MarbleSolitaireView.
   *
   * @throws IllegalStateException only if the controller is unable to successfully read
   *                               input or transmit output
   */
  @Override
  public void playGame() throws IllegalStateException {
    try {
      Scanner scan = new Scanner(input);

      while (!model.isGameOver()) {
        view.renderBoard();
        //Added new line after rendering board (instead of "\n" in renderBoard() itself)
        view.renderMessage("\n");
        transmitScore();

        int[] arr = new int[4];

        for (int i = 0; i < 4; i++) {
          if (scan.hasNext()) {
            String inputArg = scan.next();

            if (inputArg.equals("q") || inputArg.equals("Q")) {
              gameQuit();
              return;
            } else if (isPositiveInt(inputArg)) {
              arr[i] = Integer.parseInt(inputArg) - 1;
            } else {
              //invalid input
              view.renderMessage("Please re-enter value:\n");
              i--;
            }
          } else {
            throw new IllegalStateException("Could not read input from readable\n");
          }
        }

        try {
          model.move(arr[0], arr[1], arr[2], arr[3]);
        } catch (IllegalArgumentException e) {
          view.renderMessage("Invalid move. Play again. " + e.getMessage() + "\n");
        }
      }

      //Game Over tasks
      view.renderMessage("Game over!\n");
      view.renderBoard();
      //Added new line after rendering board (instead of "\n" in renderBoard() itself)
      view.renderMessage("\n");
      transmitScore();
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }


  }

  private void gameQuit() {
    try {
      view.renderMessage("Game quit!\nState of game when quit:\n");
      view.renderBoard();
      //Added new line after rendering board (instead of "\n" in renderBoard() itself)
      view.renderMessage("\n");
      transmitScore();
    } catch (IOException e) {
      throw new IllegalStateException("Could not quit the game.\n");
    }
  }

  private void transmitScore() {
    String score = "Score: " + model.getScore() + "\n";
    try {
      view.renderMessage(score);
    } catch (IOException e) {
      throw new IllegalStateException("Could not transmit the current score.\n");
    }
  }

  private boolean isPositiveInt(String in) {
    try {
      return Integer.parseInt(in) > 0;
    } catch (NumberFormatException n) {
      return false;
    }
  }

}
