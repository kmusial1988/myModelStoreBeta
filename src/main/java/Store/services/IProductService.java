package Store.services;

import Store.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> allProductList();
    List<Product> getProductByCategory(Product.Category category);
    List<Product> getProductByName(String name);
    List<Product> findProduct(String pattern);

}
