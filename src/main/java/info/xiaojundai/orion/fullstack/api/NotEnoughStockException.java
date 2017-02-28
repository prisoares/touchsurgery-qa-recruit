package info.xiaojundai.orion.fullstack.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NotEnoughStockException extends RuntimeException {
  public NotEnoughStockException(Long productId, Integer currentQuantity, Integer quantity) {
    super("not enough stock for product #" + productId + ", current quantity: " + currentQuantity + ", expect quantity: " + quantity);
  }
}
