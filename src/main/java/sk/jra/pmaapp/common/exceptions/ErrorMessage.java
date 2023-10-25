package sk.jra.pmaapp.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage implements Serializable {

  private int statusCode;
  private LocalDateTime timestamp;
  private String message;
  private String description;

  public ErrorMessage(int statusCode, PmaException e) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = e.getMessage();
    this.description = e.getDescription();
  }

  public ErrorMessage(int statusCode, String message, String description) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = message;
    this.description = description;
  }

  public ErrorMessage(int statusCode, String message, Map<String, String> errors) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = message;
    this.description = errors.keySet().stream().map(key -> key + " " + errors.get(key)).collect(Collectors.joining(", "));
  }
}
