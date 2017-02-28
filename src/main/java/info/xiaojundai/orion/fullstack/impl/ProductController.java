package info.xiaojundai.orion.fullstack.impl;

import info.xiaojundai.orion.fullstack.api.Product;
import info.xiaojundai.orion.fullstack.api.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
  public static final String BASE_URL = "/products";

  @Autowired
  private ProductRepository productRepository;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Iterable<Product> index() {
    return productRepository.findAll();
  }
}

