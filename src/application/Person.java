package application;

import javafx.beans.property.*;

public class Person {
	private StringProperty firstName = new SimpleStringProperty();
	private StringProperty lastName = new SimpleStringProperty();
	private DoubleProperty salary = new SimpleDoubleProperty();
	
	public Person() {
		this.firstName.set("");
		this.lastName.set("");
		this.salary.set(0);
	}
	public Person(String firstName, String lastName, double salary) {
		this.firstName.set(firstName);
		this.lastName.set(lastName);
		this.salary.set(salary);
	}
	
	public StringProperty firstNameProperty()
	{
		return firstName;
	}
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	public StringProperty lastNameProperty()
	{
		return lastName;
	}
	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
	public DoubleProperty salaryProperty()
	{
		return salary;
	}
	public double getSalary() {
		return salary.get();
	}
	public void setSalary(double salary) {
		this.salary.set(0);
	}
	
}

