package com.examplevalidation.validationexample.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
	@NotBlank(message = "Username is required")
	private String userName;
	
	@NotNull(message = "Date of birth is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth should be in the format yyyy-MM-dd")
    private String dateOfBirth;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
	
	@NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Phone number should be 12 digits with first 2 digits as country code")
    private String mobile;
	
	private String gender;

}
