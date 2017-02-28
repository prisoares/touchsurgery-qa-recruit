package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.Order;
import info.xiaojundai.orion.fullstack.api.OrderRepository;
import info.xiaojundai.orion.fullstack.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OrderController.BASE_URL)
public class OrderController {
  public static final String BASE_URL = "/orders";

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderRepository orderRepository;

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Order create(@RequestBody Order order) {
    return orderService.create(order);
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Iterable<Order> index() {
    return orderRepository.findAll();
  }
}
