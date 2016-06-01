package ro.sci.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;



/**
 * Class Company Management System receives as an input a list of employees.
 * The Company Management System allow a way to obtain a list of employees who
 * don't have any parking spaces. This list should be ordered based on the
 * employee's seniority in the company. Employee's seniority is defined by the
 * years spent in the company - Not the role. This class keeps internally the
 * employees in role-specific lists. All managers will be in a managers
 * collection, all junior software engineers will be in the junior software
 * engineers collection.
 * 
 * This class implements CompanyManagementInterface.
 * 
 * @author Ovidiu
 *
 */

/**
 * The constructor generates from Collection of Employ a HashMap which contains
 * all the employ's data. Inside the HashMap are three collection - role
 * specific.
 * 
 * @author Ovidiu
 *
 */
public class CompanyManagementSystem implements CompanyManagementInterface {

	private Collection<Employee> listOfManagers = new ArrayList<>();
	private Collection<Employee> listOfJuniorEngineers = new ArrayList<>();
	private Collection<Employee> listOfSeniorEngineers = new ArrayList<>();
	private HashMap<role, Collection<Employee>> mapOfAllEmployees = new HashMap<>();
	
	public CompanyManagementSystem(Collection<Employee> listOfAllEmploy) throws RoleNotDefined {
		createListsForDifferentEmploiesRoles(listOfAllEmploy);
		addListsToHashMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.sci.cms.CompanyManagementInterface#
	 * generateListOfEmployeesWithParkingSpace()
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
		System.out.println("----------");
		for (Employee employee : listOfEmployeesWithoutParkingSpace) {
			System.out.println(employee.toString());
		}
		return listOfEmployeesWithoutParkingSpace;
	}


	private void addListsToHashMap() {
		mapOfAllEmployees.put(role.MANAGER, listOfManagers);
		mapOfAllEmployees.put(role.SENIOR_ENGINEERS, listOfSeniorEngineers);
		mapOfAllEmployees.put(role.JUNIOR_ENGINEERS, listOfJuniorEngineers);
	}

	private void createListsForDifferentEmploiesRoles(Collection<Employee> listOfAllEmploy) throws RoleNotDefined {
		for (Employee employ : listOfAllEmploy) {
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
				throw new RoleNotDefined(
						"Error - Role in company " + employ.getRoleInCompany() + " not exist" + "\n Employ not added!");
			}
			}
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
