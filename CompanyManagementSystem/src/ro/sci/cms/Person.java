package ro.sci.cms;

public class Person implements Comparable<Person> {

	private String name;
	private int seniority;
	private String roleInCompany;

	public Person(String name, int seniority, String roleInCompany) {

		this.name = name;
		this.seniority = seniority;
		this.roleInCompany = roleInCompany;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", seniority=" + seniority + ", roleInCompany=" + roleInCompany + "]";
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

	public String getRoleInCompany() {
		return roleInCompany;
	}

	public void setRoleInCompany(String roleInCompany) {
		this.roleInCompany = roleInCompany;
	}

	@Override
	public int compareTo(Person o) {
		if (this.seniority < o.getSeniority()) {
			return -1;
		}
		if (this.seniority > o.getSeniority()) {
			return 1;
		}
		return 0;

	}

}
