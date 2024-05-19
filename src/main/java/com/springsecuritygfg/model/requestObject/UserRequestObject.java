package com.springsecuritygfg.model.requestObject;

import com.springsecuritygfg.annotation.EmailAnnotation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestObject {

    @NotNull(message = "username should not be null")
    @NotBlank(message = "username should not be blank")
    @Size(max = 126, min = 3, message = "username character should be between 3 to 126")
    private String username;

    @NotBlank(message = "password should not be blank")
    @Size(max = 126, min = 3, message = "password character should be between 3 to 126")
    private String password;

    private String authority;

    @EmailAnnotation
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    @NotNull(message = "phoneNumber should not be null")
    @NotBlank(message = "phoneNumber should not be blank")
    private String phoneNumber;
}
