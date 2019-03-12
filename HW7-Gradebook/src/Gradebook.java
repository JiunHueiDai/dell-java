import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Gradebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> studentInfo = getStudentInfo();
		Map<String, Double> studentAvgScores = getStudentAvgScores(studentInfo);

		printOutStudentInfo(studentInfo, studentAvgScores);
	}

	private static Map<String, String> getStudentInfo(){
		Map<String, String> studentInfo = new Hashtable<String, String>();
		Scanner reader = new Scanner(System.in);
		boolean moreStudent = true;
		
		//Ask users to provide student name and scores string separated by comma.
		while (moreStudent) {
			System.out.println("Please enter student name:");
			String name = reader.nextLine().trim();
			System.out.println("Please enter all of student scores separated by comma:");
			//adding student name and score to the map
			studentInfo.put(name, reader.nextLine().trim());
			System.out.println("Enter next student information?");
			
			//Unless users provide "N" to stop entering student info, it will continue asking 
			if (reader.nextLine().trim().toUpperCase().equals("N")) {
				moreStudent = false;
			}
		}
		
		reader.close();
		return studentInfo;
	}
	
	private static Map<String,Double> getStudentAvgScores(Map<String,String> studentInfo){
		Iterator<Map.Entry<String,String>> itr = studentInfo.entrySet().iterator();
		Map<String, Double> studentAvgScores = new Hashtable<String, Double>();
		
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			String name = entry.getKey();
			String scoresString = entry.getValue();
			//Separate all of scores by comma and then map all the values to a scores array
			int[] scores = Stream.of(scoresString.split(",")).mapToInt(Integer::parseInt).toArray();
			//Sum up all the scores and then divides by the number of scores to get average score for the student. 
			//Then put the score in the map as value for the student
			studentAvgScores.put(name,(double)Arrays.stream(scores).sum()/scores.length);
		}
		return studentAvgScores;
	}
	
	private static void printOutStudentInfo(Map<String, String> studentInfo, Map<String, Double> studentAvgScores) {
		for(Map.Entry<String,Double> entry : studentAvgScores.entrySet()) {
			System.out.println("Student Name: " + entry.getKey() + ", Average Scores: " + entry.getValue());
			System.out.println("All Scores: " + studentInfo.get(entry.getKey()));
		}
	}

}
