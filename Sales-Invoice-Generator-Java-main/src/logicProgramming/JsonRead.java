//
//
package logicProgramming;
//
//import java.io.FileReader;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class JsonRead {
//	public static void main(String[] args) {
//		// Read the JSON file
//		JSONParser parser = new JSONParser();
//		try {
//			Object obj = parser.parse(new FileReader("/home/amr/Downloads/Sales-Invoice-Generator-Java-main/Student course details.json"));
//			JSONObject jsonObject = (JSONObject) obj;
//
//			// Get the student id
//			String studentId = "1";
//			JSONArray courses = (JSONArray) jsonObject.get(studentId);
//
//			// Print the courses for the student
//			System.out.println("Student " + studentId + " is enrolled in the following courses:");
//			for (Object course : courses) {
//				System.out.println("- Course " + course);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class JsonRead {

	public int idcr(int id) {
		int[] arr = {1, 2, 3, 4,6 };
		int result = Arrays.binarySearch(arr, id);
		if (result >= 0)
			System.out.println("This student has  enrolled in any courses");
		else
			System.out.println("This student hasn't enrolled in any courses");
		return result;
	}


	public JSONObject createJson () {
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4");
		jsonObject.put("1", array);

		JSONArray array2 = new JSONArray();
		array2.add("2");
		array2.add("4");
		array2.add("6");

		jsonObject.put("2", array2);

		JSONArray array3 = new JSONArray();
		array3.add("1");
		array3.add("3");
		array3.add("5");

		jsonObject.put("3", array2);


		try {
			FileWriter file = new FileWriter("src/main/java/FolderUsed/StudentData.json");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject;
	}


}



