
public class ParkingGarage {
	private static int _capacity = 0;
	Car[] _parkingSpots = new Car[_capacity];

	/*
	 * ParkingGarage Class construction to initiate the size of the parking garage
	 */
	public ParkingGarage(int capacity) {
		_capacity = capacity;
		/*
		 * after having capacity from user, the _parkingSpots needs to be new up with
		 * user's capacity
		 */
		_parkingSpots = new Car[_capacity];
	}

	/* will add the car to a parking spot. */
	public void park(Car car, int spot) {
		/* check if the selected spot is inside of parking garage's capacity */
		if (!isValidSpot(spot)) {
			return;
		}

		/* If spot is taken by another car, the new car can't part at this spot */
		if (isSpotTaken(spot, true)) {
			return;
		}

		_parkingSpots[spot] = car;
	}

	/* check if the selected spot is inside of parking garage's capacity */
	private boolean isValidSpot(int spot) {
		try {
			if (spot > _parkingSpots.length - 1) {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The spot #" + spot + " does not exist in this Garage.");
			System.out.println("Only the Spots #0 ~ #" + (_parkingSpots.length - 1) + " are available.");

			return false;
		}
		return true;
	}

	/*
	 * If spot is taken by another car, the new car can't part at this spot Since
	 * vacate method calls this method to check if the car in this spot can be
	 * unparked so the error message doesn't need to be printed out to user
	 */
	private boolean isSpotTaken(int spot, boolean printMessage) {
		if (_parkingSpots[spot] == null) {
			return false;
		}

		if (!_parkingSpots[spot].getLicenseNumber().isEmpty()) {
			if (printMessage) {
				System.out.println("The spot #" + spot + " is taken.");
				System.out.println("Please choose another spot to park your car.");
			}
			return true;
		}

		return false;
	}

	/*
	 * Remove the car from the specified spot by initiating the car property which
	 * means creating an empty spot.
	 */
	public void vacate(int spot) {
		if (!isSpotTaken(spot, false)) {
			System.out.println("The spot #" + spot + " is empty already.");

			return;
		}

		_parkingSpots[spot].initiateCarProperties();
	}

	/* Print out all cars in the parking garage if the spot isn't empty */
	public void printInventory() {
		for (int i = 0; i < _parkingSpots.length; i++) {
			if (!_parkingSpots[i].getLicenseNumber().isEmpty()) {
				System.out.println("The spot #" + i + " in the parking garage:");
				System.out.println("    Make " + _parkingSpots[i].getMake() + "; Color " + _parkingSpots[i].getColor()
						+ "; License# " + _parkingSpots[i].getLicenseNumber() + "; Model " + _parkingSpots[i].getModel()
						+ ".");
			}
		}

		System.out.println("");
	}
}
