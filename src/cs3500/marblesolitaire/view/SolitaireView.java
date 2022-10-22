package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class for MarbleSolitaireViews, contains renderBoard and renderMessage common methods
 * but toString must be implemented by each specific view.
 */
public abstract class SolitaireView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState slotState;
  protected Appendable appendable;

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above. This  throws an IOException if
   * the transmission fails.
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    renderMessage(this.toString());
  }

  /**
   * Render a specific message to the provided data destination (Appendable Object), throws an
   * IOException if the transmission fails.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    appendable.append(message);
  }

}
