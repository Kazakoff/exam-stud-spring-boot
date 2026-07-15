package by.vstu.vsrpp.exam.studgroup.exception;

import java.util.List;

public class GroupValidationException extends RuntimeException {

	private final List<String> errors;

	public GroupValidationException(List<String> errors) {
		super("Ошибка валидации группы");
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}
}
