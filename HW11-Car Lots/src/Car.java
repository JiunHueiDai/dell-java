
public class Car extends Vehicle {
	/*These variables will only be set in constructor since they don't contain setters*/
	private String _type;
	private String _numberOfDoors;

	/*The getter for a Car Type*/
	public String getType() {
		return _type;
	}

	/*The getter for number of doors of a Car*/
	public String getNumberOfDoors() {
		return _numberOfDoors;
	}

	/*Car constructor to initialize all the car properties and also initialize it in the parent/super class*/
	Car(String make, String model, String price, String licenseNumber, String description, String type,
			String numberOfDoors) {
		super(make, model, price, licenseNumber, description);
		_type = type;
		_numberOfDoors = numberOfDoors;
	}

	/*Method overwrite from parent/super class since Car class has two extra properties than parent/super class*/
	public void printVehicleDetail() {
		System.out.println("***Car: Make - " + getMake() + ", Model - " + getModel() + ", License Number - "
				+ getLicenseNumber() + ", price - " + getPrice() + ", Type - " + getType() + ", Number Of Doors - "
				+ getNumberOfDoors() + ", description - " + getDescription());
	}
}
