package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.StockItem;
import info.xiaojundai.orion.fullstack.api.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import info.xiaojundai.orion.fullstack.api.OrderService;

@RestController
@RequestMapping(StockItemController.BASE_URL)
public class StockItemController {

  public static final String BASE_URL = "/stock_items";

  @Autowired
  private StockItemRepository stockItemRepository;

  @Autowired
  private OrderService orderService;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Iterable<StockItem> index() {
    return stockItemRepository.findAll();
  }

  @RequestMapping(path = "/reset", method = RequestMethod.POST)
  public void reset() {
    stockItemRepository.loadDummyData();
    orderService.resetOrders();
  }
}
