package ro.sci.cms;


import java.util.Set;

public interface CompanyManagementInterface {
	enum role {
		MANAGER, JUNIOR_ENGINEERS, SENIOR_ENGINEERS
	};
	

	/**
	 * This method generates the lis1t of employees with parking space.
	 * 
	 * @return list of these employees
	 */
	Set<Employee> generateListOfEmployeesWithoutParkingSpace();

	/**
	 * This method print the list of employees with parking space.
	 * 
	 * @param list
	 *            of employees with parking space - to be print
	 */

	}