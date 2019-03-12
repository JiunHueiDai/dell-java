
public class Room implements Rentable {

	private double _dailyRate;
	private String _description;

	/* Room construction to set daily rate and item description */
	public Room(double dailyRate, String description) {
		_dailyRate = dailyRate;
		_description = description;
	}

	/* Getter to return the room description */
	public String getDescription() {
		return _description;
	}

	/* Getter to return the room daily rental rate */
	public double getDailyRate() {
		return _dailyRate;
	}

	/*
	 * Getter to calculate the total price and then return the room total rental
	 * amount
	 */
	public double getPrice(double days) {
		return getDailyRate() * days;
	}
}
