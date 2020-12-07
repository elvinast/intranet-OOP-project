package main;

import java.util.List;

/**
* @generated
*/
public class Employee extends User {
    
    private Integer salary;
    private double workExperience;
    private List<Message> messages;
    
    public Employee() {}
    public Employee(String firstName, String lastName, String email, Integer salary) {
    	super(firstName, lastName, email);
    	this.salary = salary;
    }
    
    
	@Override
	public String toString() {
		return super.toString() + " Employee [salary=" + salary + ", workExperience=" + workExperience + ", messages=" + messages + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee employee = (Employee) obj;
		return super.equals(obj) && salary == employee.salary;
	}
	
	private Integer getSalary() {
        return this.salary;
    }
    
    private void setSalary(Integer salary) {
        this.salary = salary;
    }
    
    private double getWorkExperience() {
        return this.workExperience;
    }
    
    private void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    private List<Message> getMessages() {
        return this.messages;
    }

    public void putMessage(Message message) {
        this.messages.add(message);
    }
    
    public void updateSalary(int newSalary) {
    	this.salary += newSalary;
    }
    
}
