import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {

  MarbleSolitaireModelState m;
  MarbleSolitaireTextView textView;

  @Test(expected = IllegalArgumentException.class)
  public void testOneInputConstructorReceivingNullInput() {
    textView = new MarbleSolitaireTextView(m);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFullConstructorReceivingNull_ModelState() {
    Appendable builder = new StringBuilder();
    textView = new MarbleSolitaireTextView(null, builder);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFullConstructorReceivingNullAppendable() {
    textView = new MarbleSolitaireTextView(m, null);
  }

  @Test
  public void testToString() {
    m = new EnglishSolitaireModel(3);
    textView = new MarbleSolitaireTextView(m);

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", textView.toString());

    m = new EnglishSolitaireModel(5, 0, 6);
    textView = new MarbleSolitaireTextView(m);

    assertEquals("        O O _ O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", textView.toString());
  }

  @Test
  public void testToStringAfter1Move() {
    m = new EnglishSolitaireModel(3);
    textView = new MarbleSolitaireTextView(m);

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", textView.toString());

    EnglishSolitaireModel mprime = new EnglishSolitaireModel(3);
    mprime.move(3, 1, 3, 3);
    m = mprime;
    textView = new MarbleSolitaireTextView(m);

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", textView.toString());

    m = new EnglishSolitaireModel(5, 0, 6);
    textView = new MarbleSolitaireTextView(m);

    assertEquals("        O O _ O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", textView.toString());

    mprime = new EnglishSolitaireModel(5, 0, 6);
    mprime.move(0, 4, 0, 6);
    m = mprime;
    textView = new MarbleSolitaireTextView(m);

    assertEquals("        _ _ O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", textView.toString());
  }

  @Test
  public void testRenderBoardEnglish() {
    m = new EnglishSolitaireModel(3);
    Appendable builder = new StringBuilder();
    textView = new MarbleSolitaireTextView(m, builder);

    try {
      textView.renderBoard();
    } catch (IOException e) {
      //
    }
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", builder.toString());

    m = new EnglishSolitaireModel(5, 0, 6);
    builder = new StringBuilder();
    textView = new MarbleSolitaireTextView(m, builder);

    try {
      textView.renderBoard();
    } catch (IOException e) {
      //
    }

    assertEquals("        O O _ O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", builder.toString());
  }

  @Test
  public void testRenderBoardEuropean() {
    m = new EuropeanSolitaireModel(3);
    Appendable builder = new StringBuilder();
    textView = new MarbleSolitaireTextView(m, builder);

    try {
      textView.renderBoard();
    } catch (IOException e) {
      //
    }
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", builder.toString());

    m = new EuropeanSolitaireModel(5, 0, 6);
    StringBuilder builder2 = new StringBuilder();

    textView = new MarbleSolitaireTextView(m, builder2);

    try {
      textView.renderBoard();
    } catch (IOException e) {
      //
    }

    assertEquals("        O O _ O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", builder2.toString());
  }

  @Test(expected = IOException.class)
  public void testRenderException() throws IOException {
    m = new EnglishSolitaireModel(3);
    InvalidAppendable builder = new InvalidAppendable();
    textView = new MarbleSolitaireTextView(m, builder);
    textView.renderBoard();
  }

  @Test
  public void testRenderMessage() {
    m = new EnglishSolitaireModel(3);
    Appendable builder = new StringBuilder();
    textView = new MarbleSolitaireTextView(m, builder);

    try {
      textView.renderMessage("Hello World!\n");
    } catch (IOException e) {
      //
    }

    assertEquals("Hello World!\n", builder.toString());

    try {
      textView.renderMessage("Goodbye Moon!\n");
    } catch (IOException e) {
      //
    }

    String[] lines = builder.toString().split("\n");
    assertEquals("Goodbye Moon!", lines[1]);

  }

  @Test(expected = IOException.class)
  public void testRenderMessageException() throws IOException {
    m = new EnglishSolitaireModel(3);
    Appendable builder = new InvalidAppendable();
    textView = new MarbleSolitaireTextView(m, builder);
    textView.renderMessage("Hello World!");
  }


}