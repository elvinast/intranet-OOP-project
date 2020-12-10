package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Vector;

/**
* @generated
*/
public class Student extends User implements IOrder{
    
    private Integer yearOfStudy;
    private double GPA;
    private Vector<Course> courses;
    private String id="";
    private int curCredits = 0;
    private Faculties faculty;
    private Degree degree;
    private Transcript transcript;
    private HashMap<Course, Mark> marks;
    final Integer CREDITS_LIMIT = 21;
    public static int numOfStud = 0;
    public Student() {}

    public Student(String firstName, String lastName, String email, Integer yearOfStudy, Faculties faculty, Degree degree) {
    	super(firstName, lastName, email);
    	this.yearOfStudy = yearOfStudy;
    	this.faculty = faculty;
    	this.degree = degree;
    	numOfStud++;
    }
    
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //to main driver
    public static void studentsMode(Student student) throws IOException {
    	System.out.println("Welcome to Student mode " + student.getFirstName() + "!\n:");
    	System.out.println("1. Information about student\n"
    						+ "2. View courses\n"
    						+ "3. View teachers\n"
    						+ "4. View transcript\n"
    						+ "5. View Marks\n"
    						+ "6. View course files\n"
    						+ "7. View news\n"
    						+ "8. Registration for disciplines\n"
    						+ "9. Send order to Executor\n"
    						+ "10. EXIT\n");
    	
    	int ans = reader.read();
    	
    }
    
    
    
    public Student(Integer yearOfStudy, double gPA, Vector<Course> courses, String id, Faculties faculty, 
    		Degree degree, Transcript transcript, HashMap<Course, Mark> marks) {
		super();
		this.yearOfStudy = yearOfStudy;
		this.GPA = GPA;
		this.courses = courses;
		this.id = id;
		this.faculty = faculty;
		this.degree = degree;
		this.transcript = transcript;
		this.marks = marks;
		numOfStud++;
	}
    

	public Integer getYearOfStudy() {
        return this.yearOfStudy;
    }
    
    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    public double getGPA() {
        return this.GPA;
    }
    
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    public Vector<Course> getCourses() {
        return this.courses;
    }
    
    public int getCurCredits() {
    	return curCredits;
    }
    
    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Faculties getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
    
    public Degree getDegree() {
        return this.degree;
    }
    
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    
    public Transcript getTranscript() {
        return this.transcript;
    }
    
    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }
    
    public HashMap<Course, Mark> getMarks() {
        return this.marks;
    }
    
    public void setMark(Course c, Mark m) {
    	marks.put(c, m);
    }		
    

    //                          Operations                                  
    
    public void registerOnCourse(String courseID) throws CreditsOverflow{
    	Course newCourse = null;
        for (Course course: Database.courses) {
        	if (course.getCourseCode().equals(courseID)) {
        		this.curCredits += course.getCredits();
        		newCourse = course;
        	}
        }
        if (this.curCredits <= this.CREDITS_LIMIT) {
        	courses.add(newCourse);
    		marks.put(newCourse, null);
    		System.out.println("New course successfully added!");
        }
        else {
            throw new CreditsOverflow(newCourse, CREDITS_LIMIT);
        }
    }
    
    public void updateYearOfStudy() {
    	this.yearOfStudy++;
    }
    
    public String createID() {
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	year -= this.yearOfStudy;
    	year++;
    	id += String.valueOf(year).substring(2);
    	if (this.degree == Degree.BACHELOR) id += "BD";
    	else if (this.degree == Degree.MASTERS) id += "MD";
    	else id += "PD";
    	StringBuilder builder = new StringBuilder(String.valueOf(numOfStud));
        while (builder.length() < 6) builder.insert(0, "0");
        id += builder.toString();
//        this.id = id;
		return id;
    }
    
    public String showInfo() {
    	String s = "";
    	s += "\nStudent Name: " + this.getFirstName() + " " + this.getLastName() + 
    			"\nYear of study: " + this.yearOfStudy + "\nFaculty: " + this.faculty + "\nGPA: " + this.GPA;
    	return s;
    }
    
    @Override
	public String toString() {
		return "Student [yearOfStudy=" + yearOfStudy + ", GPA=" + GPA + ", id=" + id + ", faculty=" + faculty + "]";
	}

	/**
    * @generated
    */
    public void viewTranscript() {
    	System.out.println(transcript);
    }
    
    public void viewCourses() {
    	int num = 0;
    	for (Course course: this.courses) {
    		num++;
    		System.out.println(course);
    	}
    	System.out.println("You have " + num + "courses. Good Luck)");
    }
   
    public void viewCourseFiles(Course course) {
        for (File file: course.courseFiles) {
        	file.showFileInfo();
        }
    }
    
    public void viewMarks(Course course) {
		System.out.println("Marks of the student " + this.getFirstName() + " " + this.getLastName());
		for (Entry<Course, Mark> entry : this.marks.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
    }

    public String showTeachers() {
        return Database.getTeachers();
    }


	@Override
	public void sendOrder(String problem, Order order) {
		//ToDo
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), id, yearOfStudy, courses, GPA);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)){
			return true;
		}
    	Student s = (Student) obj;
    	return super.equals(s) && yearOfStudy.equals(s.yearOfStudy) && id.equals(s.id)
    			&& s.GPA == this.GPA;
	}
	
}
