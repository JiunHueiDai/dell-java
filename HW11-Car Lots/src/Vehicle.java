
public class Vehicle {
	/*
	 * These variables will only be set in constructor since they don't contain
	 * setters
	 */
	private String _description;
	private String _licenseNumber;
	private String _make;
	private String _model;
	private String _price;

	/* The getter for description of a vehicle */
	public String getDescription() {
		return _description;
	}

	/* The getter for license number of a vehicle */
	public String getLicenseNumber() {
		return _licenseNumber;
	}

	/* The getter for make of a vehicle */
	public String getMake() {
		return _make;
	}

	/* The getter for model of a vehicle */
	public String getModel() {
		return _model;
	}

	/* The getter for price of a vehicle */
	public String getPrice() {
		return _price;
	}

	/* Vehicle constructor to initialize all the vehicle properties */
	Vehicle(String make, String model, String price, String licenseNumber, String description) {
		_make = make;
		_model = model;
		_price = price;
		_licenseNumber = licenseNumber;
		_description = description;
	}

	/*
	 * Print all of vehicle details, including Make, Model, License Number, Price,
	 * Description
	 */
	public void printVehicleDetail() {
		System.out.println("***Vehicle: Make - " + getMake() + ", Model - " + getModel() + ", License Number - "
				+ getLicenseNumber() + ", price - " + getPrice() + ", description - " + getDescription());
	}
}
