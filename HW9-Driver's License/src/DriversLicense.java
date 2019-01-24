import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
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

	
	/*_DOB needs to have this format "January 2, 2010" in order to convert to date correctly*/
	private Date getDOBInDate() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = new Date();
		try {
			date = format.parse(_DOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public int getAge() {
		LocalDate today = LocalDate.now(); // today's date
		Date DOBInDate = getDOBInDate();
		LocalDate birthday = LocalDate.of(DOBInDate.getYear(), DOBInDate.getMonth(), DOBInDate.getDay()); // date of birth

		Period period = Period.between(birthday, today);
		int age = period.getYears(); // calculate the period between DOB and today in years
		
		return age;
	}
}
