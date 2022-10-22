import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Tests for EuropeanSolitaireModel.
 */
public class EuropeanSolitaireModelTest {

  static MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;
  static MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  static MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;

  /**
   * Returns the hard-coded armThickness-3 Board with empty slot at (sRow, sCol) as
   * a 2D SlotState array.
   *
   * @param sRow inputted row for empty slot
   * @param sCol inputted column for empty slot
   * @return 2D array of SlotStates for each position on the board
   */
  public static MarbleSolitaireModelState.SlotState[][] getExpected3Board(int sRow, int sCol) {

    MarbleSolitaireModelState.SlotState[][] arr = new MarbleSolitaireModelState.SlotState[7][7];
    arr[0][0] = invalid;
    arr[0][1] = invalid;
    arr[0][2] = marble;
    arr[0][3] = marble;
    arr[0][4] = marble;
    arr[0][5] = invalid;
    arr[0][6] = invalid;
    arr[1][0] = invalid;
    arr[1][1] = marble;
    arr[1][2] = marble;
    arr[1][3] = marble;
    arr[1][4] = marble;
    arr[1][5] = marble;
    arr[1][6] = invalid;
    arr[2][0] = marble;
    arr[2][1] = marble;
    arr[2][2] = marble;
    arr[2][3] = marble;
    arr[2][4] = marble;
    arr[2][5] = marble;
    arr[2][6] = marble;
    arr[3][0] = marble;
    arr[3][1] = marble;
    arr[3][2] = marble;
    arr[3][3] = marble;
    arr[3][4] = marble;
    arr[3][5] = marble;
    arr[3][6] = marble;
    arr[4][0] = marble;
    arr[4][1] = marble;
    arr[4][2] = marble;
    arr[4][3] = marble;
    arr[4][4] = marble;
    arr[4][5] = marble;
    arr[4][6] = marble;
    arr[5][0] = invalid;
    arr[5][1] = marble;
    arr[5][2] = marble;
    arr[5][3] = marble;
    arr[5][4] = marble;
    arr[5][5] = marble;
    arr[5][6] = invalid;
    arr[6][0] = invalid;
    arr[6][1] = invalid;
    arr[6][2] = marble;
    arr[6][3] = marble;
    arr[6][4] = marble;
    arr[6][5] = invalid;
    arr[6][6] = invalid;

    arr[sRow][sCol] = empty;

    return arr;
  }

  /**
   * Returns the hard-coded armThickness-5 Board with empty slot at (sRow, sCol) as
   * a 2D SlotState array.
   *
   * @param sRow inputted row for empty slot
   * @param sCol inputted column for empty slot
   * @return 2D array of SlotStates for each position on the board
   */
  public static MarbleSolitaireModelState.SlotState[][] getExpected5Board(int sRow, int sCol) {
    MarbleSolitaireModelState.SlotState[][] arr2 = new MarbleSolitaireModelState.SlotState[13][13];

    arr2[0][0] = invalid;
    arr2[0][1] = invalid;
    arr2[0][2] = invalid;
    arr2[0][3] = invalid;
    arr2[0][4] = marble;
    arr2[0][5] = marble;
    arr2[0][6] = marble;
    arr2[0][7] = marble;
    arr2[0][8] = marble;
    arr2[0][9] = invalid;
    arr2[0][10] = invalid;
    arr2[0][11] = invalid;
    arr2[0][12] = invalid;
    arr2[1][0] = invalid;
    arr2[1][1] = invalid;
    arr2[1][2] = invalid;
    arr2[1][3] = marble;
    arr2[1][4] = marble;
    arr2[1][5] = marble;
    arr2[1][6] = marble;
    arr2[1][7] = marble;
    arr2[1][8] = marble;
    arr2[1][9] = marble;
    arr2[1][10] = invalid;
    arr2[1][11] = invalid;
    arr2[1][12] = invalid;
    arr2[2][0] = invalid;
    arr2[2][1] = invalid;
    arr2[2][2] = marble;
    arr2[2][3] = marble;
    arr2[2][4] = marble;
    arr2[2][5] = marble;
    arr2[2][6] = marble;
    arr2[2][7] = marble;
    arr2[2][8] = marble;
    arr2[2][9] = marble;
    arr2[2][10] = marble;
    arr2[2][11] = invalid;
    arr2[2][12] = invalid;
    arr2[3][0] = invalid;
    arr2[3][1] = marble;
    arr2[3][2] = marble;
    arr2[3][3] = marble;
    arr2[3][4] = marble;
    arr2[3][5] = marble;
    arr2[3][6] = marble;
    arr2[3][7] = marble;
    arr2[3][8] = marble;
    arr2[3][9] = marble;
    arr2[3][10] = marble;
    arr2[3][11] = marble;
    arr2[3][12] = invalid;
    arr2[4][0] = marble;
    arr2[4][1] = marble;
    arr2[4][2] = marble;
    arr2[4][3] = marble;
    arr2[4][4] = marble;
    arr2[4][5] = marble;
    arr2[4][6] = marble;
    arr2[4][7] = marble;
    arr2[4][8] = marble;
    arr2[4][9] = marble;
    arr2[4][10] = marble;
    arr2[4][11] = marble;
    arr2[4][12] = marble;
    arr2[5][0] = marble;
    arr2[5][1] = marble;
    arr2[5][2] = marble;
    arr2[5][3] = marble;
    arr2[5][4] = marble;
    arr2[5][5] = marble;
    arr2[5][6] = marble;
    arr2[5][7] = marble;
    arr2[5][8] = marble;
    arr2[5][9] = marble;
    arr2[5][10] = marble;
    arr2[5][11] = marble;
    arr2[5][12] = marble;
    arr2[6][0] = marble;
    arr2[6][1] = marble;
    arr2[6][2] = marble;
    arr2[6][3] = marble;
    arr2[6][4] = marble;
    arr2[6][5] = marble;
    arr2[6][6] = marble;
    arr2[6][7] = marble;
    arr2[6][8] = marble;
    arr2[6][9] = marble;
    arr2[6][10] = marble;
    arr2[6][11] = marble;
    arr2[6][12] = marble;
    arr2[7][0] = marble;
    arr2[7][1] = marble;
    arr2[7][2] = marble;
    arr2[7][3] = marble;
    arr2[7][4] = marble;
    arr2[7][5] = marble;
    arr2[7][6] = marble;
    arr2[7][7] = marble;
    arr2[7][8] = marble;
    arr2[7][9] = marble;
    arr2[7][10] = marble;
    arr2[7][11] = marble;
    arr2[7][12] = marble;
    arr2[8][0] = marble;
    arr2[8][1] = marble;
    arr2[8][2] = marble;
    arr2[8][3] = marble;
    arr2[8][4] = marble;
    arr2[8][5] = marble;
    arr2[8][6] = marble;
    arr2[8][7] = marble;
    arr2[8][8] = marble;
    arr2[8][9] = marble;
    arr2[8][10] = marble;
    arr2[8][11] = marble;
    arr2[8][12] = marble;
    arr2[9][0] = invalid;
    arr2[9][1] = marble;
    arr2[9][2] = marble;
    arr2[9][3] = marble;
    arr2[9][4] = marble;
    arr2[9][5] = marble;
    arr2[9][6] = marble;
    arr2[9][7] = marble;
    arr2[9][8] = marble;
    arr2[9][9] = marble;
    arr2[9][10] = marble;
    arr2[9][11] = marble;
    arr2[9][12] = invalid;
    arr2[10][0] = invalid;
    arr2[10][1] = invalid;
    arr2[10][2] = marble;
    arr2[10][3] = marble;
    arr2[10][4] = marble;
    arr2[10][5] = marble;
    arr2[10][6] = marble;
    arr2[10][7] = marble;
    arr2[10][8] = marble;
    arr2[10][9] = marble;
    arr2[10][10] = marble;
    arr2[10][11] = invalid;
    arr2[10][12] = invalid;
    arr2[11][0] = invalid;
    arr2[11][1] = invalid;
    arr2[11][2] = invalid;
    arr2[11][3] = marble;
    arr2[11][4] = marble;
    arr2[11][5] = marble;
    arr2[11][6] = marble;
    arr2[11][7] = marble;
    arr2[11][8] = marble;
    arr2[11][9] = marble;
    arr2[11][10] = invalid;
    arr2[11][11] = invalid;
    arr2[11][12] = invalid;
    arr2[12][0] = invalid;
    arr2[12][1] = invalid;
    arr2[12][2] = invalid;
    arr2[12][3] = invalid;
    arr2[12][4] = marble;
    arr2[12][5] = marble;
    arr2[12][6] = marble;
    arr2[12][7] = marble;
    arr2[12][8] = marble;
    arr2[12][9] = invalid;
    arr2[12][10] = invalid;
    arr2[12][11] = invalid;
    arr2[12][12] = invalid;

    arr2[sRow][sCol] = empty;

    return arr2;
  }

  @Test
  public void defaultConstructor() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(36, e.getScore());

    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(3, 3);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void inputEmptySlotConstructor() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(0, 2);

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(36, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(0, 2);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlot_0_0() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_1() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_5() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_6() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(0, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_0() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_6() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_5_0() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_5_6() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_0() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_1() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_5() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_6() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(6, 6);
  }

  @Test
  public void armThicknessConstructor_3() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(3);

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(36, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(3, 3);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void armThicknessConstructor_5() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(5);

    assertEquals(13, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(5, armThickness);
    assertEquals(128, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(6, 6);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_2() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_4() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_6() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(6);
  }

  @Test
  public void armAndEmptySlotConstructor_3() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(3, 3, 3);

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(36, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(3, 3);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void armAndEmptySlotConstructor_5() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(5, 5, 5);

    assertEquals(13, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(5, armThickness);
    assertEquals(128, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(5, 5);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void armAndEmptySlotConstructor_invalidArmThickness_2() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armAndEmptySlotConstructor_invalidSlot_0_0() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(3, 0, 0);
  }

  @Test
  public void move() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    assertEquals(marble, e.getSlotAt(3, 1));
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(empty, e.getSlotAt(3, 3));
    assertEquals(36, e.getScore());
    //move from (3,1) to (3,3) ->left to right
    e.move(3, 1, 3, 3);
    assertEquals(empty, e.getSlotAt(3, 1));
    assertEquals(empty, e.getSlotAt(3, 2));
    assertEquals(marble, e.getSlotAt(3, 3));
    assertEquals(35, e.getScore());

    assertEquals(marble, e.getSlotAt(5, 2));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(empty, e.getSlotAt(3, 2));
    //move from (5,2) to (3,2) ->bottom to top
    e.move(5, 2, 3, 2);
    assertEquals(empty, e.getSlotAt(5, 2));
    assertEquals(empty, e.getSlotAt(4, 2));
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(34, e.getScore());

    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(marble, e.getSlotAt(4, 3));
    assertEquals(empty, e.getSlotAt(4, 2));
    //move from (4,4) to (4,2) -> right to left
    e.move(4, 4, 4, 2);
    assertEquals(empty, e.getSlotAt(4, 4));
    assertEquals(empty, e.getSlotAt(4, 3));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(33, e.getScore());

    assertEquals(marble, e.getSlotAt(2, 4));
    assertEquals(marble, e.getSlotAt(3, 4));
    assertEquals(empty, e.getSlotAt(4, 4));
    //move from (2,4) to (4,4) -> top to bottom
    e.move(2, 4, 4, 4);
    assertEquals(empty, e.getSlotAt(2, 4));
    assertEquals(empty, e.getSlotAt(3, 4));
    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(32, e.getScore());
  }

  @Test
  public void moveToAndFromCorners() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(1,1);
    assertEquals(marble, e.getSlotAt(1, 3));
    assertEquals(marble, e.getSlotAt(1, 2));
    assertEquals(empty, e.getSlotAt(1, 1));
    assertEquals(36, e.getScore());
    //move from (1,3) to (1,1) ->into empty corner
    e.move(1, 3, 1, 1);
    assertEquals(empty, e.getSlotAt(1, 3));
    assertEquals(empty, e.getSlotAt(1, 3));
    assertEquals(marble, e.getSlotAt(1, 1));
    assertEquals(35, e.getScore());

    e = new EuropeanSolitaireModel(1,3);
    assertEquals(marble, e.getSlotAt(1, 5));
    assertEquals(marble, e.getSlotAt(1, 4));
    assertEquals(empty, e.getSlotAt(1, 3));
    assertEquals(36, e.getScore());
    //move from (1,5) to (1,3) ->from corner
    e.move(1, 5, 1, 3);
    assertEquals(empty, e.getSlotAt(1, 5));
    assertEquals(empty, e.getSlotAt(1, 4));
    assertEquals(marble, e.getSlotAt(1, 3));
    assertEquals(35, e.getScore());

    e = new EuropeanSolitaireModel(5,3);
    assertEquals(marble, e.getSlotAt(5, 1));
    assertEquals(marble, e.getSlotAt(5, 2));
    assertEquals(empty, e.getSlotAt(5, 3));
    assertEquals(36, e.getScore());
    //move from (5,1) to (5,3) ->from corner
    e.move(5, 1, 5, 3);
    assertEquals(empty, e.getSlotAt(5, 1));
    assertEquals(empty, e.getSlotAt(5, 2));
    assertEquals(marble, e.getSlotAt(5, 3));
    assertEquals(35, e.getScore());

    e = new EuropeanSolitaireModel(5,5);
    assertEquals(marble, e.getSlotAt(5, 3));
    assertEquals(marble, e.getSlotAt(5, 4));
    assertEquals(empty, e.getSlotAt(5, 5));
    assertEquals(36, e.getScore());
    //move from (5,3) to (5,5) ->from corner
    e.move(5, 3, 5, 5);
    assertEquals(empty, e.getSlotAt(5, 3));
    assertEquals(empty, e.getSlotAt(5, 4));
    assertEquals(marble, e.getSlotAt(5, 5));
    assertEquals(35, e.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_adjacent_marble_to_marble() {
    //M(from) M(to)
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(0, 3, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_distance2() {
    //M(from) Marble M(to)
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(0, 2, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_diagonal() {
    //M(from) Marble
    //Marble  M(to)
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(3, 1, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_diagonal2() {
    //Marble   M(to)
    //M(from)  Marble
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(4, 1, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_across_board() {
    //Marble   M(to)
    //M(from)  Marble
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(4, 0, 2, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_empty() {
    //Marble
    //Empty
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(2, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_over_2_marbles_to_empty() {
    //Marble
    //Marble
    //Marble
    //Empty
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(0, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_with_empty_slot_in_between() {
    //M(from) Empty M(to)
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(3,2,3,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_invalid_top_left_corner() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(2, 3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_invalid_adjacent() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(1, 2, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_adjacent_empty_to_marble() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(3, 3, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_marble_distance2() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(3, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_marble_diagonal() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(3, 3, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_invalid_to_invalid() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    e.move(1, 2, 5, 5);
  }

  @Test
  public void isGameOver_full_game() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    assertFalse(e.isGameOver());
    e.move(3, 1, 3, 3);
    assertFalse(e.isGameOver());
    e.move(5, 2, 3, 2);
    assertFalse(e.isGameOver());
    e.move(4, 0, 4, 2);
    assertFalse(e.isGameOver());
    e.move(4, 3, 4, 1);
    assertFalse(e.isGameOver());
    e.move(4, 5, 4, 3);
    assertFalse(e.isGameOver());
    e.move(6, 4, 4, 4);
    assertFalse(e.isGameOver());
    e.move(3, 4, 5, 4);
    assertFalse(e.isGameOver());
    e.move(6, 2, 6, 4);
    assertFalse(e.isGameOver());
    e.move(6, 4, 4, 4);
    assertFalse(e.isGameOver());
    e.move(2, 2, 4, 2);
    assertFalse(e.isGameOver());
    e.move(0, 2, 2, 2);
    assertFalse(e.isGameOver());
    e.move(1, 4, 3, 4);
    assertFalse(e.isGameOver());
    e.move(3, 4, 5, 4);
    assertFalse(e.isGameOver());
    e.move(5, 4, 5, 2);
    assertFalse(e.isGameOver());
    e.move(5, 2, 3, 2);
    assertFalse(e.isGameOver());
    e.move(3, 2, 1, 2);
    assertFalse(e.isGameOver());
    e.move(2, 0, 4, 0);
    assertFalse(e.isGameOver());
    e.move(4, 0, 4, 2);
    assertFalse(e.isGameOver());
    e.move(4, 2, 4, 4);
    assertFalse(e.isGameOver());
    e.move(2, 6, 2, 4);
    assertFalse(e.isGameOver());
    e.move(2, 3, 2, 5);
    assertFalse(e.isGameOver());
    e.move(4, 6, 2, 6);
    assertFalse(e.isGameOver());
    e.move(2, 6, 2, 4);
    assertFalse(e.isGameOver());
    e.move(0, 4, 0, 2);
    assertFalse(e.isGameOver());
    e.move(0, 2, 2, 2);
    assertFalse(e.isGameOver());
    e.move(2, 1, 2, 3);
    assertFalse(e.isGameOver());
    e.move(2, 3, 2, 5);
    assertFalse(e.isGameOver());
    e.move(2, 5, 4, 5);
    assertFalse(e.isGameOver());
    e.move(4, 5, 4, 3);
    assertFalse(e.isGameOver());
    e.move(4, 3, 2, 3);
    assertFalse(e.isGameOver());
    e.move(1, 3, 3, 3);
    assertTrue(e.isGameOver());
  }

  @Test
  public void isGameOver_random_game() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel();
    assertFalse(e.isGameOver());
    e.move(1, 3, 3, 3);
    assertFalse(e.isGameOver());
    e.move(4, 3, 2, 3);
    assertFalse(e.isGameOver());
    e.move(3, 1, 3, 3);
    assertFalse(e.isGameOver());
    e.move(1, 2, 3, 2);
    assertFalse(e.isGameOver());
    e.move(4, 2, 2, 2);
    assertFalse(e.isGameOver());
    e.move(2, 3, 4, 3);
    assertFalse(e.isGameOver());
    e.move(4, 4, 4, 2);
    assertFalse(e.isGameOver());
    e.move(5, 2, 3, 2);
    assertFalse(e.isGameOver());
    e.move(2, 2, 4, 2);
    assertFalse(e.isGameOver());
    e.move(4, 1, 4, 3);
    assertFalse(e.isGameOver());
    e.move(5, 4, 5, 2);
    assertFalse(e.isGameOver());
    e.move(6, 2, 4, 2);
    assertFalse(e.isGameOver());
    e.move(4, 3, 4, 1);
    assertFalse(e.isGameOver());
    e.move(4, 0, 4, 2);
    assertFalse(e.isGameOver());
  }

  @Test
  public void getBoardSize() {
    EuropeanSolitaireModel e3 = new EuropeanSolitaireModel();
    assertEquals(7, e3.getBoardSize());

    EuropeanSolitaireModel e5 = new EuropeanSolitaireModel(5);
    assertEquals(13, e5.getBoardSize());

    EuropeanSolitaireModel e7 = new EuropeanSolitaireModel(7);
    assertEquals(19, e7.getBoardSize());

    EuropeanSolitaireModel e9 = new EuropeanSolitaireModel(9);
    assertEquals(25, e9.getBoardSize());

    EuropeanSolitaireModel e1111 = new EuropeanSolitaireModel(1111);
    assertEquals(3331, e1111.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(3);

    //checks if board is constructed properly
    //checks every position against hard-coded 3x3 slotState arr w/ empty center (3,3)
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(3, 3);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void getScore() {
    EuropeanSolitaireModel e = new EuropeanSolitaireModel(3);
    assertEquals(36, e.getScore());
    e.move(1, 3, 3, 3);
    assertEquals(35, e.getScore());
    e.move(2, 1, 2, 3);
    assertEquals(34, e.getScore());
    e.move(0, 2, 2, 2);
    assertEquals(33, e.getScore());

    EuropeanSolitaireModel e2 = new EuropeanSolitaireModel(5);
    assertEquals(128, e2.getScore());
    e2.move(6, 4, 6, 6);
    assertEquals(127, e2.getScore());
    e2.move(6, 2, 6, 4);
    assertEquals(126, e2.getScore());
    e2.move(6, 0, 6, 2);
    assertEquals(125, e2.getScore());
  }
}