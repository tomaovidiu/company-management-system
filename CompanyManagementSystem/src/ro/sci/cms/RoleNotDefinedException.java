package ro.sci.cms;

public class RoleNotDefinedException extends Exception {

	private static final long serialVersionUID = 799596449794372866L;

	public RoleNotDefinedException(String string) {
		super(string);
		System.err.println(string);
	}

}
