package excepciones;

public class NoIdObtainedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoIdObtainedException() {
	}

	public NoIdObtainedException(String message) {
		super(message);
	}

	public NoIdObtainedException(Throwable cause) {
		super(cause);
	}

	public NoIdObtainedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoIdObtainedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
