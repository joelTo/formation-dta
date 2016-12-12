package fr.exception;

public class UpdatesPizzaException extends Exception {

	/**
	 * Classe {UpdatesPizzaException} permettant de retrouner les divers
	 * exceptions causées par les actions {Updates} de pizza. - serialVersionUID
	 * = 1L
	 */
	private static final long serialVersionUID = 1L;

	public UpdatesPizzaException() {
		super();

	}

	public UpdatesPizzaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UpdatesPizzaException(String message, Throwable cause) {
		super(message, cause);

	}

	public UpdatesPizzaException(String message) {
		super(message);

	}

	public UpdatesPizzaException(Throwable cause) {
		super(cause);

	}

}
