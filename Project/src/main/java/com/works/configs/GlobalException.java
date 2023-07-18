package com.works.configs;

import com.works.utils.Rest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid( MethodArgumentNotValidException ex ) {
        String className = ex.getStackTrace()[0].getClass().getName();
        log.error(className + " - " + ex.getMessage());
        return Rest.fail( parseValidError(ex.getFieldErrors()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)



    private Object parseValidError(List<FieldError> fieldErrors) {
        List ls = new ArrayList();
        for( FieldError error : fieldErrors ) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            Map<String, String> hm = new LinkedHashMap<>();
            hm.put("field", field);
            hm.put("message", message);
            ls.add(hm);
        }
        return ls;
    }


}
