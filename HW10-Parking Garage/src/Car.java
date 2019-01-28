
public class Car {
	private String _color;
	private String _licenseNumber;
	private String _make;
	private String _model;

	Car() {
		initiateCarProperties();
	}

	public Car(String color, String licenseNumber, String make, String model) {
		_color = color;
		_licenseNumber = licenseNumber;
		_make = make;
		_model = model;
	}

	public String getLicenseNumber() {
		return _licenseNumber;
	}

	public void initiateCarProperties() {
		_color = "";
		_licenseNumber = "";
		_make = "";
		_model = "";
	}

	public String getColor() {
		return _color;
	}

	public String getMake() {
		return _make;
	}

	public String getModel() {
		return _model;
	}
}
