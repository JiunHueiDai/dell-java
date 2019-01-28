
public class GarageManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParkingGarage packingGarage = new ParkingGarage(5);
		Car car1 = new Car("red", "10001", "Tesla", "X3");
		Car car2 = new Car("yellow", "10002", "Lamborghini", "Urus");
		Car car3 = new Car("blue", "10003", "BMW", "Urus");
		Car car4 = new Car("green", "10004", "Ferrari", "Purist");
		Car car5 = new Car("white", "10005", "Bentley", "Bentayga");
		Car car6 = new Car("Dark Metal", "10006", "Lotus", "Evora");
		packingGarage.park(car1, 0);
		packingGarage.park(car2, 1);
		packingGarage.park(car3, 2);
		packingGarage.park(car4, 3);
		packingGarage.park(car5, 4);
		packingGarage.park(car6, 5);
	}
	
}
