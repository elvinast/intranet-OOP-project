package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student s = new Student("Jack", "V", "hismail", 2, Faculties.FIT, Degree.BACHELOR);
			System.out.println(s.createID());
			System.out.println(s.getId());
			
			Student s1 = new Student("Bob", "KKK", "mail123", 3, Faculties.MCM, Degree.BACHELOR);
			s1.setPassword("123hello");
			Database.users.add(s1);
			System.out.println(s1.getLogin());
		
			s1.signIn();
			
			Teacher t = new Teacher("Teacher111", "235", "emailTeacher", 10000, Faculties.FIT);
			System.out.println(t.getLogin());
			
			
			
			
	}

} 
