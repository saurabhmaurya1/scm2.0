package com.scm.validators;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileValidator implements ConstraintValidator<VaildFile,MultipartFile> {

    private static final long MAX_FILE_SIZE = 1024 * 1024 *2 ; //2 mb

    //Type 
    //height
    //Width
    

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        
        if(file==null || file.isEmpty()){
            // context.disableDefaultConstraintViolation();
            // context.buildConstraintViolationWithTemplate("file cannot be Empty").addConstraintViolation();
            return true;
        }

        // file size
        if (file.getSize()>MAX_FILE_SIZE){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("file size should be less than 2 mb").addConstraintViolation();
            return false;
        }

        // //resolution
        // try {
        //     BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
            return true;

    }

}
