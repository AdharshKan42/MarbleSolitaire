package cs3500.marblesolitaire.model.hw04;

/**
 *  An implementation of Marble Solitaire called European Peg Solitaire. This is similar to
 *  English Solitaire yet its corners have a staircase pattern that when traced around the entire
 *  board, looks like an octagon. Abstracted so the majority of functional code
 *  is in Abstract class SolitaireModel; only contains the constructors and changes the
 *  initialization of the board so it's specific to European Peg Solitaire construction rules.
 */
public class EuropeanSolitaireModel extends SolitaireModel {
  /**
   * The default Constructor for EuropeanSolitaireModel, sets arm thickness to 3,
   * empty slot to (3,3), and initializes game.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructor for EuropeanSolitaireModel that initializes game using inputted slot.
   *
   * @param sRow Row of inputted Empty Slot
   * @param sCol Column of inputted Empty Slot
   * @throws IllegalArgumentException if the inputted slot is not a valid slot on the board
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructor for EuropeanSolitaireModel that instantiates game with a specified armThickness
   * (width of one of the 4 "arm" squares on the board).
   *
   * @param armThickness width of one of the 4 "arm" squares on the board
   * @throws IllegalArgumentException if the arm thickness is even (must be odd)
   */
  public EuropeanSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  /**
   * Main Constructor for EuropeanSolitaireModel that instantiates the game using armThickness,
   * and the coordinates of the initial empty slot.
   *
   * @param armThickness the width of one of the 4 "arm" square on the board
   * @param sRow         Row of inputted Empty Slot
   * @param sCol         Column of inputted Empty Slot
   * @throws IllegalArgumentException if the arm thickness is even (must be odd) or
   *                                  if the inputted slot is not a valid slot on the board
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.boardWidth = armThickness;
    this.boardSize = 3 * armThickness - 2;

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException();
    } else {
      this.initBoardStates();
      this.score = boardSize * boardSize - (4 * (armThickness - 1) * (armThickness) / 2) - 1;
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

  /**
   * Initializes all the slots with their respective states as explained in the class definition,
   * except for the empty position.
   */
  @Override
  protected void initBoardStates() {
    super.initBoardStates();

    //initializes slanted "staircase" edges for octagonal board config
    this.initStairs();
  }


  //Adds "stairs" in corners of model, adding onto EnglishSolitaireModel to create
  //an EuropeanSolitaireModel
  private void initStairs() {
    int closerBound = boardWidth - 1;
    int middleBound = (2 * boardWidth) - 2;
    int fartherBound = boardSize;

    int start = closerBound - 1;
    for (int c = 1; c < closerBound; c += 1) {
      for (int r = start; r < closerBound; r += 1) {
        slotState[r][c] = SlotState.Marble;
      }
      start--;
    }

    start = closerBound - 1;
    for (int c = fartherBound - 2; c > middleBound; c -= 1) {
      for (int r = start; r < closerBound; r += 1) {
        slotState[r][c] = SlotState.Marble;
      }
      start--;
    }

    start = middleBound + 1;
    for (int c = 1; c < closerBound; c += 1) {
      for (int r = start; r > middleBound; r -= 1) {
        slotState[r][c] = SlotState.Marble;
      }
      start++;
    }

    start = middleBound + 1;
    for (int c = fartherBound - 2; c > middleBound; c -= 1) {
      for (int r = start; r > middleBound; r -= 1) {
        slotState[r][c] = SlotState.Marble;
      }
      start++;
    }
  }
}
