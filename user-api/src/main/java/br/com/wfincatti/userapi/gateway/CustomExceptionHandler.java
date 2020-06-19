package br.com.wfincatti.userapi.gateway;

import br.com.wfincatti.userapi.domain.exception.UserNotFoundException;
import br.com.wfincatti.userapi.gateway.assembler.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@ControllerAdvice()
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> errorDetails(UserNotFoundException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = ErrorDetails
                .builder()
                .path(request.getRequestURI())
                .message(ex.getMessage())
                .timestamp(LocalDate.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
