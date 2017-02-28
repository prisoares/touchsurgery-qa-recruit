package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StockItemServiceImpl implements StockItemService {

  @Autowired
  private StockItemRepository stockItemRepository;

  @Override
  public void decreaseQuantity(Long productId, Integer quantity) {
    Assert.notNull(productId);
    quantity = getDefaultQuantity(quantity);
    StockItemValidator.shouldQuantityEqualOrLargerThan0(quantity);

    StockItem stockItem = stockItemRepository.findByProductId(productId);
    Integer currentQuantity = stockItem.getQuantity();
    if (currentQuantity >= quantity) {
      stockItem.setQuantity(currentQuantity - quantity);
      stockItemRepository.save(stockItem);
    } else {
      throw new NotEnoughStockException(productId, currentQuantity, quantity);
    }
  }

  private Integer getDefaultQuantity(Integer quantity) {
    if (quantity == null) {
      return 0;
    }
    return quantity;
  }
}
