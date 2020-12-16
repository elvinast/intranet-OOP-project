package main;

import java.awt.desktop.UserSessionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;


public class Main {

	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
    public static User signIn() {
        for(int i = 0; i < 3; i++) {
        	System.out.println("Welcome! You have " + (3 - i) + " attempts to login.");
        	System.out.println("Enter login: ");
        	String in = sc.next();
        	for(User u: Database.users) {
	        	if (u.getLogin().equals(in) == true) {
	        		System.out.println("Enter password: ");
	        		String in1 = sc.next();
	        		String ps = in1;
	        		if (u.getPassword().equals(ps)) {
	        			System.out.println("Successfully authorized!");
	        			return u;
	        		}
	        		else {
	        			System.out.println("Error! Wrong password!");
	        			continue;
	        		}
	        	}
        	}
        	if (i < 2) System.out.println("Try again!");
        }
        
        System.out.println("No such user:(");
        return null;
    }
    
	public static void main(String[] args){
		//                STUDENTS
		Student s1 = new Student("Jack", "Back", "email123", 2, Faculties.FIT, Degree.BACHELOR);
		Student s2 = new Student("Bob", "KKK", "newmail123", 3, Faculties.MCM, Degree.BACHELOR); 
		Student s3 = new Student("Mike", "Vaz", "gmail", 4, Faculties.ISE, Degree.BACHELOR); 
		Student s4 = new Student("Brown", "Les", "mailru", 1, Faculties.FIT, Degree.BACHELOR); 
		Student s5 = new Student("Jony", "TTT", "emailgoogle", 2, Faculties.FIT, Degree.BACHELOR);
		Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4); Database.users.add(s5);
		
		//                TEACHERS
		Teacher t1 = new Teacher("Teacher111", "235", "emailTeacher", 10000, Faculties.FIT);
		Teacher t2 = new Teacher("Teacher222", "123", "emailTeacher1", 100200, Faculties.FIT);
		Teacher t3 = new Teacher("Teacher333", "New", "emailTeacher2", 110000, Faculties.MCM);
		Teacher t4 = new Teacher("Teacher444", "AAA", "emailTeacher3", 310000, Faculties.FIT);
		Teacher t5 = new Teacher("Teacher555", "BBB", "emailTeacher4", 101000, Faculties.ISE);
		Database.users.add(t1); Database.users.add(t2); Database.users.add(t3); Database.users.add(t4); Database.users.add(t5);
		
		//                TechSupportGuy
		TechSupportGuy techGuy = new TechSupportGuy("TechGuy", "111", "emailTechGuy", 123000);
		Database.users.add(techGuy);
		
		//      		  Manager
		Manager manager = new Manager("FirstManader", "111", "emailManager", 11223000);
		Database.users.add(manager); 
		
		//      		  Admin
		Admin admin = new Admin("Admin", "First", "emailAdmin", 12312000);
		Database.users.add(admin); 
		
		//      		  Courses
		Course OOP = new Course("Object-Oriented Programming and Design", 3, "CS1");
		Course ADS = new Course("Algorithms and Data Structures", 3, "CS2");
		Course DB = new Course("Databases", 3, "CS3");
		Course ICT = new Course("Information and Communication Technologies", 3, "CS4");
		Course PP2 = new Course("Programming principles 2", 4, "CS5");
		Course PP1 = new Course("Programming principles 1", 4, "CS6");
		Database.courses.add(PP1); Database.courses.add(PP2); Database.courses.add(OOP); Database.courses.add(DB); Database.courses.add(ADS); Database.courses.add(ICT);
		

		
//		System.out.println(Database.getTeachers());
//		System.out.println(Database.getStudents());
		
		
		
//		Database.saveCourses();
//		Database.loadCourses();
		
		
//		System.exit(0);
		
		while(true) {
			System.out.println("Welcome to the Intranet System!");
			User u = signIn();
			if (u instanceof Student) {
				System.out.println("Welcome to Student's mode " + u.getFirstName() + "!\n");
				studentsMenu((Student) u);
				break;
			}
			else if (u instanceof Teacher) {
				System.out.println("Welcome to Teahcher's mode " + u.getFirstName() + "!\n");
				teachersMenu((Teacher) u);
				break;
			}
			else if (u instanceof Manager) {
				System.out.println("Welcome to Manager's mode " + u.getFirstName() + "!\n");
				managersMenu((Manager) u);
				break;
			}
			else if (u instanceof Admin) {
				System.out.println("Welcome to Admin's mode " + u.getFirstName() + "!\n");
				adminsMenu((Admin) u);
				break;
			}
			else if (u instanceof TechSupportGuy) {
				System.out.println("Welcome to Executor's mode " + u.getFirstName() + "!\n");
				techSupportGuysMenu((TechSupportGuy) u);
				break;
			}
		}
			
	}

	
	


	
    // ---------------------------- T E A C H E R -----------------------------
	
	
	
	
	private static void teachersMenu(Teacher teacher) {
		while (true) {
	    	System.out.println(   "		[1]         	Information about teacher\n"
	    						+ "		[2]         	View courses\n"
	    						+ "		[3]         	View course Files\n"
	    						+ "		[4]         	Add course file\n"
	    						+ "		[5]        	Delete course file\n"
	    						+ "		[6]         	Add course\n"
	    						+ "		[7]         	Create News\n"
	    						+ "		[8]         	Put mark to student\n"
	    						+ "		[9]         	Send Message\n"
	    						+ "		[10]        	Send Order to Executor\n"
	    						+ "		[11]        	View news\n"
	    						+ "		[0]         	EXIT\n");
	    	int ans = 0;
	    	ans = sc.nextInt();
	    	switch(ans) {
	    		case 1: 
	    			System.out.println(teacher.showInfo());
	    			break;
	    		case 2:
	    			System.out.println(teacher.viewCourses());
	    			break;
	    		case 3: 
	    			viewCourseFiles(teacher);
	    			break;
	    		case 4: 
	    			addCourseFile(teacher);
	    			break;
	    		case 5: 
	    			deleteCourseFile(teacher);
	    			break;
	    		case 6:
	    			System.out.println(addCourse(teacher));
	    			break;
	    		case 7:
	    			createNews(teacher);
	    			break;
	    		case 8:
	    			putMark(teacher);
	    			break;
	    		case 9:
	    			sendMessage(teacher);
	    			break;
	    		case 10:
	    			sendOrder(teacher);
	    			break;
	    		case 11: 
	    			viewNews();;
	    			break;
	    		case 0:
	    			System.exit(0);
	    			break;	
	    	}
		}
	}


	private static void putMark(Teacher teacher) {
		System.out.println("Enter the ID of the student: ");
		String id = sc.next();
		Student student = null;
		for (User u: Database.users) {
			if (u instanceof Student) {
				if (((Student) u).getId().equals(id)) {
					student = (Student) u;
				}
			}
		}
		
		System.out.println("Enter course ID: ");
		String courseID = sc.next();
		Course course = null;
		for (Course c: Database.courses) {
			if (c.getCourseCode().equals(courseID)) {
				course = c;
			}
		}
		if (student.getCourses().contains(course)) {
			System.out.println("Choose number of mark's type: \n1. ATTESTATION 1\n2. ATTESTATION 2\n3. FINAL EXAM");
			int type = sc.nextInt();
			MarksType mark = null;
			switch(type) {
				case 1:
					mark = MarksType.ATTESTATION1; 
					break;
				case 2:
					mark = MarksType.ATTESTATION2; 
					break;	
				case 3:
					mark = MarksType.FINAL_EXAM; 
					break;
			}
			
			System.out.println("Enter the number of points: ");
			Double points = sc.nextDouble();
			try {
				if (teacher.putMark(course, mark, points, student)) {
					System.out.println("Successfully done!");
				}
				else {
					System.out.println("Error!");
				}
				
			} catch (DeadlineExpired e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Error!");
		}
	}

	//FOR ADMIN, TEACHER, MANAGER
	private static void createNews(Employee e) {
		System.out.println("Enter the title of the news: ");
		String title = sc.next();
		System.out.println("Enter the text of the news: ");
		String text = sc.next();
		Date date = java.util.Calendar.getInstance().getTime(); 
		News n = new News(title, text, date);
		if (e instanceof Teacher) {
			Teacher t = (Teacher) e;
			t.createNews(title, text, date);
		}
		else if (e instanceof Manager) {
			Manager t = (Manager) e;
			t.createNews(title, text, date);
		}
		else if (e instanceof Admin) {
			Admin t = (Admin) e;
			t.createNews(title, text, date);
		}
	}
	
	//FOR TEACHER, MANAGER
	private static void sendMessage(Employee e) {
		System.out.println("Enter the title of the message: ");
		String title = sc.next();
		System.out.println("Enter the text of the message: ");
		String text = sc.next();
		Date date = java.util.Calendar.getInstance().getTime(); 
		Message m = new Message(title, text, date);
		System.out.println("Enter the login of Manager/Teacher to send message: ");
		String login = sc.next();
		for(User u : Database.users) {
			if (u instanceof Manager || u instanceof Teacher) {
				if (u.getLogin().equals(login)) {
					if (e instanceof Teacher) {
						Teacher t = (Teacher) e;
						Employee sendTo = (Employee) u;
						t.sendMessage(m, sendTo);
					}
					else if (e instanceof Manager) {
						Manager t = (Manager) e;
						Employee sendTo = (Employee) u;
						t.sendMessage(m, sendTo);
					}
				}
			}
		}
	}
	
	//FOR ADMIN TEACHER MANAGER
	private static void sendOrder(Employee e) {
		System.out.println("Enter the problem: ");
		String problem = sc.next();
		System.out.println("Enter the text of the message: ");
		String text = sc.next();
		Date date = java.util.Calendar.getInstance().getTime(); 
		Order m = new Order(OrderStatus.NEW, text, date, e);
		System.out.println("Enter the name or login of Tech Support Guy to send order: ");
		String login = sc.next();
		for(User u : Database.users) {
			if (u instanceof TechSupportGuy) {
				if (u.getLogin().equals(login) || u.getFirstName().equals(login)) {
					if (e instanceof Teacher) {
						Teacher t = (Teacher) e;
						TechSupportGuy sendTo = (TechSupportGuy) u;
						t.sendOrder(problem, m, sendTo);
						System.out.println("Done!");
					}
					else if (e instanceof Manager) {
						Manager t = (Manager) e;
						TechSupportGuy sendTo = (TechSupportGuy) u;
						t.sendOrder(problem, m, sendTo);
						System.out.println("Done!");
					}
					else if (e instanceof Admin) {
						Admin t = (Admin) e;
						TechSupportGuy sendTo = (TechSupportGuy) u;
						t.sendOrder(problem, m, sendTo);
						System.out.println("Done!");
					}
				}
			}
		}
	}
		

	private static String addCourse(Teacher teacher) {
		System.out.println("Enter course ID: ");
		String c = sc.next();
		for(Course course: Database.courses) {
			if (course.getCourseCode().equals(c)) {
				teacher.addCourse(course);
				return "New course successfully added!";
			}
		}
		return "Oops! No such course in KBTU";
	}

	private static void deleteCourseFile(Teacher teacher) {
		System.out.println("Enter course ID to remove file of this course: ");
		String c = sc.next();
		if (teacher.getCourses().size() >= 1) {
			for (Course course: teacher.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				if (course.courseFiles.size() >= 1) {
    					System.out.println("Enter the title of the file: ");
	    				String fileTitle = sc.next();
	    				for (File f : course.courseFiles) {
	    					if (f.getFileName().equals(fileTitle)) {
	    						course.courseFiles.remove(f);
	    						System.out.println("File successfully deleted\nCourse has " + course.courseFiles.size() + " files.");
	    						break;
	    					}
	    				}
    				}
    				else {
    					System.out.println("You have no files in this course;");
    				}
    			}
    		}
		}
		else {
			System.out.println("You have no courses");
		}
	}
	
	private static void addCourseFile(Teacher teacher) {
		System.out.println("Enter course ID to add file to this course: ");
		String c = "";
		c = sc.next();
		if (teacher.getCourses().size() >= 1) {
			for (Course course: teacher.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				System.out.println("Enter the title of the new file: ");
    				String fileTitle = sc.next();
    				System.out.println("Enter the description of the new file: ");
    				String fileDescription = sc.next();
    				if (teacher.addCourseFile(course, new File(fileTitle, course, teacher, fileDescription))) {
    					System.out.println("New file successfully added to " + course.getCourseName() + " course!\n");
    				}
    				break;
    			}
    		}
		}
		else {
			System.out.println("You have no courses");
		}
	}

	private static void viewCourseFiles(Teacher teacher) {
		System.out.println("Enter course ID to see the files of this course: ");
		String c = "";
		c = sc.next();
		if (teacher.getCourses().size() >= 1) {
			for (Course course: teacher.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				System.out.println(teacher.viewCourseFiles(course));
    				break;
    			}
    		}
		}
		else {
			System.out.println("You have no courses");
		}
	}

	
	
	
	
	// ---------------------------- S T U D E N T -----------------------------
	
	
	
	
	
	private static void studentsMenu(Student student){
		while (true) {
	    	System.out.println(    " 		[1]		Information about student\n"
	    						+ "		[2]         	View courses\n"
	    						+ "		[3]         	View teachers\n"
	    						+ "		[4]         	View transcript\n"
	    						+ "		[5]         	View Marks\n"
	    						+ "		[6]         	View course files\n"
	    						+ "		[7]         	View news\n"
	    						+ "		[8]         	Registration for disciplines\n"
	    						+ "		[0]        		EXIT\n");
	    	int ans = 0;
	    	ans = sc.nextInt();
	    	switch(ans) {
	    		case 1: 
	    			System.out.println(student.showInfo());
	    			break;
	    		case 2:
	    			System.out.println(student.viewCourses());
	    			break;
	    		case 3: 
	    			System.out.println(student.showTeachers());
	    			break;
	    		case 4: 
	    			System.out.println(student.viewTranscript());
	    			break;
	    		case 5: 
	    			showMarks(student);
	    			break;
	    		case 6:
	    			showCourseFiles(student);
	    			break;
	    		case 7:
	    			System.out.println(student.viewNews());
	    			break;
	    		case 8:
	    			registerOnCourse(student);
	    			break;
	    		default:
	    			System.out.println("Bye!");
	    			System.exit(0);
	    			break;	
	    	}
		}
	}



	private static void showMarks(Student student) {
		// TODO Auto-generated method stub
		System.out.println("Enter course id to see the marks of this course: ");
		String c = "";
		c = sc.next();
		if (student.getCourses() != null) {
			for (Course course: student.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				student.viewMarks(course);
    				break;
    			}
    		}
		}
		System.out.println("You don't have such course.");
	}
	
	private static void showCourseFiles(Student student) {
		System.out.println("Enter course id to see the files of this course: ");
		String c = "";
		c = sc.next();
		if (student.getCourses() != null) {
			for (Course course: student.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				student.viewCourseFiles(course);
    				break;
    			}
    		}
		}
		System.out.println("You don't have such course.");
	}
	
	private static void registerOnCourse(Student student) {
		System.out.println("Enter ID of the course for registration: ");
		String c = sc.next();
		try {
			if (student.registerOnCourse(c)) {
				System.out.println("New course successfully added!");
			}
			else {
				System.out.println("Error!");
			}
		} catch (CreditsOverflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	//----------------------------- A D M I N ---------------------------------------
	
	
	
	
	
	private static void adminsMenu(Admin admin) {
    	System.out.println(   "		[1]         	Add user\n"
    						+ "		[2]         	Remove user\n"
    						+ "		[3]         	Show info about admin\n"
    						+ "		[4]         	Create news\n"
    						+ "		[5]         	Add course\n"
    						+ "		[6]        		Send Order to Executor\n"
    						+ "		[7]         	View news\n"
    						+ "		[0]         	EXIT\n");
    	int ans = 0;
    	ans = sc.nextInt();
    	switch(ans) {
    		case 1: 
    			addUser(admin);
    			break;
    		case 2:
    			removeUser(admin);
    			break;
    		case 3: 
    			System.out.println(admin.showInfo());
    		case 4: 
    			createNews(admin);
    			break;
    		case 5: 
    			addCourse(admin);
    			break;
    		case 6: 
    			sendOrder(admin);
    			break;
    		case 7: 
    			viewNews();;
    			break;
    		case 0:
    			System.exit(0);
    			break;	
    	}
	}

	private static void viewNews() {
		// TODO Auto-generated method stub
		for (News n: Database.news) {
			System.out.println(n.showNews());
		}
	}

	private static void addCourse(Admin admin) {
		System.out.println("Enter the name of the course: ");
		String name = sc.next();
		System.out.println("Enter the number of credits: ");
		int credits = sc.nextInt();
		System.out.println("Enter the ID of the course: ");
		String courseID = sc.next();
		admin.addCourse(name, credits, courseID);
	}

	private static void removeUser(Admin admin) {
		System.out.println("Enter login of the user: ");
		String log = sc.next();
		System.out.println("Enter the email: ");
		String email = sc.next();
		for (User u: Database.users) {
			if (u.getLogin().equals(log) && u.getEmail().equals(email)) {
				Database.users.remove(u);
				System.out.println("User successfully removed from KBTU.");
			}
		}
		System.out.println("Error");
	}

	private static void addUser(Admin admin) {
		// TODO Auto-generated method stub		
		System.out.println("		[1]		Add Student\n"
						 + " 		[2]		Add Teacher\n"
						 + " 		[3]		Add Manager\n"
						 + " 		[4]		Add TechSupportGuy\n"
						 + " 		[5]		Add Admin\n");
		int res = sc.nextInt();
		
		System.out.println("Enter the first name: ");
		String firstName = sc.next();
		System.out.println("Enter the last name: ");
		String lastName = sc.next();
		System.out.println("Enter the email: ");
		String email = sc.next();
		
		switch(res) {
			case 1:
				System.out.println("Enter the year of study: ");
				int yearOfStudy = sc.nextInt();
				
				System.out.println("Enter the faculty: ");
				String fac = sc.next();
				Faculties f = getFacultiesss(fac);
				
				System.out.println("Enter the degree: ");
				String deg = sc.next();
				Degree d = null;
				switch(fac) {
					case "PHD": d = Degree.PHD; break;
					case "Masters": d = Degree.MASTERS; break;
					case "Bachelor": d = Degree.BACHELOR; break;
				}
				
				admin.createStudent(firstName, lastName, email, yearOfStudy, f, d);
				break;
			case 2:
				System.out.println("Enter the salary: ");
				int salary = sc.nextInt();
				
				System.out.println("Enter the faculty: ");
				String fac1 = sc.next();
				Faculties f1 = getFacultiesss(fac1);
				
				admin.createTeacher(firstName, lastName, email, salary, f1);
				break;
				
			case 3:
				System.out.println("Enter the salary for manager: ");
				int salaryM = sc.nextInt();
				admin.createManager(firstName, lastName, email, salaryM);
				break;
				
			case 4:
				System.out.println("Enter the salary for executor: ");
				int salaryT = sc.nextInt();
				admin.createTechSupportGuy(firstName, lastName, email, salaryT);
				break;
				
			case 5:
				System.out.println("Enter the salary for administrator: ");
				int salaryA = sc.nextInt();
				admin.createAdmin(firstName, lastName, email, salaryA);
				break;
				
		}
	}
	
	
	
	
	
	// ------------------------- T E C H    S U P P O R T    G U Y ---------------------------------
	
	
	
	
	
	
	private static void techSupportGuysMenu(TechSupportGuy guy) {
		System.out.println(   "		[1]         	View new orders\n"
							+ "		[2]         	View accepted orders\n"
							+ "		[3]         	View rejected orders\n"
							+ "		[4]         	View finished orders\n"
							+ "		[5]         	View pending orders\n"
							+ "		[6]         	Delete all orders\n"
							+ "		[7]        		Manage new orders\n"
							+ "		[8]         	View all orders\n"
							+ "		[9]         	Finish order\n"
							+ "		[10]         	Show info about executor\n"
							+ "		[0]         	EXIT\n");
		int ans = 0;
		ans = sc.nextInt();
		switch(ans) {
		case 1: 
			System.out.println(guy.view0rderByStatus(OrderStatus.NEW));
			break;
		case 2:
			System.out.println(guy.view0rderByStatus(OrderStatus.ACCEPTED));
			break;
		case 3: 
			System.out.println(guy.view0rderByStatus(OrderStatus.REJECTED));
			break;
		case 4: 
			System.out.println(guy.view0rderByStatus(OrderStatus.DONE));
			break;
		case 5: 
			System.out.println(guy.view0rderByStatus(OrderStatus.IN_PROGRESS));
			break;
		case 6: 
			guy.clearOrders();
			System.out.println("Now you have 0 orders.");
			break;
		case 7: 
			manageNewOrders(guy);
			break;
		case 8: 
			System.out.println(guy.view0rdersInfo());
			break;
		case 9: 
			finishOrder(guy);
			break;
		case 10: 
			System.out.println(guy.showInfo());
			break;
		case 0:
			System.exit(0);
			break;	
		}
	}

	private static void finishOrder(TechSupportGuy guy) {
		int i = 1;
		System.out.println("Enter the number of order you want to finish.");
		for(Order order: guy.getOrders()) {
			if (order.getOrderStatus().equals(OrderStatus.IN_PROGRESS)) {
				System.out.println(i + ". " + order);
				i++;
			}
		}
		int k = 1;
		int res = sc.nextInt();
		for(Order order: guy.getOrders()) {
			if (order.getOrderStatus().equals(OrderStatus.IN_PROGRESS)) {
				k++;
				if (k == res) {
					guy.updateOrder(OrderStatus.DONE, order);
					System.out.println("Congrats! You finished 1 order.");
				}
			}
		}
	}

	private static void manageNewOrders(TechSupportGuy guy) {
		int cnt = 0;
		if (guy.getOrders().size() >= 1) {
			for(Order order: guy.getOrders()) {
				if (order.getOrderStatus().equals(OrderStatus.NEW)) {
					cnt++;
				}
			}
		}
		else {
			System.out.println("You have 0 new orders.");
			return;
		}
		System.out.println("You have to accept/reject " + cnt + " orders.");
		for(Order order: guy.getOrders()) {
			if (order.getOrderStatus().equals(OrderStatus.NEW)) {
				System.out.println(order);
				System.out.println("Choose 1 option:\n[1] Accept order\n[2] Reject order\n[3] Back");
				int ans = sc.nextInt();
				switch(ans) {
					case 1:
						guy.acceptOrder(order);
						System.out.println("You successfully accepted " + order);
						break;
					case 2:
						guy.rejectOrder(order);
						System.out.println("You successfully rejected " + order);
						break;
					case 3:
						return;
				}
			}
		}		
	}
	
	
	
	
	// ------------------------------ M A N A G E R ------------------------------
	
	
	
	
	
	private static void managersMenu(Manager manager) {
		System.out.println(   "		[1]         	Create course\n"
							+ "		[2]         	Open course for registration\n"
							+ "		[3]        		View news\n"
							+ "		[4]         	Create news\n"
							+ "		[5]         	Send order to executor\n"
							+ "		[6]         	Show info about manager\n"
							+ "		[7]         	Send message\n"
							+ "		[0]         	EXIT\n");
		int ans = 0;
		ans = sc.nextInt();
		switch(ans) {
			case 1: 
				createCourse(manager);
				break;
			case 2: 
				openCourseForRegistration(manager);
				break;
			case 3: 
				viewNews();
				break;
			case 4: 
				createNews(manager);
				break;
			case 5: 
				sendOrder(manager);
				break;
			case 6: 
				System.out.println(manager.showInfo());
				break;
			case 7:
				sendMessage(manager);
			case 0:
				System.exit(0);
				break;	
		}
	}

	private static void createCourse(Manager manager) {
		System.out.println("Enter the name of the course: ");
		String name = sc.next();
		System.out.println("Enter the number of credits: ");
		int credits = sc.nextInt();
		System.out.println("Enter the ID of the course: ");
		String courseID = sc.next();
		if (manager.createCourse(name, credits, courseID))
			System.out.println("Course successfully created!");
		else System.out.println("Error");
		
	}

	private static void openCourseForRegistration(Manager manager) {
		System.out.println("Enter course ID: ");
		String id = sc.next();
		Course course = null;
		
		for(Course c: Database.courses) {
			if (c.getCourseCode().equals(id)) {
				course = c;
			}
		}
		
		System.out.println("Enter faculty: ");
		String fac = sc.next();
		Faculties f = getFacultiesss(fac);
		if (manager.suggestCourse(course, f))
			System.out.println("Course is available now");
		else System.out.println("Error!");
	}
	
	private static Faculties getFacultiesss(String fac) {
		Faculties f = null;
		switch(fac) {
			case "FIT": f = Faculties.FIT; break;
			case "BS": f = Faculties.BS; break;
			case "ISE": f = Faculties.ISE; break;
			case "FGA": f = Faculties.FGA; break;
			case "FEOGI": f = Faculties.FEOGI; break;
			case "KMA": f = Faculties.KMA; break;
			case "MCM": f = Faculties.MCM; break;
		}
		return f;
	}
} 
