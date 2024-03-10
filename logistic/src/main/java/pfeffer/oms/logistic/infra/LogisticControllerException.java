package pfeffer.oms.logistic.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pfeffer.oms.inventory.domain.dtos.ExceptionDTO;
import pfeffer.oms.logistic.domain.exceptions.LogisticException;

@RestControllerAdvice
public class LogisticControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> threatGeneralExceptions(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> threatDataIntegrityViolationExceptions(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "400");

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(LogisticException.class)
    public ResponseEntity<ExceptionDTO> threatOrderException(LogisticException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), String.valueOf(exception.getStatusCode()));

        return switch (exception.getStatusCode()) {
            case 400 -> ResponseEntity.badRequest().body(exceptionDTO);
            case 404 -> ResponseEntity.notFound().build();
            default -> ResponseEntity.internalServerError().body(exceptionDTO);
        };
    }

}