package ro.sci.cms;

import org.junit.Before;
import org.junit.Test;

import ro.sci.cms.Employee.role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This will tests CompanyManagementSystem class.
 * 
 * @author Ovidiu
 *
 */
public class CompanyManagementSystemTest {

	List<Employee> listOfAllEmployess = new ArrayList<>();

	@Before
	public void initListOfEmploy() {
		Employee employ = new Employee("Andrei", 5, role.MANAGER, true);
		listOfAllEmployess.add(employ);
		employ = new Employee("Gigi", 10, role.JUNIOR_ENGINEERS, false);
		listOfAllEmployess.add(employ);
		employ = new Employee("Alin", 9, role.SENIOR_ENGINEERS, true);
		listOfAllEmployess.add(employ);
		employ = new Employee("Doru", 9, role.SENIOR_ENGINEERS, false);
		listOfAllEmployess.add(employ);
		employ = new Employee("Nana", 5, role.SENIOR_ENGINEERS, false);
		listOfAllEmployess.add(employ);
		employ = new Employee("Vivi", 6, role.JUNIOR_ENGINEERS, true);
		listOfAllEmployess.add(employ);
		assertEquals("List generated ok", 6, listOfAllEmployess.size());
	}

	@Test
	public void hashMapIsCreatedOk() throws RoleNotDefined {
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
		companyManagementSystem.addListOfEmployess(listOfAllEmployess);
		assertEquals("HashMap generated ok", 3, companyManagementSystem.getMapOfAllEmploies().size());
	}

	@Test //also print the list of all employees and the list of employees with parking spaces
	public void listOfEmployeesWithoutParkingSpacesHasCorectSize() throws RoleNotDefined {
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
		companyManagementSystem.addListOfEmployess(listOfAllEmployess);
		System.out.println("---List of ALL employees:");
		for (Employee employee : listOfAllEmployess) {
			System.out.println(employee.toString());
		}
		Set<Employee> listOfEmployeesWithoutParkingSpaces = new TreeSet<>();
		listOfEmployeesWithoutParkingSpaces = companyManagementSystem.generateListOfEmployeesWithoutParkingSpace();
		System.out.println("\n---Sorted list of employees whitout parking spaces:");
		for (Employee employee : listOfEmployeesWithoutParkingSpaces) {
			System.out.println(employee.toString());
		}
		assertEquals("List of employess without parking has corect size", 3,
				listOfEmployeesWithoutParkingSpaces.size());
	}

	@Test
	public void listOfEmployeesWithoutParkingSpacesIsSorted() throws RoleNotDefined {
		// given
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
		Set<Employee> listOfEmployeesWithoutParkingSpaces = new TreeSet<>();
		// when
		listOfEmployeesWithoutParkingSpaces = companyManagementSystem.generateListOfEmployeesWithoutParkingSpace();
		int lastEmploySeniority = -1;
		boolean listIsNotSorted = false;
		for (Employee employee : listOfEmployeesWithoutParkingSpaces) {
			//System.out.println(employee.getSeniority() + " " +lastEmploySeniority);
			if (employee.getSeniority() < lastEmploySeniority) {
				listIsNotSorted = true;
				break;
			}
		}
		// then
		assertFalse(listIsNotSorted);
	}

	@Test
	public void listOfManagersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfManagers = new ArrayList<>();
			// when
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
			companyManagementSystem.addListOfEmployess(listOfAllEmployess);
			listOfManagers = companyManagementSystem.getListOfManagers();
			// then
			assertEquals("Managers list size = ok", 1, listOfManagers.size());
		}
	}

	@Test
	public void listOfJuniorEngineersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfJuniorEngineers = new ArrayList<>();
			// when
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
			companyManagementSystem.addListOfEmployess(listOfAllEmployess);
			listOfJuniorEngineers = companyManagementSystem.getListOfJuniorEngineers();
			// then
			assertEquals("Junior engineers list size = ok", 2, listOfJuniorEngineers.size());
		}
	}

	@Test
	public void listOfSeniorEngineersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfSeniorEngineers = new ArrayList<>();
			// when
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem();
			companyManagementSystem.addListOfEmployess(listOfAllEmployess);
			listOfSeniorEngineers = companyManagementSystem.getListOfSeniorEngineers();
			// then
			assertEquals("Senior engineers list size = ok", 3, listOfSeniorEngineers.size());
		}
	}

}
