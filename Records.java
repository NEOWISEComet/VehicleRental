import java.util.HashMap;
import java.util.Map;

public class Records {
    private Map <String, VehicleRentals> RentalVehicles;
    private Map <String, BorrowClass> RentRecords;

    public Records() {
        RentalVehicles = new HashMap<>();
        RentRecords = new HashMap<>();
    }

    /**
     * Adds a vehicle to the rental
     * Either Available or Unavailable
     * Essentially a warehouse list
     * @param rentals
     */
    public void addRentalVehicle(VehicleRentals rentals){
        RentalVehicles.put("RNV" +rentals.getRental_ID(), rentals);
    }

    /**
     * Removes a vehicle from the rental
     * @param rentalID
     */
    public void removeRentalVehicle(String rentalID){
        RentalVehicles.remove(rentalID);
    }

    /**
     * Returns a specific vehicle from the Hashpmap
     * @param rentalID
     * @return
     */
    public VehicleRentals getRentalVehicle(String rentalID){
        return RentalVehicles.get(rentalID);
    }

    /**
     * Returns a list of all vehicles
     * @return
     */
    public Map<String, VehicleRentals> getRentalVehicles() {
        return RentalVehicles;
    }


    /**
     * Methods for Booking or Renting a vehicle
     */
    
    /**
     * Creates a new Rented Vehicle Records
     * Should include dates
     * @param RentedRecord
     * @param Rental_ID
     */
    public void NewBorrowRecord(BorrowClass customer){
        RentRecords.put(customer.getBorrowID(), customer);
    }
    /**
     * Removes a rented vehicle record
     * @param rentalID
     */
    public void removeRentedRecord(String rentalID){
        RentRecords.remove(rentalID);
    }
    /**
     * Returns a list of all rented vehicles
     * @return
     */
    public Map<String, BorrowClass> getBorrowRecords() {
        return RentRecords;
    }

    

}
