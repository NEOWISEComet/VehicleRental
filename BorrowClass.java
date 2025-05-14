public class BorrowClass {
    private String borrowID;
    private String vehicleID;
    private int rentedDays;
    private Customer customer;
    private BorrowStatus status;

    public BorrowClass(String borrowlID, String vehicleID, int rentalDays, Customer customer, BorrowStatus status) {
        this.borrowID = borrowlID;
        this.vehicleID = vehicleID;
        this.rentedDays = rentalDays;
        this.customer = customer;
        this.status = status;
    }
    public String getBorrowID() {
        return borrowID;
    }
    public String getVehicleID() {
        return vehicleID;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getRentedDays() {
        return rentedDays;
    }
    public BorrowStatus getStatus() {
        return status;
    }
    public enum BorrowStatus {
        Paid,
        Unpaid
    }
    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
    return "Borrow ID: " + borrowID + "\n" +
           "Vehicle ID: " + vehicleID + "\n" +
           "Customer: " + customer.getName() + "\n" +
           "Rented Days: " + rentedDays + "\n" +
           "Status: " + status + "\n";
    }
}
