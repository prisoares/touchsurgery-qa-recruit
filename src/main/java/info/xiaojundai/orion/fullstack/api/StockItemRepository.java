package info.xiaojundai.orion.fullstack.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StockItemRepository extends CrudRepository<StockItem, Long> {
  StockItem findByProductId(Long productId);

  void snapshot();
  void restore();
  void loadDummyData();
}
