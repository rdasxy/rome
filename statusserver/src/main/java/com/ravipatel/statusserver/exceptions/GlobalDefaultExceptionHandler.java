package com.ravipatel.statusserver.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ravipatel.statusserver.utils.BaseJsonOutput;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody ResponseEntity<BaseJsonOutput> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;
    	BaseJsonOutput output = new BaseJsonOutput();
    	output.setMessage("Internal Error");
    	output.setStatuscode(500);
    	output.setSuccess(false);;
    	output.setResult(e.getMessage());
        return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}