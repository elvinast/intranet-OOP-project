package main;

import java.io.Serializable;
import java.util.List;

/**
* @generated
*/
public class Database implements Serializable {
    
    /**
    * @generated
    */
    private List<User> users;
    
    /**
    * @generated
    */
    private List<Course> courses;
    
    /**
    * @generated
    */
    private List<News> news;
    
    /**
    * @generated
    */
    private List<Order> orders;
    
    
    
    
    /**
    * @generated
    */
    private List<User> getUsers() {
        return this.users;
    }
    
    /**
    * @generated
    */
    private void setUsers(List<User> users) {
        this.users = users;
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
    private List<News> getNews() {
        return this.news;
    }
    
    /**
    * @generated
    */
    private void setNews(List<News> news) {
        this.news = news;
    }
    
    /**
    * @generated
    */
    private List<Order> getOrders() {
        return this.orders;
    }
    
    /**
    * @generated
    */
    private void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Course findCourse(String courseCode) {
        //TODO
    	return null;
    }
    /**
    * @generated
    */
    public Student findStudent(String id) {
    	return null;
        //TODO
    }
    
}
