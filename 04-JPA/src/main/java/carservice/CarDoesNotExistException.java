package carservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarDoesNotExistException extends Exception {
  public CarDoesNotExistException(Long id) { super(String.format("Car '%d' does not exist", id)); }
}
