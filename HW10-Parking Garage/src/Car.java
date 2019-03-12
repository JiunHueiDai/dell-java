
public class Car {
	private String _color;
	private String _licenseNumber;
	private String _make;
	private String _model;

	/*
	 * Car class construction to initiate car properties with empty string if user
	 * doesn't define
	 */
	Car() {
		initiateCarProperties();
	}

	/*
	 * Car class construction to initiate car properties with user defined
	 * properties
	 */
	public Car(String color, String licenseNumber, String make, String model) {
		_color = color;
		_licenseNumber = licenseNumber;
		_make = make;
		_model = model;
	}

	/*
	 * Initiate/Reset car properties to be empty string which also means there is no
	 * car assigned from user
	 */
	public void initiateCarProperties() {
		_color = "";
		_licenseNumber = "";
		_make = "";
		_model = "";
	}

	/* Return the car's color */
	public String getColor() {
		return _color;
	}

	/* Return the car's license number */
	public String getLicenseNumber() {
		return _licenseNumber;
	}

	/* Return the car's make */
	public String getMake() {
		return _make;
	}

	/* Return the car's model */
	public String getModel() {
		return _model;
	}
}
