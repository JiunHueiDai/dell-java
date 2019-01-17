import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Gradebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> studentInfo = new Hashtable<String, String>();
		Scanner reader = new Scanner(System.in);
		boolean continueEntering = true;
		Map<String, Double> studentAvgScores = new Hashtable<String, Double>();

		while (continueEntering) {
			System.out.println("Please enter student name:");
			String name = reader.nextLine().trim();
			System.out.println("Please enter all of student scores separated by comma:");
			studentInfo.put(name, reader.nextLine().trim());
			System.out.println("Enter next student information?");
			if (reader.nextLine().trim().toUpperCase().equals("N")) {
				continueEntering = false;
			}
		}

		studentAvgScores = getStudentAvgScore(studentInfo);

		for(Map.Entry<String,Double> entry : studentAvgScores.entrySet()) {
			System.out.println("Student Name: " + entry.getKey() + ", Average Scores: " + entry.getValue());
			System.out.println("All Scores: " + studentInfo.get(entry.getKey()));
		}
	}

	private static Map<String,Double> getStudentAvgScore(Map<String,String> studentInfo){
		Iterator<Map.Entry<String,String>> itr = studentInfo.entrySet().iterator();
		Map<String, Double> studentAvgScores = new Hashtable<String, Double>();
		
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			String name = entry.getKey();
			String scoresString = entry.getValue();
			int[] scores = Stream.of(scoresString.split(",")).mapToInt(Integer::parseInt).toArray();
			studentAvgScores.put(name,(double)Arrays.stream(scores).sum()/scores.length);
		}
		return studentAvgScores;
	}

}
