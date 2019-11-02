package excepciones;

public class NonExistingCarException extends Exception {

	private static final long serialVersionUID = 1L;

	public NonExistingCarException() {
	}

	public NonExistingCarException(String message) {
		super(message);
	}

	public NonExistingCarException(Throwable cause) {
		super(cause);
	}

	public NonExistingCarException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistingCarException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
