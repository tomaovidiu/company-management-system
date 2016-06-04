package ro.sci.cms;

/**
 * This class implements Employee. An Employ has 4 elements:
 * <ul>
 * <li>name
 * <li>seniority - how old is the employ in the firm
 * <li>role in company
 * <li>hasParkingSpaces - boolean - if the employee has parking spaces
 * </ul>
 *
 * @author Ovidiu
 *
 */
public class Employee implements Comparable<Employee> {

	private String name;
	private int seniority;
	private boolean hasParkingSpaces;
	private role roleInCompany;

	enum role {
		MANAGER, JUNIOR_ENGINEERS, SENIOR_ENGINEERS
	};

	public Employee(String name, int seniority, role roleInCompany, boolean hasParkingSpaces) {

		this.name = name;
		this.seniority = seniority;
		this.roleInCompany = roleInCompany;
		this.setHasParkingSpaces(hasParkingSpaces);
	}

	@Override
	public int compareTo(Employee o) {
		if (this.seniority < o.getSeniority()) {
			return 1;
		}
		if (this.seniority > o.getSeniority()) {
			return -1;
		}
		return this.name.compareTo(o.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public role getRoleInCompany() {
		return roleInCompany;
	}

	public void setRoleInCompany(role roleInCompany) {
		this.roleInCompany = roleInCompany;
	}

	public boolean isHasParkingSpaces() {
		return hasParkingSpaces;
	}

	public void setHasParkingSpaces(boolean hasParkingSpaces) {
		this.hasParkingSpaces = hasParkingSpaces;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", seniority=" + seniority + ", hasParkingSpaces=" + hasParkingSpaces
				+ ", roleInCompany=" + roleInCompany + "]";
	}

}
