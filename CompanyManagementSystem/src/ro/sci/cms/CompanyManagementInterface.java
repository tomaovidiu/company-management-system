package ro.sci.cms;

import java.util.Collection;
import java.util.Set;

public interface CompanyManagementInterface {

	/**
	 * Print all the employees.
	 */
	void printOfAllEmployees();

	/**
	 * This method generates the lis1t of employees with parking space.
	 * 
	 * @return list of these employees
	 */
	Set<Employee> generateListOfEmployeesWithParkingSpace();

	/**
	 * This method print the list of employees with parking space.
	 * 
	 * @param list
	 *            of employees with parking space - to be print
	 */
	void printOfEmploiesWithParkingSpace(Collection<Employee> employWithParkingSpace);

	}