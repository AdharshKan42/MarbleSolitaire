import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for TriangleSolitaireTextView.
 */
public class TriangleSolitaireTextViewTest {

  MarbleSolitaireModelState m;
  TriangleSolitaireTextView textView;

  @Test(expected = IllegalArgumentException.class)
  public void testOneInputConstructorReceivingNullInput() {
    textView = new TriangleSolitaireTextView(m);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFullConstructorReceivingNull_ModelState() {
    Appendable builder = new StringBuilder();
    textView = new TriangleSolitaireTextView(null, builder);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFullConstructorReceivingNullAppendable() {
    textView = new TriangleSolitaireTextView(m, null);
  }

  @Test
  public void testToString() {
    m = new TriangleSolitaireModel(3);
    textView = new TriangleSolitaireTextView(m);

    assertEquals("  _\n" +
            " O O\n" +
            "O O O", textView.toString());

    m = new TriangleSolitaireModel(5, 3, 2);
    textView = new TriangleSolitaireTextView(m);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O O O O", textView.toString());
  }

  @Test
  public void testToStringAfter1Move() {
    m = new TriangleSolitaireModel(3);
    textView = new TriangleSolitaireTextView(m);

    assertEquals("  _\n" +
            " O O\n" +
            "O O O", textView.toString());

    TriangleSolitaireModel mprime = new TriangleSolitaireModel(3);
    mprime.move(2, 2, 0, 0);
    m = mprime;
    textView = new TriangleSolitaireTextView(m);

    assertEquals("  O\n" +
            " O _\n" +
            "O O _", textView.toString());

    m = new TriangleSolitaireModel(5, 2, 1);
    textView = new TriangleSolitaireTextView(m);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", textView.toString());

    mprime = new TriangleSolitaireModel(5, 2, 1);
    mprime.move(4, 3, 2, 1);
    m = mprime;
    textView = new TriangleSolitaireTextView(m);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O O _ O", textView.toString());
  }

  @Test
  public void testRenderBoard() {
    m = new TriangleSolitaireModel(3);
    Appendable builder = new StringBuilder();
    textView = new TriangleSolitaireTextView(m, builder);

    try {
      textView.renderBoard();
    } catch (IOException e) {
      //
    }
    assertEquals("  _\n" +
            " O O\n" +
            "O O O", builder.toString());


    m = new TriangleSolitaireModel(5, 3, 2);
    builder = new StringBuilder();
    textView = new TriangleSolitaireTextView(m, builder);

    try {
      textView.renderBoard();
    } catch (IOException e) {
      //
    }

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O O O O", textView.toString());
  }

  @Test(expected = IOException.class)
  public void testRenderException() throws IOException {
    m = new TriangleSolitaireModel(3);
    InvalidAppendable builder = new InvalidAppendable();
    textView = new TriangleSolitaireTextView(m, builder);
    textView.renderBoard();
  }

  @Test
  public void testRenderMessage() {
    m = new TriangleSolitaireModel(3);
    Appendable builder = new StringBuilder();
    textView = new TriangleSolitaireTextView(m, builder);

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
    m = new TriangleSolitaireModel(3);
    Appendable builder = new InvalidAppendable();
    textView = new TriangleSolitaireTextView(m, builder);
    textView.renderMessage("Hello World!");
  }


}