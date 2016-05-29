package ro.sci.cms;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Collection<Person> listOfAllEmploy = new TreeSet<>();
		PriorityQueue<Person> employWithParkingSpace = new PriorityQueue<>();
		Person person = new Person("Andrei Toma", 5, "Manager");
		listOfAllEmploy.add(person);
		person = new Person("Gigi", 10, "Junior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Alin", 9, "Senior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Doru", 9, "Senior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Nana", 5, "Junior Software Engineer");
		listOfAllEmploy.add(person);
		person = new Person("Vivi", 4, "Junior Software Engineer");
		listOfAllEmploy.add(person);
		System.out.println("size after add = " + listOfAllEmploy.size());

		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmploy);

		companyManagementSystem.printOfAllEmploies();
		employWithParkingSpace = companyManagementSystem.generateListOfEmployeesWithParkingSpace();
		companyManagementSystem.printOfEmploiesWithParkingSpace(employWithParkingSpace);

	}

};