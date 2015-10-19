import java.util.ArrayList;
import java.util.List;

public class RentalStatement {
  private String customerName;
  private List<Rental> rentals = new ArrayList<Rental>();
  private double totalAmount;
  private int frequentRenterPoints;

  public RentalStatement(String name) {
    this.customerName = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getCustomerName() {
    return customerName;
  }

  public String makeRentalStatement() {
    clearTotals();
    return makeHeader() + makeRentalItems() + makeFooter();
  }

  private void clearTotals() {
    totalAmount = 0;
    frequentRenterPoints = 0;
  }

  private String makeHeader() {
    return "Rental Record for " + getCustomerName() + "\n";
  }

  private String makeRentalItems() {
    String rentalItems = "";
    for (Rental rental : rentals)
      rentalItems += makeRentalItem(rental);

    return rentalItems;
  }

  private String makeRentalItem(Rental rental) {
    double rentalAmount = rental.determineAmount();
    frequentRenterPoints += rental.determinePoints();
    totalAmount += rentalAmount;

    return formatRentalItem(rental, rentalAmount);
  }

  private String formatRentalItem(Rental rental, double thisAmount) {
    return "\t" + rental.getTitle() + "\t" + thisAmount + "\n";
  }

  private String makeFooter() {
    return "You owed " + totalAmount + "\n" +
      "You earned " + frequentRenterPoints + " frequent renter points\n";
  }

  public double getOwed() {
    return totalAmount;
  }

  public int getPoints() {
    return frequentRenterPoints;
  }
}