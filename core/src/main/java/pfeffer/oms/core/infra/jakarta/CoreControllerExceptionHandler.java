package pfeffer.oms.core.infra.jakarta;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pfeffer.oms.core.domain.dtos.ExceptionDTO;
import pfeffer.oms.core.domain.exceptions.CustomerException;

@RestControllerAdvice
public class CoreControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> threatGeneralExceptions(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> DataIntegrityViolationExceptions(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "400");

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ExceptionDTO> threatCustomerException(CustomerException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), String.valueOf(exception.getStatusCode()));

        return switch (exception.getStatusCode()) {
            case 400 -> ResponseEntity.notFound().build();
            case 404 -> ResponseEntity.badRequest().body(exceptionDTO);
            default -> ResponseEntity.internalServerError().body(exceptionDTO);
        };
    }

}