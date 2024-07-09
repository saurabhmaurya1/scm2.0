package com.scm.forms;

import org.springframework.web.multipart.MultipartFile;

import com.scm.validators.VaildFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactForm {

    @NotBlank(message = "Username is required")
    @Size(min=3,message = "min 3 character is required")
    private String name;

    @Email(message = "invaild email address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone Number  is required")
    @Pattern(regexp="^[0-9]{10}$",message="invalid phone Number")
    private String phoneNumber;

    @NotBlank(message = "address is required")
    private String address;
    
   
    private String description;

    private boolean favorite;
    private String websiteLink;
    private String linkedInLink;

    //annotation  create karenge for validation
    @VaildFile(message = "Invalid file")
    private MultipartFile contactImage;

    private String picture;


}
