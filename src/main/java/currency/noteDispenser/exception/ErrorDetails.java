package currency.noteDispenser.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ErrorDetails {

	private LocalDateTime timestamp;
	private String errorMessage;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime  timestamp, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
	}

	public LocalDateTime  getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime  timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
