package sk.jra.pmaapp.common.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

@Slf4j
@Getter
@Setter
public class PmaException extends RuntimeException{

  protected String message;
  protected String description;

  public PmaException(String message, String description) {
    this.message = message;
    this.description = description;
    log.error(this.description);
  }

  public PmaException(Exception e) {
    this.message = e.getMessage();
    this.description = e.getLocalizedMessage();
    log.error(this.description, e);
  }

  public PmaException(String message, String description, String... params) {
    this.message = message;
    MessageFormat descriptionFormated = new MessageFormat(description);
    this.description = descriptionFormated.format(params);
    log.error(this.description);
  }
}
