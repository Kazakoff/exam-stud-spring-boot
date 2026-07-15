package by.vstu.vsrpp.exam.studgroup.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ValidStudentCountValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStudentCount {

	String message() default "Количество студентов в группе должно быть от {min} до {max}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 1;

	int max() default 30;
}
