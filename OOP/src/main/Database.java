package main;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class Database implements Serializable {
    
	public static Vector<User> users = new Vector<User>();
	public static Vector<Course> courses = new Vector<Course>();
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
	
	public static String getTechGuys() {
		String s = "";
		for(User u: users) {
			if (u instanceof TechSupportGuy) {
				TechSupportGuy t = (TechSupportGuy) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
    
    public Course findCourse(String courseCode) {
        for (Course course : this.courses) {
        	if (course.getCourseCode().equals(courseCode)) {
        		return course;
        	}
        }
        return null;
    }
    
    public Student findStudent(String id) {
    	for (User user : this.users) {
    		if (user instanceof Student) {
    			Student student = (Student) user;
    			if (student.getId().equals(id)) {
    				return student;
    			}
    		}
        	
        }
        return null;
    }
    
    public User removeUser(String login) {
        for (User user: users) {
            if (user.getLogin().equals(login)) {
                users.remove(user);
                return user;
            }
        }
        return null;
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Course removeCourse(String name) {
        for (Course course: courses) {
            if (course.getCourseName().equals(name)) {
                courses.remove(course);
                return course;
            }
        }
        return null;
    }
    
    public void addNews(News news) {
        this.news.add(news);
    }
    
    //--------------------------- E N U M S --------------------------
    public Faculties[] getFaculties() {
        return new Faculties[] {
        	Faculties.FIT, Faculties.BS, Faculties.FGA, Faculties.FEOGI, Faculties.ISE, Faculties.MCM, Faculties.KMA
        };
    }
    
    public Degree[] getDegree() {
        return new Degree[] { Degree.BACHELOR, Degree.MASTERS, Degree.PHD };
    }
    
    public TeachingStatus[] getTeachingStatus() {
        return new TeachingStatus[] {
        	TeachingStatus.ASSISTANT, TeachingStatus.LECTURER, TeachingStatus.PROFESSOR, TeachingStatus.SENIOR_LECTURER, TeachingStatus.TUTOR
        };
    }
    
    
    //--------------------------- S A V E   D A T A --------------------------
    private void saveUsers() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("user.out"))) {
            oot.writeObject(users);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("user.out: IOException");
        }
    }

    private void saveCourses() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("course.out"))) {
            oot.writeObject(courses);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("course.out: IOException");
        }
    }

    private void saveNews() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("news.out"))) {
            oot.writeObject(news);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("news.out: IOException");
        }
    }
    
  //--------------------------- L O A D   D A T A --------------------------
    
    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.out"))) {
            users = (Vector<User>) ois.readObject();
        }
        catch (IOException e) {
            users = new Vector<>();
            System.err.println("user.out: IOException");
        }
        catch (ClassNotFoundException e) {
            users = new Vector<>();
            System.err.println("user.out: ClassNotFoundException");
        }
        
    }
    
    private void loadCourses(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("course.out"))) {
            courses = (Vector<Course>) ois.readObject();
        }
        catch (ClassNotFoundException e) {
            courses = new Vector<>();
            System.err.println("course.out: ClassNotFoundException");
        }
        catch (IOException e) {
            courses = new Vector<>();
            System.err.println("course.out: IOException");
        }
    }
    
    private void loadNews() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("news.out"))) {
            news = (Vector<News>) ois.readObject();
        }
        catch (ClassNotFoundException e) {
            news = new Vector<>();
            System.err.println("news.outs: ClassNotFoundException");
        }
        catch (IOException e) {
            news = new Vector<>();
            System.err.println("news.out: IOException");
        }
    }
    
}
