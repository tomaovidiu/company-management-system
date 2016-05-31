package ro.sci.cms;

import org.junit.Before;
import org.junit.Test;

import ro.sci.cms.CompanyManagementSystem.role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This will tests CompanyManagementClass.
 * 
 * @author Toma
 *
 */
public class CompanyManagementSystemTest {

	List<role> listOfAllEmployess = new ArrayList<>();

	@Before
	public void initListOfEmploy() {
		Employee employ = new Employee("Andrei Toma", 5, role.MANAGER, true);
		listOfAllEmployess.add(employ);
		employ = new Employee("Gigi", 10, role.JUNIOR_ENGINEERS, false);
		listOfAllEmployess.add(employ);
		employ = new Employee("Alin", 9, role.SENIOR_ENGINEERS, true);
		listOfAllEmployess.add(employ);
		employ = new Employee("Doru", 9, role.SENIOR_ENGINEERS, false);
		listOfAllEmployess.add(employ);
		employ = new Employee("Nana", 5, role.SENIOR_ENGINEERS, false);
		listOfAllEmployess.add(employ);
		employ = new Employee("Vivi", 4, role.JUNIOR_ENGINEERS, true);
		listOfAllEmployess.add(employ);
		assertEquals("List generated ok", 6, listOfAllEmployess.size());
	}

	@Test
	public void hashMapIsCreatedOk() throws RoleNotDefined {
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployess);
		assertEquals("HashMap generated ok", 3, companyManagementSystem.getMapOfAllEmploies().size());
	}

	@Test
	public void listOfManagersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfManagers = new ArrayList<>();
			// when
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployess);
			listOfManagers = companyManagementSystem.getListOfManagers();
			// then
			assertEquals("managers list size = ok", 1, listOfManagers.size());
		}
	}

	@Test
	public void listOfJuniorEngineersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfJuniorEngineers = new ArrayList<>();
			// when
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployess);
			listOfJuniorEngineers = companyManagementSystem.getListOfJuniorEngineers();
			// then
			assertEquals("junior engineers list size = ok", 3, listOfJuniorEngineers.size());
		}
	}

	@Test
	public void listOfSeniorEngineersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfSeniorEngineers = new ArrayList<>();
			// when
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployess);
			listOfSeniorEngineers = companyManagementSystem.getListOfSeniorEngineers();
			// then
			assertEquals("senior engineers list size = ok", 2, listOfSeniorEngineers.size());

		}
	}

		@Test
	public void listSizeOfEmployeesWithParkingSpaceIsLessOrEqualThenNumberOfParkingSpaces() throws RoleNotDefined {
		// list size can be less then number of parking spaces!
		// given
		Collection<Employee> listOfAllEmployees = new TreeSet<>();
		Employee employ = new Employee("Andrei Toma", 5, "Manager", true);
		listOfAllEmployees.add(employ);
		employ = new Employee("Gigi", 10, "Junior Software Engineer", false);
		listOfAllEmployees.add(employ);
		employ = new Employee("Alin", 10, "Senior Software Engineer", true);
		listOfAllEmployees.add(employ);
		employ = new Employee("Andrei", 9, "Senior Software Engineer", false);
		listOfAllEmployees.add(employ);
		employ = new Employee("Nana", 5, "Junior Software Engineer", true);
		listOfAllEmployees.add(employ);
		employ = new Employee("Vivi", 4, "Junior Software Engineer", true);
		// when
		listOfAllEmployees.add(employ);
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployees);
		// then
		
	}

	// listOfEmployeesWithParkingSpaceIsCorectGenerated
	// equals true = num
}
