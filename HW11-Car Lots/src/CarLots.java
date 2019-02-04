import java.util.ArrayList;
import java.util.List;

public class CarLots {
	/*
	 * This variable will only be set in constructor since it doesn't contain setter
	 */
	private String _name;
	private List<Vehicle> _vehicles = new ArrayList<Vehicle>();

	/* Car Lot constructor to initialize only name property */
	CarLots(String name) {
		_name = name;
	}

	/* Car Lot constructor to initialize both name and vehicles properties */
	CarLots(String name, List<Vehicle> vehicles) {
		_name = name;
		_vehicles = vehicles;
	}

	/* To add a vehicle to car lots' vehicles list collection */
	public void addVehicle(Vehicle vehicle) {
		_vehicles.add(vehicle);
	}

	/*
	 * Print all of car lots details, including name, viehicles size, and vehicle
	 * detail
	 */
	public void printCarLot() {
		System.out.println("Car Lot Name: " + _name + " contains the following " + _vehicles.size() + " vehicles.");

		for (Vehicle v : _vehicles) {
			v.printVehicleDetail();
		}
	}
}
