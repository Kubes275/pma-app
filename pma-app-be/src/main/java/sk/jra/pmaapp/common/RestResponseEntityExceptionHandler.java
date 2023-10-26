package sk.jra.pmaapp.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import sk.jra.pmaapp.common.exceptions.ErrorMessage;
import sk.jra.pmaapp.common.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
      HttpStatus.NOT_FOUND.value(),
      e.getMessage(),
      request.getDescription(false));
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
  }

}
