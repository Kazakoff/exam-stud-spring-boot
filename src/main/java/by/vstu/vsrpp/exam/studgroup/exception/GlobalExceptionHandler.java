package by.vstu.vsrpp.exam.studgroup.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(GroupValidationException.class)
	public ResponseEntity<ValidationErrorResponse> handleGroupValidation(GroupValidationException ex) {
		return ResponseEntity.badRequest().body(new ValidationErrorResponse(ex.getErrors()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleRequestValidation(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.collect(Collectors.toList());
		return ResponseEntity.badRequest().body(new ValidationErrorResponse(errors));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ValidationErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(new ValidationErrorResponse(ex.getMessage()));
	}

	public static class ValidationErrorResponse {
		private final List<String> errors;

		public ValidationErrorResponse(List<String> errors) {
			this.errors = errors;
		}

		public ValidationErrorResponse(String error) {
			this.errors = java.util.Collections.singletonList(error);
		}

		public List<String> getErrors() {
			return errors;
		}
	}
}
