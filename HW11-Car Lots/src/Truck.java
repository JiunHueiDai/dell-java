
public class Truck extends Vehicle {
	/*
	 * This variable will only be set in constructor since it doesn't contain setter
	 */
	private int _bedSize;

	/*The getter for bed size of a Car*/
	public int getBedSize() {
		return _bedSize;
	}

	/*Truck constructor to initialize all the truck properties and also initialize it in the parent/super class*/
	Truck(String make, String model, String price, String licenseNumber, String description, int bedSize) {
		super(make, model, price, licenseNumber, description);
		_bedSize = bedSize;
	}

	/*Method overwrite from parent/super class since Truck class has one extra property than parent/super class*/
	public void printVehicleDetail() {
		System.out.println("***Truck: Make - " + getMake() + ", Model - " + getModel() + ", License Number - "
				+ getLicenseNumber() + ", price - " + getPrice() + ", Bed Size - " + getBedSize() + ", description - "
				+ getDescription());
	}
}
