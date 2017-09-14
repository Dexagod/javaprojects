package game;

public class ColorConverter {

  public static String toHex(double r, double g, double b) {
    return "#" + toBrowserHexValue((int) r) + toBrowserHexValue((int) g) + toBrowserHexValue((int) b);
  }

  private static String toBrowserHexValue(int number) {
    StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
    while (builder.length() < 2) {
      builder.append("0");
    }
    return builder.toString().toUpperCase();
  }


}