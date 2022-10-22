import java.io.IOException;

/**
 * Invalid Appendable for testing failure of transmitting data to Appendable object;
 * throws IOExceptions for all implemented methods.
 */
public class InvalidAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
