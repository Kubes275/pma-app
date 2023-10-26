package sk.jra.pmaapp.common.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends PmaException implements Serializable {

  public ResourceNotFoundException(String message, String description) {
    super(message, description);
  }

  public ResourceNotFoundException(Exception e) {
    super(e);
  }

  public ResourceNotFoundException(String message, String description, String... params) {
    super(message, description, params);
  }

}
