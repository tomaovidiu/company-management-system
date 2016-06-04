package ro.sci.cms;

import java.util.List;
import java.util.Set;

public interface CompanyManagementInterface {
	enum role {
		MANAGER, JUNIOR_ENGINEERS, SENIOR_ENGINEERS
	};

	/**
	 * This method generates the list of employees with parking space.
	 * 
	 * @return list of these employees
	 */
	Set<Employee> generateListOfEmployeesWithoutParkingSpace();

	/**
	 * This method add a list of employees to the company management system.
	 * 
	 * @param listOfAllEmployees
	 */
	void addListOfEmployees(List<Employee> listOfAllEmployees);

}