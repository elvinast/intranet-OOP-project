package main;

import java.io.Serializable;
import java.util.Scanner;

/**
* @generated
*/
public class User implements Serializable, Comparable {
	
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    
    public User() {}

    public User(String firstName, String lastName, String email) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.login = this.firstName.substring(0, 1).toLowerCase() + "_" + this.lastName.toLowerCase();
    	this.password = password;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }
  
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return this.login;
    }
    

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //                          Operations                                  
    
    Scanner sc = new Scanner(System.in);
    public int signIn() {
        
        
//        int id = Integer.parseInt(in);
        for(int i = 0; i < 3; i++) {
        	System.out.println("Welcome! You have " + (3 - i) + " attempts to login.");
        	System.out.println("Enter login: ");
        	String in = sc.next();
        	for(User u: Database.users) {
	        	if (u.login.equals(in) == true) {
	        		System.out.println("Enter password: ");
	        		String in1 = sc.next();
	        		String ps = in1;
	        		if (u.password.equals(ps)) {
	        			System.out.println("Successfully authorized!");
	        			return 1;
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
        return -1;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
        	this.password = newPassword;
        	return true;
        }
    	return false;
    }
    
    @Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		User user = (User)o;
        return this.login.compareTo(user.login);
	}

}
