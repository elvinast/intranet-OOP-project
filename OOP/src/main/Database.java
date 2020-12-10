package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
* @generated
*/
public class Database implements Serializable {
    
	public static Vector<User> users = new Vector<User>();
//	public static Vector<Student> students = new Vector<Student>();
//	public static Vector<Teacher> teachers = new Vector<Teacher>();
//	public static Vector<Manager> managers = new Vector<Manager>();
//	public static Vector<Admin> admins = new Vector<Admin>();
	public static Vector<Course> courses = new Vector<Course>();
//	public static Vector<TechSupportGuy> techGuys = new Vector<TechSupportGuy>();
	public static Vector<File> files = new Vector<File>();
	public static Vector<News> news = new Vector<News>();
	public static Vector<Order> orders = new Vector<Order>();
	public static Vector<Message> messages = new Vector<Message>();
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
	public static ObjectInputStream oin;
	
	
	
	
	
    //                          Operations                                  
    
	
	
	
//	public static void serStudents() throws IOException{
//		fos = new FileOutputStream("students.out");
//		oos = new ObjectOutputStream(fos);
//		oos.writeObject(students);
//		oos.close();
//	}
//	
//	public  static void desStudents() throws IOException, ClassNotFoundException {
//		fis = new FileInputStream("students.out");
//		oin = new ObjectInputStream(fis);
//		students = (Vector<Student>) oin.readObject();
//		oin.close();
//		fis.close();
//	}
	
	public static String getTeachers() {
		String s = "";
		for(User u: users) {
			if (u instanceof Teacher) {
				Teacher t = (Teacher) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getManagers() {
		String s = "";
		for(User u: users) {
			if (u instanceof Manager) {
				Manager t = (Manager) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getAdmins() {
		String s = "";
		for(User u: users) {
			if (u instanceof Admin) {
				Admin t = (Admin) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getStudents() {
		String s = "";
		for(User u: users) {
			if (u instanceof Student) {
				Student t = (Student) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
    /**
    * @generated
    */
    public Course findCourse(String courseCode) {
        for (Course course : this.courses) {
        	if (course.getCourseCode().equals(courseCode)) {
        		return course;
        	}
        }
        return null;
    }
    
    /**
    * @generated
    */
    public Student findStudent(String id) {
    	for (Student student : this.getStudents()) {
        	if (student.getId().equals(id)) {
        		return student;
        	}
        }
        return null;
    }
    
}
