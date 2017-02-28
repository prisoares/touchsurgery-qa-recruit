package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.MyIllegalArgumentException;

public class StockItemValidator {
  public static void shouldQuantityEqualOrLargerThan0(Integer quantity) {
    if (quantity < 0) {
      throw new MyIllegalArgumentException("quantity must be equal or larger than 0");
    }
  }
}
