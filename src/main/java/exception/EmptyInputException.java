package exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String errorCode;
	private final String errorMssg;
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMssg() {
		return errorMssg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmptyInputException(String errorCode, String errorMssg) {
		super();
		this.errorCode = errorCode;
		this.errorMssg = errorMssg;
	}

}
