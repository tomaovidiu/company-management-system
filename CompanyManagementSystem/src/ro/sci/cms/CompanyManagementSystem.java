package ro.sci.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class Company Management System receives as an input a list of employees. The
 * Company Management System allow a way to obtain a list of employees who don't
 * have any parking spaces. This list should be ordered based on the employee's
 * seniority in the company. Employee's seniority is defined by the years spent
 * in the company - Not the role. This class keeps internally the employees in
 * role-specific lists. All managers will be in a managers collection, all
 * junior software engineers will be in the junior software engineers
 * collection.
 *
 * This class implements CompanyManagementInterface.
 * 
 * @author Ovidiu
 *
 */

public class CompanyManagementSystem implements CompanyManagementInterface {

	private Collection<Employee> listOfManagers = new ArrayList<>();
	private Collection<Employee> listOfJuniorEngineers = new ArrayList<>();
	private Collection<Employee> listOfSeniorEngineers = new ArrayList<>();
	private HashMap<role, Collection<Employee>> mapOfAllEmployees = new HashMap<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.sci.cms.CompanyManagementInterface#addListOfEmployees(java.util.List)
	 */
	@Override
	public void addListOfEmployees(List<Employee> listOfAllEmployees)
			throws WrongSeniorityException, RoleNotDefinedException {

		if (listOfAllEmployees == null) {
			throw new IllegalArgumentException("Exception: List of all employees in empthy!");
		}

		createListsForDifferentEmployeesRoles(listOfAllEmployees);
		addListsToHashMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.sci.cms.CompanyManagementInterface#
	 * generateListOfEmployeesWithoutParkingSpace()
	 */
	@Override
	public Set<Employee> generateListOfEmployeesWithoutParkingSpace() {
		Collection<Employee> listOfAllEmployees = new TreeSet<Employee>();
		Set<Employee> listOfEmployeesWithoutParkingSpace = new TreeSet<Employee>();

		// prepare the list with all the employees
		for (Entry<role, Collection<Employee>> entry : mapOfAllEmployees.entrySet()) {
			listOfAllEmployees.addAll(entry.getValue());
		}
		// generate the list of employees with parking spaces
		for (Employee employee : listOfAllEmployees) {
			if (employee.isHasParkingSpaces()) {
				listOfEmployeesWithoutParkingSpace.add(employee);
			}
		}
		return listOfEmployeesWithoutParkingSpace;
	}

	private void addListsToHashMap() {
		mapOfAllEmployees.put(role.MANAGER, listOfManagers);
		mapOfAllEmployees.put(role.SENIOR_ENGINEERS, listOfSeniorEngineers);
		mapOfAllEmployees.put(role.JUNIOR_ENGINEERS, listOfJuniorEngineers);
	}

	private void createListsForDifferentEmployeesRoles(Collection<Employee> listOfAllEmployees)
			throws WrongSeniorityException, RoleNotDefinedException {

		try {
			for (Employee employ : listOfAllEmployees) {
				if (employ.getSeniority() < 0) {
					throw new WrongSeniorityException(
							"Exception: Seniority < 0 is not ok! At employ " + employ.getName());
				}

				switch (employ.getRoleInCompany()) {
				case MANAGER: {
					listOfManagers.add(employ);
					break;
				}
				case JUNIOR_ENGINEERS: {
					listOfJuniorEngineers.add(employ);
					break;
				}
				case SENIOR_ENGINEERS: {
					listOfSeniorEngineers.add(employ);
					break;
				}
				default: {
					throw new RoleNotDefinedException("Error - Role in company " + employ.getRoleInCompany()
							+ " not defined! At employ " + employ.getName());
				}
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Exception: List of employees is not valid!");
			e.printStackTrace();
		}

	}

	public Collection<Employee> getListOfManagers() {
		return listOfManagers;
	}

	public Collection<Employee> getListOfJuniorEngineers() {
		return listOfJuniorEngineers;
	}

	public Collection<Employee> getListOfSeniorEngineers() {
		return listOfSeniorEngineers;
	}

	public HashMap<role, Collection<Employee>> getMapOfAllEmploies() {
		return mapOfAllEmployees;
	}
}
