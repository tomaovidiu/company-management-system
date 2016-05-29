package ro.sci.cms;

import java.util.Collection;
import java.util.TreeSet;

/**
 * This the Main class of the application - Company Management System. Is uses
 * as an input a list of employees. The Company Management System must
 * allow a way to obtain a list of employees who don't have any parking spaces.
 * 
 * @author Ovidiu
 *
 */
public class Main {

	public static void main(String[] args) throws RoleNotDefined {

		Collection<Employee> listOfAllEmploy = new TreeSet<>();
		Collection<Employee> employWithParkingSpace = new TreeSet<>();
		Employee employ = new Employee("Andrei Toma", 5, "Manager");
		listOfAllEmploy.add(employ);
		employ = new Employee("Gigi", 10, "Junior Software Engineer");
		listOfAllEmploy.add(employ);
		employ = new Employee("Alin", 9, "Senior Software Engineer");
		listOfAllEmploy.add(employ);
		employ = new Employee("Doru", 9, "Senior Software Engineer");
		listOfAllEmploy.add(employ);
		employ = new Employee("Nana", 5, "Junior Software  Engineer");
		listOfAllEmploy.add(employ);
		employ = new Employee("Vivi", 4, "Junior Software Engineer");
		listOfAllEmploy.add(employ);
		System.out.println("size after add = " + listOfAllEmploy.size());

		CompanyManagementInterface companyManagementSystem = new CompanyManagementSystem(listOfAllEmploy);

		companyManagementSystem.printOfAllEmployees();
		employWithParkingSpace = companyManagementSystem.generateListOfEmployeesWithParkingSpace();
		companyManagementSystem.printOfEmploiesWithParkingSpace(employWithParkingSpace);

	}

};