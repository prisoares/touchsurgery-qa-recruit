package info.xiaojundai.orion.fullstack.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyIllegalArgumentException extends IllegalArgumentException {
  public MyIllegalArgumentException(String message) {
    super(message);
  }
}
