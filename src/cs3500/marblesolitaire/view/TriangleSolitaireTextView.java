package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Text view (in String format) for Triangle Solitaire game.
 */
public class TriangleSolitaireTextView extends SolitaireView {
  /**
   * One input Constructor for TriangleSolitaireTextView, takes in just the
   * MarbleSolitaireModelState and outputs to System.out,throws an IllegalArgumentException
   * if the inputted game is null.
   *
   * @param slotState inputted game of type MarbleSolitaireModelState
   * @throws IllegalArgumentException if the inputted game (MarbleSolitaireModelState) is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState slotState)
          throws IllegalArgumentException {
    this(slotState, System.out);
  }

  /**
   * Main Constructor for TriangleSolitaireTextView, takes in both a MarbleSolitaireModelState and
   * an Appendable object to output the game moves and state to, throws an IllegalArgumentException
   * if the inputted game is null.
   *
   * @param slotState  inputted game of type MarbleSolitaireModelState
   * @param appendable output destination for rendering board plays and game state
   * @throws IllegalArgumentException if the inputted game (MarbleSolitaireModelState) or the
   *                                  output destination (Appendable) is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState slotState, Appendable appendable)
          throws IllegalArgumentException {
    if ((slotState == null) || (appendable == null)) {
      throw new IllegalArgumentException();
    }

    this.slotState = slotState;
    this.appendable = appendable;
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */

  @Override
  public String toString() {
    int boardSize = slotState.getBoardSize();
    int numSpaces = boardSize - 1;
    int end = 1;
    StringBuilder output = new StringBuilder();

    output.append("");

    for (int r = 0; r < boardSize; r += 1) {
      for (int k = 0; k < numSpaces; k += 1) {
        output.append(" ");
      }

      for (int c = 0; c < end; c += 1) {
        if (slotState.getSlotAt(r, c) == MarbleSolitaireModelState.SlotState.Empty) {
          output.append("_ ");
        } else if (slotState.getSlotAt(r, c) == MarbleSolitaireModelState.SlotState.Marble) {
          output.append("O ");
        }
      }
      end++;
      numSpaces--;
      output.deleteCharAt(output.length() - 1);
      if (r != boardSize - 1) {
        output.append("\n");
      }
    }
    return output.toString();
  }
}
