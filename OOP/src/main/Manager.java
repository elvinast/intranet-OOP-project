package main;

import java.util.List;

/**
* @generated
*/
public class Manager extends Employee implements INews, IOrder {
    
    /**
    * @generated
    */
    private List<Student> students;
    
    /**
    * @generated
    */
    private List<Teacher> teachers;
    
    /**
    * @generated
    */
    private List<Course> courses;
    
    
    /**
    * @generated
    */
    private News news;
    
    /**
    * @generated
    */
    private List<Student> getStudents() {
        return this.students;
    }
    
    /**
    * @generated
    */
    private void setStudents(List<Student> students) {
        this.students = students;
    }
    /**
    * @generated
    */
    private List<Teacher> getTeachers() {
        return this.teachers;
    }
    
    /**
    * @generated
    */
    private void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    
    /**
    * @generated
    */
    private List<Course> getCourses() {
        return this.courses;
    }
    
    /**
    * @generated
    */
    private void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    
    /**
    * @generated
    */
    public News getNews() {
        return this.news;
    }
    
    /**
    * @generated
    */
    public void setNews(News news) {
        this.news = news;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Course createCourse(String name, int credits, Teacher teacher) {
		return null;
        //TODO
    }
    /**
    * @generated
    */
    public void infoStudents() {
        //TODO
    }
    /**
    * @generated
    */
    public void infoTeachers() {
        //TODO
    }
    /**
    * @generated
    */
    public void suggestCourse(Course course, List<Student> students) {
        //TODO
    }
    /**
    * @generated
    */
    public boolean approveRegistration(Student student) {
		return true;
    }

	@Override
	public News createNews(Message news) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendOrder(String problem, TechSupportGuy executor) {
		// TODO Auto-generated method stub
		
	}
    
}
