package com.project.myapp.utiles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e){

        System.out.println("여길 오긴 오나?");
        System.out.println("e.getMessage() = " + e.getMessage());
        ModelAndView mav =new ModelAndView();
        mav.setViewName("errorPage/error404");
        mav.addObject("exception", e);
        return mav;
    }

}
