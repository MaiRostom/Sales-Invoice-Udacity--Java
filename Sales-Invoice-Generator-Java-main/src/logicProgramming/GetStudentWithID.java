package logicProgramming;


//
//import java.io.FileWriter;
//import java.io.IOException;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//public class JsonWrite {
//
//	public static void main(String[] args) {
//
//		JSONObject obj = new JSONObject();
//
//		//JSONObject class creates a json object,
//		//provides a put function to insert the details into json object
//		obj.put("name", "Abhishek Sharma");
//		obj.put("department","B.E");
//		obj.put("branch", "C.S.E");
//		obj.put("year", 3);
//
//	//	JSONArray list = new JSONArray();
//
////		//This is a JSON Array List ,
////		//It creates an array and then add the values in it
////		list.add("remark 1");
////		list.add("remark 2");
////		list.add("remark 3");
////
////		obj.put("remarks", list);//adding the list to our JSON Object
//
//		try (FileWriter file = new FileWriter("newfile.json")) {
//			//File Writer creates a file in write mode at the given location
//			file.write(obj.toJSONString());
//
//			//write function is use to write in file,
//			//here we write the Json object in the file
//			file.flush();
//
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(obj);
//		//to print our JSon object
//	}
//
//}
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class Course {
	int id;
	String name;
	String instructor;
	String duration;
	String hours;
	String location;

	public Course(int id, String name, String instructor, String duration, String hours, String location) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
		this.duration = duration;
		this.hours = hours;
		this.location = location;
	}
}

class Student {
	int id;
	String name;
	int grade;
	String email;
	List<Course> courses;

	public Student(int id, String name, int grade, String email, List<Course> courses) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.email = email;
		this.courses = courses;
	}
}

public class GetStudentWithID {
	private static int x;

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {

			Scanner myObj = new Scanner(System.in);

			 x = Integer.parseInt(myObj.nextLine());
			Object obj = parser.parse(new FileReader("StudentData.json"));
			JSONObject jsonObject = (JSONObject) obj;
			int studentId = x; // replace with the id of the student you are looking for
			JSONArray courseIds = (JSONArray) jsonObject.get(String.valueOf(studentId));

			ArrayList<String> courses1 = new ArrayList<>();
		courses1 =(ArrayList<String>) jsonObject.get(String.valueOf(studentId));

			if (courseIds == null) {
				System.out.println("====================================================================================");
				System.out.println("Student Details page");
				System.out.println("====================================================================================");
				System.out.println("Name: Malcolm Barnes\tGrade:9\t    Email:velit.aliquam@outlook.couk");
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println("Enrolled courses.");
				System.out.println("This student hasn't enrolled in any courses");
				System.out.println("------------------------------------------------------------------------------------");
			} else {
				List<Course> courses = new ArrayList<>();

				for (String courseId : courses1) {
					// get course details by id and add to the list of courses
					System.out.println(courseId);
					switch (Integer.parseInt(courseId)) {
						case 1 ->
								courses.add(new Course(1, "Algorithms", "Scott, Austin C.", "8 weeks", "2H", "Hall1"));
						case 2 ->
								courses.add(new Course(2, "Data Structures", "Kim, Julie Y.", "12 weeks", "3H", "Hall2"));
						case 3 ->
								courses.add(new Course(3, "Database Systems", "Brown, David A.", "16 weeks", "4H", "Hall3"));
						case 4 ->
								courses.add(new Course(4, "Web Development", "Smith, Sarah L.", "10 weeks", "2.5H", "Hall4"));
						default -> {
						}
					}
				}
				System.out.println("====================================================================================");
				System.out.println("Student Details page");
				System.out.println("====================================================================================");
				System.out.println("Name: Malcolm Barnes\tGrade:9\tEmail:velit.aliquam@outlook.couk");
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println("Enrolled courses.");
				for (int i = 0; i < courses.size(); i++) {
					System.out.println((i + 1) + " - " + courses.get(i).id + ", " + courses.get(i).name + ", " + courses.get(i).instructor + ", " + courses.get(i).duration + ", " + courses.get(i).hours + ", " + courses.get(i).location);
				}
				System.out.println("------------------------------------------------------------------------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
