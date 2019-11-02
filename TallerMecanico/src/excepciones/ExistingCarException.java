package excepciones;

public class ExistingCarException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExistingCarException() {
	}

	public ExistingCarException(String message) {
		super(message);
	}

	public ExistingCarException(Throwable cause) {
		super(cause);
	}

	public ExistingCarException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExistingCarException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
