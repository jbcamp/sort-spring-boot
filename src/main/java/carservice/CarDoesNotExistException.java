package carservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jonathancampbell on 10/7/14.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarDoesNotExistException extends Exception {
  public CarDoesNotExistException(Long id) { super(String.format("Car '%d' does not exist", id)); }
}
