public class JoJo {
  public final static Tariff SKANE = new Skane();
  public final static Rebate DUO = new Family();
  public static void main(String[] args) {
    TravelCard jojo = new TravelCard();
    jojo.setTariff(SKANE);
    double price = jojo.price(3, DUO);
    System.out.println(price);
  }
}
