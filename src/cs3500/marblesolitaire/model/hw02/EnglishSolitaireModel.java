package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.SolitaireModel;

/**
 * An implementation of Marble Solitaire called English Peg Solitaire. Abstracted so the majority
 * of functional code (besides constructors) are in Abstract class SolitaireModel.
 */
public class EnglishSolitaireModel extends SolitaireModel {
  /**
   * The default Constructor for EnglishSolitaireModel, sets arm thickness to 3,
   * empty slot to (3,3), and initializes game.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructor for EnglishSolitaireModel that initializes game using inputted slot.
   *
   * @param sRow Row of inputted Empty Slot
   * @param sCol Column of inputted Empty Slot
   * @throws IllegalArgumentException if the inputted slot is not a valid slot on the board
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructor for EnglishSolitaireModel that instantiates game with a specified armThickness
   * (width of one of the 4 "arm" squares on the board).
   *
   * @param armThickness width of one of the 4 "arm" squares on the board
   * @throws IllegalArgumentException if the arm thickness is even (must be odd)
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  /**
   * Main Constructor for EnglishSolitaireModel that instantiates the game using armThickness,
   * and the coordinates of the initial empty slot.
   *
   * @param armThickness the width of one of the 4 "arm" square on the board
   * @param sRow         Row of inputted Empty Slot
   * @param sCol         Column of inputted Empty Slot
   * @throws IllegalArgumentException if the arm thickness is even (must be odd) or
   *                                  if the inputted slot is not a valid slot on the board
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.boardWidth = armThickness;
    this.boardSize = 3 * armThickness - 2;

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException();
    } else {
      this.initBoardStates();
      this.score = 5 * (armThickness) * (armThickness) - 4 * (armThickness) - 1;
    }

    if (!isValidSlot(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + sRow + ", "
              + sCol + ")");
    }

    this.mtSlotRow = sRow;
    this.mtSlotCol = sCol;
    slotState[mtSlotRow][mtSlotCol] = SlotState.Empty;
  }
}
