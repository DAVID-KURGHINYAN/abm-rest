package am.abm.abm.controllers;
import am.abm.abm.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class BaseController {

    protected <R> ResponseModel<R> createResult(R data, String message) {
        List<String> errors = new ArrayList<>();
        errors.add(message);
        return createResult(data, errors);
    }

    private <R> ResponseModel<R> createResult(R data, List<String> message) {
        ResponseModel<R> responseModel = new ResponseModel<>();
        responseModel.setData(data);
        responseModel.setSuccess(true);
        responseModel.setMessage(message);
        return responseModel;
    }

    protected <R> ResponseModel<R> createErrorResult(Exception e) {
        ResponseModel<R> responseModel = new ResponseModel<>();
        responseModel.setSuccess(false);
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        responseModel.setMessage(errors);
        return responseModel;
    }

    protected <R> ResponseModel<R> createErrorResult(List<String> errors) {
        ResponseModel<R> responseModel = new ResponseModel<>();
        responseModel.setSuccess(false);
        responseModel.setMessage(errors);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <R> ResponseModel<R> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<String> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            if (((FieldError) error).getRejectedValue() != null) {
                String errorMessage = fieldName + " " + error.getDefaultMessage();
                errors.add(errorMessage);
            } else {
                String errorMessage =  error.getDefaultMessage();
                errors.add(errorMessage);
            }
        });
        return createErrorResult(errors);
    }
}
