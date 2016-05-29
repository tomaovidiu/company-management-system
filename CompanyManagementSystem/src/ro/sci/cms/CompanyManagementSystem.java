package ro.sci.cms;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class CompanyManagementSystem {

	private Collection <Person> listOfManagers = new ArrayList<>();
	private Collection <Person> listOfJuniorEngineers = new ArrayList<>();
	private Collection <Person> listOfSeniorEngineers = new ArrayList<>();
	private HashMap<String,Collection<Person>> mapOfAllEmployees = new HashMap<>();
	private int numberOfParkingSpaces = 10;

	public CompanyManagementSystem(Collection<Person> listOfAllEmploy) {
		createListsForDifferentEmploiesRoles(listOfAllEmploy);
		addListsToHashMap();
	}

	
	
	
	
	private void addListsToHashMap() {
		mapOfAllEmployees.put("Manager", listOfManagers);
		mapOfAllEmployees.put("Senior Software Engineer", listOfSeniorEngineers);
		mapOfAllEmployees.put("Junior Software Engineer", listOfJuniorEngineers);
	}

	private void createListsForDifferentEmploiesRoles(Collection<Person> listOfAllEmploy) {
		for (Person person : listOfAllEmploy) {
			if (person.getRoleInCompany().equals("Manager")
					|| (person.getRoleInCompany().equals("Junior Software Engineer"))
					|| (person.getRoleInCompany().equals("Senior Software Engineer")))

				switch (person.getRoleInCompany()) {
				case "Manager":
					listOfManagers.add(person);
					break;

				case "Junior Software Engineer":
					listOfJuniorEngineers.add(person);
					break;

				case "Senior Software Engineer":
					listOfSeniorEngineers.add(person);
					break;
				}
			else {
				System.out.println("Error - Role in company " + person.getRoleInCompany() + " not exist");
				System.out.println("Person " + person.getName() + " NOT added!");
			}
		}
	}

	public void printOfAllEmploies() {
		int nrOfEmployees = 0;
		System.out.println("\nList of all emploies - from HashMap:");
		if (mapOfAllEmployees.isEmpty()) {
			System.out.println("No employees are in the list!");
		} else {
			for (Entry<String, Collection<Person>> entry : mapOfAllEmployees.entrySet()) {
				// System.out.println(entry.getKey() + "/" +
				// entry.getValue().toString());
				ArrayList<Person> temp = new ArrayList<>();
				temp.addAll(entry.getValue());
				for (Person person : temp) {
					System.out.println(person.toString());
					nrOfEmployees++;
				}
			}
			System.out.println("Number of employees = " + nrOfEmployees);
		}
	}

	public PriorityQueue<Person> generateListOfEmployeesWithParkingSpace() {
		// prepare the list with all the employees
		PriorityQueue<Person> listOfEmployeesWithParkingSpace = new PriorityQueue<Person>();
		for (Entry<String, Collection<Person>> entry : mapOfAllEmployees.entrySet()) {
			listOfEmployeesWithParkingSpace.addAll(entry.getValue());
		}
		System.out.println(listOfEmployeesWithParkingSpace.size());
		// eliminate from the list the employ witch don't have parking spaces
		int sizeList = listOfEmployeesWithParkingSpace.size();
		for (int i = 0; i < sizeList - numberOfParkingSpaces; i++) {
			listOfEmployeesWithParkingSpace.remove();
		}
		return listOfEmployeesWithParkingSpace;
	}

	public void printOfEmploiesWithParkingSpace(PriorityQueue<Person> listOfEmployiesWithParkingSpace) {
		System.out.println("\nList of emploies with parking spaces:");
		if (numberOfParkingSpaces == 0) {
			System.out.println("Number of parking spaces = 0 ! No employ has parking spaces!");
		} else {
			int temp = listOfEmployiesWithParkingSpace.size();
			for (int i = 0; i < temp; i++) {
				System.out.println(listOfEmployiesWithParkingSpace.poll());
			}
			System.out.println("Number of parking spaces = " + numberOfParkingSpaces);
		}
	}

	public Collection<Person> getListOfManagers() {
		return listOfManagers;
	}

	public void setListOfManagers(ArrayList<Person> listOfManagers) {
		this.listOfManagers = listOfManagers;
	}

	public Collection<Person> getListOfJuniorEngineers() {
		return listOfJuniorEngineers;
	}

	public void setListOfJuniorEngineers(ArrayList<Person> listOfJuniorEngineers) {
		this.listOfJuniorEngineers = listOfJuniorEngineers;
	}

	public Collection<Person> getListOfSeniorEngineers() {
		return listOfSeniorEngineers;
	}

	public void setListOfSeniorEngineers(ArrayList<Person> listOfSeniorEngineers) {
		this.listOfSeniorEngineers = listOfSeniorEngineers;
	}

	public AbstractMap<String,Collection<Person>> getMapOfAllEmploies() {
		return mapOfAllEmployees;
	}

	public void setMapOfAllEmploies(HashMap<String, Collection<Person>> mapOfAllEmploies) {
		this.mapOfAllEmployees = mapOfAllEmploies;
	}

	public int getNumberOfParkingSpaces() {
		return numberOfParkingSpaces;
	}

	public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
		this.numberOfParkingSpaces = numberOfParkingSpaces;
	}

}
