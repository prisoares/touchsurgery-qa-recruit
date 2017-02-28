package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.ProductRepository;
import info.xiaojundai.orion.fullstack.api.StockItem;
import info.xiaojundai.orion.fullstack.api.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class StockItemRepositoryMem implements StockItemRepository {

  @Autowired
  private ProductRepository productRepository;

  private Map<Long, StockItem> stockItems = new HashMap<>();
  private AtomicLong idGenerator = new AtomicLong();

  private Map<Long, StockItem> stockItemsSnapshot;

  @PostConstruct
  public void loadDummyData() {
    stockItems.clear();
    idGenerator = new AtomicLong();

    Long id = idGenerator.incrementAndGet();
    StockItem stockItem = new StockItem(productRepository.findOne(1L), 20);
    stockItem.setId(id);
    stockItems.put(id, stockItem);


    id = idGenerator.incrementAndGet();
    stockItem = new StockItem(productRepository.findOne(2L), 10);
    stockItem.setId(id);
    stockItems.put(id, stockItem);
  }

  @Override
  public StockItem findByProductId(Long productId) {
    for (StockItem stockItem : stockItems.values()) {
      if (productId.equals(stockItem.getProduct().getId())) {
        return stockItem;
      }
    }
    return null;
  }

  @Override
  public void snapshot() {
    stockItemsSnapshot = new HashMap<>();
    for (StockItem stockItem : stockItems.values()) {
      StockItem stockItemCopy = new StockItem(stockItem.getProduct(), stockItem.getQuantity());
      stockItemCopy.setId(stockItem.getId());
      stockItemsSnapshot.put(stockItemCopy.getId(), stockItemCopy);
    }
  }

  @Override
  public void restore() {
    stockItems = stockItemsSnapshot;
  }

  @Override
  public Iterable<StockItem> findAll() {
    return stockItems.values();
  }

  @Override
  public StockItem findOne(Long id) {
    return stockItems.get(id);
  }

  @Override
  public StockItem save(StockItem stockItem) {
    Long id = stockItem.getId();
    if (id == null) {
      id = idGenerator.incrementAndGet();
      stockItem.setId(id);
    }

    stockItems.put(id, stockItem);
    return stockItem;
  }

  @Override
  public Iterable<StockItem> findAll(Iterable<Long> ids) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    return stockItems.size();
  }

  @Override
  public void delete(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(StockItem entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(Iterable<? extends StockItem> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAll() {
    stockItems.clear();
  }

  @Override
  public <S extends StockItem> Iterable<S> save(Iterable<S> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean exists(Long aLong) {
    throw new UnsupportedOperationException();
  }

  public Map<Long, StockItem> getStockItemsSnapshot() {
    return stockItemsSnapshot;
  }
}
