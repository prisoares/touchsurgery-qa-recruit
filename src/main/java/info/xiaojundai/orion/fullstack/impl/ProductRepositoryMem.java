package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.Product;
import info.xiaojundai.orion.fullstack.api.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductRepositoryMem implements ProductRepository {

  private Map<Long, Product> products = new HashMap<>();
  private AtomicLong idGenerator = new AtomicLong();

  @PostConstruct
  public void loadDummyData() {
    Long id = idGenerator.incrementAndGet();
    Product product = new Product("Item A");
    product.setId(id);
    products.put(id, product);

    id = idGenerator.incrementAndGet();
    product = new Product("Item B");
    product.setId(id);
    products.put(id, product);
  }

  @Override
  public <S extends Product> S save(S entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public <S extends Product> Iterable<S> save(Iterable<S> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Product findOne(Long id) {
    return products.get(id);
  }

  @Override
  public boolean exists(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterable<Product> findAll() {
    return products.values();
  }

  @Override
  public Iterable<Product> findAll(Iterable<Long> longs) {
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
  public void delete(Product entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(Iterable<? extends Product> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAll() {
    throw new UnsupportedOperationException();
  }
}
