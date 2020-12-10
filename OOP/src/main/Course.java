package main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class Course implements Serializable, Comparable {
    
    private String courseName;
    private Integer credits;
    private String description;
    private String courseCode;
    private boolean isAvailable;
    private Teacher teacher;
    private List<Student> students;
    private List<File> courseFiles;
    private HashMap<Student, Mark> marks;
    private String prerequisite;
//    public List<File> files;
    
    
    public Course(String courseName, Integer credits, Teacher teacher, String courseCode) {
    	this.courseName = courseName;
    	this.credits = credits;
    	this.teacher = teacher;
    	this.courseCode = courseCode;
    }

//    public Course(String courseName, Integer credits, String description, String courseCode, Boolean isAvailable, Teacher teacher,
//    		List<Studentt> students, List<File> courseFiles, HashMap<Studentt, Mark> marks, String prerequisite, List<File> files) {
//    	this.courseName = courseName;
//    	this.credits = credits;
//    	this.description = description;
//    	this.courseCode = courseCode;
//    	this.isAvailable = isAvailable;
//    	this.teacher = teacher;
//    	this.students = students;
//    	this.courseFiles = courseFiles;
//    	this.marks = marks;
//    	this.prerequisite = prerequisite;
////    	this.files = files;
//    	
//    }

    public Course(String courseName, Integer credits, String description, String courseCode, Boolean isAvailable, Teacher teacher,
    		List<Student> students, List<File> courseFiles, HashMap<Studentt, Mark> marks, String prerequisite) {
    	this.courseName = courseName;
    	this.credits = credits;
    	this.description = description;
    	this.courseCode = courseCode;
    	this.isAvailable = isAvailable;
    	this.teacher = teacher;
    	this.students = students;
    	this.courseFiles = courseFiles;
    	this.marks = marks;
    	this.prerequisite = prerequisite;

    	
    }
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public Integer getCredits() {
        return this.credits;
    }
    
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public List<File> getCourseFiles() {
        return this.courseFiles;
    }

    public void setCourseFiles(List<File> courseFiles) {
        this.courseFiles = courseFiles;
    }

    public HashMap<Student, Mark> getMarks() {
        return this.marks;
    }

    public void setMarks(HashMap<Student, Mark> marks) {
        this.marks = marks;
    }

    public String getPrerequisite() {
        return this.prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

//    public File getFile() {
//        return this.files;
//    }
//
//    public void setFile(File file) {
//        this.files = file;
//    }

    //                          Operations                                  

    public void addStudent(Student student) {
        //TODO
    	if(students.contains(student)) {
    		System.out.println("This student is in this course");
    	}else {
    		students.add(student);
    		System.out.println("Student added");
    	}
    }

    public boolean removeStudent(Student student) {
        //TODO
    	if(students.contains(student)) {
    		students.remove(student);
    		System.out.println("This student removed");
    		return true;
    	}else {
    		System.out.println("This student isn't in this course");
    		return false;
    	}
    }

    public void addCourseFile(File courseFile) {
        //TODO
    	if(courseFiles.contains(courseFile)) {
    		System.out.println("This course file was added");
    	}else {
    		courseFiles.add(courseFile);
    		System.out.println("Course file added");
    	}
    }

    public boolean removeCourseFile(File courseFile) {
        //TODO
    	if(courseFiles.contains(courseFile)) {
    		courseFiles.remove(courseFile);
    		System.out.println("This course file removed");
    		return true;
    	}else {
    		System.out.println("This course file isn't exist");
    		return false;
    	}
    }
//    /**
//    * @return 
//     * @generated
//    */
//    public void putMark() {
//        //TODO
//    }

    public boolean hasPrereq() {
        //TODO
    	if(prerequisite != null) {
    		return true;
    	}else {
    		return false;
    	}
    }

    public void showPrereq(Course course) {
        //TODO
    	if(hasPrereq()) {
    		System.out.println(prerequisite);
    	}else {
    		System.out.println("There is no prerequisite");
    	}
    }

    public void addPrereq(String courseCode) {
        //TODO
    	if(!hasPrereq()) {
    		setPrerequisite(courseCode);
    	}else {
    		System.out.println("Course has prerequisite");
    	}
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Course c = (Course) o;
		return this.courseCode.compareTo(c.courseCode);
	}
	
    
}
