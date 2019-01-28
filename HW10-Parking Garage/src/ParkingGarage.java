
public class ParkingGarage {
	private static int _capacity = 0;
	Car[] _parkingSpots = new Car[_capacity];

	public ParkingGarage(int capacity) {
		_capacity = capacity;
		_parkingSpots = new Car[_capacity];
	}

	/* will add the car to a parking spot. */
	public void park(Car car, int spot) {
		if (!doesSpotExist(car, spot) && isSpotTaken(spot)) {
			return;
		}

		_parkingSpots[spot] = car;
	}

	private boolean doesSpotExist(Car car, int spot) {
		try {
			_parkingSpots[spot] = car;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The spot #" + spot + " does not exist in this Garage.");
			System.out.println("We only have the Spot #0 ~ #" + _parkingSpots.length);
			return false;
		}
		return true;
	}

	private boolean isSpotTaken(int spot) {
		if (_parkingSpots[spot].getLicenseNumber().equals(null)
				&& _parkingSpots[spot].getLicenseNumber().isEmpty() == true) {
			System.out.println("The spot #" + spot + " is taken.");
			System.out.println("Please select another spot to park your car.");
			return false;
		}

		return true;
	}

	/* will remove the car from the specified spot. */
	public void vacate(int spot) {
		if (!isSpotTaken(spot)) {
			System.out.println("The spot #" + spot + " is empty.");
		}

		_parkingSpots[spot].initiateCarProperties();
	}

	public void printInventory() {
		for (int i = 0; i < _parkingSpots.length; i++) {
			System.out.println("The spot #" + i + " in the parking garage:");
			System.out.println("The car's color " + _parkingSpots[i].getColor() + "; License# "
					+ _parkingSpots[i].getLicenseNumber() + "; make " + _parkingSpots[i].getMake() + "; model "
					+ _parkingSpots[i].getModel() + ".");
		}
	}
}
