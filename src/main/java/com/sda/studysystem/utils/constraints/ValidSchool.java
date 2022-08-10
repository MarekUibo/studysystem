package com.sda.studysystem.utils.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 * Constrains annotation for unique school validation
 */

@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = {ValidSchoolValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSchool {
    String message() default "{messages.constraints.School-exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
