import java.util.LinkedList;
import java.util.List;

public class LicenseProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<DriversLicense> dvList = new LinkedList<DriversLicense>();
		
		DriversLicense dv1 = new DriversLicense("John", "Muphy", "1998-05-14", "6\"4'", "M");
		DriversLicense dv2 = new DriversLicense("Anders", "Hejlsberg", "1960-12-25", "5\"11'", "M");
		DriversLicense dv3 = new DriversLicense("Oprah", "Winfrey", "1954-01-29", "5\"4'", "F");
		
		dvList.add(dv1);
		dvList.add(dv2);
		dvList.add(dv3);
		int i = 1;
		for(DriversLicense driver: dvList) {
			System.out.println("Number" + i + " Driver Full Name:" + driver.getFullName() + " at Age " + driver.getAge());
		}
	}

}

