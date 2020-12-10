package main;

import java.util.*;

/**
* @generated
*/
public class Manager extends Employee implements INews, IOrder {
    

//    private List<Student> students;
//    private List<Teacher> teachers;
//    private List<Course> courses;
    private News news;
   
    public Manager() {}
    
    public Manager(String firstName, String lastName, String email, 
    		Integer salary, List<Student> students, List<Teacher> teachers, List<Course> courses, News news) {
    	super(firstName, lastName, email, salary);
    	this.news = news;
    }
    
//    private List<Student> getStudents() {
//        return this.students;
//    }
//    
//    private void setStudents(List<Student> students) {
//        this.students = students;
//    }
//    
//    private List<Teacher> getTeachers() {
//        return this.teachers;
//    }
//
//    
//    private void setTeachers(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//    
//    private List<Course> getCourses() {
//        return this.courses;
//    }
//    
//    private void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }
    
    public News getNews() {
        return this.news;
    }
    
    public void setNews(News news) {
        this.news = news;
    }
    
    //                          Operations                                  

//    @Override
//	public String toString() {
//		return "Manager [students=" + students + ", teachers=" + teachers + ", courses=" + courses + ", news=" + news
//				+ "]";
//	}

	public void createCourse(String name, int credits, Teacher teacher, String courseCode) {
    	
    	Course newCourse = new Course(name, credits, teacher, courseCode);
    	for (Course course: Database.courses) {
        	if (!course.getCourseCode().equals(courseCode)) {
        		Database.courses.add(newCourse);
        	}else {
        		System.out.println("This course exists");
        	}
        //TODO
    	}
    }
    

    public void suggestCourse(Course course, List<Student> students) {
        //TODO
    	for(Student s : students) {
    		if(s.getCourses().contains(course)) {
    			System.out.println("Course exists");
    		}else {
    			course.setIsAvailable(false);
    		}
    	}
    }

    public boolean approveRegistration(Student student, Course course) {
		
    	if(student.getCurCredits() <= (21 - course.getCredits())) {
    		return true;
    	}else {
    		return false;
    	}
    }

    @Override
	public News createNews(Faculties faculty, String title, String text, Date date) {
		return new News(faculty, title, text, date);
	}

	@Override
	public void sendOrder(String problem, Order order) {
		// TODO Auto-generated method stub
		
	}
	public boolean equals(Object obj) {
    	if(!super.equals(obj)){
			return true;
		}
    	Manager m = (Manager) obj;
    	return super.equals(m) && news.equals(m.news);
    }
	
	public int hashCode() {
		return Objects.hash(super.hashCode(), news);
	}
	
	public String showInfo() {
		String s = "";
		s += "\nFull name: " + this.getFirstName() + " " + this.getLastName() + "\nWork Experience: " + this.getWorkExperience();
		return s;
	}
}
