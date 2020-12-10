package main;

import java.util.List;
import java.util.Random;

/**
* @generated
*/
public class TechSupportGuy extends Employee {

    private Integer salary;
    private double workExperience;
    private List<Order> orders;
    private String id;
    private String login;
    private String password;
    private Order order;
    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public TechSupportGuy(int salary, double workExperience, String id){
        this.salary = salary;
        this.workExperience  = workExperience;
        this.id = id;
    }
    public Integer getSalary() {
        return this.salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public double getWorkExperience() {
        return this.workExperience;
    }
    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }
    public List<Order> getOrders() {
        return this.orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLogin() {
        return this.login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Order getOrder() {
        return this.order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    

    public boolean acceptOrder(Order order) {
        orders.add(order);
    	return true;
    }
    public void updateOrder(OrderStatus status) {
        this.setOrderStatus(status);
    }
    public void viewOrders(OrderStatus status) {
        for (Order order: this.orders) {
        	if (order.getOrderStatus().equals(orderStatus)){
        		System.out.println(order);
        	}
        }
    }

//    public String getTechSupportGuy(){
//        Random rand = new Random();
//        int num = rand.nextInt(10) + 1;
//        switch(num){
//            case 1:
//                return "Yerbol";
//                break;
//            case 2:
//                return "Nurbol";
//                break;
//            case 3:
//                return "Futbol";
//                break;
//            default:
//                return "No Guy available";
//                break;
//        }
//    }

    public void clearOrders(){
        orders.clear();
    }

    public void numberOfOrders(){
        if(orders.size() == 0){
            System.out.println("No orders");
        }
        else {
            System.out.println(orders.size());
        }
    }
     
    public boolean rejectOrder(Order order) {
        if(getTechSupportGuy().equals("No guy available"));
        return true;
    }

    public String toString(){
        String str = " ";
        for(int i = 0; i < orders.size(); i++){
            str += orders.get(i).toString() + "\n"; 
        }
        return str;
    }
    
}
