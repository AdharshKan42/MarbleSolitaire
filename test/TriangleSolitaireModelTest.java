import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Tests for TriangleSolitaireModel.
 */
public class TriangleSolitaireModelTest {

  static MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;
  static MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  static MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;

  /**
   * Returns the hard-coded boardSize-3 Board with empty slot at (sRow, sCol) as
   * a 2D SlotState array.
   *
   * @param sRow inputted row for empty slot
   * @param sCol inputted column for empty slot
   * @return 2D array of SlotStates for each position on the board
   */
  public static MarbleSolitaireModelState.SlotState[][] getExpected3Board(int sRow, int sCol) {

    MarbleSolitaireModelState.SlotState[][] arr = new MarbleSolitaireModelState.SlotState[3][3];
    arr[0][0] = marble;
    arr[0][1] = invalid;
    arr[0][2] = invalid;
    arr[1][0] = marble;
    arr[1][1] = marble;
    arr[1][2] = invalid;
    arr[2][0] = marble;
    arr[2][1] = marble;
    arr[2][2] = marble;

    arr[sRow][sCol] = empty;

    return arr;
  }

  /**
   * Returns the hard-coded boardSize-5 Board with empty slot at (sRow, sCol) as
   * a 2D SlotState array.
   *
   * @param sRow inputted row for empty slot
   * @param sCol inputted column for empty slot
   * @return 2D array of SlotStates for each position on the board
   */
  public static MarbleSolitaireModelState.SlotState[][] getExpected5Board(int sRow, int sCol) {
    MarbleSolitaireModelState.SlotState[][] arr = new MarbleSolitaireModelState.SlotState[5][5];
    arr[0][0] = marble;
    arr[0][1] = invalid;
    arr[0][2] = invalid;
    arr[0][3] = invalid;
    arr[0][4] = invalid;
    arr[1][0] = marble;
    arr[1][1] = marble;
    arr[1][2] = invalid;
    arr[1][3] = invalid;
    arr[1][4] = invalid;
    arr[2][0] = marble;
    arr[2][1] = marble;
    arr[2][2] = marble;
    arr[2][3] = invalid;
    arr[2][4] = invalid;
    arr[3][0] = marble;
    arr[3][1] = marble;
    arr[3][2] = marble;
    arr[3][3] = marble;
    arr[3][4] = invalid;
    arr[4][0] = marble;
    arr[4][1] = marble;
    arr[4][2] = marble;
    arr[4][3] = marble;
    arr[4][4] = marble;

    arr[sRow][sCol] = empty;

    return arr;
  }

  @Test
  public void defaultConstructor() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();

    assertEquals(5, e.getBoardSize());
    assertEquals(14, e.getScore());

    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(0, 0);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void inputEmptySlotConstructor() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(2, 1);

    assertEquals(5, e.getBoardSize());
    assertEquals(14, e.getScore());

    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(2, 1);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_1() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_2() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_3() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_0_4() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_2() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_3() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_1_4() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void EmptySlotConstructor_invalidSlotException_3_4() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(3, 4);
  }

  @Test
  public void armThicknessConstructor_3() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(3);

    assertEquals(3, e.getBoardSize());
    assertEquals(5, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(0, 0);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void armThicknessConstructor_5() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(5);

    assertEquals(5, e.getBoardSize());
    assertEquals(14, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(0, 0);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_Negative2() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_Negative4() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(-4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armConstructor_invalidArmThickness_0() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(0);
  }

  @Test
  public void armAndEmptySlotConstructor_3() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(3, 1, 1);

    assertEquals(3, e.getBoardSize());
    assertEquals(5, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected3Board(1, 1);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void armAndEmptySlotConstructor_5() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(5, 2, 1);

    assertEquals(5, e.getBoardSize());
    assertEquals(14, e.getScore());


    //checks if board is constructed properly
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(2, 1);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void armAndEmptySlotConstructor_invalidBoardWidth_Negative2() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(-2, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armAndEmptySlotConstructor_invalidSlot_0_1() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(3, 0, 1);
  }

  @Test
  public void move() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(6,3,3);
    assertEquals(marble, e.getSlotAt(3, 1));
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(empty, e.getSlotAt(3, 3));
    assertEquals(20, e.getScore());
    //move from (3,1) to (3,3) ->left to right
    e.move(3, 1, 3, 3);
    assertEquals(empty, e.getSlotAt(3, 1));
    assertEquals(empty, e.getSlotAt(3, 2));
    assertEquals(marble, e.getSlotAt(3, 3));
    assertEquals(19, e.getScore());

    e = new TriangleSolitaireModel(6, 4,2);
    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(marble, e.getSlotAt(4, 3));
    assertEquals(empty, e.getSlotAt(4, 2));
    //move from (4,4) to (4,2) -> right to left
    e.move(4, 4, 4, 2);
    assertEquals(empty, e.getSlotAt(4, 4));
    assertEquals(empty, e.getSlotAt(4, 3));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(19, e.getScore());

    e = new TriangleSolitaireModel(6, 3,2);
    assertEquals(marble, e.getSlotAt(5, 2));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(empty, e.getSlotAt(3, 2));
    //move from (5,2) to (3,2) ->bottom-left to top-right
    e.move(5, 2, 3, 2);
    assertEquals(empty, e.getSlotAt(5, 2));
    assertEquals(empty, e.getSlotAt(4, 2));
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(19, e.getScore());

    e = new TriangleSolitaireModel(6, 5,2);
    assertEquals(marble, e.getSlotAt(3, 2));
    assertEquals(marble, e.getSlotAt(4, 2));
    assertEquals(empty, e.getSlotAt(5, 2));
    //move from (3,2) to (5,2) -> top-right to bottom-left
    e.move(3, 2, 5, 2);
    assertEquals(empty, e.getSlotAt(3, 2));
    assertEquals(empty, e.getSlotAt(4, 2));
    assertEquals(marble, e.getSlotAt(5, 2));
    assertEquals(19, e.getScore());

    e = new TriangleSolitaireModel(6, 4,4);
    assertEquals(marble, e.getSlotAt(2, 2));
    assertEquals(marble, e.getSlotAt(3, 3));
    assertEquals(empty, e.getSlotAt(4, 4));
    //move from (2,4) to (4,4) -> top-left to bottom-right
    e.move(2, 2, 4, 4);
    assertEquals(empty, e.getSlotAt(2, 2));
    assertEquals(empty, e.getSlotAt(3, 3));
    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(19, e.getScore());

    e = new TriangleSolitaireModel(6, 2,2);
    assertEquals(marble, e.getSlotAt(4, 4));
    assertEquals(marble, e.getSlotAt(3, 3));
    assertEquals(empty, e.getSlotAt(2, 2));
    //move from (4,4) to (2,2) ->bottom-right to top-left
    e.move(4, 4, 2, 2);
    assertEquals(empty, e.getSlotAt(4, 4));
    assertEquals(empty, e.getSlotAt(3, 3));
    assertEquals(marble, e.getSlotAt(2, 2));
    assertEquals(19, e.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_adjacent_marble_to_marble() {
    //M(from) M(to)
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(2, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_distance2() {
    //M(from) Marble M(to)
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(4, 1, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_diagonal_distance2() {
    //M(from) Marble
    //Marble  M(to)
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(23, 1, 5, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_diagonal2() {
    //Marble   M(to)
    //M(from)  Marble
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(5, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_across_board() {
    //Marble   M(to)
    //M(from)  Marble
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(4, 0, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_empty() {
    //Marble
    //Empty
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(1, 1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_over_2_marbles_to_empty() {
    //Marble
    //Marble
    //Marble
    //Empty
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(3, 3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_marble_with_empty_slot_in_between() {
    //M(from) Empty M(to)
    TriangleSolitaireModel e = new TriangleSolitaireModel(1,1);
    e.move(2,2,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_marble_to_invalid() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(0, 0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_invalid_adjacent() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(0, 0, 0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_adjacent_empty_to_marble() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(2,1);
    e.move(2, 1, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_marble_distance2() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(0, 0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_empty_to_marble_diagonal() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(0, 0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove_invalid_to_invalid() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();
    e.move(1, 2, 0, 2);
  }

  @Test
  public void isGameOver_full_game() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(3);
    assertFalse(e.isGameOver());
    e.move(2,2,0,0);
    assertFalse(e.isGameOver());
    e.move(2, 0,2, 2);
    assertFalse(e.isGameOver());
    e.move(0, 0, 2, 0);
    assertTrue(e.isGameOver());
  }

  @Test
  public void isGameOver_random_game() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(4);
    assertFalse(e.isGameOver());
    e.move(2,2,0,0);
    assertFalse(e.isGameOver());
    e.move(2, 0,2, 2);
    assertFalse(e.isGameOver());
    e.move(0, 0, 2, 0);
    assertFalse(e.isGameOver());
    e.move(3, 0, 1, 0);
    assertFalse(e.isGameOver());
    e.move(3, 2, 3, 0);
    assertFalse(e.isGameOver());
    e.move(3, 3, 1, 1);
    assertTrue(e.isGameOver());
  }

  @Test
  public void getBoardSize() {
    TriangleSolitaireModel e3 = new TriangleSolitaireModel();
    assertEquals(5, e3.getBoardSize());

    TriangleSolitaireModel e5 = new TriangleSolitaireModel(5);
    assertEquals(5, e5.getBoardSize());

    TriangleSolitaireModel e7 = new TriangleSolitaireModel(7);
    assertEquals(7, e7.getBoardSize());

    TriangleSolitaireModel e9 = new TriangleSolitaireModel(9);
    assertEquals(9, e9.getBoardSize());

    TriangleSolitaireModel e1111 = new TriangleSolitaireModel(1111);
    assertEquals(1111, e1111.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    TriangleSolitaireModel e = new TriangleSolitaireModel();

    //checks if board is constructed properly
    //checks every position against hard-coded 5x5 slotState arr w/ empty center (0,0)
    MarbleSolitaireModelState.SlotState[][] expectedBoard = getExpected5Board(0, 0);
    for (int r = 0; r < e.getBoardSize(); r += 1) {
      for (int c = 0; c < e.getBoardSize(); c += 1) {
        assertEquals(expectedBoard[r][c], e.getSlotAt(r, c));
      }
    }
  }

  @Test
  public void getScore() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(3);
    assertEquals(5, e.getScore());
    e.move(2,2,0,0);
    assertEquals(4, e.getScore());
    e.move(2, 0,2, 2);
    assertEquals(3, e.getScore());
    e.move(0, 0, 2, 0);
    assertEquals(2, e.getScore());

    TriangleSolitaireModel e2 = new TriangleSolitaireModel(5);
    assertEquals(14, e2.getScore());
    e2.move(2,2,0,0);
    assertEquals(13, e2.getScore());
    e2.move(3, 1, 1, 1);
    assertEquals(12, e2.getScore());
    e2.move(3, 3, 3, 1);
    assertEquals(11, e2.getScore());
  }
}