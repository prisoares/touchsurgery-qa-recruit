package info.xiaojundai.orion.fullstack.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StockItem {
  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  private Product product;

  private Integer quantity;

  public StockItem() {
  }

  public StockItem(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
