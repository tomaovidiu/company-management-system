package ro.sci.cms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {

		ArrayList<Person> listOfAllEmploy = new ArrayList<>();
		PriorityQueue<Person> employWithParkingSpace = new PriorityQueue<>();
		Person person = new Person("Andrei Toma", 5, "Manager");
		listOfAllEmploy.add(person);
		person = new Person("Gigi", 10, "Junior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Alin", 10, "Senior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Andrei", 9, "Senior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Nana", 5, "Junior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Vivi", 4, "Junior Software Engineer");
		listOfAllEmploy.add(person);

		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmploy);

		companyManagementSystem.printOfAllEmploies();
		employWithParkingSpace = companyManagementSystem.generateListOfEmployeesWithParkingSpace();
		companyManagementSystem.printOfEmploiesWithParkingSpace(employWithParkingSpace);

	}

};