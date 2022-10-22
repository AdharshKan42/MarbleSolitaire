import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Tests for MarbleSolitaireControllerImpl.
 */
public class MarbleSolitaireControllerImplTest {
  Readable in;
  Appendable out;
  EnglishSolitaireModel model;
  MarbleSolitaireView view;
  MarbleSolitaireControllerImpl controller;

  @Test
  public void testConstructor() {
    in = new StringReader("");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    assertFalse(model.isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_null_model() {
    in = new StringReader("");
    out = new StringBuilder();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_null_view() {
    in = new StringReader("");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();

    controller = new MarbleSolitaireControllerImpl(model, view, in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_null_readableInput() {
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
  }

  @Test(expected = IllegalStateException.class)
  public void readableOutOfInputs_empty_string() {
    Readable in = new StringReader("");
    Appendable out = new StringBuilder();
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);

    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void readableOutofInputs_invalid_inputs() {
    in = new StringReader("asdfasdf peqwirjpqowier 12341234");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void readableOutofInputs_invalid_moves() {
    in = new StringReader("1 1 1    ");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void readableOutofInputs_invalid_4_moves() {
    in = new StringReader("1 1 1 2");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void readableOutofInputs_3_valid_spaces() {
    in = new StringReader("3 1 3");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test
  public void quit_on_first_input() {
    in = new StringReader("q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    //Since controller doesn't call MockMarbleSolitaire (not valid move),
    //nothing is appended to the log
    assertEquals("", log.toString());
  }

  @Test
  public void quit_on_second_input() {
    in = new StringReader("1 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    //Since controller doesn't call MockMarbleSolitaire (not valid move),
    //nothing is appended to the log
    assertEquals("", log.toString());
  }

  @Test
  public void quit_on_third_input() {
    in = new StringReader("1 2 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    //Since controller doesn't call MockMarbleSolitaire (not valid move),
    //nothing is appended to the log
    assertEquals("", log.toString());
  }

  @Test
  public void quit_on_fourth_input() {
    in = new StringReader("1 2 3 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    //Since controller doesn't call MockMarbleSolitaire (not valid move),
    //nothing is appended to the log
    assertEquals("", log.toString());
  }

  @Test
  public void invalid_inputs_then_quit() {
    in = new StringReader("asdf asdf asdf asdf q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    //Since controller doesn't call MockMarbleSolitaire (not valid move),
    //nothing is appended to the log
    assertEquals("", log.toString());
  }

  @Test
  public void invalid_move_then_quit() {
    in = new StringReader("1 1 1 2 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 0, fromCol = 0, toRow = 0, toCol = 1\n", log.toString());
  }

  @Test
  public void invalid_move_then_quit_twice() {
    in = new StringReader("1 1 1 2 q q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 0, fromCol = 0, toRow = 0, toCol = 1\n", log.toString());
  }

  @Test
  public void valid_move_then_quit_twice() {
    in = new StringReader("4 2 4 4 q q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void move_ALL_Spaces() {
    in = new StringReader("4 2 4 4 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void move_ALL_Enters() {
    in = new StringReader("4\n2\n4\n4\nq");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void move_mix_spaces_and_enters() {
    in = new StringReader("\n4 2\n4 4\nq");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void move_invalid_inputs_in_between() {
    in = new StringReader("4 asdf22&^ 2 asdf#)*@ 4 4 @*#()@*(# q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void move_invalid_negative_digits_in_between() {
    in = new StringReader("4 -2 2 -9 4 4 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void invalid_move_invalid_negative_digits_in_between() {
    in = new StringReader("4 -2 2 -9 4 3 q");
    out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockMarbleSolitaire model = new MockMarbleSolitaire(log);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    //invalid move input gets to MockModel (will throw exception in EnglishSolitaireModel)
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 2\n", log.toString());
  }

  @Test
  public void invalid_move_output() {
    in = new StringReader("1 1 1 3 q");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    String output = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. Move is invalid.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n";
    assertEquals(output, out.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void gameCannotTransmitOutput() {
    in = new StringReader("4 -2 2 -9 4 3 q");
    out = new InvalidAppendable();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    //Throws IOException that's caught by the controller and
    //instead throws an IllegalStateExpection
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test
  public void asksForOnlyInvalidInput_fromReadable() {
    in = new StringReader("4 2 -2 4 4 q");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    Readable expInput = new StringReader("4 2 4 4 q");
    Appendable expOut = new StringBuilder();
    EnglishSolitaireModel expModel = new EnglishSolitaireModel();
    MarbleSolitaireView expView = new MarbleSolitaireTextView(expModel, expOut);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    MarbleSolitaireControllerImpl expController =
            new MarbleSolitaireControllerImpl(expModel, expView, expInput);
    expController.playGame();

    assertEquals(expView.toString(), view.toString());
  }

  @Test
  public void earlyQuitOutputs_are_Valid_incompleteMove() {
    in = new StringReader("4 2 q");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    String output = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n";

    assertEquals(output, out.toString());
  }


  @Test
  public void earlyQuitOutputs_are_Valid_valid_then_invalid_entry() {
    in = new StringReader("4 6 4 4 asdf q");
    out = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    String output = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Please re-enter value:\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n";

    assertEquals(output, out.toString());
  }

  @Test
  public void fullGame() {
    in = new StringReader("");
    out = new StringBuilder();
    model = new EnglishSolitaireModel(1);
    view = new MarbleSolitaireTextView(model, out);

    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    String output = "Game over!\n" +
            "_\n" +
            "Score: 0\n";
    assertEquals(output, out.toString());
  }

  //test Constructor
  //null for model, view, or input
  //Controller inputs:
  //if readable is null (runs out of inputs) ->tests hasNext
  //game quitting at any point
  //4 inputs: separated by spaces or new lines
  // multiple bad inputs between 4 good inputs
  //all spaces
  //all enters
  //mix of spaces and enters
  //     not positive integer input (negative number, decimal, char, string, etc)
  // bad inputs + 4 positive inputs but invalid move -> invalid move is called
  // multiple bad inputs with less than 4 ]good inputs (readable runs out)
  //test gameQuit (+ exception)
  //test transmitScore (+ exception)
  // valid move + q (before gameOver)


  //Controller outputs:
  //test gameOver()
  //test all messages and calls to view


}