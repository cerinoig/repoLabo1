package excepciones;

public class CamposVaciosException extends Exception {

	private static final long serialVersionUID = 1L;

	public CamposVaciosException() {
	}

	public CamposVaciosException(String arg0) {
		super(arg0);
	}

	public CamposVaciosException(Throwable arg0) {
		super(arg0);
	}

	public CamposVaciosException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CamposVaciosException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
