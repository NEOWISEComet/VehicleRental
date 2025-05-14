import java.util.Map;

public class ManageRental {
    private Records records;
    
    public ManageRental(Records records) {
        this.records = records;
    }

    public void addRentalCar(Car car) {
        if (!vehicleExists(car.getRental_ID())) {
            records.addRentalVehicle(car);
        }
    }
    public void addRentalMotorcycle(Motorcycle motorcycle) {
        if (!vehicleExists(motorcycle.getRental_ID())) {
            records.addRentalVehicle(motorcycle);
            
        }
    }
    public void removeRental(String rentalID) {
        records.removeRentalVehicle(rentalID);
    }
    public Map<String, VehicleRentals> getRentalVehicles() {
        return records.getRentalVehicles();
    }
    /**
     * Checks if a vehicle is available for rent
     * @param rentalID
     * @return true if available, false otherwise
     */
    public boolean isVehicleAvailable(String rentalID) {
        VehicleRentals vehicle = records.getRentalVehicles().get(rentalID);
        if (vehicle != null) {
            return vehicle.isAvailable();
        }
        return false;
    }
    /**
     * Checks if Vehicle already exists
     * @param rentalID
     * @return true if exists, false otherwise
     */
    private boolean vehicleExists(String rentalID) {
        String formattedID = "RNV" + rentalID;
        return records.getRentalVehicles().containsKey(formattedID);
    }

    /**
     * Checks if a vehicle is Available for rent
     * @param rentalID
     * @return true if Available, false otherwise
     */
    private boolean isVehicleRented(String rentalID) {
        String formattedID = "RNV" + rentalID;
        VehicleRentals vehicle = records.getRentalVehicles().get(formattedID);
        return vehicle != null && vehicle.getAvailability() == VehicleRentals.Availability.Unavailable;
    }

    /**
     * Creates a new customer or a renting/borrowing record
     */
    public void createNewBorrowRecord(BorrowClass customer) {
        if (!vehicleExists(customer.getVehicleID())) {
            System.out.println("Vehicle not found.");
            return;
        }
        if (isVehicleRented(customer.getVehicleID())) {
            System.out.println("Vehicle is already rented.");
            return;
        }
        else{
            String Veh = customer.getVehicleID();
            VehicleRentals vehicle = records.getRentalVehicles().get(Veh);
            vehicle.setAvailability(VehicleRentals.Availability.Unavailable);
            customer.setStatus(BorrowClass.BorrowStatus.Unpaid);
            records.NewBorrowRecord(customer);
        }
    }

    /**
     * Retrieves all borrow records.
     * @return A map of borrow records.
     */
    public Map<String, BorrowClass> getBorrowRecords() {
        return records.getBorrowRecords();
    }

    /**
     * Retrieves a specific borrow record by its borrow ID.
     * @param borrowID The borrow ID.
     * @return The BorrowClass object, or null if not found.
     */
    public BorrowClass getBorrowRecord(String borrowID) {
        return records.getBorrowRecords().get(borrowID);
    }

    /**
     * Method or function for returning a vehivle
     * @param borrowID
     */
    public void returnVehicle(String borrowID) {
        BorrowClass borrow = records.getBorrowRecords().get(borrowID);
        String vehicleID = borrow.getVehicleID();
        if (vehicleID != null && borrow != null) {
            VehicleRentals vehicle = records.getRentalVehicles().get(vehicleID);
            vehicle.setAvailability(VehicleRentals.Availability.Available);
            vehicle.calculateRentalPrice(borrow.getRentedDays());
            //This is just assuming if the vehicle is Paid after returning it
            //borrow.setStatus(BorrowClass.BorrowStatus.Paid);
        }
    }

}
