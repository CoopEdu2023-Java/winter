package cn.msa.museum.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.msa.museum.dto.ResponseDto;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDto<Void> exceptionHandler(Exception e) {
        System.out.println("Exception: " + e);
        return new ResponseDto<>(1000, "Unknown Error: " + e.getMessage(), null);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseDto<Void> exceptionHandler(BusinessException e) {
        System.out.println("Exception: " + e);
        return new ResponseDto<>(e.getCode(), "Error: " + e.getMessage(), null);
    }
}
