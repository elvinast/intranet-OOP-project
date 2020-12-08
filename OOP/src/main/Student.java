package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

/**
* @generated
*/
public class Student extends User implements Comparable, IOrder {
    
    private Integer yearOfStudy;
    private double GPA;
    private Vector<Course> courses;
    private String id;
    private int curCredits = 0;
    private Faculties faculty;
    private Degree degree;
    private Transcript transcript;
    private HashMap<Course, Mark> marks;
    final Integer CREDITS_LIMIT = 21;
    
    public Student() {}

    public Student(String firstName, String lastName, String email, Integer yearOfStudy, Faculties faculty, Degree degree) {
    	super(firstName, lastName, email);
    	this.yearOfStudy = yearOfStudy;
    	this.faculty = faculty;
    	this.degree = degree;
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
    
    public void setMarks(HashMap<Course, Mark> marks) {
        this.marks = marks;
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
    	String id = "";
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	id += String.valueOf(year).substring(2);
    	if (this.degree == Degree.BACHELOR) id += "BD";
    	else if (this.degree == Degree.MASTERS) id += "MD";
    	else id += "PD";
    	
    	//random
    	
		return id;
    }
    
    @Override
	public String toString() {
		return "Student [yearOfStudy=" + yearOfStudy + ", GPA=" + GPA + ", id=" + id + ", faculty=" + faculty + "]";
	}

	/**
    * @generated
    */
    public void viewTranscript() {
        //TODO
    }
    /**
    * @generated
    */
    public void viewCourses() {
    	int num = 0;
    	for (Course course: this.courses) {
    		num++;
    		System.out.println(course);
    	}
    	System.out.println("You have " + num + "courses. Good Luck)");
    }
    /**
    * @generated
    */
    public void viewCourseFiles(Course course) {
        //TODO
    }
    /**
    * @generated
    */
    public void viewMarks(Course course) {
        //TODO
    }
    /**
    * @generated
    */
    public void showTeachers(Faculties faculty) {
        //TODO
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sendOrder(String problem, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(GPA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((yearOfStudy == null) ? 0 : yearOfStudy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(GPA) != Double.doubleToLongBits(other.GPA))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (yearOfStudy == null) {
			if (other.yearOfStudy != null)
				return false;
		} else if (!yearOfStudy.equals(other.yearOfStudy))
			return false;
		return true;
	}
}
