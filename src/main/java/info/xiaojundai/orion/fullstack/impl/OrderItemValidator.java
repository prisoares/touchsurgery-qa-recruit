package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.MyIllegalArgumentException;
import info.xiaojundai.orion.fullstack.api.OrderItem;

import java.util.List;

public class OrderItemValidator {
  public static void shouldIncludeAtLeastOneProduct(List<OrderItem> orderItems) {
    String message = "at least buy one product";
    if (orderItems == null || orderItems.isEmpty()) {
      throw new MyIllegalArgumentException(message);
    }

    for (OrderItem orderItem : orderItems) {
      if (orderItem.getQuantity() != null && orderItem.getQuantity() > 0) {
        return;
      }
    }
    throw new MyIllegalArgumentException(message);
  }
}
