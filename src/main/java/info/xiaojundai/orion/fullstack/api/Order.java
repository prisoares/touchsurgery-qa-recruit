package info.xiaojundai.orion.fullstack.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Order {
  @Id
  @GeneratedValue
  private Long id;

  @JsonProperty("order_items")
  @OneToMany
  private List<OrderItem> orderItems;

  public Order() {
  }

  public Order(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }
}
