package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class OrderServiceImpl implements OrderService {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private StockItemService stockItemService;

  @Autowired
  private StockItemRepository stockItemRepository;

  @Override
  @Transactional
  public Order create(Order order) {
    OrderItemValidator.shouldIncludeAtLeastOneProduct(order.getOrderItems());

    try {
      stockItemRepository.snapshot();
      for (OrderItem orderItem : order.getOrderItems()) {
        stockItemService.decreaseQuantity(orderItem.getProduct().getId(), orderItem.getQuantity());
      }
      return orderRepository.save(order);
    } catch (Exception e) {
      // manual transaction rollback
      stockItemRepository.restore();
      log.info("transaction rollback");
      throw e;
    }
  }

  @Override
  @Transactional
  public void resetOrders() {
      try {
        orderRepository.resetOrders();
      } catch (Exception e) {
        // manual transaction rollback
        stockItemRepository.restore();
        log.info("transaction rollback");
        throw e;
      }
  }
}
