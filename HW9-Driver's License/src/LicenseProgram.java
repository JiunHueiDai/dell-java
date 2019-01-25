import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LicenseProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Create a list to hold all the driver's license*/		
		List<DriversLicense> dvList = new LinkedList<DriversLicense>();

		/*Date of birth has to be this Format. Otherwise, it will throw exception.*/
		DriversLicense dv1 = new DriversLicense("John", "Muphy", "1998-05-14", "6\"4'", "M");
		DriversLicense dv2 = new DriversLicense("Anders", "Hejlsberg", "1960-12-25", "5\"11'", "M");
		DriversLicense dv3 = new DriversLicense("Oprah", "Winfrey", "1954-01-29", "5\"4'", "F");
		DriversLicense dv4 = new DriversLicense("Angie", "Dai", "1911/07/03", "5\"7'", "F");

		/*Add all the driver to the list*/
		dvList.add(dv1);
		dvList.add(dv2);
		dvList.add(dv3);
		dvList.add(dv4);
		
		int i = 1;
		
		/*print out all the driver's license information*/		
		for(DriversLicense driver: dvList) {
			System.out.println("Number" + i + " Driver Full Name: " + driver.getFullName() + " at Age: " + driver.getAge());
			System.out.println("               Height: " + driver.getHeight() + ", Gender: " + driver.getGender());
			i++;
		}
	}

}

