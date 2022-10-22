package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class for MarbleSolitaireModel, implementations can extend it for its functionality.
 * Contains the fields and main methods and their logic to properly execute any SolitaireModel type,
 * along with the proper helpers to display what needs to be changed for each implementation.
 */
public abstract class SolitaireModel implements MarbleSolitaireModel {
  protected int mtSlotRow;
  protected int mtSlotCol;
  protected int boardWidth;
  protected int boardSize;
  protected int score;
  protected SlotState[][] slotState;


  /**
   * Checks if the inputted slot falls within the proper boundaries of any implemented model.
   *
   * @param row of inputted slot
   * @param col of inputted slot
   * @return true if the inputted slot is within the proper boundaries of any implemented model
   */
  protected boolean isValidSlot(int row, int col) {
    if (this.isInvalidSlotPosition(row, col)) {
      return false;
    } else {
      return (!this.isOutsideBoardDimensions(row, col));
    }
  }

  /**
   * Initializes all the slots with their respective states, except for the empty position.
   * This implementation defaults to an EnglishSolitaireModel initialization.
   */
  protected void initBoardStates() {
    slotState = new SlotState[boardSize][boardSize];
    for (int r = 0; r < boardSize; r += 1) {
      for (int c = 0; c < boardSize; c += 1) {
        if (this.isInvalidForInitEnglishBoard(r, c)) {
          slotState[r][c] = SlotState.Invalid;
        } else {
          slotState[r][c] = SlotState.Marble;
        }
      }
    }
  }

  /**
   * Helps initialize the board by returning if an inputted slot is considered "INVALID".
   * This implementation defaults to an EnglishSolitaireModel initialization.
   *
   * @param row of inputted slot being checked
   * @param col of inputted slot being checked
   * @return true if the inputted slot is considered "INVALID" within the board boundaries.
   */
  protected boolean isInvalidForInitEnglishBoard(int row, int col) {
    int closerBound = boardWidth - 1;
    int middleBound = (2 * boardWidth) - 2;
    int fartherBound = boardSize;
    if ((row < closerBound) && (col < closerBound)) {
      //top-left
      return true;
    } else if (((col > middleBound)
            && (col < fartherBound))
            && (row < closerBound)) {
      //top-right
      return true;
    } else //bottom-right
      if (((row > middleBound)
              && (row < fartherBound))
              && (col < closerBound)) {
        //bottom-left
        return true;
      } else {
        return ((row > middleBound)
                && (row < fartherBound))
                && ((col > middleBound)
                && (col < fartherBound));
      }
  }

  /**
   * Checks if slot is of enum state "INVALID" in the rectangular board boundaries, can be used by
   * any implemented model.
   *
   * @param row of inputted slot being checked
   * @param col of inputted slot being checked
   * @return if inputted slot is of enum state "INVALID" in the rectangular board boundaries
   */
  protected boolean isInvalidSlotPosition(int row, int col) {
    if (this.isOutsideBoardDimensions(row, col)) {
      return false;
    } else {
      return (slotState[row][col] == SlotState.Invalid);
    }
  }

  /**
   * Checks if an inputted slot is outside the rectangular board dimensions.
   *
   * @param row of inputted slot being checked
   * @param col of inputted slot being checked
   * @return true if an inputted slot is outside the rectangular board dimensions
   */
  protected boolean isOutsideBoardDimensions(int row, int col) {
    return row < 0 || col < 0 || row > boardSize - 1 || col > boardSize - 1;
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible, such as when a move is not
   *                                  exactly vertical or horizontal, from a space with a marble to
   *                                  an empty spot with a marble between them, and having this
   *                                  jump be exactly 2 spaces apart (within the boundaries of the
   *                                  board). Movements to another marble, an invalid spot,
   *                                  not having a marble between the from and
   *                                  to positions, diagonal jumps, and trying to move slots other
   *                                  than a marble are invalid.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    //checks if move is valid and then makes move
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Move is invalid.");
    } else {
      makeMove(fromRow, fromCol, toRow, toCol);
      score -= 1;
    }
  }

  /**
   * Checks if two inputted slots (from and to) correspond to a valid move according the game rules,
   * should be implemented for models that don't follow same rules as English or European Models.
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
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidSlot(fromRow, fromCol)
            || !(isValidSlot(toRow, toCol))) {
      return false;
    }
    if ((this.getSlotAt(fromRow, fromCol) != SlotState.Marble)
            || (this.getSlotAt(toRow, toCol) != SlotState.Empty)) {

      return false;
    }
    if (!((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
            || (fromCol == toCol && Math.abs(fromRow - toRow) == 2))) {

      return false;
    } else if (fromRow == toRow) {
      return this.getSlotAt(fromRow, fromCol + (toCol - fromCol) / 2) == SlotState.Marble;
    } else if (fromCol == toCol) {
      return this.getSlotAt(fromRow + (toRow - fromRow) / 2, fromCol) == SlotState.Marble;
    }
    return true;

  }

  /**
   * Changes the states of the inputted slots to make a valid move, depending on each model's rules.
   * ASSUMES INPUTTED MOVE IS VALID.
   *
   * @param fromRow the row number of the position to be moved from
   *                 (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *            (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *               (starts at 0)
   */
  protected void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
    boolean isHorizontalMove = (fromRow == toRow);
    slotState[fromRow][fromCol] = SlotState.Empty;
    slotState[toRow][toCol] = SlotState.Marble;
    //remove middle marble
    if (isHorizontalMove) {
      slotState[fromRow][fromCol + (toCol - fromCol) / 2] = SlotState.Empty;
    } else {
      slotState[fromRow + (toRow - fromRow) / 2][fromCol] = SlotState.Empty;
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
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
          }
        }
      }
    }
    return true;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return boardSize;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (isOutsideBoardDimensions(row, col)) {
      throw new IllegalArgumentException("row and/or column are beyond the board dimensions");
    } else {
      return this.slotState[row][col];
    }
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    return score;
  }
}
