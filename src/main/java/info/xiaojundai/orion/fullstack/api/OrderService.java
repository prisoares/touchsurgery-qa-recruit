package info.xiaojundai.orion.fullstack.api;

import javax.transaction.Transactional;

public interface OrderService {
  Order create(Order order);
  void resetOrders();
}
