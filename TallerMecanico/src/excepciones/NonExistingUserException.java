package excepciones;

public class NonExistingUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public NonExistingUserException() {
	}

	public NonExistingUserException(String message) {
		super(message);
	}

	public NonExistingUserException(Throwable cause) {
		super(cause);
	}

	public NonExistingUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistingUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
