
public class CarLotProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Create a Car Lot named "Austin", and then add 2 cars and 1 truck in the lot.
		 * Print out all the vehicle details
		 */
		CarLots Austin = new CarLots("Austin Car Lots");
		// make, model, price, license number, description, type, number of doors
		Vehicle car1 = new Car("Honda", "Fit", "22000", "10001",
				"The Honda Fit has been a longtime favorite in the segment for its combination of good fuel economy, impressive roominess and mind-bending cargo flexibility. In fact, it's more practical than quite a few SUVs",
				"Hatchback", "5");
		Vehicle car2 = new Car("Bentley", "Bentayga", "179000", "10002",
				"Bentayga is unlike any other sport utility vehicle in the world. This powerful, all-terrain, all-purpose car offers an exceptional driving experience. As well as having the most technically advanced engine in its category, it has Mulliner Driving Specification fitted as standard and a choice of more paint colours than any other SUV. Bentayga brings together outstanding performance and unparalleled levels of luxury on and off-road",
				"Sedan", "4");
		Vehicle truck1 = new Truck("GMC", "Canyon", "34900", "10003",
				"The GMC Canyon offers class-leading towing capabilities, lots of available tech and safety features, and a smooth highway ride. The eyebrow-raising prices of fancier models constitute the Canyon's biggest shortcoming.",
				2);
		Austin.addVehicle(car1);
		Austin.addVehicle(truck1);
		Austin.addVehicle(car2);
		Austin.printCarLot();
		System.out.println();

		/*
		 * Create a Car Lot named "Cedar Park", and then add 2 cars and 2 truck in the
		 * lot. Print out all the vehicle details
		 */
		CarLots CedarPark = new CarLots("Cedar Park Car Lots");
		// make, model, price, license number, description, type, number of doors
		Vehicle car3 = new Car("Tesla", "Model 3", "35000", "10004",
				"Model 3 comes with the option of dual motor all-wheel drive, 20” Performance Wheels and Brakes and lowered suspension for total control, in all weather conditions. And a carbon fiber spoiler improves stability at high speeds, all allowing Model 3 to accelerate from 0-60 mph in as little as 3.3 seconds.",
				"Sedan", "4");
		Vehicle car4 = new Car("Lamborghini", "Urus", "86000", "10005",
				"A super sports car soul and the functionality typical for an SUV: this is Lamborghini Urus, the world’s first Super Sport Utility Vehicle. Identifiable as an authentic Lamborghini with its unmistakable DNA, Urus is at the same time a groundbreaking car: the extreme proportions, the pure Lamborghini design and the outstanding performance make it absolutely unique. Urus’ distinctive silhouette with a dynamic flying coupé line shows its super sports origins, while its outstanding proportions convey strength, solidity and safety. Without a doubt the factors at the heart of Urus’ success are advanced design, extraordinary driving dynamics and thrilling performance. All these features allowed Lamborghini to launch a Super Sport Utility Vehicle remaining loyal to its DNA.\r\n"
						+ "Urus conveys its utmost versatility also in its design, which meets the requirements of a wide variety of customers with Style packages, exterior details in carbon fiber or the Off-Road package",
				"Sedan", "4");
		Vehicle truck2 = new Truck("Honda", "Ridgeline", "29900", "10006",
				"The Honda Ridgeline is more comfortable than the average midsize pickup, yet it retains nearly all the utility of its workaday rivals. It's true that it can't tow as much or go as far off-road as some traditional trucks, but it's a durable, practical choice with some tricks up its sleeve",
				2);
		Vehicle truck3 = new Truck("Chevrolet", "Silverado 1500", "39999", "10007",
				"Redesigned for 2019, the Chevrolet Silverado 1500 is a versatile full-size pickup that can be a competent workhorse and a plush people-mover at the same time. However, this jack-of-all-trades truck doesn't excel in any particular area",
				1);

		CedarPark.addVehicle(truck2);
		CedarPark.addVehicle(car3);
		CedarPark.addVehicle(car4);
		CedarPark.addVehicle(truck3);
		CedarPark.printCarLot();
	}
}
