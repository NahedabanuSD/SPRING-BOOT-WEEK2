package com.dept.assignment.week2.mvc.advices;

import com.dept.assignment.week2.mvc.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse<?>> handleResorceNOtFound(ResourceNotFoundException exception)
{
ApiError apiError=ApiError.builder().httpStatus(HttpStatus.NOT_FOUND)
        .message(exception.getMessage())
                .build();
return buildErrorResponseEntity(apiError);

}
@ExceptionHandler(Exception.class)
public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception)
{
    ApiError apiError=ApiError.builder()
            .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
    return buildErrorResponseEntity(apiError);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception)
{
List<String> errorList=exception.getBindingResult()
        .getAllErrors().stream()
        .map(error->error.getDefaultMessage())
        .collect(Collectors.toList());
ApiError apiError=ApiError.builder()
        .httpStatus(HttpStatus.BAD_REQUEST)
        .message("")
        .subErrors(errorList)
        .build();
return buildErrorResponseEntity(apiError);
}

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getHttpStatus());
    }
}
