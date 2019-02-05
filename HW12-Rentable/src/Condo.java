
public class Condo implements Rentable {

	private double _weeklyRate;
	private String _description;

	/* Condo construction to set daily rate and condo description */
	public Condo(double weeklyRate, String description) {
		_weeklyRate = weeklyRate;
		_description = description;
	}

	/* Getter to return the condo description */
	public String getDescription() {
		return _description;
	}

	/* Getter to return the condo daily rental rate */
	public double getDailyRate() {
		return _weeklyRate;
	}

	/*
	 * Getter to calculate the total price and then return the condo total rental
	 * amount
	 */
	public double getPrice(double days) {
		return _weeklyRate * days;
	}

}
