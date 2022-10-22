import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Tests for English SolitaireModel.
 */
public class EnglishSolitaireModelTest {

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
    arr[1][1] = invalid;
    arr[1][2] = marble;
    arr[1][3] = marble;
    arr[1][4] = marble;
    arr[1][5] = invalid;
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
    arr[5][1] = invalid;
    arr[5][2] = marble;
    arr[5][3] = marble;
    arr[5][4] = marble;
    arr[5][5] = invalid;
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
    arr2[1][3] = invalid;
    arr2[1][4] = marble;
    arr2[1][5] = marble;
    arr2[1][6] = marble;
    arr2[1][7] = marble;
    arr2[1][8] = marble;
    arr2[1][9] = invalid;
    arr2[1][10] = invalid;
    arr2[1][11] = invalid;
    arr2[1][12] = invalid;
    arr2[2][0] = invalid;
    arr2[2][1] = invalid;
    arr2[2][2] = invalid;
    arr2[2][3] = invalid;
    arr2[2][4] = marble;
    arr2[2][5] = marble;
    arr2[2][6] = marble;
    arr2[2][7] = marble;
    arr2[2][8] = marble;
    arr2[2][9] = invalid;
    arr2[2][10] = invalid;
    arr2[2][11] = invalid;
    arr2[2][12] = invalid;
    arr2[3][0] = invalid;
    arr2[3][1] = invalid;
    arr2[3][2] = invalid;
    arr2[3][3] = invalid;
    arr2[3][4] = marble;
    arr2[3][5] = marble;
    arr2[3][6] = marble;
    arr2[3][7] = marble;
    arr2[3][8] = marble;
    arr2[3][9] = invalid;
    arr2[3][10] = invalid;
    arr2[3][11] = invalid;
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
    arr2[9][1] = invalid;
    arr2[9][2] = invalid;
    arr2[9][3] = invalid;
    arr2[9][4] = marble;
    arr2[9][5] = marble;
    arr2[9][6] = marble;
    arr2[9][7] = marble;
    arr2[9][8] = marble;
    arr2[9][9] = invalid;
    arr2[9][10] = invalid;
    arr2[9][11] = invalid;
    arr2[9][12] = invalid;
    arr2[10][0] = invalid;
    arr2[10][1] = invalid;
    arr2[10][2] = invalid;
    arr2[10][3] = invalid;
    arr2[10][4] = marble;
    arr2[10][5] = marble;
    arr2[10][6] = marble;
    arr2[10][7] = marble;
    arr2[10][8] = marble;
    arr2[10][9] = invalid;
    arr2[10][10] = invalid;
    arr2[10][11] = invalid;
    arr2[10][12] = invalid;
    arr2[11][0] = invalid;
    arr2[11][1] = invalid;
    arr2[11][2] = invalid;
    arr2[11][3] = invalid;
    arr2[11][4] = marble;
    arr2[11][5] = marble;
    arr2[11][6] = marble;
    arr2[11][7] = marble;
    arr2[11][8] = marble;
    arr2[11][9] = invalid;
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
    EnglishSolitaireModel e = new EnglishSolitaireModel();

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(32, e.getScore());

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
    EnglishSolitaireModel e = new EnglishSolitaireModel(0, 2);

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(32, e.getScore());


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
    EnglishSolitaireModel e = new EnglishSolitaireModel(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_1() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_5() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_6() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(0, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_0() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_1() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_5() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_6() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_5_0() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_5_1() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(5, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_5_5() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_5_6() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_0() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_1() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_5() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_6_6() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(6, 6);
  }

  @Test
  public void armThicknessConstructor_3() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(3);

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(32, e.getScore());


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
    EnglishSolitaireModel e = new EnglishSolitaireModel(5);

    assertEquals(13, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(5, armThickness);
    assertEquals(104, e.getScore());


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
    EnglishSolitaireModel e = new EnglishSolitaireModel(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_4() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_6() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(6);
  }

  @Test
  public void armAndEmptySlotConstructor_3() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(3, 3, 3);

    assertEquals(7, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(3, armThickness);
    assertEquals(32, e.getScore());


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
    EnglishSolitaireModel e = new EnglishSolitaireModel(5, 5, 5);

    assertEquals(13, e.getBoardSize());
    int armThickness = (e.getBoardSize() + 2) / 3;
    assertEquals(5, armThickness);
    assertEquals(104, e.getScore());


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
    EnglishSolitaireModel e = new EnglishSolitaireModel(2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armAndEmptySlotConstructor_invalidSlot_0_0() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(3, 0, 0);
  }

  @Test
  public void move() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    assertEquals(marble, e.getSlotAt(3, 1));
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(empty, e.getSlotAt(3, 3));
    assertEquals(32, e.getScore());
    //move from (3,1) to (3,3) ->left to right
    e.move(3, 1, 3, 3);
    assertEquals(empty, e.getSlotAt(3, 1));
    assertEquals(empty, e.getSlotAt(3, 2));
    assertEquals(marble, e.getSlotAt(3, 3));
    assertEquals(31, e.getScore());

    assertEquals(marble, e.getSlotAt(5, 2));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(empty, e.getSlotAt(3, 2));
    //move from (5,2) to (3,2) ->bottom to top
    e.move(5, 2, 3, 2);
    assertEquals(empty, e.getSlotAt(5, 2));
    assertEquals(empty, e.getSlotAt(4, 2));
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(30, e.getScore());

    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(marble, e.getSlotAt(4, 3));
    assertEquals(empty, e.getSlotAt(4, 2));
    //move from (4,4) to (4,2) -> right to left
    e.move(4, 4, 4, 2);
    assertEquals(empty, e.getSlotAt(4, 4));
    assertEquals(empty, e.getSlotAt(4, 3));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(29, e.getScore());

    assertEquals(marble, e.getSlotAt(2, 4));
    assertEquals(marble, e.getSlotAt(3, 4));
    assertEquals(empty, e.getSlotAt(4, 4));
    //move from (2,4) to (4,4) -> top to bottom
    e.move(2, 4, 4, 4);
    assertEquals(empty, e.getSlotAt(2, 4));
    assertEquals(empty, e.getSlotAt(3, 4));
    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(28, e.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_adjacent_marble_to_marble() {
    //M(from) M(to)
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(0, 3, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_distance2() {
    //M(from) Marble M(to)
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(0, 2, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_diagonal() {
    //M(from) Marble
    //Marble  M(to)
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(3, 1, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_diagonal2() {
    //Marble   M(to)
    //M(from)  Marble
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(4, 1, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_across_board() {
    //Marble   M(to)
    //M(from)  Marble
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(4, 0, 2, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_empty() {
    //Marble
    //Empty
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(2, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_over_2_marbles_to_empty() {
    //Marble
    //Marble
    //Marble
    //Empty
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(0, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_with_empty_slot_in_between() {
    //M(from) Empty M(to)
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(3,2,3,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_invalid_top_left_corner() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(2, 3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_invalid_adjacent() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(1, 2, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_adjacent_empty_to_marble() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(3, 3, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_marble_distance2() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(3, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_marble_diagonal() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(3, 3, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_invalid_to_invalid() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    e.move(1, 2, 5, 5);
  }

  @Test
  public void isGameOver_full_game() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
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
    EnglishSolitaireModel e = new EnglishSolitaireModel();
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
    EnglishSolitaireModel e3 = new EnglishSolitaireModel();
    assertEquals(7, e3.getBoardSize());

    EnglishSolitaireModel e5 = new EnglishSolitaireModel(5);
    assertEquals(13, e5.getBoardSize());

    EnglishSolitaireModel e7 = new EnglishSolitaireModel(7);
    assertEquals(19, e7.getBoardSize());

    EnglishSolitaireModel e9 = new EnglishSolitaireModel(9);
    assertEquals(25, e9.getBoardSize());

    EnglishSolitaireModel e1111 = new EnglishSolitaireModel(1111);
    assertEquals(3331, e1111.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(3);

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
    EnglishSolitaireModel e = new EnglishSolitaireModel(3);
    assertEquals(32, e.getScore());
    e.move(1, 3, 3, 3);
    assertEquals(31, e.getScore());
    e.move(2, 1, 2, 3);
    assertEquals(30, e.getScore());
    e.move(0, 2, 2, 2);
    assertEquals(29, e.getScore());

    EnglishSolitaireModel e2 = new EnglishSolitaireModel(5);
    assertEquals(104, e2.getScore());
    e2.move(6, 4, 6, 6);
    assertEquals(103, e2.getScore());
    e2.move(6, 2, 6, 4);
    assertEquals(102, e2.getScore());
    e2.move(6, 0, 6, 2);
    assertEquals(101, e2.getScore());
  }
}