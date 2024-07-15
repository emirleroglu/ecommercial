package com.example.ecommercial.application.controller.exception;

import com.example.ecommercial.application.controller.messages.Message;
import com.example.ecommercial.application.controller.transfer.error.ErrorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorDTO> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String code = error.getCode();
            String errorMessage = error.getDefaultMessage();
            errors.add(ErrorDTO.builder().message(errorMessage).code(code).build());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ErrorDTO> handleBusinessException(BusinessException ex) {

        return ResponseEntity.badRequest()
                .body(ErrorDTO.builder()
                        .message(messageSource.getMessage(ex.getErrorMessage(), null, Locale.getDefault()))
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDTO> handleAllExceptions(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(ErrorDTO.builder()
                        .message(messageSource.getMessage(Message.INTERNAL_SERVER_ERROR, null, Locale.getDefault()))
                        .build());
    }
}
