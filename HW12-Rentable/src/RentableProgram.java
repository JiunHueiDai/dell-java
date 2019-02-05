import java.util.Scanner;

public class RentableProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rentable[] aRentableArray = new Rentable[3];
		filloutRentalDetail(aRentableArray);
		printRentableDetailToUser(aRentableArray, 0);
		int daysToRent = getUserRentalDays();
		printRentableDetailToUser(aRentableArray, daysToRent);

	}

	/*
	 * Print all the rental detail in the rental array to user If days is more
	 * than 0, it means user has provided the day that user wants to rent Otherwise,
	 * it will just print daily price for each type
	 */
	private static void printRentableDetailToUser(Rentable[] aRentable, int days) {

		if (days > 0) {
			System.out.println("[The detail with " + days + " days of rental]");
		}

		for (int i = 0; i < aRentable.length; i++) {
			System.out.println(aRentable[i].getDescription());

			if (days > 0) {
				System.out.println("     - Total amount: $" + aRentable[i].getPrice(days));
			} else {
				System.out.println("     - Daily rate: $" + aRentable[i].getDailyRate());
			}
		}
	}

	/*
	 * Ask how many days user wants to rent those rental items and then return the
	 * days to the main method
	 */
	private static int getUserRentalDays() {
		System.out.println("");
		System.out.println("How many days do you need to rent them?");
		Scanner reader = new Scanner(System.in);
		int daysToRent = Integer.parseInt(reader.nextLine().toString().trim());
		System.out.println("");
		reader.close();
		return daysToRent;
	}

	/*
	 * Fill out the description and price for each item in the rental array Return
	 * the rental array to main method
	 */
	private static void filloutRentalDetail(Rentable[] aRentable) {
		Room aRoom = new Room(249.99, "A Room with 2 queen size beds and one bath.");
		Condo aCondo = new Condo(461.99, "A Condo with 3 bedrooms, 2 baths, and one living room.");
		Tool aTool = new Tool(37.83, "A Vacuum to keep fresh floors.");
		aRentable[0] = aRoom;
		aRentable[1] = aCondo;
		aRentable[2] = aTool;
	}
}
