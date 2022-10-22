package cs3500.marblesolitaire.model.hw04;

/**
 * An implementation of Marble Solitaire called Triangle Peg Solitaire. This model starts with one
 * space and stacks on an additional space in each subsequent row, creating a pyramid shape.
 * Abstracted so the majority of functional code is in Abstract class SolitaireModel;
 * only contains the constructors, changes to the initialization of the board, and helpers for
 * determining a valid move and making a move (as diagonal moves are now allowed),
 * and overriding isGameOver so it also checks for possible diagonal moves.
 */
public class TriangleSolitaireModel extends SolitaireModel {
  /**
   * The default Constructor for TriangleSolitaireModel, sets boardWidth to 3,
   * empty slot to (3,3), and initializes game.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Constructor for TriangleSolitaireModel that initializes game using inputted slot.
   *
   * @param sRow Row of inputted Empty Slot
   * @param sCol Column of inputted Empty Slot
   * @throws IllegalArgumentException if the inputted slot is not a valid slot on the board
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(5, sRow, sCol);
  }

  /**
   * Constructor for TriangleSolitaireModel that instantiates game with a specified boardWidth
   * (width of one of the 4 "arm" squares on the board).
   *
   * @param dimensions width of one of the 4 "arm" squares on the board
   * @throws IllegalArgumentException if the arm thickness is even (must be odd)
   */
  public TriangleSolitaireModel(int dimensions) throws IllegalArgumentException {
    this(dimensions, 0, 0);
  }

  /**
   * Main Constructor for TriangleSolitaireModel that instantiates the game using boardWidth,
   * and the coordinates of the initial empty slot.
   *
   * @param boardWidth the width of one of the 4 "arm" square on the board
   * @param sRow       Row of inputted Empty Slot
   * @param sCol       Column of inputted Empty Slot
   * @throws IllegalArgumentException if the arm thickness is even (must be odd) or
   *                                  if the inputted slot is not a valid slot on the board
   */
  public TriangleSolitaireModel(int boardWidth, int sRow, int sCol)
          throws IllegalArgumentException {
    this.boardWidth = boardWidth;
    this.boardSize = boardWidth;

    if (boardWidth < 0) {
      throw new IllegalArgumentException("inputted dimension is less than 0");
    } else {
      this.initBoardStates();
      this.score = (boardWidth * (boardWidth + 1) / 2) - 1;
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
   * Initializes all the slots with their respective states, except for the empty position,
   * uses pyramid structure described in class definition.
   */
  @Override
  protected void initBoardStates() {
    slotState = new SlotState[boardSize][boardSize];
    int end = 1;
    for (int r = 0; r < boardSize; r += 1) {
      for (int c = 0; c < boardSize; c += 1) {
        if (c < end) {
          slotState[r][c] = SlotState.Marble;
        } else {
          slotState[r][c] = SlotState.Invalid;
        }
      }
      end += 1;
    }
  }

  /**
   * Checks if two inputted slots (from and to) correspond to a valid move according the game rules,
   * meaning that a move is possible when first having this jump be exactly 2 spaces apart.
   * Next, the move can occur either left and right and diagonally in 4 directions (up-left,
   * up-right, down-left, down-right).
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @return true if the inputted from and to slots correspond to a valid move, depending on the
   *     rules of each implementation
   */
  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidSlot(fromRow, fromCol)
            || !(isValidSlot(toRow, toCol))) {
      return false;
    }
    if ((this.getSlotAt(fromRow, fromCol) != SlotState.Marble)
            || (this.getSlotAt(toRow, toCol) != SlotState.Empty)) {

      return false;
    }
    if (fromRow == toRow && Math.abs(fromCol - toCol) == 2) {
      return this.getSlotAt(fromRow, fromCol + (toCol - fromCol) / 2) == SlotState.Marble;
    } else if (fromCol == toCol && Math.abs(fromRow - toRow) == 2) {
      return this.getSlotAt(fromRow + (toRow - fromRow) / 2, fromCol) == SlotState.Marble;
    } else if (((fromRow - toRow == -2) && (fromCol - toCol == -2))
            || ((fromRow - toRow == 2) && (fromCol - toCol == 2))) {
      return this.getSlotAt(fromRow + (toRow - fromRow) / 2,
              fromCol + (toCol - fromCol) / 2) == SlotState.Marble;
    }
    return false;
  }

  @Override
  protected void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
    boolean horiztonalMove = (fromRow == toRow);
    boolean verticalMove = (fromCol == toCol);
    slotState[fromRow][fromCol] = SlotState.Empty;
    slotState[toRow][toCol] = SlotState.Marble;
    //remove middle marble
    if (horiztonalMove && !verticalMove) {
      slotState[fromRow][fromCol + (toCol - fromCol) / 2] = SlotState.Empty;
    } else if (!horiztonalMove && verticalMove) {
      slotState[fromRow + (toRow - fromRow) / 2][fromCol] = SlotState.Empty;
    } else {
      slotState[fromRow + (toRow - fromRow) / 2][fromCol + (toCol - fromCol) / 2] = SlotState.Empty;
    }
  }

  @Override
  public boolean isGameOver() {
    for (int r = 0; r < boardSize; r += 1) {
      for (int c = 0; c < boardSize; c += 1) {
        if (slotState[r][c] == SlotState.Marble) {
          if (isValidMove(r, c, r - 2, c)) {
            return false;
          } else if (isValidMove(r, c, r + 2, c)) {
            return false;
          } else if (isValidMove(r, c, r, c - 2)) {
            return false;
          } else if (isValidMove(r, c, r, c + 2)) {
            return false;
          } else if (isValidMove(r, c, r - 2, c - 2)) {
            return false;
          } else if (isValidMove(r, c, r + 2, c + 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
