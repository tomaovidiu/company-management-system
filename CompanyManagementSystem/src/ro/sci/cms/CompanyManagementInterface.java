package ro.sci.cms;

import java.util.List;
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
	 * This method add list of employees to the company management system
	 * 
	 * @return void
	 */
	void addListOfEmployess(List<Employee> listOfAllEmployees) throws RoleNotDefinedException, WrongSeniorityException;

}