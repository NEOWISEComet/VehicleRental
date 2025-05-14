public class VehicleRentals extends Vehicle implements Rentable {

    private String Rental_ID;
    private Availability availability;
    private double rentalPrice;

    public VehicleRentals(String Rental_ID, int mileage, String LicensePLate, String color, String Brand, 
    Availability availability, double rentalPrice){
        super(mileage, LicensePLate, color, Brand);
        this.Rental_ID = Rental_ID;
        this.availability = availability;
    }

    public enum Availability{
        Available,
        Unavailable
    }
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Availability getAvailability() {
        return availability;
    }

    public String getRental_ID() {
        return Rental_ID;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    
    public double getRentalPrice() {
        return rentalPrice;
    }

    @Override
    public double calculateRentalPrice(int rentalDays) {
        return rentalPrice * rentalDays;
    }

    @Override
    public boolean isAvailable() {
        return availability == Availability.Available;
    }

    @Override
    public String toString(){
        return "Rental ID: " + Rental_ID + "\n" +
                "Mileage: " + getMileage() + "\n" +
                "License Plate: " + getLicensePlate() + "\n" +
                "Color: " + getColor() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Availability: " + availability + "\n";

    }

}

class Motorcycle extends VehicleRentals {

    private String MotorcycleModel;
    private MotorcycleType motorcycleType;

    public Motorcycle(String Rental_ID, int mileage, String LicensePLate, String color, String Brand,
     Availability availability, String MotorcycleModel, MotorcycleType motorcycleType, double rentalPrice){
        super(Rental_ID, mileage, LicensePLate, color, Brand, availability, rentalPrice);
        this.MotorcycleModel = MotorcycleModel;
        this.motorcycleType = motorcycleType;

    }

    public enum MotorcycleType{
        Scooter,
        Big_Bike,
        Standard
    }

    public MotorcycleType getMotorcycleType(){
        return motorcycleType;
    }

    @Override
    public String toString(){
        return super.toString() + 
                "Motorcycle Model: " + MotorcycleModel + "\n" +
                "Motorcycle Type: " + motorcycleType + "\n";
    }
}

class Car extends VehicleRentals {
    private String CarModel;
    private CarType carType;


    public Car(String Rental_ID, int mileage, String LicensePLate, String color, String Brand, 
    Availability availability, String CarModel, CarType carType, double rentalPrice){
        super(Rental_ID, mileage, LicensePLate, color, Brand, availability, rentalPrice);
        this.CarModel = CarModel;
        this.carType = carType;
    }

    public enum CarType{
        Sedan,
        Pickup,
        Van,
        SUV,
        EV
    }

    public CarType getCarType(){
        return carType;
    } 

    @Override
    public String toString(){
        return super.toString() + 
                "Car Model: " + CarModel + "\n" +
                "Car Type: " + carType + "\n";
    }
}
