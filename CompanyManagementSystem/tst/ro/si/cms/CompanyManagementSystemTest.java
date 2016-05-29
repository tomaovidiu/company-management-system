package ro.si.cms;

import org.junit.Test;

import ro.sci.cms.CompanyManagementSystem;
import ro.sci.cms.Person;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class CompanyManagementSystemTest {

	@Test
	public void listOfManagersIsCorectGenerated() {
		{
			Collection<Person> listOfAllEmploy = new TreeSet<>();
			Collection<Person> list = new TreeSet<>();
			Person person = new Person("Andrei Toma", 5, "Manager");
			listOfAllEmploy.add(person);
			person = new Person("Gigi", 10, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Alin", 10, "Senior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Andrei", 9, "Senior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Nana", 5, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Vivi", 4, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmploy);
			list = companyManagementSystem.getListOfManagers();
			assertEquals("manager list size = ok", 1, list.size());
		}
	}

	@Test
	public void listOfJuniorEngeneersIsCorectGenerated() {
		{
			ArrayList<Person> listOfAllEmploy = new ArrayList<>();
			Collection<Person> list = new ArrayList<>();
			Person person = new Person("Andrei Toma", 5, "Manager");
			listOfAllEmploy.add(person);
			person = new Person("Gigi", 10, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Alin", 10, "Senior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Andrei", 9, "Senior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Nana", 5, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Vivi", 4, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmploy);
			list = companyManagementSystem.getListOfJuniorEngineers();
			assertEquals("junior engineers list size = ok", 3, list.size());
		}
	}
	
	@Test
	public void listOfSeniorEngineersIsCorectGenerated() {
		{
			ArrayList<Person> listOfAllEmploy = new ArrayList<>();
			Collection<Person> list = new ArrayList<>();
			Person person = new Person("Andrei Toma", 5, "Manager");
			listOfAllEmploy.add(person);
			person = new Person("Alin", 10, "Senior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Andrei", 9, "Senior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Nana", 5, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			person = new Person("Vivi", 4, "Junior Software Engineer");
			listOfAllEmploy.add(person);
			CompanyManagementSystem companyManagementSystem = new CompanyManagementSystem(listOfAllEmploy);
			list = companyManagementSystem.getListOfSeniorEngineers();
			assertEquals("senior engineers list size = ok", 2, list.size());

		}
	}


//APersonWhoHasNotADefinedRoleIsNotAddedToTheList
	
	//cele 3 liste au size 0
//given when then
//
	
//	listOfEmployeesWithParkingSpaceHasCorectSize
	
	// listOfEmployeesWithParkingSpaceIsCorectGenerated
	// ne uitam la continut din cele 2
}

