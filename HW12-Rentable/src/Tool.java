
public class Tool implements Rentable {
	private double _hourlyRate;
	private String _description;

	/* Tool construction to set daily rate and item description */
	public Tool(double hourlyRate, String description) {
		_hourlyRate = hourlyRate;
		_description = description;
	}

	/* Getter to return the tool description */
	public String getDescription() {
		return _description;
	}

	/* Getter to return the tool daily rental rate by using hourly rate times 24 hours a day*/
	public double getDailyRate() {
		return _hourlyRate * 24;
	}

	/*
	 * Getter to calculate the total price and then return the tool total rental
	 * amount
	 */
	public double getPrice(double days) {
		return getDailyRate() * days;
	}
}
