package fr.exception;

public class SavePizzaException extends Exception {

	/**
	 * Classe {SavePizzaException} permettant de retrouner les divers exceptions
	 * causées par les actions {Save} de pizza. - serialVersionUID = 1L
	 */
	private static final long serialVersionUID = 1L;

	public SavePizzaException() {
		super();

	}

	public SavePizzaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);

	}

	public SavePizzaException(String message) {
		super(message);

	}

	public SavePizzaException(Throwable cause) {
		super(cause);

	}

}
