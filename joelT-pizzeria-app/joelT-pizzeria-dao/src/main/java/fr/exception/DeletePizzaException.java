package fr.exception;

public class DeletePizzaException extends Exception {

	/**
	 * Classe {DeletePizzaException} permettant de retrouner les divers
	 * exceptions causées par les actions {Delete} de pizza. - serialVersionUID
	 * = 1L
	 */
	private static final long serialVersionUID = 1L;

	public DeletePizzaException() {
		super();

	}

	public DeletePizzaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public DeletePizzaException(String message, Throwable cause) {
		super(message, cause);

	}

	public DeletePizzaException(String message) {
		super(message);

	}

	public DeletePizzaException(Throwable cause) {
		super(cause);

	}

}
