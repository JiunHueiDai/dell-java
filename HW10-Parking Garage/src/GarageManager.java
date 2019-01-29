
public class GarageManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Please read the print out messages with the symbols[] before and after to
		 * understand the tests of this program
		 */
		ParkingGarage parkingGarage = new ParkingGarage(5);
		Car car0 = new Car("red", "10001", "Tesla", "X3");
		Car car1 = new Car("yellow", "10002", "Lamborghini", "Urus");
		Car car2 = new Car("blue", "10003", "BMW", "Urus");
		Car car3 = new Car("green", "10004", "Ferrari", "Purist");
		Car car4 = new Car("white", "10005", "Bentley", "Bentayga");
		Car car5 = new Car("Dark Metal", "10006", "Lotus", "Evora");
		parkingGarage.park(car0, 0);
		parkingGarage.park(car1, 1);
		parkingGarage.park(car2, 2);
		parkingGarage.park(car3, 3);
		parkingGarage.park(car4, 4);
		System.out.println("[Currently, there are following cars parking in the garage.]");
		parkingGarage.printInventory();

		System.out.println("[Trying to park more than the garage's capacity and then");
		System.out.println(" printing out what kind of cars garage currently has]");
		parkingGarage.park(car5, 5);
		parkingGarage.printInventory();

		System.out.println("[Trying to park car (Lotus) to an non-empty spot (#1) and then ");
		System.out.println(" printing out what kind of cars garage currently has]");
		parkingGarage.park(car5, 1);
		parkingGarage.printInventory();

		System.out.println("[Unparking #2 car (BMW) and #3 car (Ferrari) from the garage and then]");
		System.out.println(" printing out what kind of cars garage currently has]");
		parkingGarage.vacate(2);
		parkingGarage.vacate(3);
		parkingGarage.printInventory();

		System.out.println("[Trying to unpark empty spot (#3) from the garage and then]");
		System.out.println(" printing out what kind of cars garage currently has]");
		parkingGarage.vacate(3);
		parkingGarage.printInventory();

		System.out.println("[Parking #5 car (Lotus) in the spot #3 and then]");
		System.out.println(" printing out what kind of cars garage currently has]");
		parkingGarage.park(car5, 3);
		parkingGarage.printInventory();
	}

}
