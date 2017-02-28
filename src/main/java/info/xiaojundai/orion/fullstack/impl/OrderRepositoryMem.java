package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class OrderRepositoryMem implements OrderRepository {

  @Autowired
  private ProductRepository productRepository;

  private Map<Long, Order> orders = new HashMap<>();
  private AtomicLong idGenerator = new AtomicLong();

  @Override
  public <S extends Order> S save(S order) {
    Long id = order.getId();
    if (id == null) {
      id = idGenerator.incrementAndGet();
      order.setId(id);
    }

    orders.put(id, order);
    return order;
  }

  @Override
  public Iterable<Order> findAll() {
    Collection<Order> orders = this.orders.values();
    for (Order order : orders) {
      populateOrderItem(order.getOrderItems());
    }
    return orders;
  }

  @Override
  public void resetOrders() {
	  deleteAll();
	  idGenerator = new AtomicLong();
  }

  private void populateOrderItem(List<OrderItem> orderItems) {
    if (orderItems != null) {
      for (OrderItem orderItem : orderItems) {
        populateProduct(orderItem);
      }
    }
  }

  private void populateProduct(OrderItem orderItem) {
    Product product = orderItem.getProduct();
    product.setName(productRepository.findOne(product.getId()).getName());
  }

  @Override
  public <S extends Order> Iterable<S> save(Iterable<S> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Order findOne(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean exists(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterable<Order> findAll(Iterable<Long> ids) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(Order entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(Iterable<? extends Order> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAll() {
	  orders.clear();
  }
}
