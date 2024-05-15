package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min=3,message = "min 3 character is required")
    private String name;

    @Email(message = "invaild email address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "password is required ")
    @Size(min=6, message = "minimum 6 character is required")
    private String password;

    @Size(min=8,max = 12,message = "Invalid phone Number")
    private String phoneNumber;

    @NotBlank(message="About is required")
    private String about;

}
