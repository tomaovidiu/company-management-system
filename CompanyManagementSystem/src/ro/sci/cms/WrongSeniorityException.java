package ro.sci.cms;

public class WrongSeniorityException extends Exception {
	private static final long serialVersionUID = -8507817084206133458L;

	public WrongSeniorityException(String string) {
		super(string);
		System.err.println(string);

	}
}
