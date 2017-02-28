package info.xiaojundai.orion.fullstack.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OrderRepository extends CrudRepository<Order, Long> {
	  void resetOrders();
}
