public class Skane implements Tariff {
  public double price(int zones) {
    switch (zones) {
      case 1:
        return 17.0;
      default:
        return 7.0 * zones + 7.0;
    }
  }
}
