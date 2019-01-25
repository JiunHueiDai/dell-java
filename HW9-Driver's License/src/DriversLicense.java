import java.time.LocalDate;
import java.time.Period;

public class DriversLicense {
	private String _firstName;
	private String _lastName;
	private String _DOB;
	private String _height;
	private String _gender;
	
	/*Overload Construction to receive 5 parameters*/
	public DriversLicense(String firstName, String lastName, String DOB, String height, String gender) {
		_firstName = firstName;
		_lastName = lastName;
		_DOB = DOB;
		_height = height;
		_gender = gender;
	}
	
	/*Get full name by concatenating first name and last name*/
	public String getFullName() {
		return _firstName + " " + _lastName;
	}

	/*Calculate ages by today's time minus driver's date of birth*/
	public int getAge() {		
		int age = -1;
		
		/*if the format of driver's date of birth is not correct, return error message to user and also set age to -1*/		
		if(isValidDOBFormat()) {
			LocalDate today = LocalDate.now(); // today's date
			LocalDate DOBInDate = LocalDate.now();
			
			DOBInDate = LocalDate.parse(_DOB);		
			Period period = Period.between(DOBInDate, today);
			age = period.getYears(); // calculate the period between DOB and today in years	
		}
		
		return age;
	}
	
	private boolean isValidDOBFormat() {	
		boolean validate = true;
		
		try {
			LocalDate.parse(_DOB);		
		}catch(Exception e) {
			System.out.println("");
			System.out.println(_DOB + " is NOT in correct format.");
			System.out.println("Please use yyyy-mm-dd.");
			validate = false;
		}
		
		return validate;
	}
	
	public String getHeight(){
		return _height;
	}
	
	public String getGender() {
		return _gender;
	}
}
