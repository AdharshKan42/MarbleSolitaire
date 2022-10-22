package cs3500.marblesolitaire;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Final Class from where the entire Marble Solitaire game is ran from (can choose what type of
 * game to play through the command line).
 */
public final class MarbleSolitaire {
  /**
   * Main method for Marble Solitaire game, (can choose what type of
   *  * game to play through the command line).
   *
   * @param args command line arguments (either english, european, or triangular for type of game,
   *             then -size N, where N is an integer, and/or -hole I J, where I J are also
   *             integers.
   */
  public static void main(String[] args) {
    ArrayList<String> arr = new ArrayList<String>(Arrays.asList(args));
    String first = arr.get(0);

    Readable in;
    Appendable out;
    EnglishSolitaireModel englishModel;
    EuropeanSolitaireModel europeanModel;
    TriangleSolitaireModel triangleModel;
    MarbleSolitaireView view;

    MarbleSolitaireControllerImpl controller = null;

    in = new InputStreamReader(System.in);
    out = System.out;

    switch (first) {
      case "english":
        if (arr.contains("-size")) {
          int boardWidth = Integer.parseInt(arr.get(arr.indexOf("-size") + 1));
          if (arr.contains("-hole")) {
            int row = Integer.parseInt(arr.get(arr.indexOf("-hole") + 1));
            int col = Integer.parseInt(arr.get(arr.indexOf("-hole") + 2));

            englishModel = new EnglishSolitaireModel(boardWidth, row, col);
          } else {
            englishModel = new EnglishSolitaireModel(boardWidth);
          }
        } else if (arr.contains("-hole")) {
          int row = Integer.parseInt(arr.get(arr.indexOf("-hole") + 1));
          int col = Integer.parseInt(arr.get(arr.indexOf("-hole") + 2));

          englishModel = new EnglishSolitaireModel(row, col);
        } else {
          englishModel = new EnglishSolitaireModel();
        }

        view = new MarbleSolitaireTextView(englishModel, out);
        controller = new MarbleSolitaireControllerImpl(englishModel, view, in);
        break;
      case "european":
        if (arr.contains("-size")) {
          int boardWidth = Integer.parseInt(arr.get(arr.indexOf("-size") + 1));
          if (arr.contains("-hole")) {
            int row = Integer.parseInt(arr.get(arr.indexOf("-hole") + 1));
            int col = Integer.parseInt(arr.get(arr.indexOf("-hole") + 2));

            europeanModel = new EuropeanSolitaireModel(boardWidth, row, col);
          } else {
            europeanModel = new EuropeanSolitaireModel(boardWidth);
          }
        } else if (arr.contains("-hole")) {
          int row = Integer.parseInt(arr.get(arr.indexOf("-hole") + 1));
          int col = Integer.parseInt(arr.get(arr.indexOf("-hole") + 2));

          europeanModel = new EuropeanSolitaireModel(row, col);
        } else {
          europeanModel = new EuropeanSolitaireModel();
        }

        view = new MarbleSolitaireTextView(europeanModel, out);
        controller = new MarbleSolitaireControllerImpl(europeanModel, view, in);
        break;
      case "triangular":
        if (arr.contains("-size")) {
          int boardWidth = Integer.parseInt(arr.get(arr.indexOf("-size") + 1));
          if (arr.contains("-hole")) {
            int row = Integer.parseInt(arr.get(arr.indexOf("-hole") + 1));
            int col = Integer.parseInt(arr.get(arr.indexOf("-hole") + 2));

            triangleModel = new TriangleSolitaireModel(boardWidth, row, col);
          } else {
            triangleModel = new TriangleSolitaireModel(boardWidth);
          }
        } else if (arr.contains("-hole")) {
          int row = Integer.parseInt(arr.get(arr.indexOf("-hole") + 1));
          int col = Integer.parseInt(arr.get(arr.indexOf("-hole") + 2));

          triangleModel = new TriangleSolitaireModel(row, col);
        } else {
          triangleModel = new TriangleSolitaireModel();
        }

        view = new TriangleSolitaireTextView(triangleModel, out);
        controller = new MarbleSolitaireControllerImpl(triangleModel, view, in);
        break;
      default:
        //According to the assignment, there shouldn't be any invalid or empty inputs and thus
        //the default case shouldn't be called.
    }
    controller.playGame();
  }

}
