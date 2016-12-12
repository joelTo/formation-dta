package fr.exception;

public class BaseJDBCException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BaseJDBCException() {
		super();

	}

	public BaseJDBCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public BaseJDBCException(String message, Throwable cause) {
		super(message, cause);

	}

	public BaseJDBCException(String message) {
		super(message);

	}

	public BaseJDBCException(Throwable cause) {
		super(cause);

	}



}
