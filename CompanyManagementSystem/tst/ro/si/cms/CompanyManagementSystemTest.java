package ro.si.cms;

import org.junit.Test;

import ro.sci.cms.CompanyManagementSystem;
import ro.sci.cms.Employee;
import ro.sci.cms.RoleNotDefined;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class CompanyManagementSystemTest {

	@Test
	public void listOfManagersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection<Employee> listOfAllEmployees = new TreeSet<>();
			Collection<Employee> listOfManagers = new TreeSet<>();
			Employee employ = new Employee("Andrei Toma", 5, "Manager");
			listOfAllEmployees.add(employ);
			employ = new Employee("Gigi", 10, "Junior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Alin", 10, "Senior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Andrei", 9, "Senior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Nana", 5, "Junior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Vivi", 4, "Junior Software Engineer");
			// when
			listOfAllEmployees.add(employ);
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployees);
			listOfManagers = companyManagementSystem.getListOfManagers();
			// then
			assertEquals("manager list size = ok", 1, listOfManagers.size());
		}
	}

	@Test
	public void listOfJuniorEngineersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			ArrayList<Employee> listOfAllEmployees = new ArrayList<>();
			Collection<Employee> listOfJuniorEngineers = new ArrayList<>();
			Employee employ = new Employee("Andrei Toma", 5, "Manager");
			listOfAllEmployees.add(employ);
			employ = new Employee("Gigi", 10, "Junior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Alin", 10, "Senior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Andrei", 9, "Senior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Nana", 5, "Junior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Vivi", 4, "Junior Software Engineer");
			// when
			listOfAllEmployees.add(employ);
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployees);
			listOfJuniorEngineers = companyManagementSystem.getListOfJuniorEngineers();
			// then
			assertEquals("junior engineers list size = ok", 3, listOfJuniorEngineers.size());
		}
	}

	@Test
	public void listOfSeniorEngineersIsCorectGenerated() throws RoleNotDefined {
		{
			// given
			Collection <Employee> listOfAllEmployees = new ArrayList<>();
			Collection<Employee> listOfSeniorEngineers = new ArrayList<>();
			Employee employ = new Employee("Andrei Toma", 5, "Manager");
			listOfAllEmployees.add(employ);
			employ = new Employee("Alin", 10, "Senior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Andrei", 9, "Senior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Nana", 5, "Junior Software Engineer");
			listOfAllEmployees.add(employ);
			employ = new Employee("Vivi", 4, "Junior Software Engineer");
			// when
			listOfAllEmployees.add(employ);
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployees);
			listOfSeniorEngineers = companyManagementSystem.getListOfSeniorEngineers();
			// then
			assertEquals("senior engineers list size = ok", 2, listOfSeniorEngineers.size());

		}
	}

	@Test
	public void anEmployeeWhoHasNotADefinedRoleIsNotAddedToAnyInternalUsedCollection() throws RoleNotDefined {
		// given
		Collection<Employee> listOfAllEmployees = new ArrayList<>();
		Collection<Employee> list1 = new ArrayList<>();
		Collection<Employee> list2 = new ArrayList<>();
		Collection<Employee> list3 = new ArrayList<>();
		// when
		Employee employ = new Employee("Andrei Toma", 5, "Undefined Role");
		listOfAllEmployees.add(employ);
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployees);
		list1 = companyManagementSystem.getListOfSeniorEngineers();
		list2 = companyManagementSystem.getListOfManagers();
		list3 = companyManagementSystem.getListOfJuniorEngineers();
		// then
		assertEquals("an employee with undefined role is not added to any Colection", 0,
				list1.size() + list2.size() + list3.size());

	}

	@Test
	public void listSizeOfEmployeesWithParkingSpaceIsLessOrEqualThenNumberOfParkingSpaces() throws RoleNotDefined {
		// list size can be less then number of parking spaces!
		// given
		Collection<Employee> listOfAllEmployees = new TreeSet<>();
		Employee employ = new Employee("Andrei Toma", 5, "Manager");
		listOfAllEmployees.add(employ);
		employ = new Employee("Gigi", 10, "Junior Software Engineer");
		listOfAllEmployees.add(employ);
		employ = new Employee("Alin", 10, "Senior Software Engineer");
		listOfAllEmployees.add(employ);
		employ = new Employee("Andrei", 9, "Senior Software Engineer");
		listOfAllEmployees.add(employ);
		employ = new Employee("Nana", 5, "Junior Software Engineer");
		listOfAllEmployees.add(employ);
		employ = new Employee("Vivi", 4, "Junior Software Engineer");
		// when
		listOfAllEmployees.add(employ);
		CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmployees);
		// then
		assertTrue("list size is ok", companyManagementSystem.generateListOfEmployeesWithParkingSpace()
				.size() <= companyManagementSystem.getNumberOfParkingSpaces());
	}

	// listOfEmployeesWithParkingSpaceIsCorectGenerated
	// ne uitam la continut din cele 2
}
