import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class DriversLicense {
	private String _firstName;
	private String _lastName;
	private String _DOB;
	private String _height;
	private String _gender;

	public DriversLicense(String firstName, String lastName, String DOB, String height, String gender) {
		_firstName = firstName;
		_lastName = lastName;
		_DOB = DOB;
		_height = height;
		_gender = gender;
	}

	public String getFullName() {
		return _firstName + " " + _lastName;
	}

	public int getAge() {
		LocalDate today = LocalDate.now(); // today's date
		LocalDate DOBInDate = LocalDate.parse(_DOB);
		
		Period period = Period.between(DOBInDate, today);
		int age = period.getYears(); // calculate the period between DOB and today in years
		
		return age;
	}
}
