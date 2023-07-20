package com.works.utils;

import com.works.entities.Customer;
import com.works.models.RestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.Optional;

public class Rest {

    public static ResponseEntity success(Object obj) {
        long start = System.currentTimeMillis();
        RestModel restModel = new RestModel();
        restModel.setStatus(true);
        restModel.setResult(obj);
        ResponseEntity res = new ResponseEntity(restModel, HttpStatus.OK);
        long end = System.currentTimeMillis();
        long beetwen = end - start;
        //System.out.println( "beetwen :" + beetwen  );
        return res;
    }

    public static ResponseEntity fail( Object obj, HttpStatus httpStatus ) {
        RestModel restModel = new RestModel();
        restModel.setStatus(false);
        restModel.setResult(obj);
        return new ResponseEntity(restModel, httpStatus);
    }

    public static Optional<String> userOptional(HttpServletRequest req) {
        Object obj = req.getSession().getAttribute("customer");
        if (obj != null && obj instanceof Customer) {
            Customer customer = (Customer) obj;
            Optional<String> stringOptional = Optional.of(customer.getEmail());
            return stringOptional;
        }
        return Optional.empty();
    }

}
