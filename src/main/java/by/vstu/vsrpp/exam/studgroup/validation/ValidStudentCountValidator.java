package by.vstu.vsrpp.exam.studgroup.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import by.vstu.vsrpp.exam.studgroup.entity.Group;
import by.vstu.vsrpp.exam.studgroup.entity.Student;

public class ValidStudentCountValidator implements ConstraintValidator<ValidStudentCount, Group> {

	private int min;
	private int max;

	@Override
	public void initialize(ValidStudentCount constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(Group group, ConstraintValidatorContext context) {
		if (group == null) {
			return true;
		}

		List<Student> students = group.getStudents();
		int count = students == null ? 0 : students.size();

		if (count >= min && count <= max) {
			return true;
		}

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(
				String.format("Группа '%s' содержит %d студентов. Допустимо от %d до %d.",
						group.getNazvanie(), count, min, max))
				.addConstraintViolation();
		return false;
	}
}
