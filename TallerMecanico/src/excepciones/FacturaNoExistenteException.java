package excepciones;

public class FacturaNoExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public FacturaNoExistenteException() {
	}

	public FacturaNoExistenteException(String message) {
		super(message);
	}

	public FacturaNoExistenteException(Throwable cause) {
		super(cause);
	}

	public FacturaNoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public FacturaNoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
