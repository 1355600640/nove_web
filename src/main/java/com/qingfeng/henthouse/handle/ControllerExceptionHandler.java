package com.qingfeng.henthouse.handle;

import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.common.HttpException;
import com.qingfeng.henthouse.enmus.ControlStatus;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;


@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(HttpException.class)
    public ApiResponseObject<String> httpException(HttpException   e) {
        e.printStackTrace();
        return new ApiResponseObject<>(ControlStatus.FAIL.getErrorCode(), ControlStatus.FAIL.getErrorMsg(),e.getErrorMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponseObject<String> exception(Exception   e) {
        e.printStackTrace();
        return new ApiResponseObject<>(ControlStatus.FAIL.getErrorCode(), ControlStatus.FAIL.getErrorMsg(),e.getMessage());
    }




    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseObject<String>  methodArgumentNotValidException(ConstraintViolationException exception) {
        System.out.println(exception.getLocalizedMessage());
        Iterator<ConstraintViolation<?>> iterator = exception.getConstraintViolations().iterator();
        if (iterator.hasNext()) {
            ConstraintViolationImpl next = (ConstraintViolationImpl)iterator.next();
            return ApiResponseObject.error(next.getMessage());
        }
        return ApiResponseObject.error(exception.getMessage());
    }


}
