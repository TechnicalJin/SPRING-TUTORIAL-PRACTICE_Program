package com.hibernate.Validator;

import com.hibernate.Mapping.InheritanceMapping.JOINED.Employee;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class LIstOfValidators {

    // 1. Basic Constraints


    @NotNull(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "List must not be empty")
    private List<String> skills;

    @NotBlank(message = "Username cannot be blank")
    private String username;


    // 2. Numeric Constraints

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not be greater than 60")
    private int age;

    @Positive(message = "Salary must be positive")
    private double salary;

    @Digits(integer = 5, fraction = 2, message = "Value must have up to 5 integer digits and 2 decimal places")
    private BigDecimal price;


    // 3. String Constraints

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name1;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String email;


    // 4. Date and Time Constraints


    @Future(message = "Booking date must be in the future")
    private LocalDate bookingDate;

    @Past(message = "Birthdate must be in the past")
    private LocalDate birthDate;



    // 5. Boolean Constraints


    @AssertTrue(message = "The user must accept the terms and conditions")
    private boolean agreedToTerms;

    @AssertFalse(message = "Field should not be true")
    private boolean isBlocked;



    // 6. Collection Constraints


    @NotEmpty(message = "Skills list cannot be empty")
    @Size(min = 1, max = 5, message = "You can select up to 5 skills")
    private List<String> allSkills;


    // 7. Custom Validation (Using @Constraint)
    // Step 3: Apply the Custom Validator
    @ValidPassword
    private String password;




    // 8. Grouping Validations
    // Step 2: Apply Groups to Fields
    @NotNull(groups = CreateGroup.class, message = "Name is required for new records")
    private String nameGroups;

    @Min(value = 18, groups = {CreateGroup.class, UpdateGroup.class}, message = "Age must be at least 18")
    private int ageGroups;


    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    private Object employee;
    Set<ConstraintViolation<Employee>> violations = validator.validate((Employee) employee, CreateGroup.class);

}


// 7. Custom Validation (Using @Constraint)


// Step 1: Create Annotation

@Documented
@Constraint(validatedBy = PasswordValidator.class)
//@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)


@interface ValidPassword {
    String message() default "Password must contain at least 1 uppercase letter, 1 number, and 1 special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


// Step 2: Implement the Validator


class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }
}





// 8. Grouping Validations

// Step 1: Define Groups
interface CreateGroup {}
interface UpdateGroup {}




// 9. Validating Request Body in Spring Boot



/*
@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok("Employee created successfully: " + employee.getName());
    }
}
*/



// 10. Global Exception Handling (@ControllerAdvice)

///*
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errors.put(error.getField(), error.getDefaultMessage());
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//}
//*/
