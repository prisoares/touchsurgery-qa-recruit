package info.xiaojundai.orion.fullstack.api;

public interface StockItemService {
  void decreaseQuantity(Long productId, Integer quantity);
}
