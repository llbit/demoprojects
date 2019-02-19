public class TravelCard {
  private Tariff tariff;
  public double price(int zones, Rebate rebate) {
    double amount = tariff.price(zones);
    return rebate.price(amount);
  }
  public void setTariff(Tariff tariff) {
    this.tariff = tariff;
  }
}
