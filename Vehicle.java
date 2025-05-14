public abstract class Vehicle{
    private int mileage;
    private String LicensePLate;
    private String color;
    private String Brand;

    public Vehicle(int mileage, String LicensePLate, String color, String Brand){
        this.mileage = mileage;
        this.LicensePLate = LicensePLate;
        this.color = color;
        this.Brand = Brand;
    }
    
    public String getLicensePlate(){
        return LicensePLate;
    }

    public String getColor(){
        return color;
    }

    public String getBrand(){
        return Brand;
    }
    public int getMileage(){
        return mileage;
    }
}
