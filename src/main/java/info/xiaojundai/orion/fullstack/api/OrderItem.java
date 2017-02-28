package info.xiaojundai.orion.fullstack.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  private Product product;

  private Integer quantity;

  public OrderItem() {
  }

  public OrderItem(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }

  public Integer getQuantity() {
    return quantity;
  }
}
